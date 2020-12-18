package blatt08;

public class Karte {

  enum KartenFarbe { KARO, HERZ, PIK, KREUZ }

  static int farbenWert(KartenFarbe farbe) {
    int ret;
    switch (farbe) {
    case KARO:
      ret = 9;
      break;
    case HERZ:
      ret = 10;
    case PIK:
      ret = 11;
    default:
      ret = 12;
      break;
    }
    return ret;
  }
}
