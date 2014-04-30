public class Route {
    int[] directions;   //Przechowujemy tak jak na wykladzie. Na n-tej pozycji jest do kąd jedziemy z n-tego miasta.

    boolean validate(){
        for(int i=0;i<directions.length;i++){
            if(directions[i]==i) return false;
        }
        return true;
    }
}
