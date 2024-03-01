import java.util.Arrays;

public class DefuseTheBomb {
    public static int[] decrypt(int[] code, int k){
        int sum = 0;
        int[] out = new int[code.length];

        int[] input = new int[2*code.length];
        int j = 0;
        for (int i=0; i<input.length; i++){
            input[i] = code[j];
            j++;
            if (j == code.length){
                j = 0;
            }
        }

        if (k > 0){
            int p = 0;
            for (p=1; p<=k; p++){
                sum += input[p];
            }
            out[0] = sum;
            for (int t=1; t<out.length; t++){
                out[t] = sum - code[t] + input[p];
                sum = out[t];
                p++;
            }

        } else if (k < 0) {
            for (int i= code.length-1; i>=(code.length+k); i--){
                sum += code[i];
            }
            out[0] = sum;
            int current = code.length;
            for (int p=1; p< out.length; p++){
                out[p] = sum - input[current+k] + input[current];
                current++;
                sum = out[p];
            }


        }else {
            return out;
        }


        return out;
    }
    public static void main(String[] args) {
        int[] nums = {2,4,9,3};
        System.out.println(Arrays.toString(decrypt(nums, -2)));
    }
}
