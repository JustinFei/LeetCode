    if(secret.length() == 0){return "0A0B";}

    int bull = 0;
    int cow = 0;
    int [] result = new int [10];

    for(int i = 0;i<secret.length();i++)
    {
        int x = secret.charAt(i) - 48;
        int y = guess.charAt(i) - 48;

        if(x == y)
        {
            bull++;
        }
        else
        {
            if(result[x] < 0){cow++;}
            result[x]++;

            if(result[y] > 0){cow++;}
            result[y]--;
        }
    }

    return bull+"A"+cow+"B";

}
-------------------------------------
public class Solution {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        int[] secretarr = new int[10];
        int[] guessarr = new int[10];
        int bull = 0, cow = 0;
        for (int i = 0; i < len; ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bull;
            } else {
                ++secretarr[secret.charAt(i) - '0'];
                ++guessarr[guess.charAt(i) - '0'];
            }
        }
        for (int i = 0; i < 10; ++i) {
            cow += Math.min(secretarr[i], guessarr[i]);
        }
        return "" + bull + "A" + cow + "B";
    }
}
