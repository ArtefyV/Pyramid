package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: This is your 3rd task.
 * Please implement the class to satisfy the interface. *
 */
public class YourSolver implements PyramidSolver {

    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        if(pyramid == null) {
            throw new IllegalArgumentException("Pyramid cannot be null");
        }

        int rows = pyramid.getRows();
        if(rows == 0) return 0;

        int[][] data = pyramid.getData();
        if(rows == 1) return data[0][0];

        long[] memSum = new long[rows];
        for (int i = 0; i < rows; i++) {
            memSum[i] = data[0][i];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 0; col < rows - row; col++) {
                memSum[col] =  data[row][col] + Math.max( memSum[col], memSum[col+1] );
            }
        }

        return memSum[0];
    }
}
