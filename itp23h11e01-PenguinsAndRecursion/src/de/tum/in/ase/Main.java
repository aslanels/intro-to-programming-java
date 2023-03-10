package de.tum.in.ase;

import java.util.ArrayList;
import java.util.Arrays;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        // You can test your source code here...
        int[] seqF = new int[10];
        seqF[0] = Solution.penguTwinSeqF(0);
        seqF[1] = Solution.penguTwinSeqF(1);
        seqF[2] = Solution.penguTwinSeqF(2);
        seqF[3] = Solution.penguTwinSeqF(3);
        seqF[4] = Solution.penguTwinSeqF(4);
        seqF[5] = Solution.penguTwinSeqF(5);
        seqF[6] = Solution.penguTwinSeqF(6);
        seqF[7] = Solution.penguTwinSeqF(7);
        seqF[8] = Solution.penguTwinSeqF(8);
        seqF[9] = Solution.penguTwinSeqF(9);
        System.out.println(Arrays.toString(seqF));

        int[] seqM = new int[10];
        seqM[0] = Solution.penguTwinSeqM(0);
        seqM[1] = Solution.penguTwinSeqM(1);
        seqM[2] = Solution.penguTwinSeqM(2);
        seqM[3] = Solution.penguTwinSeqM(3);
        seqM[4] = Solution.penguTwinSeqM(4);
        seqM[5] = Solution.penguTwinSeqM(5);
        seqM[6] = Solution.penguTwinSeqM(6);
        seqM[7] = Solution.penguTwinSeqM(7);
        seqM[8] = Solution.penguTwinSeqM(8);
        seqM[9] = Solution.penguTwinSeqM(9);
        System.out.println(Arrays.toString(seqM));

        long[] bigSeq = new long[4];
        bigSeq[0] = Solution.penguBigSeq(0, 2);
        bigSeq[1] = Solution.penguBigSeq(1, 2);
        bigSeq[2] = Solution.penguBigSeq(2, 2);
        bigSeq[3] = Solution.penguBigSeq(3, 2);
        System.out.println(Arrays.toString(bigSeq));

        long[] recSeq = new long[20];
        recSeq[0] = Solution.penguRecursiveSeq(0, 1, 1, 2);
        recSeq[1] = Solution.penguRecursiveSeq(1, 1, 1, 2);
        recSeq[2] = Solution.penguRecursiveSeq(2, 1, 1, 2);
        recSeq[3] = Solution.penguRecursiveSeq(3, 1, 1, 2);
        recSeq[4] = Solution.penguRecursiveSeq(4, 1, 1, 2);
        recSeq[5] = Solution.penguRecursiveSeq(5, 1, 1, 2);
        recSeq[6] = Solution.penguRecursiveSeq(6, 1, 1, 2);
        recSeq[7] = Solution.penguRecursiveSeq(7, 1, 1, 2);
        recSeq[8] = Solution.penguRecursiveSeq(8, 1, 1, 2);
        recSeq[9] = Solution.penguRecursiveSeq(9, 1, 1, 2);
        recSeq[10] = Solution.penguRecursiveSeq(10, 1, 1, 2);
        recSeq[11] = Solution.penguRecursiveSeq(11, 1, 1, 2);
        recSeq[12] = Solution.penguRecursiveSeq(12, 1, 1, 2);
        recSeq[13] = Solution.penguRecursiveSeq(13, 1, 1, 2);
        recSeq[14] = Solution.penguRecursiveSeq(14, 1, 1, 2);
        recSeq[15] = Solution.penguRecursiveSeq(15, 1, 1, 2);
        recSeq[16] = Solution.penguRecursiveSeq(16, 1, 1, 2);
        recSeq[17] = Solution.penguRecursiveSeq(17, 1, 1, 2);
        recSeq[18] = Solution.penguRecursiveSeq(18, 1, 1, 2);
        recSeq[19] = Solution.penguRecursiveSeq(19, 1, 1, 2);

        System.out.println(Arrays.toString(recSeq));

    }
}
