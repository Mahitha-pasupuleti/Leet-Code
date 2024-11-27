class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // System.out.println(map);

        int result = 0;

        for ( int i=1; i<s.length(); i++ ) {
            if ( map.get(s.charAt(i-1)) < map.get(s.charAt(i)) ) result -= map.get(s.charAt(i-1));
            else result += map.get(s.charAt(i-1));
        }
        result += map.get(s.charAt(s.length()-1));

        return result;
    }
}