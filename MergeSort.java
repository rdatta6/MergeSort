package com.company;
import java.util.*;

public class MergeSort {

    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0); //comparison
    }

    public static void merge(LinkedList<Comparable> list, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        LinkedList<Comparable> aux;
        aux = (LinkedList) list.clone();

        for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    list.set(k, aux.get(j++));
                } else if (j > hi) {
                    list.set(k, aux.get(i++));
                } else if (less(aux.get(j), aux.get(i))) {
                    list.set(k, aux.get(j++));
                } else {
                    list.set(k, aux.get(i++)); //merge function
                }
            }
    }

    public static boolean isSorted(LinkedList<Comparable> list) {
        for (int i = 1; i < list.size(); i += 1) {
            if (less(list.get(i), list.get(i-1))) { //check for sort condition
                return false;
            }
        }
        return true;
    }

    public static void nSort(LinkedList<Comparable> list) {
        int i = 0;
        while(!isSorted(list)){//while not sorted
            int lo = i;
            if (i != list.size()-1) {
                while (less(list.get(i), list.get(i + 1))) {
                    i++;
                    if (i == list.size() - 1) {
                        break; //find first ordered sequence
                    }
                }
            }
            int mid = i;
            int j = i+1;
            if (j!=list.size() && j!=list.size()-1) {
                while (less(list.get(j), list.get(j + 1))) {
                    j++;
                    if (j == list.size() - 1) {
                        break; //find second ordered sequence
                    }
                }
                int hi = j;
                merge(list, lo, mid, hi); //merge them
            }
            else if(j==list.size()-1){
                merge(list,lo,mid,j);
            }
            if (j==list.size() || j==list.size()-1){
                i = 0; //if the end is reached, start over
            }
            else {i = j + 1;} //else, continue to next sorted sequence
        }
    }


    public static void main(String args[]) {
        LinkedList<Comparable> yo = new LinkedList<>();
        yo.add(35);
        yo.add(5);
        yo.add(47);
        yo.add(1);
        yo.add(-100);
        yo.add(2);
        yo.add(843);
        yo.add(1);
        yo.add(12);
        nSort(yo);
        for (int i = 0; i < 9; i++) {
            System.out.println(yo.get(i));
        }
    }
}

///Library/Java/JavaVirtualMachines/jdk-10.0.1.jdk/Contents/Home/bin/java "-javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=56762:/Applications/IntelliJ IDEA CE.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Users/rohandatta/IdeaProjects/Lab2Q1/out/production/Lab2Q1 com.company.MergeSort
//-100
//1
//1
//2
//5
//12
//35
//47
//843

