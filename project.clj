(defproject feriados-anbima "0.2.7"
  :description "Bilioteca para facilitar a checagem de feriados brasileiros e dias úteis"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clojure.java-time "0.3.2"]
                 [clj-time "0.15.2"]]
  :profiles {:dev {:dependencies [[org.slf4j/slf4j-log4j12 "1.7.1"]]
                   :plugins [[cider/cider-nrepl "0.24.0"]]
                   :source-paths ["src" "test" "dev"]
                   :resource-paths ["resources" "resources-dev"]}}
  :repl-options {:init-ns feriados-anbima.core})
