package laiCode.dp;

public class ArrayHopper {

    public boolean canJumpI(int[] array) {  // from right to left
        if (array.length == 1) {
            return true;
        }
        boolean[] canJump = new boolean[array.length];
        for (int i = array.length - 2; i >= 0; i--) {
            if (i + array[i] >= array.length - 1) {
                canJump[i] = true;
            } else {
                for (int j = array[i]; j >= 1; j--) {
                    if (canJump[j + i]) {
                        canJump[i] = true;
                        break;
                    }
                }
            }
        }
        return canJump[0];
    }

    public boolean canJumpII(int[] array) {  // from left to right
        boolean[] canJump = new boolean[array.length];
        canJump[0] = true;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (canJump[j] && array[j] + j >= i) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[array.length - 1];
    }


    public boolean canJumpIII(int[] array) {    // Gready algo
        if (array.length == 1) {
            return true;
        }
        int cur = 0;
        int next = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > cur) {
                if (cur == next) {
                    return false;
                }
                cur = next;
            }
            next = Math.max(next, i + array[i]);
        }
        return true;
    }

}
