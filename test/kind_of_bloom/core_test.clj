(ns kind-of-bloom.core-test
  (:require [clojure.test :refer :all]
            [kind-of-bloom.core :refer :all]))

(deftest bloom-filter-creation
  (let [k [(fn [x] x) (fn [x] x) (fn [x] x)]
        m 31
        bf (create-bloom-filter k m)]
    (is (= m (filter-length bf)))
    (is (= (count k) (count (hash-functions bf))))))

(deftest bloom-filter-use
  (let [m 31
        k [(fn [x] x) (fn [x] (- (- m 1) x))]
        bf (add-item (create-bloom-filter k m) 0)]
    (is (= true (in-filter bf 0)))
    (is (= true (in-filter bf 30)))
    (doseq [i (range 1 30)]
      (is (= false (in-filter bf i))))))
