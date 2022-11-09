package udacity.streamAPI;

import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public final class SummarizeClients {
    public static void main(String[] args) {

        List<UdacisearchClient> clients = ClientStore.getClients();
        int numClients = clients.size();
        int totalQuarterlySpend =
                clients
                        .stream()
                        .mapToInt(UdacisearchClient::getQuarterlyBudget)
                        .sum();

        double averageBudget =
                clients
                        .stream()
                        .mapToDouble(UdacisearchClient::getQuarterlyBudget)
                        .average()
                        .orElse(0);

        long nextExpiration =
                clients
                        .stream()
                        .min(Comparator.comparing(UdacisearchClient::getContractEnd))
                        .map(UdacisearchClient::getId)
                        .orElse(-1L);

        List<ZoneId> representedZoneIds =
                clients
                        .stream()
                        .flatMap(c -> c.getTimeZones().stream())
                        .distinct()
                        .collect(Collectors.toList());

        Map<Year, Long> contractsPerYear =
                clients
                        .stream()
                        .collect(Collectors.groupingBy(SummarizeClients::getContractYear, Collectors.counting()));


//        for (UdacisearchClient client : ClientStore.getClients()) {
//            numClients++;
//            totalQuarterlySpend += client.getQuarterlyBudget();
//            if (nextExpiration == null || client.getContractStart().plus(client.getContractLength())
//                    .isAfter(nextExpiration.getContractStart().plus(nextExpiration.getContractLength()))) {
//                nextExpiration = client;
//            }
//            for (ZoneId zone : client.getTimeZones()) {
//                representedZoneIds.add(zone);
//            }
//            contractsPerYear.compute(getContractYear(client), (k, v) -> (v == null) ? 1 : v + 1);
//        }

        System.out.println("Num clients: " + numClients);
        System.out.println("Total quarterly spend: " + totalQuarterlySpend);
        System.out.println("Average budget: " + averageBudget);
        System.out.println("ID of next expiring contract: " + nextExpiration);
        System.out.println("Client time zones: " + representedZoneIds);
        System.out.println("Contracts per year: " + contractsPerYear);
    }

    private static Year getContractYear(UdacisearchClient client) {
        LocalDate contractDate =
                LocalDate.ofInstant(client.getContractStart(), client.getTimeZones().get(0));
        return Year.of(contractDate.getYear());
    }
}

