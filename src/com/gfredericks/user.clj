(ns com.gfredericks.user)

(defn load-dot-clojure-user-clj
  "Loads ~/.clojure/user.clj, if it exists."
  []
  (let [f
        (.toFile
         (java.nio.file.Paths/get
          (System/getenv "HOME")
          (into-array String [".clojure" "user.clj"])))]
    (if (.exists f)
      (try
        (load-file (str f))
        (catch Exception e
          (binding [*out* *err*]
            (printf "WARNING: Exception while loading %s\n" f)
            (prn e)))))))

(defn go
  "Performs all the functionality of the com.gfredericks/user.clj library,
  printing and swallowing any exceptions."
  []
  (try
    (when (not (System/getenv "LEIN_NO_USER_PROFILES"))
      (load-dot-clojure-user-clj))
    (catch Exception e
      (binding [*out* *err*]
        (println "WARNING: unexpected exception in com.gfredericks.user/go")
        (prn e)))))
