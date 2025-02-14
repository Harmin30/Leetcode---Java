class ProductOfNumbers {
 private List<Integer> stream;
    private int n;
    private int lastZeroIdx;
    public ProductOfNumbers() {
         stream = new ArrayList<>();
        stream.add(1);
        n = 1;
        lastZeroIdx = -1;
    }
    
    public void add(int num) {
        if (num == 0) {
            lastZeroIdx = n;
        }

        if (stream.get(stream.size() - 1) == 0) {
            stream.add(num);
        } else {
            stream.add(stream.get(stream.size() - 1) * num);
        }
        n++;
    }
    
    public int getProduct(int k) {
         if (lastZeroIdx >= n - k) {
            return 0;
        }
        if (stream.get(n - k - 1) == 0) {
            return stream.get(n - 1);
        } else {
            return stream.get(n - 1) / stream.get(n - k - 1);
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */