(ns start.config)

(def config {:top-level-package "start"
             :js "public/javascripts"
             :dev-js-file-name "main.js"
             :prod-js-file-name "mainp.js"
             :dev-js ["goog.require('start.core');"
                      "goog.require('start.model');"
                      "start.core.start();start.core.repl();"]
             :prod-js ["start.core.start();"]
             :reload-clj ["/start/templates"
                          "/start/api"
                          "/start/core"]})

(defn cljs-build-opts [config]
  {:output-to (str (:js config) "/" (:dev-js-file-name config))
   :output-dir (str (:js config) "/out")})

(defn production-js [config]
  (str (:js config) "/" (:prod-js-file-name config)))
