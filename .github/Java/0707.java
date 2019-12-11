public class Homework0707 {
    /** Main method */
    public static void main(String[] args) {
//        int counts[] = new int[10] ;
        int nums[] = new int[100] ;

        /** 产生含有100个随机数的数组 */
        for ( int i = 0 ; i < 100 ; i++ ){
            nums[i] = ((int) (Math.random() * 10)) ;
        }

        for ( int m = 0 ; m < 10 ; m++ ) {
            int j = 0 ;

            for ( int n = 0 ; n < 100 ; n++ ){
                if ( nums[n] == m ){
                    j++ ;
//                    counts[m] = j ;
                }
            }

            System.out.println( m + "出现的次数为: " + j + " ;");
        }
    }
}