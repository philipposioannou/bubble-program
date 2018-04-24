public class SortAlgorithm extends Thread {


        @Override
        public void run ()
        {
            int n = num.length;
            int temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {
                    if (num[j - 1] > num[j]) {
                        //swap elements

                        temp = num[j - 1];
                        num[j - 1] = num[j];
                        num[j] = temp;

                        //print the results
                        String result = "";
                        for (int k = 0; k < num.length; k++) {
                            result += num[k] + " ";
                        }
                        final String Result = result;

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (paused) {
                                    try {
                                        Thread.sleep(2000);

                                    } catch (InterruptedException ie) {
                                    }
                                    //while (!step);{
                                    // step = false;

                                }
                                textOutput.setText(Result);
                            }
                        });

                        try {
                            Thread.sleep(1000);

                        } catch (InterruptedException ie) {

                        }
                    }
                }
            }
        }

    }
}
