import java.util.*;

public class Problem12 {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        int notes = console.nextInt();
        console.nextLine();

        HashMap<Character, Integer> mapping = new HashMap<>();
        mapping.put('A',0);
        mapping.put('B',2);
        mapping.put('C',3);
        mapping.put('D',5);
        mapping.put('E',7);
        mapping.put('F',8);
        mapping.put('G',10);

        int[] vals = new int[notes];
        int hashes = 0;
        int maxNote = -1;
        int minNote = 88;

        for(int i=0;i<notes;i++){
            String note = console.nextLine();
            int x;
            if(note.charAt(1)=='0'){
                x = mapping.get(note.charAt(0));
            }
            else{
                x = mapping.get(note.charAt(0))+12*(note.charAt(1)-49);
            }

            if(note.length()==3){
                hashes++;
                x++;
            }
            if(x>maxNote){
                maxNote = x;
            }
            if(x<minNote){
                minNote = x;
            }
            vals[i] = x%12;
        }


        int upperShift = Math.min(11,87-maxNote);
        int lowerShift = Math.min(11,minNote);



        HashSet<Integer> hasHash = new HashSet<>();
        hasHash.add(1);
        hasHash.add(4);
        hasHash.add(6);
        hasHash.add(9);
        hasHash.add(11);

        int bestHashes = hashes;


        for(int i =1;i<=upperShift;i++){
            int currHashes = 0;
            for(int val:vals){
                if(hasHash.contains((val+i)%12)){
                    currHashes++;
                }
            }
            if(currHashes+1<bestHashes){
                bestHashes = currHashes+1;
            }
        }

        for(int i =1;i<=lowerShift;i++){
            int currHashes = 0;
            for(int val:vals){
                if(hasHash.contains((val-i+12)%12)){
                    currHashes++;
                }
            }
            if(currHashes+2<bestHashes){
                bestHashes = currHashes+2;
            }
        }

        System.out.println(notes*2+bestHashes);


    }
}
