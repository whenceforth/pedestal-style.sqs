(defproject pedestal-style.sqs "1.0.1-alpha1"
  :description "Pedestal-style interface for AWS SQS."
  :url "https://github.com/whenceforth/pedestal-style.sqs"
  :license {:name         "The MIT License"
            :url          "http://opensource.org/licenses/MIT"
            :distribution :repo}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/core.async "0.6.532"]
                 [org.clojure/test.check "0.10.0"]

                 [io.pedestal/pedestal.service "0.5.7"]
                 [io.pedestal/pedestal.interceptor "0.5.7"]


                 [com.cognitect.aws/api "0.8.408"]
                 [com.cognitect.aws/endpoints "1.1.11.689"]
                 [com.cognitect.aws/sqs "770.2.568.0"]
                 [org.clojure/data.json "0.2.7"]
                 [org.clojure/data.xml "0.2.0-alpha6"]
                 [org.clojure/tools.logging "0.5.0"]

                 [cheshire "5.9.0"]]
  :min-lein-version "2.0.0"

  :deploy-repositories [["clojars" {:sign-releases false
                                    :url           "https://clojars.org/repo"}]]

  :global-vars {*warn-on-reflection* true}

  :main pedestal.sqs
  :source-paths ["src"]

  :profiles {:dev     {:aliases        {"integration-test" ["sqs" "test"]}
                       :plugins        [[lein-sqs "0.1.0"]
                                        [jonase/eastwood "0.3.6"]]
                       :resource-paths ["config"]
                       :dependencies   [[io.pedestal/pedestal.service-tools "0.5.7"]]}
             :uberjar {:aot :all}})
