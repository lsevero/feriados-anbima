# feriados-anbima

[![Clojars Project](https://img.shields.io/clojars/v/feriados-anbima.svg)](https://clojars.org/feriados-anbima)

Uma bilioteca feita para facilitar a detecção de feriados brasileiros programaticamente.

## Usage

```clojure
(ns seu-ns
  (:require [feriados-anbima.core :refer :all] 
            [clj-time.core :as t]
            [clj-time.local :as l]
            [clj-time.predicates :as p]))


(feriado? (t/date-time 2078 12 25))
(feriado? (t/local-date-time 2078 12 25))
(feriado? (t/now))
(dia-util? (t/date-time 2078 12 25))
(dia-util? (t/local-date-time 2078 12 25))
(dia-util? (t/now))
```

## License

Copyright © 2020 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
