package Iterators;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IterableFibonacci implements Iterable<Long>{               //Implements Iterable as Type Long
    private long first;
    private long second;
    List<Long> list = new LinkedList<Long>();                           //Sets list to store elements

    @Override
    public Iterator<Long> iterator() {
        return new FibonacciIterator(list);                             //Returns the list as an Iterator
    }
    
    public IterableFibonacci(long first ,long second){                  //Parameterized constructor
        this.first = first;
        this.second = second;
        list.add(first);                                                //Adds first two elements to list
        list.add(second);
    }
    public void add(){                                      //Makes fibonacci series
        long nextTerm = first + second;
        first = second;
        second = nextTerm;
        list.add(second);
    }
    public String toString(){                               //Converts list to string form
        return list.toString();
    }
    public Long get(int index){                         //Returns element at list index
        return list.get(index);
    }

    public int length(){                        //Returns length of list
        return list.size();
    }

    class FibonacciIterator implements Iterator<Long> {             //FibonacciIterator class that implements Iterator

        public int currentIndex = 0;
        private List newList;

        public FibonacciIterator(List newList){                 //Sets list as Iterator
            this.newList = newList;
        }
    
        public boolean hasNext() {                              //Checks if there is next element in list
            return currentIndex < list.size();
        }
    
        public Long next() {                                //Returns next element in list
            long result = get(currentIndex);
            currentIndex++;
            return result;
        }
    }
    public static void main(String[] args){                                     //Main method that adds and display the Fibonacci Series
        IterableFibonacci fib = new IterableFibonacci(2, 5);
        fib.add();
        fib.add();
        System.out.println(fib);
    }
}