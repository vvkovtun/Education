package com.vadym.Safe;

import java.util.ArrayList;

/**
 * Created by vvkovtun on 01/12/2015.
 */
public class Safe {
    final int SAFE_I = 4;
    final int SAFE_J = 4;
    final int MAX_LEVEL = 9;
    int[][][] arrLavel = new int[MAX_LEVEL + 1][SAFE_I][SAFE_J];
    int levelFound = 99999;
    ArrayList<String> matrixWay = new ArrayList<String>();
    String minWay;


    void findWayPoint(int[][] m, int level, int iPrior, int jPrior) {
        int curLevel = level + 1;
        if (curLevel > MAX_LEVEL || levelFound <= level) {
            return;
        }
        for (int i = 0; i < m.length; i++) {
            int[][] arrBuf = new int[SAFE_I][SAFE_J];
            for (int j = 0; j < m[i].length; j++) {
                if ((iPrior == i && jPrior == j) == false) {
                    arrBuf = arrayCopy(m);
                    change(arrBuf, i, j);
                    arrLavel[curLevel][0][0] = i;
                    arrLavel[curLevel][0][1] = j;
                    if (checksMatrix(arrBuf)) {
                        saveKey(curLevel);
                        return;
                    } else {
                        findWayPoint(arrBuf, curLevel, i, j);
                    }
                }
            }
        }
    }


    int[][] findKey(int[][] m) {
        int curLevel = 1;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                int[][] arrBuf = new int[4][4];
                arrLavel[curLevel][0][0] = i;
                arrLavel[curLevel][0][1] = j;
                arrBuf = arrayCopy(m);
                change(arrBuf, i, j);
                if (checksMatrix(arrBuf)) {
                    saveKey(curLevel);
                    return arrBuf;
                } else {
                    findWayPoint(arrBuf, curLevel, i, j);
                }
            }
        }
        return m;
    }

    void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }

    boolean checksMatrix(int[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }


    void change(int[][] mt, int i, int j) {

        for (int k = 0; k < mt.length; k++) {
            mt[i][k] = mt[i][k] == 0 ? 1 : 0;
        }


        for (int k = 0; k < mt.length; k++) {
            if (k != i) {
                mt[k][j] = mt[k][j] == 0 ? 1 : 0;
            }
        }
    }

    int[][] arrayCopy(int[][] arrayFrom) {
        int[][] result = new int[SAFE_I][SAFE_J];
        for (int i = 0; i < arrayFrom.length; i++) {
            for (int j = 0; j < arrayFrom[i].length; j++) {
                result[i][j] = arrayFrom[i][j];
            }
        }
        return result;
    }


    String getArrayLevel(int curLevel) {
        StringBuilder b = new StringBuilder();
        for (int i = 1; i <= curLevel; i++) {
            b.append("[");
            b.append(arrLavel[i][0][0]);
            b.append(",");
            b.append(arrLavel[i][0][1]);
            b.append("]");
        }
        return curLevel + b.toString();
    }

    void saveKey(int curLevel) {
        minWay = "(" + getArrayLevel(curLevel) + ")";
        matrixWay.add(minWay);
        levelFound = curLevel;
    }
}
