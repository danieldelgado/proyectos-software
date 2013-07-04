package com.vst.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class FilterTextsUtils {

	private static final String spanishStopWords="aca, actualmente, acuerdo, adelante, ademas, adrede, afirmo, agrego, ahi, ahora, ajena, ajenas, ajeno, ajenos, algo, algun, alguna, algunas, alguno, algunos, alla, alli, alrededor, ambos, añadio, antano, ante, anterior, antes, apenas, aproximadamente, aquel, aquella, aquellas, aquello, aquellos, aqui, arribaabajo, aseguro, asi, aun, aunque, ayer, bajo, bastante, bien, breve, buen, buena, buenas, bueno, buenos, cada, casi, cerca, cierta, ciertas, cierto, ciertos, cinco, claro, comento, como, con, conmigo, conocer, considera, considero, consigo, contigo, contra, cosas, creo, cual, cuales, cualquier, cualquiera, cualquieras, cuan, cuando, cuanta, cuantas, cuanto, cuantos, cuatro, cuenta, dado, dan, dar, debajo, debe, deben, debido, decir, dejar, dejo, de, del, delante, demas, demasiada, demasiadas, demasiado, demasiados, dentro, deprisa, desde, despacio, despues, detras, dia, dias, dice, dicen, dicho, dieron, diferente, diferentes, dijeron, dijo, dio, donde, dos, durante, ejemplo, el, ella, ellas, ello, ellos, en, embargo, encima, encuentra, enfrente, enseguida, entonces, entre, era, erais, eramos, eran, eras, eres, esa, esas, ese, eso, esos, esta, estaba, estabais, estabamos, estaban, estabas, estad, estada, estadas, estado, estados, estais, estamos, estan, estando, estar, estara, estaran, estaras, estare, estareis, estaremos, estaria, estariais, estariamos, estarian, estarias, estas, este, este, esteis, estemos, esten, estes, esto, estos, estoy, estuve, estuviera, estuvierais, estuvieramos, estuvieran, estuvieras, estuvieron, estuviese, estuvieseis, estuviesemos, estuviesen, estuvieses, estuvimos, estuviste, estuvisteis, estuvo, excepto, existe, existen, explico, expreso, fin, final, fue, fuera, fuerais, fueramos, fueran, fueras, fueron, fuese, fueseis, fuesemos, fuesen, fueses, fui, fuimos, fuiste, fuisteis, general, gran, grandes, habeis, haber, habia, habiais, habiamos, habian, habias, habida, habidas, habido, habidos, habiendo, habla, hablan, habra, habran, habras, habre, habreis, habremos, habria, habriais, habriamos, habrian, habrias, hace, hacen, hacer, hacerlo, hacia, haciendo, han, has, hasta, hay, haya, hayais, hayamos, hayan, hayas, hecho, hemos, hicieron, hizo, horas, hoy, hube, hubiera, hubierais, hubieramos, hubieran, hubieras, hubieron, hubiese, hubieseis, hubiesemos, hubiesen, hubieses, hubimos, hubiste, hubisteis, hubo, igual, incluso, indico, informo, jamas, junto, juntos, lado, la, las, lejos, les, llego, lleva, llevar, los, luego, lugar, mal, manera, manifesto, mas, mayor, mediante, medio, mejor, menciono, menos, menudo, mia, mias, mientras, mio, mios, mis, misma, mismas, mismo, mismos, momento, mucha, muchas, muchisima, muchisimas, muchisimo, muchisimos, mucho, muchos, muy, nada, nadie, ningun, ninguna, ningunas, ninguno, ningunos, nos, nosotras, nosotros, nuestra, nuestras, nuestro, nuestros, nueva, nuevas, nuevo, nuevos, nunca, ocho, otra, otras, otro, otros, pais, para, parece, parecer, parte, partir, pasada, pasado, peor, pero, pesar, poca, pocas, poco, pocos, podemos, podra, podran, podria, podrian, poner, por, porque, posible, primer, primera, primero, primeros, principalmente, pronto, propia, propias, propio, propios, proximo, proximos, pudo, pueda, puede, pueden, pues, qeu, que, quedo, queremos, querer, quien, quienes, quienesquiera, quienquiera, quiere, quiza, quizas, raras, realizado, realizar, realizo, repente, respecto, salvo, sea, seais, seamos, sean, seas, segun, segunda, segundo, seis, señalo, sentid, sentida, sentidas, sentido, sentidos, ser, sera, seran, seras, sere, sereis, seremos, seria, seriais, seriamos, serian, serias, sido, siempre, siendo, siente, siete, sigue, siguiente, sin, sino, sintiendo, sobre, sois, sola, solamente, solas, solo, solos, somos, son, soy, soyos, sra, sres, sta, supuesto, sus, suya, suyas, suyo, suyos, tal, tales, tambien, tampoco, tan, tanta, tantas, tanto, tantos, tarde, temprano, tendra, tendran, tendras, tendre, tendreis, tendremos, tendria, tendriais, tendriamos, tendrian, tendrias, tened, teneis, tenemos, tener, tenga, tengais, tengamos, tengan, tengas, tengo, tenia, teniais, teniamos, tenian, tenias, tenida, tenidas, tenido, tenidos, teniendo, tercera, tiene, tienen, tienes, toda, todas, todavia, todo, todos, tomar, total, tras, trata, traves, tres, tus, tuve, tuviera, tuvierais, tuvieramos, tuvieran, tuvieras, tuvieron, tuviese, tuvieseis, tuviesemos, tuviesen, tuvieses, tuvimos, tuviste, tuvisteis, tuvo, tuya, tuyas, tuyo, tuyos, ultima, ultimas, ultimo, ultimos, un, una, unas, uno, unos, usted, ustedes, vamos, van, varias, varios, veces, ver, vez, vosostras, vosostros, vosotras, vosotros, vuestra, vuestras, vuestro, vuestros, a, b, c, d, e, f ,g , h, i, j, k, l, m, n, ñ, o, p, q, r, s, t, u, v, w, x, y, z";
	private static final String englishStopWords="a, able, about, above, abroad, according, accordingly, across, actually, adj, after, afterwards, again, against, ago, ahead, ain't, all, allow, allows, almost, alone, along, alongside, already, also, although, always, am, amid, amidst, among, amongst, an, and, another, any, anybody, anyhow, anyone, anything, anyway, anyways, anywhere, apart, appear, appreciate, appropriate, are, aren't, around, as, a's, aside, ask, asking, associated, at, available, away, awfully, b, back, backward, backwards, be, became, because, become, becomes, becoming, been, before, beforehand, begin, behind, being, believe, below, beside, besides, best, better, between, beyond, both, brief, but, by, c, came, can, cannot, cant, can't, caption, cause, causes, certain, certainly, changes, clearly, c'mon, co, co., com, come, comes, concerning, consequently, consider, considering, contain, containing, contains, corresponding, could, couldn't, course, c's, currently, d, dare, daren't, definitely, described, despite, did, didn't, different, directly, do, does, doesn't, doing, done, don't, down, downwards, during, e, each, edu, eg, eight, eighty, either, else, elsewhere, end, ending, enough, entirely, especially, et, etc, even, ever, evermore, every, everybody, everyone, everything, everywhere, ex, exactly, example, except, f, fairly, far, farther, few, fewer, fifth, first, five, followed, following, follows, for, forever, former, formerly, forth, forward, found, four, from, further, furthermore, g, get, gets, getting, given, gives, go, goes, going, gone, got, gotten, greetings, h, had, hadn't, half, happens, hardly, has, hasn't, have, haven't, having, he, he'd, he'll, hello, help, hence, her, here, hereafter, hereby, herein, here's, hereupon, hers, herself, he's, hi, him, himself, his, hither, hopefully, how, howbeit, however, hundred, i, i'd, ie, if, ignored, i'll, i'm, immediate, in, inasmuch, inc, inc., indeed, indicate, indicated, indicates, inner, inside, insofar, instead, into, inward, is, isn't, it, it'd, it'll, its, it's, itself, i've, j, just, k, keep, keeps, kept, know, known, knows, l, last, lately, later, latter, latterly, least, less, lest, let, let's, like, liked, likely, likewise, little, look, looking, looks, low, lower, ltd, m, made, mainly, make, makes, many, may, maybe, mayn't, me, mean, meantime, meanwhile, merely, might, mightn't, mine, minus, miss, more, moreover, most, mostly, mr, mrs, much, must, mustn't, my, myself, n, name, namely, nd, near, nearly, necessary, need, needn't, needs, neither, never, neverf, neverless, nevertheless, new, next, nine, ninety, no, nobody, non, none, nonetheless, noone, no-one, nor, normally, not, nothing, notwithstanding, novel, now, nowhere, o, obviously, of, off, often, oh, ok, okay, old, on, once, one, ones, one's, only, onto, opposite, or, other, others, otherwise, ought, oughtn't, our, ours, ourselves, out, outside, over, overall, own, p, particular, particularly, past, per, perhaps, placed, please, plus, possible, presumably, probably, provided, provides, q, que, quite, qv, r, rather, rd, re, really, reasonably, recent, recently, regarding, regardless, regards, relatively, respectively, right, round, s, said, same, saw, say, saying, says, second, secondly, see, seeing, seem, seemed, seeming, seems, seen, self, selves, sensible, sent, serious, seriously, seven, several, shall, shan't, she, she'd, she'll, she's, should, shouldn't, since, six, so, some, somebody, someday, somehow, someone, something, sometime, sometimes, somewhat, somewhere, soon, sorry, specified, specify, specifying, still, sub, such, sup, sure, t, take, taken, taking, tell, tends, th, than, thank, thanks, thanx, that, that'll, thats, that's, that've, the, their, theirs, them, themselves, then, thence, there, thereafter, thereby, there'd, therefore, therein, there'll, there're, theres, there's, thereupon, there've, these, they, they'd, they'll, they're, they've, thing, things, think, third, thirty, this, thorough, thoroughly, those, though, three, through, throughout, thru, thus, till, to, together, too, took, toward, towards, tried, tries, truly, try, trying, t's, twice, two, u, un, under, underneath, undoing, unfortunately, unless, unlike, unlikely, until, unto, up, upon, upwards, us, use, used, useful, uses, using, usually, v, value, various, versus, very, via, viz, vs, w, want, wants, was, wasn't, way, we, we'd, welcome, well, we'll, went, were, we're, weren't, we've, what, whatever, what'll, what's, what've, when, whence, whenever, where, whereafter, whereas, whereby, wherein, where's, whereupon, wherever, whether, which, whichever, while, whilst, whither, who, who'd, whoever, whole, who'll, whom, whomever, who's, whose, why, will, willing, wish, with, within, without, wonder, won't, would, wouldn't, x, y, yes, yet, you, you'd, you'll, your, you're, yours, yourself, yourselves, you've, z, zero";
	public static String deleteStopWords(String cadena,String delimitador){
		List<String> resultado=new ArrayList<String>();
		
		String []tokens=tokenizeToStringArray(cadena, delimitador);
		String []stopWords=tokenizeToStringArray(spanishStopWords, ",");
		for(int i=0;i<tokens.length;i++){
			boolean esta=false;
			for(int j=0;j<stopWords.length;j++){
				if(tokens[i].equalsIgnoreCase(stopWords[j])){
					esta=true;
					break;
				}
			}
			if(!esta){
				resultado.add(tokens[i]);
			}
		}
		return arrayToDelimitedString(resultado, "-");
	}
	
	
	private static String[]tokenizeToStringArray(String cadena,String delimitador){
		
		String[] result;
	    int i = 0;     // index into the next empty array element
	    
	    //--- Declare and create a StringTokenizer
	    StringTokenizer st = new StringTokenizer(cadena,delimitador);
	    
	    //--- Create an array which will hold all the tokens.
	    result = new String[st.countTokens()];
	    
	    //--- Loop, getting each of the tokens
	    while (st.hasMoreTokens()) {
	        result[i++] = st.nextToken();
	    }
	    
	    return result;
	    
	}
	
	private static String arrayToDelimitedString(List<String> resultado,String delimitador){
		StringBuilder sb = new StringBuilder();

		for(String s: resultado) {
		   sb.append(s).append(delimitador);
		}

		sb.deleteCharAt(sb.length()-1); //delete last comma

		String newString = sb.toString();
		
		return newString;
	}
}
