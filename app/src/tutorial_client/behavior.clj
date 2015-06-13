(ns ^:shared tutorial-client.behavior
    (:require [clojure.string :as string]
              [io.pedestal.app :as app]
              [io.pedestal.app.messages :as msg]))

(defn set-value-transform [old-value message]
  (:value message))

(defn inc-transform [old-value _]
  ((fnil inc 0) old-value))

(def example-app
  {:version 2
   :transform [[:inc [:my-counter] inc-transform]]
   :emit [[#{[:*]} (app/default-emitter [:main])]]})
