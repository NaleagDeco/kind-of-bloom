(ns kind-of-bloom.bit-array-test
  (:require [clojure.test :refer :all]
            [kind-of-bloom.bit-array :refer :all]))

(deftest test-bits
  (let [n 3000
        f (bit-array n)]
    (is (= 31 (f :element-width)))
    (doseq [x (range 0 n)]
      (is (= 0 (get-bit f x))))
    (doseq [x (range 0 n)]
      (set-bit! f x 1)
      (is (= 1 (get-bit f x))))
    (doseq [x (range 0 n)]
      (set-bit! f x 0)
      (is (= 0 (get-bit f x))))))
