(ns kind-of-bloom.core)

(defn create-bloom-filter [hashes filter-length]
  {:hashes hashes :array-data (boolean-array filter-length)})

(defn filter-length [bf]
  (count (bf :array-data)))

(defn hash-functions [bf]
  (bf :hashes))

(defn false-positive-rate [num-hashes filter-length expected-amount]
  (- 1 (exp (/ (* -1 num-hashes expected-amount) filter-length))))
