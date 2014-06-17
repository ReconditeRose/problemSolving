package eulerProblems51_100;

public class Problem80 {

	/**
	 * @param args
	 */
	static String[] values = {
			"1.",
			"1.41421356237309504880168872420969807856967187537694807317667973799073247846210703885038753432764157273501384623091229702",
			"1.73205080756887729352744634150587236694280525381038062805580697945193301690880003708114618675724857567562614141540670303",
			"2.",
			"2.23606797749978969640917366873127623544061835961152572427089724541052092563780489941441440837878227496950817615077378350",
			"2.44948974278317809819728407470589139196594748065667012843269256725096037745731502653985943310464023481859460122661418912",
			"2.64575131106459059050161575363926042571025918308245018036833445920106882323028362776039288647454361061506457833849746310",
			"2.82842712474619009760337744841939615713934375075389614635335947598146495692421407770077506865528314547002769246182459404",
			"3.",
			"3.16227766016837933199889354443271853371955513932521682685750485279259443863923822134424810837930029518734728415284005515",
			"3.31662479035539984911493273667068668392708854558935359705868214611648464260904384670884339912829065090701255784952745659",
			"3.46410161513775458705489268301174473388561050762076125611161395890386603381760007416229237351449715135125228283081340606",
			"3.60555127546398929311922126747049594625129657384524621271045305622716694829301044520461908201849071767351418202406354038",
			"3.74165738677394138558374873231654930175601980777872694630374546732003515630693902797680989519437957150099108872775197755",
			"3.87298334620741688517926539978239961083292170529159082658757376611348309193697903351928737685867351791630220686094964701",
			"4.",
			"4.12310562561766054982140985597407702514719922537362043439863357309495434633762159358786365081068429668454404093921414162",
			"4.24264068711928514640506617262909423570901562613084421953003921397219743538632111655116260298292471820504153869273689106",
			"4.35889894354067355223698198385961565913700392523244493689034413815955732820315808565615915585194452690565862129827421363",
			"4.47213595499957939281834733746255247088123671922305144854179449082104185127560979882882881675756454993901635230154756700",
			"4.58257569495584000658804719372800848898445657676797190260724212390686842554777088660436155949344503267760090539758574087",
			"4.69041575982342955456563011354446628058822835341173715360570189101702463275323972148211559606154313535459589666150860748",
			"4.79583152331271954159743806416269391999670704190412934648530911444825723590746408249219144643691886061747456324573686513",
			"4.89897948556635619639456814941178278393189496131334025686538513450192075491463005307971886620928046963718920245322837824",
			"5.",
			"5.09901951359278483002822410902278198956377094609959640758497080442593363206222419558834885109393200836119025824103991066",
			"5.19615242270663188058233902451761710082841576143114188416742093835579905072640011124343856027174572702687842424622010909",
			"5.29150262212918118100323150727852085142051836616490036073666891840213764646056725552078577294908722123012915667699492620",
			"5.38516480713450403125071049154032955629512016164478883768038867001664596282765869287663378167983548441870482179394576061",
			"5.47722557505166113456969782800802133952744694997983254226894449732493277122722733800858436163870625764726825942851392244",
			"5.56776436283002192211947129891854952047639337757041430396843258560358983925423629292721839618492667842321652739797026622",
			"5.65685424949238019520675489683879231427868750150779229270671895196292991384842815540155013731056629094005538492364918808",
			"5.74456264653802865985061146821892931822026445798279236769987747056590072145740462702712536559678812241955747694565083787",
			"5.83095189484530047087415287754558307652139833488597195445000674486781006199671262766524032645303539855678962207535491135",
			"5.91607978309961604256732829156161704841550123079434032287971966914282245910565303676575252718310917808862563511425455570",
			"6.",
			"6.08276253029821968899968424520206706208497009478641118641915304648633272531891023980306642795784866343093510090513116373",
			"6.16441400296897645025019238145424422523562402344457454487457207245839965026366421296672979919889994514855730393763723589",
			"6.24499799839839820584689312093979446107295997799165630845297193060961120058351450063333611222134058710783492585746290443",
			"6.32455532033675866399778708886543706743911027865043365371500970558518887727847644268849621675860059037469456830568011030",
			"6.40312423743284868648821767462181326452042013262101888552927262666818275819687607428935430224986996317081183250379718326",
			"6.48074069840786023096596743608799665770520430705834654971135439780961737784404437140036090660561023567545054209741169434",
			"6.55743852430200065234410999763600162792696631988378976986546010558565985348857563935580529096967854802054114870924329488",
			"6.63324958071079969822986547334137336785417709117870719411736429223296928521808769341768679825658130181402511569905491318",
			"6.70820393249936908922752100619382870632185507883457717281269173623156277691341469824324322513634682490852452845232135050",
			"6.78232998312526813906455632662596910519574832392328823275021958208072826398711258986264094093633004422870001819674266859",
			"6.85565460040104412493587144908484896046064346100132627548510818567851711513681699922732514850006683693875694634350506615",
			"6.92820323027550917410978536602348946777122101524152251222322791780773206763520014832458474702899430270250456566162681212",
			"7.",
			"7.07106781186547524400844362104849039284835937688474036588339868995366239231053519425193767163820786367506923115456148510",
			"7.14142842854284999799939981136726527876617115990273383320843088276582040644002188625898821353282041823448963226050852153",
			"7.21110255092797858623844253494099189250259314769049242542090611245433389658602089040923816403698143534702836404812708076",
			"7.28010988928051827109730249152703279377766968257647743837818179128411573862490518332957940908092675219263457047305781216",
			"7.34846922834953429459185222411767417589784244197001038529807770175288113237194507961957829931392070445578380367984256736",
			"7.41619848709566294871139744080071306097990431909750159873262326434383018431385024275300921319582494350602511185273715756",
			"7.48331477354788277116749746463309860351203961555745389260749093464007031261387805595361979038875914300198217745550395510",
			"7.54983443527074969723668480694611705822219470462338013829862690571072195391781119558245207414752397258448054230351576625",
			"7.61577310586390828566141102715832300536070559254659846895048424052035215737300124464226971438715164561597544052944631618",
			"7.68114574786860817576968702173137247306245107761488392802473648393554165799270985185604772796137779901638905968431611211",
			"7.74596669241483377035853079956479922166584341058318165317514753222696618387395806703857475371734703583260441372189929402",
			"7.81024967590665439412972273575910141356830513664856330017724376019078558893672705442543305226700489518090163471740731248",
			"7.87400787401181101968503444881200786368108612202085379459884255031376084681769805692619135124874688992745288968851766560",
			"7.93725393319377177150484726091778127713077754924735054110500337760320646969085088328117865942363083184519373501549238930",
			"8.",
			"8.06225774829854965236661323030377113113439630560857338793659238926387495102568820296015426671723064363744246613994591221",
			"8.12403840463596036045988356826604034850420408672531282765157559453291680284067269499915760294793687743797951151587069800",
			"8.18535277187244996995370372473392945888048681549803996306671520272366761446109794534392467163786834453471127515600621176",
			"8.24621125123532109964281971194815405029439845074724086879726714618990869267524318717572730162136859336908808187842828324",
			"8.30662386291807485258426274490749201023221424895565577943218836903758503342315157386739850823235705026501403985790587156",
			"8.36660026534075547978172025785187489392815369298672199811191543080418772594317009830814711964951536165398298866700053668",
			"8.42614977317635863063413990620273603160800240156075001366781112932722550275520305548569353729896965907102682707565972319",
			"8.48528137423857029281013234525818847141803125226168843906007842794439487077264223310232520596584943641008307738547378212",
			"8.54400374531753116787164832623970643459445532953328224190865125377164881932729838108097203010700942960063265270527086785",
			"8.60232526704262677172947353504971363202753555729073561950804564123742693466301701278333089069896206439618335858724244864",
			"8.66025403784438646763723170752936183471402626905190314027903489725966508454400018540573093378624287837813070707703351515",
			"8.71779788708134710447396396771923131827400785046488987378068827631911465640631617131231831170388905381131724259654842726",
			"8.77496438739212206040638830741630956087587682755450359092769562978276464621930628167569315706870575593765098724099058024",
			"8.83176086632784685476404272695925396417463948093141782621020297255713993823544284037043553941477151773362982546577601312",
			"8.88819441731558885009144167540872781707645060372952629835472011637610059962859959602359295271363055315725533939127106690",
			"8.94427190999915878563669467492510494176247343844610289708358898164208370255121959765765763351512909987803270460309513400",
			"9.",
			"9.05538513813741662657380816698406641305212446409694027658174123001865798076605923338496067859099092644576051505867784783",
			"9.11043357914429888194562610468866919009913916826495585249693846506602119428340566558534146092917724673924692633758069963",
			"9.16515138991168001317609438745601697796891315353594380521448424781373685109554177320872311898689006535520181079517148174",
			"9.21954445729288731000227428176279315724680504872246400800775220544267102680187546076789409079328056494033980887887168415",
			"9.27361849549570375251641607399017462626346891207629821337382659832823683646384302323204585735847438424521657628246411626",
			"9.32737905308881504555447554232055698327624069419165467105619729844678454880724967841422056291188201600448482749874359776",
			"9.38083151964685910913126022708893256117645670682347430721140378203404926550647944296423119212308627070919179332301721496",
			"9.43398113205660381132066037762264071698362263341512132066298144898002290958511805854102698689038410453501297428174987498",
			"9.48683298050513799599668063329815560115866541797565048057251455837778331591771466403274432513790088556204185245852016545",
			"9.53939201416945649152621586023226540254623425250545753908151852910362552305650721827782176449122069822480472705655688106",
			"9.59166304662543908319487612832538783999341408380825869297061822889651447181492816498438289287383772123494912649147373026",
			"9.64365076099295499576003104743266318390690369306325240730017688773128641866864972290005470929360859108137358340794598885",
			"9.69535971483265802814888115084531339365215098795467959053971748623303986757330072848325867847691749657612175839614617207",
			"9.74679434480896390683841319989960029925258390033749103199175000572008177246024935684871209603806552755653988140775624314",
			"9.79795897113271239278913629882356556786378992262668051373077026900384150982926010615943773241856093927437840490645675648",
			"9.84885780179610472174621141491762448169613628744276417172315452983644058370767863009320078411542576243810119887174919972",
			"9.89949493661166534161182106946788654998770312763863651223675816593512734923474927195271274029349100914509692361638607914",
			"9.94987437106619954734479821001206005178126563676806079117604643834945392782713154012653019738487195272103767354858236977",
			"10." };

	public static void main(String[] args) {
		int sum =0;
		for(int i=0;i<100;i++){
			String partial = values[i];
			if(partial.length()<5)
				continue;
			int pSum = partial.charAt(0)-'0';
			for(int c=2;(c<101 && c<partial.length());c++){
				pSum+=partial.charAt(c)-'0';
				System.out.println(partial.charAt(c)-'0');
			}
			sum+=pSum;
		}
		System.out.println(sum);

	}

}
