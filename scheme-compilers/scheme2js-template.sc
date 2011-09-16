(define infinity Number.POSITIVE_INFINITY)
(define minus-infinity Number.NEGATIVE_INFINITY)
(define nan Number.NaN)
(define pi Math.PI)

;;;we need the following math functions (which are provided by GSL in the ikarus version)
;;(define logistic #f)
;;(define lnfact #f)
(define randomize-rng (lambda args #f))
(define random-real Math.random)
(define (random-integer n) (Math.floor (* (Math.random) n)))
(define binomial-pdf binomial_pdf)
(define poisson-pdf poisson_pdf)
(define sample-poisson sample_poisson)

(define gamma-lnpdf #f)
(define dirichlet-lnpdf #f)
(define gaussian-lnpdf #f)
(define tdist-pdf #f)
(define mmultinomial-lnpdf #f)
(define discrete-pdf #f)
(define seed-rng #f)
(define discrete-sampler #f)
(define sample-binomial #f)
(define sample-gaussian #f)
(define sample-generalized-tdist #f)
(define sample-tdist #f)
(define sample-gamma #f)
(define sample-dirichlet #f)
;(define sample-mmultinomial #f)

;(define sum #f)
;(define mean #f)
;(define logsumexp #f)
;(define normalize #f)


;;;various functions needed by header:

;; ;(fold kons knil lis) = (fold kons (kons (car lis) knil) (cdr lis))
;; ;(fold kons knil '()) = knil
(define (fold f z xs)
  (if (null? xs)
      z
      (fold f (f (first xs) z) (rest xs))))

(define current-date (lambda args #f))
(define exact->inexact (lambda (x) x))
(define inexact->exact (lambda (x) x))
(define (display x) (document.write x))
(define pretty-print display)

(define scheme-gensym gensym)

(define true #t)
(define false #f)

(define first car)
(define rest cdr)
(define pair cons)
(define (second lst) (cadr lst))
(define (third lst) (caddr lst))
(define (fourth lst) (cadddr lst))
(define (fifth lst) (list-ref lst 4))
(define (sixth lst) (list-ref lst 5))
(define (seventh lst) (list-ref lst 6))
(define (eighth lst) (list-ref lst 7))
(define (ninth lst) (list-ref lst 8))
(define (tenth lst) (list-ref lst 9))

;;;for score gradients (currently not working), requires AD:
(define (*with-score-gradient*) #f)
(define (xy-gradient-R x) (error 'grad-undefined "xy-gradient-R undefined"))
(define (tape? x) #f)
(define (tapify x) x)
(define (untapify x) x)
;; (define (min a b) (if (< a b) a b)) ;;FIXME: proper dmin?
;; (define (continuous? x) (and (real? x) (not (fixnum? x))))
(define continuous? real?)

;;;the program, defining the church-main function, will be spliced in here:
%(churchprogram)s

;;seed the random number generator
(randomize-rng)
;;go...
(display (church-main '(top) (make-empty-store)))
