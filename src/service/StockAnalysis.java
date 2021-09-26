package service;

public class StockAnalysis {

    public double[] sharePrice(double[] price) {
        sort(price);
        return price;
    }

    public void sharePriceAscendingOrder(double[] price) {
        sharePrice(price);
        System.out.println("Stock prices in ascending order are : \n");
        for (double i : price)
            System.out.print(i + " ");
    }

    public void sharePriceDescendingOrder(double[] price) {
        double[] descendingPrice = new double[price.length];
        int j = 0;
        for (int i = price.length - 1; i >= 0; i--) {
            descendingPrice[j] = price[i];
            j++;
        }
        System.out.println("\"Stock prices in descending order are : \n");
        for (double i : descendingPrice)
            System.out.print(i + " ");
    }

    private void sort(double[] dataSet) {

        int size = dataSet.length;
        if (size < 2) return;
        int mid = size / 2;
        double left[] = new double[mid];
        double right[] = new double[size - mid];
        for (int i = 0; i < mid; i++)
            left[i] = dataSet[i];
        for (int i = mid; i < size; i++)
            right[i - mid] = dataSet[i];

        sort(left);
        sort(right);
        merge(dataSet, left, right);

    }

    private void merge(double[] data, double[] left, double[] right) {

        int n1 = left.length, n2 = right.length, i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                data[k] = left[i];
                i++;
            } else {
                data[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            data[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            data[k] = right[j];
            j++;
            k++;
        }
    }

    private boolean search(double[] prices, double element) {
        int start = 0, end = prices.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (element < prices[middle]) {
                end = middle - 1;
            } else if (element > prices[middle]) {
                start = middle + 1;
            } else if (element == prices[middle]) {
                return true;
            }
        }
        return false;
    }

    public void searchElement(double[] sortedPrice, double key) {
        if (search(sortedPrice, key)) System.out.println("Stock of value " + key + " is present");
        else System.out.println("Value not found");
    }

}
