# Esercizio: Calcolo dell’angolo tra due vettori con thread asincroni

---

## Consegna

Implementare un programma in **Java** per calcolare **l’angolo fra due vettori** `U[]` e `V[]` di interi di qualsivoglia dimensione.

---

## Formula dell’angolo

L’angolo fra due vettori è definito dalla formula:

    cos(α) = (U · V) / (|U| * |V|)

dove:

- **Prodotto scalare** dei vettori `U` e `V`:

      U · V = U₁ * V₁ + U₂ * V₂ + U₃ * V₃ + ... + Uₙ * Vₙ

- **Modulo (norma) del vettore U**:

      |U| = √(U₁² + U₂² + U₃² + ... + Uₙ²)

- **Modulo (norma) del vettore V**:

      |V| = √(V₁² + V₂² + V₃² + ... + Vₙ²)

In sintesi:

    cos(α) = (U₁*V₁ + U₂*V₂ + ... + Uₙ*Vₙ) / ( √(U₁²+U₂²+...+Uₙ²) * √(V₁²+V₂²+...+Vₙ²) )

---

## Specifiche del programma

Il programma deve calcolare i tre valori necessari (prodotto scalare, modulo di U, modulo di V) **tramite tre thread asincroni indipendenti**, implementando l’interfaccia `Callable<T>`.

### Thread richiesti

1. **Thread 1:** calcola il prodotto scalare → \( U \cdot V \)
2. **Thread 2:** calcola il modulo di \( U \) → \( |U| \)
3. **Thread 3:** calcola il modulo di \( V \) → \( |V| \)

---

## Requisiti del `main()`

Il metodo `main()` deve:

- Avviare i tre thread asincroni.
- Attendere che **tutti e tre** abbiano terminato la loro esecuzione.
- Applicare la **formula (1)** per calcolare il valore del **coseno dell’angolo** fra i due vettori.

---

## Suggerimenti tecnici

Per eseguire i thread asincroni, utilizzare un **ExecutorService**, ad esempio:

```java
ExecutorService executor = Executors.newFixedThreadPool(3);
