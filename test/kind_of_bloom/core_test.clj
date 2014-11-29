(ns kind-of-bloom.core-test
  (:require [clojure.test :refer :all]
            [kind-of-bloom.core :refer :all]))

(deftest create-bloom-filter
  (testing "bom-filter"
    (is (bloom-filter) {})))
