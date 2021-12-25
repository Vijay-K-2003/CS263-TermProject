import java.util.ArrayList;
public class SearchResults
{
    public static int binarySearch(ArrayList<Node> arr, int l, int r, String x)
    {
        int len=x.length();
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr.get(mid).data.name.substring(0, len+1).compareTo(x)==0){
                System.out.println("Element found");
                return mid;
            }

            if (arr.get(mid).data.name.substring(0, len+1).compareTo(x)>0)
                return binarySearch(arr, l, mid - 1, x);

            return binarySearch(arr, mid + 1, r, x);
        }

        return -1;
    }
}