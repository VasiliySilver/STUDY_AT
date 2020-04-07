package com.vector;

public class Main {
    public static void main(String[] args) {
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);
        AbVector sum_vector = v1.sum(v2);
        AbVector diff_vectors = v2.diff(v1);
        sum_vector.print();


    }
}
