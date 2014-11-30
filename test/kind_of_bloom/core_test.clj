(ns kind-of-bloom.core-test
  (:require [clojure.test :refer :all]
            [kind-of-bloom.core :refer :all]))

(deftest bloom-filter-creation
  (let [k [(fn [x] x) (fn [x] x) (fn [x] x)]
        m 31
        bf (create-bloom-filter k m)]
    (is (= m (filter-length bf)))
    (is (= (count k) (count (hash-functions bf))))))
