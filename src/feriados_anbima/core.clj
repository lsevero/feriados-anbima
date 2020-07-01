(ns feriados-anbima.core
  (:require [java-time :as jt]
            [clj-time.core :as t]
            [clj-time.local :as l]
            [clj-time.coerce :as c]
            [clj-time.format :as f]
            [clj-time.predicates :as p])
  (:import [java.util Date]
           [org.joda.time DateTime]
           [java.time LocalDateTime Instant ZonedDateTime Month]))

(def ^:const feriados-anbima #{
"20010101"
"20010226"
"20010227"
"20010413"
"20010421"
"20010501"
"20010614"
"20010907"
"20011012"
"20011102"
"20011115"
"20011225"
"20020101"
"20020211"
"20020212"
"20020329"
"20020421"
"20020501"
"20020530"
"20020907"
"20021012"
"20021102"
"20021115"
"20021225"
"20030101"
"20030303"
"20030304"
"20030418"
"20030421"
"20030501"
"20030619"
"20030907"
"20031012"
"20031102"
"20031115"
"20031225"
"20040101"
"20040223"
"20040224"
"20040409"
"20040421"
"20040501"
"20040610"
"20040907"
"20041012"
"20041102"
"20041115"
"20041225"
"20050101"
"20050207"
"20050208"
"20050325"
"20050421"
"20050501"
"20050526"
"20050907"
"20051012"
"20051102"
"20051115"
"20051225"
"20060101"
"20060227"
"20060228"
"20060414"
"20060421"
"20060501"
"20060615"
"20060907"
"20061012"
"20061102"
"20061115"
"20061225"
"20070101"
"20070219"
"20070220"
"20070406"
"20070421"
"20070501"
"20070607"
"20070907"
"20071012"
"20071102"
"20071115"
"20071225"
"20080101"
"20080204"
"20080205"
"20080321"
"20080421"
"20080501"
"20080522"
"20080907"
"20081012"
"20081102"
"20081115"
"20081225"
"20090101"
"20090223"
"20090224"
"20090410"
"20090421"
"20090501"
"20090611"
"20090907"
"20091012"
"20091102"
"20091115"
"20091225"
"20100101"
"20100215"
"20100216"
"20100402"
"20100421"
"20100501"
"20100603"
"20100907"
"20101012"
"20101102"
"20101115"
"20101225"
"20110101"
"20110307"
"20110308"
"20110421"
"20110422"
"20110501"
"20110623"
"20110907"
"20111012"
"20111102"
"20111115"
"20111225"
"20120101"
"20120220"
"20120221"
"20120406"
"20120421"
"20120501"
"20120607"
"20120907"
"20121012"
"20121102"
"20121115"
"20121225"
"20130101"
"20130211"
"20130212"
"20130329"
"20130421"
"20130501"
"20130530"
"20130907"
"20131012"
"20131102"
"20131115"
"20131225"
"20140101"
"20140303"
"20140304"
"20140418"
"20140421"
"20140501"
"20140619"
"20140907"
"20141012"
"20141102"
"20141115"
"20141225"
"20150101"
"20150216"
"20150217"
"20150403"
"20150421"
"20150501"
"20150604"
"20150907"
"20151012"
"20151102"
"20151115"
"20151225"
"20160101"
"20160208"
"20160209"
"20160325"
"20160421"
"20160501"
"20160526"
"20160907"
"20161012"
"20161102"
"20161115"
"20161225"
"20170101"
"20170227"
"20170228"
"20170414"
"20170421"
"20170501"
"20170615"
"20170907"
"20171012"
"20171102"
"20171115"
"20171225"
"20180101"
"20180212"
"20180213"
"20180330"
"20180421"
"20180501"
"20180531"
"20180907"
"20181012"
"20181102"
"20181115"
"20181225"
"20190101"
"20190304"
"20190305"
"20190419"
"20190421"
"20190501"
"20190620"
"20190907"
"20191012"
"20191102"
"20191115"
"20191225"
"20200101"
"20200224"
"20200225"
"20200410"
"20200421"
"20200501"
"20200611"
"20200907"
"20201012"
"20201102"
"20201115"
"20201225"
"20210101"
"20210215"
"20210216"
"20210402"
"20210421"
"20210501"
"20210603"
"20210907"
"20211012"
"20211102"
"20211115"
"20211225"
"20220101"
"20220228"
"20220301"
"20220415"
"20220421"
"20220501"
"20220616"
"20220907"
"20221012"
"20221102"
"20221115"
"20221225"
"20230101"
"20230220"
"20230221"
"20230407"
"20230421"
"20230501"
"20230608"
"20230907"
"20231012"
"20231102"
"20231115"
"20231225"
"20240101"
"20240212"
"20240213"
"20240329"
"20240421"
"20240501"
"20240530"
"20240907"
"20241012"
"20241102"
"20241115"
"20241225"
"20250101"
"20250303"
"20250304"
"20250418"
"20250421"
"20250501"
"20250619"
"20250907"
"20251012"
"20251102"
"20251115"
"20251225"
"20260101"
"20260216"
"20260217"
"20260403"
"20260421"
"20260501"
"20260604"
"20260907"
"20261012"
"20261102"
"20261115"
"20261225"
"20270101"
"20270208"
"20270209"
"20270326"
"20270421"
"20270501"
"20270527"
"20270907"
"20271012"
"20271102"
"20271115"
"20271225"
"20280101"
"20280228"
"20280229"
"20280414"
"20280421"
"20280501"
"20280615"
"20280907"
"20281012"
"20281102"
"20281115"
"20281225"
"20290101"
"20290212"
"20290213"
"20290330"
"20290421"
"20290501"
"20290531"
"20290907"
"20291012"
"20291102"
"20291115"
"20291225"
"20300101"
"20300304"
"20300305"
"20300419"
"20300421"
"20300501"
"20300620"
"20300907"
"20301012"
"20301102"
"20301115"
"20301225"
"20310101"
"20310224"
"20310225"
"20310411"
"20310421"
"20310501"
"20310612"
"20310907"
"20311012"
"20311102"
"20311115"
"20311225"
"20320101"
"20320209"
"20320210"
"20320326"
"20320421"
"20320501"
"20320527"
"20320907"
"20321012"
"20321102"
"20321115"
"20321225"
"20330101"
"20330228"
"20330301"
"20330415"
"20330421"
"20330501"
"20330616"
"20330907"
"20331012"
"20331102"
"20331115"
"20331225"
"20340101"
"20340220"
"20340221"
"20340407"
"20340421"
"20340501"
"20340608"
"20340907"
"20341012"
"20341102"
"20341115"
"20341225"
"20350101"
"20350205"
"20350206"
"20350323"
"20350421"
"20350501"
"20350524"
"20350907"
"20351012"
"20351102"
"20351115"
"20351225"
"20360101"
"20360225"
"20360226"
"20360411"
"20360421"
"20360501"
"20360612"
"20360907"
"20361012"
"20361102"
"20361115"
"20361225"
"20370101"
"20370216"
"20370217"
"20370403"
"20370421"
"20370501"
"20370604"
"20370907"
"20371012"
"20371102"
"20371115"
"20371225"
"20380101"
"20380308"
"20380309"
"20380421"
"20380423"
"20380501"
"20380624"
"20380907"
"20381012"
"20381102"
"20381115"
"20381225"
"20390101"
"20390221"
"20390222"
"20390408"
"20390421"
"20390501"
"20390609"
"20390907"
"20391012"
"20391102"
"20391115"
"20391225"
"20400101"
"20400213"
"20400214"
"20400330"
"20400421"
"20400501"
"20400531"
"20400907"
"20401012"
"20401102"
"20401115"
"20401225"
"20410101"
"20410304"
"20410305"
"20410419"
"20410421"
"20410501"
"20410620"
"20410907"
"20411012"
"20411102"
"20411115"
"20411225"
"20420101"
"20420217"
"20420218"
"20420404"
"20420421"
"20420501"
"20420605"
"20420907"
"20421012"
"20421102"
"20421115"
"20421225"
"20430101"
"20430209"
"20430210"
"20430327"
"20430421"
"20430501"
"20430528"
"20430907"
"20431012"
"20431102"
"20431115"
"20431225"
"20440101"
"20440229"
"20440301"
"20440415"
"20440421"
"20440501"
"20440616"
"20440907"
"20441012"
"20441102"
"20441115"
"20441225"
"20450101"
"20450220"
"20450221"
"20450407"
"20450421"
"20450501"
"20450608"
"20450907"
"20451012"
"20451102"
"20451115"
"20451225"
"20460101"
"20460205"
"20460206"
"20460323"
"20460421"
"20460501"
"20460524"
"20460907"
"20461012"
"20461102"
"20461115"
"20461225"
"20470101"
"20470225"
"20470226"
"20470412"
"20470421"
"20470501"
"20470613"
"20470907"
"20471012"
"20471102"
"20471115"
"20471225"
"20480101"
"20480217"
"20480218"
"20480403"
"20480421"
"20480501"
"20480604"
"20480907"
"20481012"
"20481102"
"20481115"
"20481225"
"20490101"
"20490301"
"20490302"
"20490416"
"20490421"
"20490501"
"20490617"
"20490907"
"20491012"
"20491102"
"20491115"
"20491225"
"20500101"
"20500221"
"20500222"
"20500408"
"20500421"
"20500501"
"20500609"
"20500907"
"20501012"
"20501102"
"20501115"
"20501225"
"20510101"
"20510213"
"20510214"
"20510331"
"20510421"
"20510501"
"20510601"
"20510907"
"20511012"
"20511102"
"20511115"
"20511225"
"20520101"
"20520304"
"20520305"
"20520419"
"20520421"
"20520501"
"20520620"
"20520907"
"20521012"
"20521102"
"20521115"
"20521225"
"20530101"
"20530217"
"20530218"
"20530404"
"20530421"
"20530501"
"20530605"
"20530907"
"20531012"
"20531102"
"20531115"
"20531225"
"20540101"
"20540209"
"20540210"
"20540327"
"20540421"
"20540501"
"20540528"
"20540907"
"20541012"
"20541102"
"20541115"
"20541225"
"20550101"
"20550301"
"20550302"
"20550416"
"20550421"
"20550501"
"20550617"
"20550907"
"20551012"
"20551102"
"20551115"
"20551225"
"20560101"
"20560214"
"20560215"
"20560331"
"20560421"
"20560501"
"20560601"
"20560907"
"20561012"
"20561102"
"20561115"
"20561225"
"20570101"
"20570305"
"20570306"
"20570420"
"20570421"
"20570501"
"20570621"
"20570907"
"20571012"
"20571102"
"20571115"
"20571225"
"20580101"
"20580225"
"20580226"
"20580412"
"20580421"
"20580501"
"20580613"
"20580907"
"20581012"
"20581102"
"20581115"
"20581225"
"20590101"
"20590210"
"20590211"
"20590328"
"20590421"
"20590501"
"20590529"
"20590907"
"20591012"
"20591102"
"20591115"
"20591225"
"20600101"
"20600301"
"20600302"
"20600416"
"20600421"
"20600501"
"20600617"
"20600907"
"20601012"
"20601102"
"20601115"
"20601225"
"20610101"
"20610221"
"20610222"
"20610408"
"20610421"
"20610501"
"20610609"
"20610907"
"20611012"
"20611102"
"20611115"
"20611225"
"20620101"
"20620206"
"20620207"
"20620324"
"20620421"
"20620501"
"20620525"
"20620907"
"20621012"
"20621102"
"20621115"
"20621225"
"20630101"
"20630226"
"20630227"
"20630413"
"20630421"
"20630501"
"20630614"
"20630907"
"20631012"
"20631102"
"20631115"
"20631225"
"20640101"
"20640218"
"20640219"
"20640404"
"20640421"
"20640501"
"20640605"
"20640907"
"20641012"
"20641102"
"20641115"
"20641225"
"20650101"
"20650209"
"20650210"
"20650327"
"20650421"
"20650501"
"20650528"
"20650907"
"20651012"
"20651102"
"20651115"
"20651225"
"20660101"
"20660222"
"20660223"
"20660409"
"20660421"
"20660501"
"20660610"
"20660907"
"20661012"
"20661102"
"20661115"
"20661225"
"20670101"
"20670214"
"20670215"
"20670401"
"20670421"
"20670501"
"20670602"
"20670907"
"20671012"
"20671102"
"20671115"
"20671225"
"20680101"
"20680305"
"20680306"
"20680420"
"20680421"
"20680501"
"20680621"
"20680907"
"20681012"
"20681102"
"20681115"
"20681225"
"20690101"
"20690225"
"20690226"
"20690412"
"20690421"
"20690501"
"20690613"
"20690907"
"20691012"
"20691102"
"20691115"
"20691225"
"20700101"
"20700210"
"20700211"
"20700328"
"20700421"
"20700501"
"20700529"
"20700907"
"20701012"
"20701102"
"20701115"
"20701225"
"20710101"
"20710302"
"20710303"
"20710417"
"20710421"
"20710501"
"20710618"
"20710907"
"20711012"
"20711102"
"20711115"
"20711225"
"20720101"
"20720222"
"20720223"
"20720408"
"20720421"
"20720501"
"20720609"
"20720907"
"20721012"
"20721102"
"20721115"
"20721225"
"20730101"
"20730206"
"20730207"
"20730324"
"20730421"
"20730501"
"20730525"
"20730907"
"20731012"
"20731102"
"20731115"
"20731225"
"20740101"
"20740226"
"20740227"
"20740413"
"20740421"
"20740501"
"20740614"
"20740907"
"20741012"
"20741102"
"20741115"
"20741225"
"20750101"
"20750218"
"20750219"
"20750405"
"20750421"
"20750501"
"20750606"
"20750907"
"20751012"
"20751102"
"20751115"
"20751225"
"20760101"
"20760302"
"20760303"
"20760417"
"20760421"
"20760501"
"20760618"
"20760907"
"20761012"
"20761102"
"20761115"
"20761225"
"20770101"
"20770222"
"20770223"
"20770409"
"20770421"
"20770501"
"20770610"
"20770907"
"20771012"
"20771102"
"20771115"
"20771225"
"20780101"
"20780214"
"20780215"
"20780401"
"20780421"
"20780501"
"20780602"
"20780907"
"20781012"
"20781102"
"20781115"
"20781225"
})

(def ^:private custom-formatter (f/formatter "yyyyMMdd"))

(defprotocol ParseDate
  (parse-date [date]))

(extend-protocol ParseDate
  Date                        (parse-date [date]
                                (->> date c/from-date (f/unparse custom-formatter)))
  DateTime                    (parse-date [date]
                                (->> date (f/unparse custom-formatter)))
  org.joda.time.LocalDateTime (parse-date [date]
                                (->> date c/to-date-time (f/unparse custom-formatter)))
  LocalDateTime               (parse-date [^LocalDateTime date]
                                (let [day (.getDayOfMonth date)
                                      month (.getValue ^Month (.getMonth date))
                                      year (.getYear date)
                                      hour (.getHour date)
                                      minute (.getMinute date)
                                      sec (.getSecond date)]
                                  (f/unparse custom-formatter (t/date-time year month day hour minute sec))))
  ZonedDateTime               (parse-date [^ZonedDateTime date]
                                (let [day (.getDayOfMonth date)
                                      month (.getValue ^Month (.getMonth date))
                                      year (.getYear date)
                                      hour (.getHour date)
                                      minute (.getMinute date)
                                      sec (.getSecond date)]
                                  (f/unparse custom-formatter (t/date-time year month day hour minute sec))))
  Instant                     (parse-date [date]
                                (->> date jt/java-date c/from-date (f/unparse custom-formatter))))

(comment (parse-date (jt/zoned-date-time)))
(comment (parse-date (l/local-now)))
(comment (parse-date (t/now)))
(comment (parse-date (Date.)))
(comment (parse-date (LocalDateTime/now)))
(comment (parse-date (jt/instant)))

(defn feriado?
  "Checa se a data é um feriado de acordo com a tabela de feriados da ANBIMA"
  [date]
  (-> date parse-date feriados-anbima some?))
(comment (feriado? (jt/zoned-date-time 2078 12 25)))
(comment (feriado? (t/date-time 2078 12 25)))
(comment (feriado? (t/local-date-time 2078 12 25)))
(comment (feriado? (Date. 2078 12 25)))
(comment (feriado? (t/now)))

(defn dia-util?
  "Checa se a data é um dia da semana e não é um feriado"
  [date]
  (cond 
    (= (type date) Instant) (and (-> date jt/java-date c/from-date p/weekday?)
                                 (not (feriado? date)))
    (= (type date) ZonedDateTime) (let [day (.getDayOfMonth date)
                                        month (.getValue ^Month (.getMonth date))
                                        year (.getYear date)
                                        hour (.getHour date)
                                        minute (.getMinute date)
                                        sec (.getSecond date)
                                        joda-date (t/date-time year month day hour minute sec)]
                                    (and (p/weekday? joda-date)
                                         (not (feriado? joda-date))))
    :else (and (p/weekday? date)
               (not (feriado? date)))))

(comment (dia-util? (jt/zoned-date-time 2078 12 25)))
(comment (dia-util? (t/date-time 2078 12 25)))
(comment (dia-util? (t/local-date-time 2078 12 25)))
(comment (dia-util? (Date. 2078 12 25)))
(comment (dia-util? (t/now)))
(comment (dia-util? (jt/instant)))
