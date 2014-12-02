(ns kind-of-bloom.core)

(defn create-bloom-filter [hashes filter-length]
  {:hashes hashes :array-data (boolean-array filter-length)})

(defn filter-length [bf]
  (count (bf :array-data)))

(defn hash-functions [bf]
  (bf :hashes))

(defn false-positive-rate [num-hashes filter-length expected-amount]
  (- 1 (Math/exp (/ (* -1 num-hashes expected-amount) filter-length))))

(defn add-item [bf item]
  (let [bits (map (fn [f] (f item)) (bf :hashes))
        new-array (aclone (bf :array-data))]
    (doseq [i bits]
      (aset-boolean new-array i true))
    {:hashes (bf :hashes) :array-data new-array}))

(defn in-filter [bf item]
  (let [bits (map (fn [f] (f item)) (bf :hashes))]
    (every? identity (map (fn [i] (aget (bf :array-data) i)) bits))))
