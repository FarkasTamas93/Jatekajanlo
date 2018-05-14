/**
 * Ez a csomag tartalmazza az Entity osztályokat, melyekből a két tábla jön létre
 * valamint azon osztályokat, melyek a klaszterezéshez szükségesek.
 *
 * A két Enytity osztály a Jatekok és a Jatekvalasztas. Ezekből dolgozva
 * jöhet létre a Vec5KlaszterErtek, melyben sorrendben tárolódnak el
 * a játékértékelések az Euklideszi távolság méréséhez. Ez akkor ad pontos seredményt,
 * ha a játékok értékelése azonos sorrendben van.
 * A klaszterezést követően az értéklések kapnak egy klaszter számot is, annak fényében,
 * hogy mely klaszterközéphez voltak közelebb az Euklideszi távolság alapján.
 *
 */

package ajanlo.model;

