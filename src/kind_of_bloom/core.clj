(ns kind-of-bloom.core)

(defn create-bloom-filter [hashes filter-length]
  {:hashes hashes :array-data (boolean-array filter-length)})

(defn filter-length [bf]
  (count (bf :array-data)))

(defn hash-functions [bf]
  (bf :hashes))
