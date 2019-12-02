(use 'clojure.java.io)

(defn get-lines [fname]
   (with-open [r (reader fname)]
      (doall (line-seq r))))

(def x (get-lines "src/day-1/input.txt"))

(def mass-list (map read-string x))

(defn get-fuel [mass]
   (+ -2 (quot mass 3)))

(def total (reduce + (map get-fuel mass-list)))

(defn get-fuel-2 [mass]
   (let [fuel (get-fuel mass)]
      (if (> 0 fuel) 0 (+ fuel (get-fuel-2 fuel)))))

(def total-2 (reduce + (map get-fuel-2 mass-list)))
