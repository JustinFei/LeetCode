public boolean isHappy (int number) {
    Set<Integer> cache = new HashSet<>();
    int sumOfDigits = 0;
    while (true) {
        sumOfDigits += (number % 10) * (number % 10);
        number /= 10;
        if (number == 0) {  // digits' square computation finished
            if (cache.contains(sumOfDigits)) {  // means endless loop
                return false;
            } else if (sumOfDigits == 1) {  // The number is happy, me too, ^_^
                return true;
            }
            cache.add(sumOfDigits);             // mark as appeared before
            number = sumOfDigits;               // next generation initialization
            sumOfDigits = 0;                    // next generation initialization
        }
    }
}