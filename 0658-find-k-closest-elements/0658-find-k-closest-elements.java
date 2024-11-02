class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {


        int left = 0, right = arr.length-1;

        while ( (right-left)+1 > k ) {
            if ( Math.abs(arr[left] - x) > Math.abs(arr[right] - x) ) {
                left++;
            } else {
                right--;
            }
        }

        List<Integer> newList = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            newList.add(arr[i]);
        }

        return newList;



















        // List<Integer> newArr = new ArrayList();

        // for ( int element: arr ) {
        //     newArr.add(Math.abs(element - x));
        // }
        // System.out.println(newArr);


        // int start = 0, end = k-1;
        // int newEnd = end+1;

        // while ( newEnd < arr.length && end-start == k-1 ) {
        //     System.out.println("HI");
        //     if ( newArr.get(start) > newArr.get(end+1) ) {
        //         start++;
        //         end++;
        //     } else if ( newArr.get(start) == newArr.get(end+1) && arr[start] > arr[end+1] ) {
        //         start++;
        //         end++;
        //     }
        //     newEnd++;
        // }

        // System.out.println(start);
        // System.out.println(end);

        // List<Integer> newList = new ArrayList<>();
        // for (int i = start; i <= end; i++) {
        //     newList.add(arr[i]);
        // }

        // return newList;
    }
}