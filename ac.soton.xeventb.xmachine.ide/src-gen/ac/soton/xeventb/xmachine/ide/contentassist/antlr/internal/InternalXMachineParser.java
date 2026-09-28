package ac.soton.xeventb.xmachine.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import ac.soton.xeventb.xmachine.services.XMachineGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalXMachineParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_XLABEL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'variables'", "'vars'", "'invariants'", "'invs'", "'variable'", "'var'", "'\\u2194'", "'<->'", "'\\uE100'", "'<<->'", "'\\uE101'", "'<->>'", "'\\uE102'", "'<<->>'", "'\\u21F8'", "'+->'", "'\\u2192'", "'-->'", "'\\u2914'", "'>+>'", "'\\u21A3'", "'>->'", "'\\u2900'", "'+>>'", "'\\u21A0'", "'->>'", "'\\u2916'", "'>->>'", "'\\u00D7'", "'**'", "'BOOL'", "'\\u21151'", "'\\u2115'", "'\\u2124'", "'where'", "'when'", "'then'", "'begin'", "'FALSE'", "'TRUE'", "'bool'", "'card'", "'dom'", "'finite'", "'id'", "'inter'", "'max'", "'min'", "'mod'", "'pred'", "'prj1'", "'prj2'", "'ran'", "'succ'", "'union'", "'NAT1'", "'NAT'", "'\\u21191'", "'POW1'", "'\\u2119'", "'POW'", "'INT'", "'('", "')'", "'\\u21D4'", "'<=>'", "'\\u21D2'", "'=>'", "'\\u2227'", "'&'", "'\\u2228'", "'or'", "'\\u00AC'", "'not'", "'\\u22A4'", "'true'", "'\\u22A5'", "'false'", "'\\u2200'", "'!'", "'\\u2203'", "'#'", "','", "'\\u00B7'", "'.'", "'='", "'\\u2260'", "'/='", "'\\u2264'", "'=<'", "'<'", "'\\u2265'", "'>='", "'>'", "'\\u2208'", "':'", "'\\u2209'", "'/:'", "'\\u2282'", "'<<:'", "'\\u2284'", "'/<<:'", "'\\u2286'", "'<:'", "'\\u2288'", "'/<:'", "'partition'", "'{'", "'}'", "'\\u21A6'", "',,'", "'|->'", "'\\u2205'", "'{}'", "'\\u2229'", "'/\\\\'", "'\\u222A'", "'\\\\/'", "'\\u2216'", "'\\\\'", "'['", "']'", "'\\uE103'", "'<+'", "'\\u2218'", "'circ'", "';'", "'\\u2297'", "'><'", "'\\u2225'", "'||'", "'\\u223C'", "'~'", "'\\u25C1'", "'<|'", "'\\u2A64'", "'<<|'", "'\\u25B7'", "'|>'", "'\\u2A65'", "'|>>'", "'\\u03BB'", "'INTER'", "'\\u22C3'", "'UNION'", "'\\u2223'", "'|'", "'\\u2025'", "'..'", "'+'", "'\\u2212'", "'-'", "'\\u2217'", "'*'", "'\\u00F7'", "'/'", "'^'", "'extended'", "'ext'", "'refined'", "'ref'", "'record'", "'rec'", "'inherits'", "'ihr'", "'field'", "'fld'", "'ordinary'", "'convergent'", "'anticipated'", "'one'", "'many'", "'opt'", "'machine'", "'end'", "'refines'", "'sees'", "'contains'", "'events'", "'includes'", "'to'", "'as'", "'visible'", "'complete'", "'ignorance'", "'knows'", "'only'", "'about'", "'if'", "'variant'", "'event'", "'any'", "'with'", "'synchronises'", "'%'", "'\\u22C2'", "'constraint'", "'extends'", "'theorem'"
    };
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int T__50=50;
    public static final int T__145=145;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int T__141=141;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__137=137;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__139=139;
    public static final int T__54=54;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=4;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=5;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__166=166;
    public static final int T__165=165;
    public static final int T__168=168;
    public static final int T__167=167;
    public static final int T__162=162;
    public static final int T__161=161;
    public static final int T__164=164;
    public static final int T__163=163;
    public static final int T__160=160;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__159=159;
    public static final int T__30=30;
    public static final int T__158=158;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__155=155;
    public static final int T__154=154;
    public static final int T__157=157;
    public static final int T__156=156;
    public static final int T__151=151;
    public static final int T__150=150;
    public static final int T__153=153;
    public static final int T__152=152;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__148=148;
    public static final int T__41=41;
    public static final int T__147=147;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__149=149;
    public static final int T__100=100;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__210=210;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__207=207;
    public static final int T__23=23;
    public static final int T__206=206;
    public static final int T__24=24;
    public static final int T__209=209;
    public static final int T__25=25;
    public static final int T__208=208;
    public static final int T__203=203;
    public static final int T__202=202;
    public static final int T__20=20;
    public static final int T__205=205;
    public static final int T__21=21;
    public static final int T__204=204;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__119=119;
    public static final int T__118=118;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__114=114;
    public static final int T__117=117;
    public static final int T__116=116;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int T__108=108;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__104=104;
    public static final int T__103=103;
    public static final int T__106=106;
    public static final int T__105=105;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__201=201;
    public static final int T__200=200;
    public static final int T__91=91;
    public static final int T__188=188;
    public static final int T__92=92;
    public static final int T__187=187;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__189=189;
    public static final int T__184=184;
    public static final int T__183=183;
    public static final int T__186=186;
    public static final int T__90=90;
    public static final int T__185=185;
    public static final int T__180=180;
    public static final int T__182=182;
    public static final int T__181=181;
    public static final int RULE_XLABEL=7;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__177=177;
    public static final int T__176=176;
    public static final int T__179=179;
    public static final int T__178=178;
    public static final int T__173=173;
    public static final int T__172=172;
    public static final int T__175=175;
    public static final int T__174=174;
    public static final int T__171=171;
    public static final int T__170=170;
    public static final int T__169=169;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__199=199;
    public static final int T__81=81;
    public static final int T__198=198;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__195=195;
    public static final int T__194=194;
    public static final int RULE_WS=10;
    public static final int T__197=197;
    public static final int T__196=196;
    public static final int T__191=191;
    public static final int T__190=190;
    public static final int T__193=193;
    public static final int T__192=192;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalXMachineParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXMachineParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXMachineParser.tokenNames; }
    public String getGrammarFileName() { return "InternalXMachine.g"; }


    	private XMachineGrammarAccess grammarAccess;

    	public void setGrammarAccess(XMachineGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleMachine"
    // InternalXMachine.g:53:1: entryRuleMachine : ruleMachine EOF ;
    public final void entryRuleMachine() throws RecognitionException {
        try {
            // InternalXMachine.g:54:1: ( ruleMachine EOF )
            // InternalXMachine.g:55:1: ruleMachine EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMachine();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMachine"


    // $ANTLR start "ruleMachine"
    // InternalXMachine.g:62:1: ruleMachine : ( ( rule__Machine__Group__0 ) ) ;
    public final void ruleMachine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:66:2: ( ( ( rule__Machine__Group__0 ) ) )
            // InternalXMachine.g:67:2: ( ( rule__Machine__Group__0 ) )
            {
            // InternalXMachine.g:67:2: ( ( rule__Machine__Group__0 ) )
            // InternalXMachine.g:68:3: ( rule__Machine__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getGroup()); 
            }
            // InternalXMachine.g:69:3: ( rule__Machine__Group__0 )
            // InternalXMachine.g:69:4: rule__Machine__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Machine__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMachine"


    // $ANTLR start "entryRuleMContains"
    // InternalXMachine.g:78:1: entryRuleMContains : ruleMContains EOF ;
    public final void entryRuleMContains() throws RecognitionException {
        try {
            // InternalXMachine.g:79:1: ( ruleMContains EOF )
            // InternalXMachine.g:80:1: ruleMContains EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMContainsRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMContains();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMContainsRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMContains"


    // $ANTLR start "ruleMContains"
    // InternalXMachine.g:87:1: ruleMContains : ( ( rule__MContains__Group__0 ) ) ;
    public final void ruleMContains() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:91:2: ( ( ( rule__MContains__Group__0 ) ) )
            // InternalXMachine.g:92:2: ( ( rule__MContains__Group__0 ) )
            {
            // InternalXMachine.g:92:2: ( ( rule__MContains__Group__0 ) )
            // InternalXMachine.g:93:3: ( rule__MContains__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMContainsAccess().getGroup()); 
            }
            // InternalXMachine.g:94:3: ( rule__MContains__Group__0 )
            // InternalXMachine.g:94:4: rule__MContains__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MContains__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMContainsAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMContains"


    // $ANTLR start "entryRuleMIncludes"
    // InternalXMachine.g:103:1: entryRuleMIncludes : ruleMIncludes EOF ;
    public final void entryRuleMIncludes() throws RecognitionException {
        try {
            // InternalXMachine.g:104:1: ( ruleMIncludes EOF )
            // InternalXMachine.g:105:1: ruleMIncludes EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMIncludes();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMIncludes"


    // $ANTLR start "ruleMIncludes"
    // InternalXMachine.g:112:1: ruleMIncludes : ( ( rule__MIncludes__Group__0 ) ) ;
    public final void ruleMIncludes() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:116:2: ( ( ( rule__MIncludes__Group__0 ) ) )
            // InternalXMachine.g:117:2: ( ( rule__MIncludes__Group__0 ) )
            {
            // InternalXMachine.g:117:2: ( ( rule__MIncludes__Group__0 ) )
            // InternalXMachine.g:118:3: ( rule__MIncludes__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getGroup()); 
            }
            // InternalXMachine.g:119:3: ( rule__MIncludes__Group__0 )
            // InternalXMachine.g:119:4: rule__MIncludes__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MIncludes__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMIncludes"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalXMachine.g:128:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalXMachine.g:129:1: ( ruleQualifiedName EOF )
            // InternalXMachine.g:130:1: ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalXMachine.g:137:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:141:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalXMachine.g:142:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalXMachine.g:142:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalXMachine.g:143:3: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // InternalXMachine.g:144:3: ( rule__QualifiedName__Group__0 )
            // InternalXMachine.g:144:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleXMultipleVariable"
    // InternalXMachine.g:153:1: entryRuleXMultipleVariable : ruleXMultipleVariable EOF ;
    public final void entryRuleXMultipleVariable() throws RecognitionException {
        try {
            // InternalXMachine.g:154:1: ( ruleXMultipleVariable EOF )
            // InternalXMachine.g:155:1: ruleXMultipleVariable EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXMultipleVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXMultipleVariable();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXMultipleVariableRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXMultipleVariable"


    // $ANTLR start "ruleXMultipleVariable"
    // InternalXMachine.g:162:1: ruleXMultipleVariable : ( ( rule__XMultipleVariable__Group__0 ) ) ;
    public final void ruleXMultipleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:166:2: ( ( ( rule__XMultipleVariable__Group__0 ) ) )
            // InternalXMachine.g:167:2: ( ( rule__XMultipleVariable__Group__0 ) )
            {
            // InternalXMachine.g:167:2: ( ( rule__XMultipleVariable__Group__0 ) )
            // InternalXMachine.g:168:3: ( rule__XMultipleVariable__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXMultipleVariableAccess().getGroup()); 
            }
            // InternalXMachine.g:169:3: ( rule__XMultipleVariable__Group__0 )
            // InternalXMachine.g:169:4: rule__XMultipleVariable__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XMultipleVariable__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXMultipleVariableAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXMultipleVariable"


    // $ANTLR start "entryRuleXIndividualVariable"
    // InternalXMachine.g:178:1: entryRuleXIndividualVariable : ruleXIndividualVariable EOF ;
    public final void entryRuleXIndividualVariable() throws RecognitionException {
        try {
            // InternalXMachine.g:179:1: ( ruleXIndividualVariable EOF )
            // InternalXMachine.g:180:1: ruleXIndividualVariable EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXIndividualVariable();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXIndividualVariable"


    // $ANTLR start "ruleXIndividualVariable"
    // InternalXMachine.g:187:1: ruleXIndividualVariable : ( ( rule__XIndividualVariable__Group__0 ) ) ;
    public final void ruleXIndividualVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:191:2: ( ( ( rule__XIndividualVariable__Group__0 ) ) )
            // InternalXMachine.g:192:2: ( ( rule__XIndividualVariable__Group__0 ) )
            {
            // InternalXMachine.g:192:2: ( ( rule__XIndividualVariable__Group__0 ) )
            // InternalXMachine.g:193:3: ( rule__XIndividualVariable__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getGroup()); 
            }
            // InternalXMachine.g:194:3: ( rule__XIndividualVariable__Group__0 )
            // InternalXMachine.g:194:4: rule__XIndividualVariable__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXIndividualVariable"


    // $ANTLR start "entryRuleXType"
    // InternalXMachine.g:203:1: entryRuleXType : ruleXType EOF ;
    public final void entryRuleXType() throws RecognitionException {
        try {
            // InternalXMachine.g:204:1: ( ruleXType EOF )
            // InternalXMachine.g:205:1: ruleXType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXType"


    // $ANTLR start "ruleXType"
    // InternalXMachine.g:212:1: ruleXType : ( ( rule__XType__Group__0 ) ) ;
    public final void ruleXType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:216:2: ( ( ( rule__XType__Group__0 ) ) )
            // InternalXMachine.g:217:2: ( ( rule__XType__Group__0 ) )
            {
            // InternalXMachine.g:217:2: ( ( rule__XType__Group__0 ) )
            // InternalXMachine.g:218:3: ( rule__XType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypeAccess().getGroup()); 
            }
            // InternalXMachine.g:219:3: ( rule__XType__Group__0 )
            // InternalXMachine.g:219:4: rule__XType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XType__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXType"


    // $ANTLR start "entryRuleXTYPEOPERATOR"
    // InternalXMachine.g:228:1: entryRuleXTYPEOPERATOR : ruleXTYPEOPERATOR EOF ;
    public final void entryRuleXTYPEOPERATOR() throws RecognitionException {
        try {
            // InternalXMachine.g:229:1: ( ruleXTYPEOPERATOR EOF )
            // InternalXMachine.g:230:1: ruleXTYPEOPERATOR EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTYPEOPERATORRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXTYPEOPERATOR();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTYPEOPERATORRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXTYPEOPERATOR"


    // $ANTLR start "ruleXTYPEOPERATOR"
    // InternalXMachine.g:237:1: ruleXTYPEOPERATOR : ( ( rule__XTYPEOPERATOR__Alternatives ) ) ;
    public final void ruleXTYPEOPERATOR() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:241:2: ( ( ( rule__XTYPEOPERATOR__Alternatives ) ) )
            // InternalXMachine.g:242:2: ( ( rule__XTYPEOPERATOR__Alternatives ) )
            {
            // InternalXMachine.g:242:2: ( ( rule__XTYPEOPERATOR__Alternatives ) )
            // InternalXMachine.g:243:3: ( rule__XTYPEOPERATOR__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTYPEOPERATORAccess().getAlternatives()); 
            }
            // InternalXMachine.g:244:3: ( rule__XTYPEOPERATOR__Alternatives )
            // InternalXMachine.g:244:4: rule__XTYPEOPERATOR__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__XTYPEOPERATOR__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTYPEOPERATORAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXTYPEOPERATOR"


    // $ANTLR start "entryRuleXTypePrimitive"
    // InternalXMachine.g:253:1: entryRuleXTypePrimitive : ruleXTypePrimitive EOF ;
    public final void entryRuleXTypePrimitive() throws RecognitionException {
        try {
            // InternalXMachine.g:254:1: ( ruleXTypePrimitive EOF )
            // InternalXMachine.g:255:1: ruleXTypePrimitive EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypePrimitiveRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXTypePrimitive();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypePrimitiveRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXTypePrimitive"


    // $ANTLR start "ruleXTypePrimitive"
    // InternalXMachine.g:262:1: ruleXTypePrimitive : ( ( rule__XTypePrimitive__Alternatives ) ) ;
    public final void ruleXTypePrimitive() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:266:2: ( ( ( rule__XTypePrimitive__Alternatives ) ) )
            // InternalXMachine.g:267:2: ( ( rule__XTypePrimitive__Alternatives ) )
            {
            // InternalXMachine.g:267:2: ( ( rule__XTypePrimitive__Alternatives ) )
            // InternalXMachine.g:268:3: ( rule__XTypePrimitive__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypePrimitiveAccess().getAlternatives()); 
            }
            // InternalXMachine.g:269:3: ( rule__XTypePrimitive__Alternatives )
            // InternalXMachine.g:269:4: rule__XTypePrimitive__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__XTypePrimitive__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypePrimitiveAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXTypePrimitive"


    // $ANTLR start "entryRuleXMultipleInvariant"
    // InternalXMachine.g:278:1: entryRuleXMultipleInvariant : ruleXMultipleInvariant EOF ;
    public final void entryRuleXMultipleInvariant() throws RecognitionException {
        try {
            // InternalXMachine.g:279:1: ( ruleXMultipleInvariant EOF )
            // InternalXMachine.g:280:1: ruleXMultipleInvariant EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXMultipleInvariantRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXMultipleInvariant();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXMultipleInvariantRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXMultipleInvariant"


    // $ANTLR start "ruleXMultipleInvariant"
    // InternalXMachine.g:287:1: ruleXMultipleInvariant : ( ( rule__XMultipleInvariant__Group__0 ) ) ;
    public final void ruleXMultipleInvariant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:291:2: ( ( ( rule__XMultipleInvariant__Group__0 ) ) )
            // InternalXMachine.g:292:2: ( ( rule__XMultipleInvariant__Group__0 ) )
            {
            // InternalXMachine.g:292:2: ( ( rule__XMultipleInvariant__Group__0 ) )
            // InternalXMachine.g:293:3: ( rule__XMultipleInvariant__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXMultipleInvariantAccess().getGroup()); 
            }
            // InternalXMachine.g:294:3: ( rule__XMultipleInvariant__Group__0 )
            // InternalXMachine.g:294:4: rule__XMultipleInvariant__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XMultipleInvariant__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXMultipleInvariantAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXMultipleInvariant"


    // $ANTLR start "entryRuleXIndividualInvariant"
    // InternalXMachine.g:303:1: entryRuleXIndividualInvariant : ruleXIndividualInvariant EOF ;
    public final void entryRuleXIndividualInvariant() throws RecognitionException {
        try {
            // InternalXMachine.g:304:1: ( ruleXIndividualInvariant EOF )
            // InternalXMachine.g:305:1: ruleXIndividualInvariant EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXIndividualInvariant();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXIndividualInvariant"


    // $ANTLR start "ruleXIndividualInvariant"
    // InternalXMachine.g:312:1: ruleXIndividualInvariant : ( ( rule__XIndividualInvariant__Group__0 ) ) ;
    public final void ruleXIndividualInvariant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:316:2: ( ( ( rule__XIndividualInvariant__Group__0 ) ) )
            // InternalXMachine.g:317:2: ( ( rule__XIndividualInvariant__Group__0 ) )
            {
            // InternalXMachine.g:317:2: ( ( rule__XIndividualInvariant__Group__0 ) )
            // InternalXMachine.g:318:3: ( rule__XIndividualInvariant__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getGroup()); 
            }
            // InternalXMachine.g:319:3: ( rule__XIndividualInvariant__Group__0 )
            // InternalXMachine.g:319:4: rule__XIndividualInvariant__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXIndividualInvariant"


    // $ANTLR start "entryRuleXVariant"
    // InternalXMachine.g:328:1: entryRuleXVariant : ruleXVariant EOF ;
    public final void entryRuleXVariant() throws RecognitionException {
        try {
            // InternalXMachine.g:329:1: ( ruleXVariant EOF )
            // InternalXMachine.g:330:1: ruleXVariant EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXVariantRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXVariant();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXVariantRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXVariant"


    // $ANTLR start "ruleXVariant"
    // InternalXMachine.g:337:1: ruleXVariant : ( ( rule__XVariant__Group__0 ) ) ;
    public final void ruleXVariant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:341:2: ( ( ( rule__XVariant__Group__0 ) ) )
            // InternalXMachine.g:342:2: ( ( rule__XVariant__Group__0 ) )
            {
            // InternalXMachine.g:342:2: ( ( rule__XVariant__Group__0 ) )
            // InternalXMachine.g:343:3: ( rule__XVariant__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXVariantAccess().getGroup()); 
            }
            // InternalXMachine.g:344:3: ( rule__XVariant__Group__0 )
            // InternalXMachine.g:344:4: rule__XVariant__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XVariant__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXVariantAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXVariant"


    // $ANTLR start "entryRuleXEvent"
    // InternalXMachine.g:353:1: entryRuleXEvent : ruleXEvent EOF ;
    public final void entryRuleXEvent() throws RecognitionException {
        try {
            // InternalXMachine.g:354:1: ( ruleXEvent EOF )
            // InternalXMachine.g:355:1: ruleXEvent EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXEvent();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXEvent"


    // $ANTLR start "ruleXEvent"
    // InternalXMachine.g:362:1: ruleXEvent : ( ( rule__XEvent__Group__0 ) ) ;
    public final void ruleXEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:366:2: ( ( ( rule__XEvent__Group__0 ) ) )
            // InternalXMachine.g:367:2: ( ( rule__XEvent__Group__0 ) )
            {
            // InternalXMachine.g:367:2: ( ( rule__XEvent__Group__0 ) )
            // InternalXMachine.g:368:3: ( rule__XEvent__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getGroup()); 
            }
            // InternalXMachine.g:369:3: ( rule__XEvent__Group__0 )
            // InternalXMachine.g:369:4: rule__XEvent__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XEvent__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXEvent"


    // $ANTLR start "entryRuleEventSync"
    // InternalXMachine.g:378:1: entryRuleEventSync : ruleEventSync EOF ;
    public final void entryRuleEventSync() throws RecognitionException {
        try {
            // InternalXMachine.g:379:1: ( ruleEventSync EOF )
            // InternalXMachine.g:380:1: ruleEventSync EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEventSyncRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEventSync();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEventSyncRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEventSync"


    // $ANTLR start "ruleEventSync"
    // InternalXMachine.g:387:1: ruleEventSync : ( ( rule__EventSync__Group__0 ) ) ;
    public final void ruleEventSync() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:391:2: ( ( ( rule__EventSync__Group__0 ) ) )
            // InternalXMachine.g:392:2: ( ( rule__EventSync__Group__0 ) )
            {
            // InternalXMachine.g:392:2: ( ( rule__EventSync__Group__0 ) )
            // InternalXMachine.g:393:3: ( rule__EventSync__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEventSyncAccess().getGroup()); 
            }
            // InternalXMachine.g:394:3: ( rule__EventSync__Group__0 )
            // InternalXMachine.g:394:4: rule__EventSync__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EventSync__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEventSyncAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEventSync"


    // $ANTLR start "entryRuleXParameter"
    // InternalXMachine.g:403:1: entryRuleXParameter : ruleXParameter EOF ;
    public final void entryRuleXParameter() throws RecognitionException {
        try {
            // InternalXMachine.g:404:1: ( ruleXParameter EOF )
            // InternalXMachine.g:405:1: ruleXParameter EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXParameterRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXParameter"


    // $ANTLR start "ruleXParameter"
    // InternalXMachine.g:412:1: ruleXParameter : ( ( rule__XParameter__Group__0 ) ) ;
    public final void ruleXParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:416:2: ( ( ( rule__XParameter__Group__0 ) ) )
            // InternalXMachine.g:417:2: ( ( rule__XParameter__Group__0 ) )
            {
            // InternalXMachine.g:417:2: ( ( rule__XParameter__Group__0 ) )
            // InternalXMachine.g:418:3: ( rule__XParameter__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXParameterAccess().getGroup()); 
            }
            // InternalXMachine.g:419:3: ( rule__XParameter__Group__0 )
            // InternalXMachine.g:419:4: rule__XParameter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XParameter__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXParameterAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXParameter"


    // $ANTLR start "entryRuleXGuard"
    // InternalXMachine.g:428:1: entryRuleXGuard : ruleXGuard EOF ;
    public final void entryRuleXGuard() throws RecognitionException {
        try {
            // InternalXMachine.g:429:1: ( ruleXGuard EOF )
            // InternalXMachine.g:430:1: ruleXGuard EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXGuardRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXGuard();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXGuardRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXGuard"


    // $ANTLR start "ruleXGuard"
    // InternalXMachine.g:437:1: ruleXGuard : ( ( rule__XGuard__Group__0 ) ) ;
    public final void ruleXGuard() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:441:2: ( ( ( rule__XGuard__Group__0 ) ) )
            // InternalXMachine.g:442:2: ( ( rule__XGuard__Group__0 ) )
            {
            // InternalXMachine.g:442:2: ( ( rule__XGuard__Group__0 ) )
            // InternalXMachine.g:443:3: ( rule__XGuard__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXGuardAccess().getGroup()); 
            }
            // InternalXMachine.g:444:3: ( rule__XGuard__Group__0 )
            // InternalXMachine.g:444:4: rule__XGuard__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XGuard__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXGuardAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXGuard"


    // $ANTLR start "entryRuleXWitness"
    // InternalXMachine.g:453:1: entryRuleXWitness : ruleXWitness EOF ;
    public final void entryRuleXWitness() throws RecognitionException {
        try {
            // InternalXMachine.g:454:1: ( ruleXWitness EOF )
            // InternalXMachine.g:455:1: ruleXWitness EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXWitnessRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXWitness();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXWitnessRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXWitness"


    // $ANTLR start "ruleXWitness"
    // InternalXMachine.g:462:1: ruleXWitness : ( ( rule__XWitness__Group__0 ) ) ;
    public final void ruleXWitness() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:466:2: ( ( ( rule__XWitness__Group__0 ) ) )
            // InternalXMachine.g:467:2: ( ( rule__XWitness__Group__0 ) )
            {
            // InternalXMachine.g:467:2: ( ( rule__XWitness__Group__0 ) )
            // InternalXMachine.g:468:3: ( rule__XWitness__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXWitnessAccess().getGroup()); 
            }
            // InternalXMachine.g:469:3: ( rule__XWitness__Group__0 )
            // InternalXMachine.g:469:4: rule__XWitness__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XWitness__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXWitnessAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXWitness"


    // $ANTLR start "entryRuleXAction"
    // InternalXMachine.g:478:1: entryRuleXAction : ruleXAction EOF ;
    public final void entryRuleXAction() throws RecognitionException {
        try {
            // InternalXMachine.g:479:1: ( ruleXAction EOF )
            // InternalXMachine.g:480:1: ruleXAction EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXActionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXAction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXActionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXAction"


    // $ANTLR start "ruleXAction"
    // InternalXMachine.g:487:1: ruleXAction : ( ( rule__XAction__Group__0 ) ) ;
    public final void ruleXAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:491:2: ( ( ( rule__XAction__Group__0 ) ) )
            // InternalXMachine.g:492:2: ( ( rule__XAction__Group__0 ) )
            {
            // InternalXMachine.g:492:2: ( ( rule__XAction__Group__0 ) )
            // InternalXMachine.g:493:3: ( rule__XAction__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXActionAccess().getGroup()); 
            }
            // InternalXMachine.g:494:3: ( rule__XAction__Group__0 )
            // InternalXMachine.g:494:4: rule__XAction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XAction__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXActionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXAction"


    // $ANTLR start "entryRuleXFormula"
    // InternalXMachine.g:503:1: entryRuleXFormula : ruleXFormula EOF ;
    public final void entryRuleXFormula() throws RecognitionException {
        try {
            // InternalXMachine.g:504:1: ( ruleXFormula EOF )
            // InternalXMachine.g:505:1: ruleXFormula EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFormulaRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXFormula();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFormulaRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXFormula"


    // $ANTLR start "ruleXFormula"
    // InternalXMachine.g:512:1: ruleXFormula : ( ( ( rule__XFormula__Alternatives ) ) ( ( rule__XFormula__Alternatives )* ) ) ;
    public final void ruleXFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:516:2: ( ( ( ( rule__XFormula__Alternatives ) ) ( ( rule__XFormula__Alternatives )* ) ) )
            // InternalXMachine.g:517:2: ( ( ( rule__XFormula__Alternatives ) ) ( ( rule__XFormula__Alternatives )* ) )
            {
            // InternalXMachine.g:517:2: ( ( ( rule__XFormula__Alternatives ) ) ( ( rule__XFormula__Alternatives )* ) )
            // InternalXMachine.g:518:3: ( ( rule__XFormula__Alternatives ) ) ( ( rule__XFormula__Alternatives )* )
            {
            // InternalXMachine.g:518:3: ( ( rule__XFormula__Alternatives ) )
            // InternalXMachine.g:519:4: ( rule__XFormula__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFormulaAccess().getAlternatives()); 
            }
            // InternalXMachine.g:520:4: ( rule__XFormula__Alternatives )
            // InternalXMachine.g:520:5: rule__XFormula__Alternatives
            {
            pushFollow(FOLLOW_3);
            rule__XFormula__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFormulaAccess().getAlternatives()); 
            }

            }

            // InternalXMachine.g:523:3: ( ( rule__XFormula__Alternatives )* )
            // InternalXMachine.g:524:4: ( rule__XFormula__Alternatives )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFormulaAccess().getAlternatives()); 
            }
            // InternalXMachine.g:525:4: ( rule__XFormula__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_INT)||(LA1_0>=18 && LA1_0<=45)||(LA1_0>=50 && LA1_0<=168)||LA1_0==206) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalXMachine.g:525:5: rule__XFormula__Alternatives
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__XFormula__Alternatives();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFormulaAccess().getAlternatives()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXFormula"


    // $ANTLR start "entryRuleEVENTB_IDENTIFIER_KEYWORD"
    // InternalXMachine.g:535:1: entryRuleEVENTB_IDENTIFIER_KEYWORD : ruleEVENTB_IDENTIFIER_KEYWORD EOF ;
    public final void entryRuleEVENTB_IDENTIFIER_KEYWORD() throws RecognitionException {
        try {
            // InternalXMachine.g:536:1: ( ruleEVENTB_IDENTIFIER_KEYWORD EOF )
            // InternalXMachine.g:537:1: ruleEVENTB_IDENTIFIER_KEYWORD EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEVENTB_IDENTIFIER_KEYWORD();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEVENTB_IDENTIFIER_KEYWORD"


    // $ANTLR start "ruleEVENTB_IDENTIFIER_KEYWORD"
    // InternalXMachine.g:544:1: ruleEVENTB_IDENTIFIER_KEYWORD : ( ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives ) ) ;
    public final void ruleEVENTB_IDENTIFIER_KEYWORD() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:548:2: ( ( ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives ) ) )
            // InternalXMachine.g:549:2: ( ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives ) )
            {
            // InternalXMachine.g:549:2: ( ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives ) )
            // InternalXMachine.g:550:3: ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getAlternatives()); 
            }
            // InternalXMachine.g:551:3: ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives )
            // InternalXMachine.g:551:4: rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEVENTB_IDENTIFIER_KEYWORD"


    // $ANTLR start "entryRuleEVENTB_PREDICATE_SYMBOLS"
    // InternalXMachine.g:560:1: entryRuleEVENTB_PREDICATE_SYMBOLS : ruleEVENTB_PREDICATE_SYMBOLS EOF ;
    public final void entryRuleEVENTB_PREDICATE_SYMBOLS() throws RecognitionException {
        try {
            // InternalXMachine.g:561:1: ( ruleEVENTB_PREDICATE_SYMBOLS EOF )
            // InternalXMachine.g:562:1: ruleEVENTB_PREDICATE_SYMBOLS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEVENTB_PREDICATE_SYMBOLS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEVENTB_PREDICATE_SYMBOLS"


    // $ANTLR start "ruleEVENTB_PREDICATE_SYMBOLS"
    // InternalXMachine.g:569:1: ruleEVENTB_PREDICATE_SYMBOLS : ( ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives ) ) ;
    public final void ruleEVENTB_PREDICATE_SYMBOLS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:573:2: ( ( ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives ) ) )
            // InternalXMachine.g:574:2: ( ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives ) )
            {
            // InternalXMachine.g:574:2: ( ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives ) )
            // InternalXMachine.g:575:3: ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAlternatives()); 
            }
            // InternalXMachine.g:576:3: ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives )
            // InternalXMachine.g:576:4: rule__EVENTB_PREDICATE_SYMBOLS__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EVENTB_PREDICATE_SYMBOLS__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEVENTB_PREDICATE_SYMBOLS"


    // $ANTLR start "entryRuleEVENTB_EXPRESSION_SYMBOLS"
    // InternalXMachine.g:585:1: entryRuleEVENTB_EXPRESSION_SYMBOLS : ruleEVENTB_EXPRESSION_SYMBOLS EOF ;
    public final void entryRuleEVENTB_EXPRESSION_SYMBOLS() throws RecognitionException {
        try {
            // InternalXMachine.g:586:1: ( ruleEVENTB_EXPRESSION_SYMBOLS EOF )
            // InternalXMachine.g:587:1: ruleEVENTB_EXPRESSION_SYMBOLS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEVENTB_EXPRESSION_SYMBOLS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEVENTB_EXPRESSION_SYMBOLS"


    // $ANTLR start "ruleEVENTB_EXPRESSION_SYMBOLS"
    // InternalXMachine.g:594:1: ruleEVENTB_EXPRESSION_SYMBOLS : ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives ) ) ;
    public final void ruleEVENTB_EXPRESSION_SYMBOLS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:598:2: ( ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives ) ) )
            // InternalXMachine.g:599:2: ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives ) )
            {
            // InternalXMachine.g:599:2: ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives ) )
            // InternalXMachine.g:600:3: ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAlternatives()); 
            }
            // InternalXMachine.g:601:3: ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives )
            // InternalXMachine.g:601:4: rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEVENTB_EXPRESSION_SYMBOLS"


    // $ANTLR start "entryRuleXRecord"
    // InternalXMachine.g:610:1: entryRuleXRecord : ruleXRecord EOF ;
    public final void entryRuleXRecord() throws RecognitionException {
        try {
            // InternalXMachine.g:611:1: ( ruleXRecord EOF )
            // InternalXMachine.g:612:1: ruleXRecord EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXRecord();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXRecord"


    // $ANTLR start "ruleXRecord"
    // InternalXMachine.g:619:1: ruleXRecord : ( ( rule__XRecord__Group__0 ) ) ;
    public final void ruleXRecord() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:623:2: ( ( ( rule__XRecord__Group__0 ) ) )
            // InternalXMachine.g:624:2: ( ( rule__XRecord__Group__0 ) )
            {
            // InternalXMachine.g:624:2: ( ( rule__XRecord__Group__0 ) )
            // InternalXMachine.g:625:3: ( rule__XRecord__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getGroup()); 
            }
            // InternalXMachine.g:626:3: ( rule__XRecord__Group__0 )
            // InternalXMachine.g:626:4: rule__XRecord__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XRecord__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXRecord"


    // $ANTLR start "entryRuleField"
    // InternalXMachine.g:635:1: entryRuleField : ruleField EOF ;
    public final void entryRuleField() throws RecognitionException {
        try {
            // InternalXMachine.g:636:1: ( ruleField EOF )
            // InternalXMachine.g:637:1: ruleField EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleField();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // InternalXMachine.g:644:1: ruleField : ( ( rule__Field__Group__0 ) ) ;
    public final void ruleField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:648:2: ( ( ( rule__Field__Group__0 ) ) )
            // InternalXMachine.g:649:2: ( ( rule__Field__Group__0 ) )
            {
            // InternalXMachine.g:649:2: ( ( rule__Field__Group__0 ) )
            // InternalXMachine.g:650:3: ( rule__Field__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getGroup()); 
            }
            // InternalXMachine.g:651:3: ( rule__Field__Group__0 )
            // InternalXMachine.g:651:4: rule__Field__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Field__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleXConstraint"
    // InternalXMachine.g:660:1: entryRuleXConstraint : ruleXConstraint EOF ;
    public final void entryRuleXConstraint() throws RecognitionException {
        try {
            // InternalXMachine.g:661:1: ( ruleXConstraint EOF )
            // InternalXMachine.g:662:1: ruleXConstraint EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXConstraintRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleXConstraint();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXConstraintRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXConstraint"


    // $ANTLR start "ruleXConstraint"
    // InternalXMachine.g:669:1: ruleXConstraint : ( ( rule__XConstraint__Group__0 ) ) ;
    public final void ruleXConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:673:2: ( ( ( rule__XConstraint__Group__0 ) ) )
            // InternalXMachine.g:674:2: ( ( rule__XConstraint__Group__0 ) )
            {
            // InternalXMachine.g:674:2: ( ( rule__XConstraint__Group__0 ) )
            // InternalXMachine.g:675:3: ( rule__XConstraint__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXConstraintAccess().getGroup()); 
            }
            // InternalXMachine.g:676:3: ( rule__XConstraint__Group__0 )
            // InternalXMachine.g:676:4: rule__XConstraint__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XConstraint__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXConstraintAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXConstraint"


    // $ANTLR start "ruleXConvergence"
    // InternalXMachine.g:685:1: ruleXConvergence : ( ( rule__XConvergence__Alternatives ) ) ;
    public final void ruleXConvergence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:689:1: ( ( ( rule__XConvergence__Alternatives ) ) )
            // InternalXMachine.g:690:2: ( ( rule__XConvergence__Alternatives ) )
            {
            // InternalXMachine.g:690:2: ( ( rule__XConvergence__Alternatives ) )
            // InternalXMachine.g:691:3: ( rule__XConvergence__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXConvergenceAccess().getAlternatives()); 
            }
            // InternalXMachine.g:692:3: ( rule__XConvergence__Alternatives )
            // InternalXMachine.g:692:4: rule__XConvergence__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__XConvergence__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXConvergenceAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXConvergence"


    // $ANTLR start "ruleMultiplicity"
    // InternalXMachine.g:701:1: ruleMultiplicity : ( ( rule__Multiplicity__Alternatives ) ) ;
    public final void ruleMultiplicity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:705:1: ( ( ( rule__Multiplicity__Alternatives ) ) )
            // InternalXMachine.g:706:2: ( ( rule__Multiplicity__Alternatives ) )
            {
            // InternalXMachine.g:706:2: ( ( rule__Multiplicity__Alternatives ) )
            // InternalXMachine.g:707:3: ( rule__Multiplicity__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityAccess().getAlternatives()); 
            }
            // InternalXMachine.g:708:3: ( rule__Multiplicity__Alternatives )
            // InternalXMachine.g:708:4: rule__Multiplicity__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Multiplicity__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplicity"


    // $ANTLR start "rule__Machine__Alternatives_6"
    // InternalXMachine.g:716:1: rule__Machine__Alternatives_6 : ( ( ( rule__Machine__Group_6_0__0 ) ) | ( ( rule__Machine__OrderedChildrenAssignment_6_1 ) ) | ( ( rule__Machine__Group_6_2__0 ) ) | ( ( rule__Machine__OrderedChildrenAssignment_6_3 ) ) | ( ( rule__Machine__OrderedChildrenAssignment_6_4 ) ) | ( ( rule__Machine__OrderedChildrenAssignment_6_5 ) ) | ( ( rule__Machine__OrderedChildrenAssignment_6_6 ) ) );
    public final void rule__Machine__Alternatives_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:720:1: ( ( ( rule__Machine__Group_6_0__0 ) ) | ( ( rule__Machine__OrderedChildrenAssignment_6_1 ) ) | ( ( rule__Machine__Group_6_2__0 ) ) | ( ( rule__Machine__OrderedChildrenAssignment_6_3 ) ) | ( ( rule__Machine__OrderedChildrenAssignment_6_4 ) ) | ( ( rule__Machine__OrderedChildrenAssignment_6_5 ) ) | ( ( rule__Machine__OrderedChildrenAssignment_6_6 ) ) )
            int alt2=7;
            switch ( input.LA(1) ) {
            case 12:
            case 13:
                {
                alt2=1;
                }
                break;
            case RULE_STRING:
                {
                switch ( input.LA(2) ) {
                case 201:
                    {
                    alt2=6;
                    }
                    break;
                case 169:
                case 170:
                case 171:
                case 172:
                case 173:
                case 174:
                    {
                    alt2=5;
                    }
                    break;
                case 16:
                case 17:
                    {
                    alt2=2;
                    }
                    break;
                case 195:
                    {
                    alt2=4;
                    }
                    break;
                case 179:
                case 180:
                case 181:
                case 202:
                    {
                    alt2=7;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }

                }
                break;
            case 16:
            case 17:
                {
                alt2=2;
                }
                break;
            case 14:
            case 15:
                {
                alt2=3;
                }
                break;
            case 195:
                {
                alt2=4;
                }
                break;
            case 169:
            case 170:
            case 171:
            case 172:
            case 173:
            case 174:
                {
                alt2=5;
                }
                break;
            case 201:
                {
                alt2=6;
                }
                break;
            case 179:
            case 180:
            case 181:
            case 202:
                {
                alt2=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalXMachine.g:721:2: ( ( rule__Machine__Group_6_0__0 ) )
                    {
                    // InternalXMachine.g:721:2: ( ( rule__Machine__Group_6_0__0 ) )
                    // InternalXMachine.g:722:3: ( rule__Machine__Group_6_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMachineAccess().getGroup_6_0()); 
                    }
                    // InternalXMachine.g:723:3: ( rule__Machine__Group_6_0__0 )
                    // InternalXMachine.g:723:4: rule__Machine__Group_6_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Machine__Group_6_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMachineAccess().getGroup_6_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:727:2: ( ( rule__Machine__OrderedChildrenAssignment_6_1 ) )
                    {
                    // InternalXMachine.g:727:2: ( ( rule__Machine__OrderedChildrenAssignment_6_1 ) )
                    // InternalXMachine.g:728:3: ( rule__Machine__OrderedChildrenAssignment_6_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_1()); 
                    }
                    // InternalXMachine.g:729:3: ( rule__Machine__OrderedChildrenAssignment_6_1 )
                    // InternalXMachine.g:729:4: rule__Machine__OrderedChildrenAssignment_6_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Machine__OrderedChildrenAssignment_6_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalXMachine.g:733:2: ( ( rule__Machine__Group_6_2__0 ) )
                    {
                    // InternalXMachine.g:733:2: ( ( rule__Machine__Group_6_2__0 ) )
                    // InternalXMachine.g:734:3: ( rule__Machine__Group_6_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMachineAccess().getGroup_6_2()); 
                    }
                    // InternalXMachine.g:735:3: ( rule__Machine__Group_6_2__0 )
                    // InternalXMachine.g:735:4: rule__Machine__Group_6_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Machine__Group_6_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMachineAccess().getGroup_6_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalXMachine.g:739:2: ( ( rule__Machine__OrderedChildrenAssignment_6_3 ) )
                    {
                    // InternalXMachine.g:739:2: ( ( rule__Machine__OrderedChildrenAssignment_6_3 ) )
                    // InternalXMachine.g:740:3: ( rule__Machine__OrderedChildrenAssignment_6_3 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_3()); 
                    }
                    // InternalXMachine.g:741:3: ( rule__Machine__OrderedChildrenAssignment_6_3 )
                    // InternalXMachine.g:741:4: rule__Machine__OrderedChildrenAssignment_6_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Machine__OrderedChildrenAssignment_6_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalXMachine.g:745:2: ( ( rule__Machine__OrderedChildrenAssignment_6_4 ) )
                    {
                    // InternalXMachine.g:745:2: ( ( rule__Machine__OrderedChildrenAssignment_6_4 ) )
                    // InternalXMachine.g:746:3: ( rule__Machine__OrderedChildrenAssignment_6_4 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_4()); 
                    }
                    // InternalXMachine.g:747:3: ( rule__Machine__OrderedChildrenAssignment_6_4 )
                    // InternalXMachine.g:747:4: rule__Machine__OrderedChildrenAssignment_6_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__Machine__OrderedChildrenAssignment_6_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalXMachine.g:751:2: ( ( rule__Machine__OrderedChildrenAssignment_6_5 ) )
                    {
                    // InternalXMachine.g:751:2: ( ( rule__Machine__OrderedChildrenAssignment_6_5 ) )
                    // InternalXMachine.g:752:3: ( rule__Machine__OrderedChildrenAssignment_6_5 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_5()); 
                    }
                    // InternalXMachine.g:753:3: ( rule__Machine__OrderedChildrenAssignment_6_5 )
                    // InternalXMachine.g:753:4: rule__Machine__OrderedChildrenAssignment_6_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__Machine__OrderedChildrenAssignment_6_5();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalXMachine.g:757:2: ( ( rule__Machine__OrderedChildrenAssignment_6_6 ) )
                    {
                    // InternalXMachine.g:757:2: ( ( rule__Machine__OrderedChildrenAssignment_6_6 ) )
                    // InternalXMachine.g:758:3: ( rule__Machine__OrderedChildrenAssignment_6_6 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_6()); 
                    }
                    // InternalXMachine.g:759:3: ( rule__Machine__OrderedChildrenAssignment_6_6 )
                    // InternalXMachine.g:759:4: rule__Machine__OrderedChildrenAssignment_6_6
                    {
                    pushFollow(FOLLOW_2);
                    rule__Machine__OrderedChildrenAssignment_6_6();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_6()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Alternatives_6"


    // $ANTLR start "rule__Machine__Alternatives_6_0_0"
    // InternalXMachine.g:767:1: rule__Machine__Alternatives_6_0_0 : ( ( 'variables' ) | ( 'vars' ) );
    public final void rule__Machine__Alternatives_6_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:771:1: ( ( 'variables' ) | ( 'vars' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            else if ( (LA3_0==13) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalXMachine.g:772:2: ( 'variables' )
                    {
                    // InternalXMachine.g:772:2: ( 'variables' )
                    // InternalXMachine.g:773:3: 'variables'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMachineAccess().getVariablesKeyword_6_0_0_0()); 
                    }
                    match(input,12,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMachineAccess().getVariablesKeyword_6_0_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:778:2: ( 'vars' )
                    {
                    // InternalXMachine.g:778:2: ( 'vars' )
                    // InternalXMachine.g:779:3: 'vars'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMachineAccess().getVarsKeyword_6_0_0_1()); 
                    }
                    match(input,13,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMachineAccess().getVarsKeyword_6_0_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Alternatives_6_0_0"


    // $ANTLR start "rule__Machine__Alternatives_6_2_0"
    // InternalXMachine.g:788:1: rule__Machine__Alternatives_6_2_0 : ( ( 'invariants' ) | ( 'invs' ) );
    public final void rule__Machine__Alternatives_6_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:792:1: ( ( 'invariants' ) | ( 'invs' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalXMachine.g:793:2: ( 'invariants' )
                    {
                    // InternalXMachine.g:793:2: ( 'invariants' )
                    // InternalXMachine.g:794:3: 'invariants'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMachineAccess().getInvariantsKeyword_6_2_0_0()); 
                    }
                    match(input,14,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMachineAccess().getInvariantsKeyword_6_2_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:799:2: ( 'invs' )
                    {
                    // InternalXMachine.g:799:2: ( 'invs' )
                    // InternalXMachine.g:800:3: 'invs'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMachineAccess().getInvsKeyword_6_2_0_1()); 
                    }
                    match(input,15,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMachineAccess().getInvsKeyword_6_2_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Alternatives_6_2_0"


    // $ANTLR start "rule__XIndividualVariable__Alternatives_2"
    // InternalXMachine.g:809:1: rule__XIndividualVariable__Alternatives_2 : ( ( 'variable' ) | ( 'var' ) );
    public final void rule__XIndividualVariable__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:813:1: ( ( 'variable' ) | ( 'var' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            else if ( (LA5_0==17) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalXMachine.g:814:2: ( 'variable' )
                    {
                    // InternalXMachine.g:814:2: ( 'variable' )
                    // InternalXMachine.g:815:3: 'variable'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXIndividualVariableAccess().getVariableKeyword_2_0()); 
                    }
                    match(input,16,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXIndividualVariableAccess().getVariableKeyword_2_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:820:2: ( 'var' )
                    {
                    // InternalXMachine.g:820:2: ( 'var' )
                    // InternalXMachine.g:821:3: 'var'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXIndividualVariableAccess().getVarKeyword_2_1()); 
                    }
                    match(input,17,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXIndividualVariableAccess().getVarKeyword_2_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Alternatives_2"


    // $ANTLR start "rule__XTYPEOPERATOR__Alternatives"
    // InternalXMachine.g:830:1: rule__XTYPEOPERATOR__Alternatives : ( ( '\\u2194' ) | ( '<->' ) | ( '\\uE100' ) | ( '<<->' ) | ( '\\uE101' ) | ( '<->>' ) | ( '\\uE102' ) | ( '<<->>' ) | ( '\\u21F8' ) | ( '+->' ) | ( '\\u2192' ) | ( '-->' ) | ( '\\u2914' ) | ( '>+>' ) | ( '\\u21A3' ) | ( '>->' ) | ( '\\u2900' ) | ( '+>>' ) | ( '\\u21A0' ) | ( '->>' ) | ( '\\u2916' ) | ( '>->>' ) | ( '\\u00D7' ) | ( '**' ) );
    public final void rule__XTYPEOPERATOR__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:834:1: ( ( '\\u2194' ) | ( '<->' ) | ( '\\uE100' ) | ( '<<->' ) | ( '\\uE101' ) | ( '<->>' ) | ( '\\uE102' ) | ( '<<->>' ) | ( '\\u21F8' ) | ( '+->' ) | ( '\\u2192' ) | ( '-->' ) | ( '\\u2914' ) | ( '>+>' ) | ( '\\u21A3' ) | ( '>->' ) | ( '\\u2900' ) | ( '+>>' ) | ( '\\u21A0' ) | ( '->>' ) | ( '\\u2916' ) | ( '>->>' ) | ( '\\u00D7' ) | ( '**' ) )
            int alt6=24;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt6=1;
                }
                break;
            case 19:
                {
                alt6=2;
                }
                break;
            case 20:
                {
                alt6=3;
                }
                break;
            case 21:
                {
                alt6=4;
                }
                break;
            case 22:
                {
                alt6=5;
                }
                break;
            case 23:
                {
                alt6=6;
                }
                break;
            case 24:
                {
                alt6=7;
                }
                break;
            case 25:
                {
                alt6=8;
                }
                break;
            case 26:
                {
                alt6=9;
                }
                break;
            case 27:
                {
                alt6=10;
                }
                break;
            case 28:
                {
                alt6=11;
                }
                break;
            case 29:
                {
                alt6=12;
                }
                break;
            case 30:
                {
                alt6=13;
                }
                break;
            case 31:
                {
                alt6=14;
                }
                break;
            case 32:
                {
                alt6=15;
                }
                break;
            case 33:
                {
                alt6=16;
                }
                break;
            case 34:
                {
                alt6=17;
                }
                break;
            case 35:
                {
                alt6=18;
                }
                break;
            case 36:
                {
                alt6=19;
                }
                break;
            case 37:
                {
                alt6=20;
                }
                break;
            case 38:
                {
                alt6=21;
                }
                break;
            case 39:
                {
                alt6=22;
                }
                break;
            case 40:
                {
                alt6=23;
                }
                break;
            case 41:
                {
                alt6=24;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalXMachine.g:835:2: ( '\\u2194' )
                    {
                    // InternalXMachine.g:835:2: ( '\\u2194' )
                    // InternalXMachine.g:836:3: '\\u2194'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getLeftRightArrowKeyword_0()); 
                    }
                    match(input,18,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getLeftRightArrowKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:841:2: ( '<->' )
                    {
                    // InternalXMachine.g:841:2: ( '<->' )
                    // InternalXMachine.g:842:3: '<->'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_1()); 
                    }
                    match(input,19,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalXMachine.g:847:2: ( '\\uE100' )
                    {
                    // InternalXMachine.g:847:2: ( '\\uE100' )
                    // InternalXMachine.g:848:3: '\\uE100'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getPrivateUseAreaE100Keyword_2()); 
                    }
                    match(input,20,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getPrivateUseAreaE100Keyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalXMachine.g:853:2: ( '<<->' )
                    {
                    // InternalXMachine.g:853:2: ( '<<->' )
                    // InternalXMachine.g:854:3: '<<->'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getLessThanSignLessThanSignHyphenMinusGreaterThanSignKeyword_3()); 
                    }
                    match(input,21,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getLessThanSignLessThanSignHyphenMinusGreaterThanSignKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalXMachine.g:859:2: ( '\\uE101' )
                    {
                    // InternalXMachine.g:859:2: ( '\\uE101' )
                    // InternalXMachine.g:860:3: '\\uE101'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getPrivateUseAreaE101Keyword_4()); 
                    }
                    match(input,22,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getPrivateUseAreaE101Keyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalXMachine.g:865:2: ( '<->>' )
                    {
                    // InternalXMachine.g:865:2: ( '<->>' )
                    // InternalXMachine.g:866:3: '<->>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getLessThanSignHyphenMinusGreaterThanSignGreaterThanSignKeyword_5()); 
                    }
                    match(input,23,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getLessThanSignHyphenMinusGreaterThanSignGreaterThanSignKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalXMachine.g:871:2: ( '\\uE102' )
                    {
                    // InternalXMachine.g:871:2: ( '\\uE102' )
                    // InternalXMachine.g:872:3: '\\uE102'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getPrivateUseAreaE102Keyword_6()); 
                    }
                    match(input,24,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getPrivateUseAreaE102Keyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalXMachine.g:877:2: ( '<<->>' )
                    {
                    // InternalXMachine.g:877:2: ( '<<->>' )
                    // InternalXMachine.g:878:3: '<<->>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getLessThanSignLessThanSignHyphenMinusGreaterThanSignGreaterThanSignKeyword_7()); 
                    }
                    match(input,25,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getLessThanSignLessThanSignHyphenMinusGreaterThanSignGreaterThanSignKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalXMachine.g:883:2: ( '\\u21F8' )
                    {
                    // InternalXMachine.g:883:2: ( '\\u21F8' )
                    // InternalXMachine.g:884:3: '\\u21F8'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowWithVerticalStrokeKeyword_8()); 
                    }
                    match(input,26,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowWithVerticalStrokeKeyword_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalXMachine.g:889:2: ( '+->' )
                    {
                    // InternalXMachine.g:889:2: ( '+->' )
                    // InternalXMachine.g:890:3: '+->'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getPlusSignHyphenMinusGreaterThanSignKeyword_9()); 
                    }
                    match(input,27,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getPlusSignHyphenMinusGreaterThanSignKeyword_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalXMachine.g:895:2: ( '\\u2192' )
                    {
                    // InternalXMachine.g:895:2: ( '\\u2192' )
                    // InternalXMachine.g:896:3: '\\u2192'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowKeyword_10()); 
                    }
                    match(input,28,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowKeyword_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalXMachine.g:901:2: ( '-->' )
                    {
                    // InternalXMachine.g:901:2: ( '-->' )
                    // InternalXMachine.g:902:3: '-->'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_11()); 
                    }
                    match(input,29,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalXMachine.g:907:2: ( '\\u2914' )
                    {
                    // InternalXMachine.g:907:2: ( '\\u2914' )
                    // InternalXMachine.g:908:3: '\\u2914'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowWithTailWithVerticalStrokeKeyword_12()); 
                    }
                    match(input,30,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowWithTailWithVerticalStrokeKeyword_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalXMachine.g:913:2: ( '>+>' )
                    {
                    // InternalXMachine.g:913:2: ( '>+>' )
                    // InternalXMachine.g:914:3: '>+>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getGreaterThanSignPlusSignGreaterThanSignKeyword_13()); 
                    }
                    match(input,31,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getGreaterThanSignPlusSignGreaterThanSignKeyword_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalXMachine.g:919:2: ( '\\u21A3' )
                    {
                    // InternalXMachine.g:919:2: ( '\\u21A3' )
                    // InternalXMachine.g:920:3: '\\u21A3'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowWithTailKeyword_14()); 
                    }
                    match(input,32,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowWithTailKeyword_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalXMachine.g:925:2: ( '>->' )
                    {
                    // InternalXMachine.g:925:2: ( '>->' )
                    // InternalXMachine.g:926:3: '>->'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getGreaterThanSignHyphenMinusGreaterThanSignKeyword_15()); 
                    }
                    match(input,33,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getGreaterThanSignHyphenMinusGreaterThanSignKeyword_15()); 
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalXMachine.g:931:2: ( '\\u2900' )
                    {
                    // InternalXMachine.g:931:2: ( '\\u2900' )
                    // InternalXMachine.g:932:3: '\\u2900'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getRightwardsTwoHeadedArrowWithVerticalStrokeKeyword_16()); 
                    }
                    match(input,34,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getRightwardsTwoHeadedArrowWithVerticalStrokeKeyword_16()); 
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalXMachine.g:937:2: ( '+>>' )
                    {
                    // InternalXMachine.g:937:2: ( '+>>' )
                    // InternalXMachine.g:938:3: '+>>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getPlusSignGreaterThanSignGreaterThanSignKeyword_17()); 
                    }
                    match(input,35,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getPlusSignGreaterThanSignGreaterThanSignKeyword_17()); 
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalXMachine.g:943:2: ( '\\u21A0' )
                    {
                    // InternalXMachine.g:943:2: ( '\\u21A0' )
                    // InternalXMachine.g:944:3: '\\u21A0'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getRightwardsTwoHeadedArrowKeyword_18()); 
                    }
                    match(input,36,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getRightwardsTwoHeadedArrowKeyword_18()); 
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalXMachine.g:949:2: ( '->>' )
                    {
                    // InternalXMachine.g:949:2: ( '->>' )
                    // InternalXMachine.g:950:3: '->>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_19()); 
                    }
                    match(input,37,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_19()); 
                    }

                    }


                    }
                    break;
                case 21 :
                    // InternalXMachine.g:955:2: ( '\\u2916' )
                    {
                    // InternalXMachine.g:955:2: ( '\\u2916' )
                    // InternalXMachine.g:956:3: '\\u2916'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getRightwardsTwoHeadedArrowWithTailKeyword_20()); 
                    }
                    match(input,38,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getRightwardsTwoHeadedArrowWithTailKeyword_20()); 
                    }

                    }


                    }
                    break;
                case 22 :
                    // InternalXMachine.g:961:2: ( '>->>' )
                    {
                    // InternalXMachine.g:961:2: ( '>->>' )
                    // InternalXMachine.g:962:3: '>->>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getGreaterThanSignHyphenMinusGreaterThanSignGreaterThanSignKeyword_21()); 
                    }
                    match(input,39,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getGreaterThanSignHyphenMinusGreaterThanSignGreaterThanSignKeyword_21()); 
                    }

                    }


                    }
                    break;
                case 23 :
                    // InternalXMachine.g:967:2: ( '\\u00D7' )
                    {
                    // InternalXMachine.g:967:2: ( '\\u00D7' )
                    // InternalXMachine.g:968:3: '\\u00D7'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getMultiplicationSignKeyword_22()); 
                    }
                    match(input,40,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getMultiplicationSignKeyword_22()); 
                    }

                    }


                    }
                    break;
                case 24 :
                    // InternalXMachine.g:973:2: ( '**' )
                    {
                    // InternalXMachine.g:973:2: ( '**' )
                    // InternalXMachine.g:974:3: '**'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTYPEOPERATORAccess().getAsteriskAsteriskKeyword_23()); 
                    }
                    match(input,41,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTYPEOPERATORAccess().getAsteriskAsteriskKeyword_23()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTYPEOPERATOR__Alternatives"


    // $ANTLR start "rule__XTypePrimitive__Alternatives"
    // InternalXMachine.g:983:1: rule__XTypePrimitive__Alternatives : ( ( RULE_ID ) | ( 'BOOL' ) | ( '\\u21151' ) | ( '\\u2115' ) | ( '\\u2124' ) | ( ( rule__XTypePrimitive__Group_5__0 ) ) | ( ( rule__XTypePrimitive__Group_6__0 ) ) | ( ( rule__XTypePrimitive__Group_7__0 ) ) );
    public final void rule__XTypePrimitive__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:987:1: ( ( RULE_ID ) | ( 'BOOL' ) | ( '\\u21151' ) | ( '\\u2115' ) | ( '\\u2124' ) | ( ( rule__XTypePrimitive__Group_5__0 ) ) | ( ( rule__XTypePrimitive__Group_6__0 ) ) | ( ( rule__XTypePrimitive__Group_7__0 ) ) )
            int alt7=8;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt7=1;
                }
                break;
            case 42:
                {
                alt7=2;
                }
                break;
            case 43:
                {
                alt7=3;
                }
                break;
            case 44:
                {
                alt7=4;
                }
                break;
            case 45:
                {
                alt7=5;
                }
                break;
            case 74:
                {
                alt7=6;
                }
                break;
            case 71:
                {
                alt7=7;
                }
                break;
            case 69:
                {
                alt7=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalXMachine.g:988:2: ( RULE_ID )
                    {
                    // InternalXMachine.g:988:2: ( RULE_ID )
                    // InternalXMachine.g:989:3: RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTypePrimitiveAccess().getIDTerminalRuleCall_0()); 
                    }
                    match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTypePrimitiveAccess().getIDTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:994:2: ( 'BOOL' )
                    {
                    // InternalXMachine.g:994:2: ( 'BOOL' )
                    // InternalXMachine.g:995:3: 'BOOL'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTypePrimitiveAccess().getBOOLKeyword_1()); 
                    }
                    match(input,42,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTypePrimitiveAccess().getBOOLKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalXMachine.g:1000:2: ( '\\u21151' )
                    {
                    // InternalXMachine.g:1000:2: ( '\\u21151' )
                    // InternalXMachine.g:1001:3: '\\u21151'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalNDigitOneKeyword_2()); 
                    }
                    match(input,43,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalNDigitOneKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalXMachine.g:1006:2: ( '\\u2115' )
                    {
                    // InternalXMachine.g:1006:2: ( '\\u2115' )
                    // InternalXMachine.g:1007:3: '\\u2115'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalNKeyword_3()); 
                    }
                    match(input,44,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalNKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalXMachine.g:1012:2: ( '\\u2124' )
                    {
                    // InternalXMachine.g:1012:2: ( '\\u2124' )
                    // InternalXMachine.g:1013:3: '\\u2124'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalZKeyword_4()); 
                    }
                    match(input,45,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalZKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalXMachine.g:1018:2: ( ( rule__XTypePrimitive__Group_5__0 ) )
                    {
                    // InternalXMachine.g:1018:2: ( ( rule__XTypePrimitive__Group_5__0 ) )
                    // InternalXMachine.g:1019:3: ( rule__XTypePrimitive__Group_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTypePrimitiveAccess().getGroup_5()); 
                    }
                    // InternalXMachine.g:1020:3: ( rule__XTypePrimitive__Group_5__0 )
                    // InternalXMachine.g:1020:4: rule__XTypePrimitive__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XTypePrimitive__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTypePrimitiveAccess().getGroup_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalXMachine.g:1024:2: ( ( rule__XTypePrimitive__Group_6__0 ) )
                    {
                    // InternalXMachine.g:1024:2: ( ( rule__XTypePrimitive__Group_6__0 ) )
                    // InternalXMachine.g:1025:3: ( rule__XTypePrimitive__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTypePrimitiveAccess().getGroup_6()); 
                    }
                    // InternalXMachine.g:1026:3: ( rule__XTypePrimitive__Group_6__0 )
                    // InternalXMachine.g:1026:4: rule__XTypePrimitive__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XTypePrimitive__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTypePrimitiveAccess().getGroup_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalXMachine.g:1030:2: ( ( rule__XTypePrimitive__Group_7__0 ) )
                    {
                    // InternalXMachine.g:1030:2: ( ( rule__XTypePrimitive__Group_7__0 ) )
                    // InternalXMachine.g:1031:3: ( rule__XTypePrimitive__Group_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXTypePrimitiveAccess().getGroup_7()); 
                    }
                    // InternalXMachine.g:1032:3: ( rule__XTypePrimitive__Group_7__0 )
                    // InternalXMachine.g:1032:4: rule__XTypePrimitive__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XTypePrimitive__Group_7__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXTypePrimitiveAccess().getGroup_7()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Alternatives"


    // $ANTLR start "rule__XEvent__Alternatives_5"
    // InternalXMachine.g:1040:1: rule__XEvent__Alternatives_5 : ( ( ( rule__XEvent__Group_5_0__0 ) ) | ( ( rule__XEvent__Group_5_1__0 ) ) );
    public final void rule__XEvent__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:1044:1: ( ( ( rule__XEvent__Group_5_0__0 ) ) | ( ( rule__XEvent__Group_5_1__0 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==187) ) {
                alt8=1;
            }
            else if ( (LA8_0==209) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalXMachine.g:1045:2: ( ( rule__XEvent__Group_5_0__0 ) )
                    {
                    // InternalXMachine.g:1045:2: ( ( rule__XEvent__Group_5_0__0 ) )
                    // InternalXMachine.g:1046:3: ( rule__XEvent__Group_5_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXEventAccess().getGroup_5_0()); 
                    }
                    // InternalXMachine.g:1047:3: ( rule__XEvent__Group_5_0__0 )
                    // InternalXMachine.g:1047:4: rule__XEvent__Group_5_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XEvent__Group_5_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXEventAccess().getGroup_5_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:1051:2: ( ( rule__XEvent__Group_5_1__0 ) )
                    {
                    // InternalXMachine.g:1051:2: ( ( rule__XEvent__Group_5_1__0 ) )
                    // InternalXMachine.g:1052:3: ( rule__XEvent__Group_5_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXEventAccess().getGroup_5_1()); 
                    }
                    // InternalXMachine.g:1053:3: ( rule__XEvent__Group_5_1__0 )
                    // InternalXMachine.g:1053:4: rule__XEvent__Group_5_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XEvent__Group_5_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXEventAccess().getGroup_5_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Alternatives_5"


    // $ANTLR start "rule__XEvent__Alternatives_8_0"
    // InternalXMachine.g:1061:1: rule__XEvent__Alternatives_8_0 : ( ( 'where' ) | ( 'when' ) );
    public final void rule__XEvent__Alternatives_8_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:1065:1: ( ( 'where' ) | ( 'when' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==46) ) {
                alt9=1;
            }
            else if ( (LA9_0==47) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalXMachine.g:1066:2: ( 'where' )
                    {
                    // InternalXMachine.g:1066:2: ( 'where' )
                    // InternalXMachine.g:1067:3: 'where'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXEventAccess().getWhereKeyword_8_0_0()); 
                    }
                    match(input,46,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXEventAccess().getWhereKeyword_8_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:1072:2: ( 'when' )
                    {
                    // InternalXMachine.g:1072:2: ( 'when' )
                    // InternalXMachine.g:1073:3: 'when'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXEventAccess().getWhenKeyword_8_0_1()); 
                    }
                    match(input,47,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXEventAccess().getWhenKeyword_8_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Alternatives_8_0"


    // $ANTLR start "rule__XEvent__Alternatives_9_0"
    // InternalXMachine.g:1082:1: rule__XEvent__Alternatives_9_0 : ( ( 'then' ) | ( 'begin' ) );
    public final void rule__XEvent__Alternatives_9_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:1086:1: ( ( 'then' ) | ( 'begin' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==48) ) {
                alt10=1;
            }
            else if ( (LA10_0==49) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalXMachine.g:1087:2: ( 'then' )
                    {
                    // InternalXMachine.g:1087:2: ( 'then' )
                    // InternalXMachine.g:1088:3: 'then'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXEventAccess().getThenKeyword_9_0_0()); 
                    }
                    match(input,48,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXEventAccess().getThenKeyword_9_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:1093:2: ( 'begin' )
                    {
                    // InternalXMachine.g:1093:2: ( 'begin' )
                    // InternalXMachine.g:1094:3: 'begin'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXEventAccess().getBeginKeyword_9_0_1()); 
                    }
                    match(input,49,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXEventAccess().getBeginKeyword_9_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Alternatives_9_0"


    // $ANTLR start "rule__XFormula__Alternatives"
    // InternalXMachine.g:1103:1: rule__XFormula__Alternatives : ( ( ruleEVENTB_IDENTIFIER_KEYWORD ) | ( ruleEVENTB_PREDICATE_SYMBOLS ) | ( ruleEVENTB_EXPRESSION_SYMBOLS ) | ( RULE_INT ) | ( RULE_ID ) );
    public final void rule__XFormula__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:1107:1: ( ( ruleEVENTB_IDENTIFIER_KEYWORD ) | ( ruleEVENTB_PREDICATE_SYMBOLS ) | ( ruleEVENTB_EXPRESSION_SYMBOLS ) | ( RULE_INT ) | ( RULE_ID ) )
            int alt11=5;
            switch ( input.LA(1) ) {
            case 42:
            case 43:
            case 44:
            case 45:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
                {
                alt11=1;
                }
                break;
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
                {
                alt11=2;
                }
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 206:
                {
                alt11=3;
                }
                break;
            case RULE_INT:
                {
                alt11=4;
                }
                break;
            case RULE_ID:
                {
                alt11=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalXMachine.g:1108:2: ( ruleEVENTB_IDENTIFIER_KEYWORD )
                    {
                    // InternalXMachine.g:1108:2: ( ruleEVENTB_IDENTIFIER_KEYWORD )
                    // InternalXMachine.g:1109:3: ruleEVENTB_IDENTIFIER_KEYWORD
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXFormulaAccess().getEVENTB_IDENTIFIER_KEYWORDParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleEVENTB_IDENTIFIER_KEYWORD();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXFormulaAccess().getEVENTB_IDENTIFIER_KEYWORDParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:1114:2: ( ruleEVENTB_PREDICATE_SYMBOLS )
                    {
                    // InternalXMachine.g:1114:2: ( ruleEVENTB_PREDICATE_SYMBOLS )
                    // InternalXMachine.g:1115:3: ruleEVENTB_PREDICATE_SYMBOLS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXFormulaAccess().getEVENTB_PREDICATE_SYMBOLSParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleEVENTB_PREDICATE_SYMBOLS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXFormulaAccess().getEVENTB_PREDICATE_SYMBOLSParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalXMachine.g:1120:2: ( ruleEVENTB_EXPRESSION_SYMBOLS )
                    {
                    // InternalXMachine.g:1120:2: ( ruleEVENTB_EXPRESSION_SYMBOLS )
                    // InternalXMachine.g:1121:3: ruleEVENTB_EXPRESSION_SYMBOLS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXFormulaAccess().getEVENTB_EXPRESSION_SYMBOLSParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleEVENTB_EXPRESSION_SYMBOLS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXFormulaAccess().getEVENTB_EXPRESSION_SYMBOLSParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalXMachine.g:1126:2: ( RULE_INT )
                    {
                    // InternalXMachine.g:1126:2: ( RULE_INT )
                    // InternalXMachine.g:1127:3: RULE_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXFormulaAccess().getINTTerminalRuleCall_3()); 
                    }
                    match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXFormulaAccess().getINTTerminalRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalXMachine.g:1132:2: ( RULE_ID )
                    {
                    // InternalXMachine.g:1132:2: ( RULE_ID )
                    // InternalXMachine.g:1133:3: RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXFormulaAccess().getIDTerminalRuleCall_4()); 
                    }
                    match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXFormulaAccess().getIDTerminalRuleCall_4()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XFormula__Alternatives"


    // $ANTLR start "rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives"
    // InternalXMachine.g:1142:1: rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives : ( ( 'BOOL' ) | ( 'FALSE' ) | ( 'TRUE' ) | ( 'bool' ) | ( 'card' ) | ( 'dom' ) | ( 'finite' ) | ( 'id' ) | ( 'inter' ) | ( 'max' ) | ( 'min' ) | ( 'mod' ) | ( 'pred' ) | ( 'prj1' ) | ( 'prj2' ) | ( 'ran' ) | ( 'succ' ) | ( 'union' ) | ( '\\u21151' ) | ( 'NAT1' ) | ( '\\u2115' ) | ( 'NAT' ) | ( '\\u21191' ) | ( 'POW1' ) | ( '\\u2119' ) | ( 'POW' ) | ( '\\u2124' ) | ( 'INT' ) );
    public final void rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:1146:1: ( ( 'BOOL' ) | ( 'FALSE' ) | ( 'TRUE' ) | ( 'bool' ) | ( 'card' ) | ( 'dom' ) | ( 'finite' ) | ( 'id' ) | ( 'inter' ) | ( 'max' ) | ( 'min' ) | ( 'mod' ) | ( 'pred' ) | ( 'prj1' ) | ( 'prj2' ) | ( 'ran' ) | ( 'succ' ) | ( 'union' ) | ( '\\u21151' ) | ( 'NAT1' ) | ( '\\u2115' ) | ( 'NAT' ) | ( '\\u21191' ) | ( 'POW1' ) | ( '\\u2119' ) | ( 'POW' ) | ( '\\u2124' ) | ( 'INT' ) )
            int alt12=28;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt12=1;
                }
                break;
            case 50:
                {
                alt12=2;
                }
                break;
            case 51:
                {
                alt12=3;
                }
                break;
            case 52:
                {
                alt12=4;
                }
                break;
            case 53:
                {
                alt12=5;
                }
                break;
            case 54:
                {
                alt12=6;
                }
                break;
            case 55:
                {
                alt12=7;
                }
                break;
            case 56:
                {
                alt12=8;
                }
                break;
            case 57:
                {
                alt12=9;
                }
                break;
            case 58:
                {
                alt12=10;
                }
                break;
            case 59:
                {
                alt12=11;
                }
                break;
            case 60:
                {
                alt12=12;
                }
                break;
            case 61:
                {
                alt12=13;
                }
                break;
            case 62:
                {
                alt12=14;
                }
                break;
            case 63:
                {
                alt12=15;
                }
                break;
            case 64:
                {
                alt12=16;
                }
                break;
            case 65:
                {
                alt12=17;
                }
                break;
            case 66:
                {
                alt12=18;
                }
                break;
            case 43:
                {
                alt12=19;
                }
                break;
            case 67:
                {
                alt12=20;
                }
                break;
            case 44:
                {
                alt12=21;
                }
                break;
            case 68:
                {
                alt12=22;
                }
                break;
            case 69:
                {
                alt12=23;
                }
                break;
            case 70:
                {
                alt12=24;
                }
                break;
            case 71:
                {
                alt12=25;
                }
                break;
            case 72:
                {
                alt12=26;
                }
                break;
            case 45:
                {
                alt12=27;
                }
                break;
            case 73:
                {
                alt12=28;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalXMachine.g:1147:2: ( 'BOOL' )
                    {
                    // InternalXMachine.g:1147:2: ( 'BOOL' )
                    // InternalXMachine.g:1148:3: 'BOOL'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBOOLKeyword_0()); 
                    }
                    match(input,42,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBOOLKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:1153:2: ( 'FALSE' )
                    {
                    // InternalXMachine.g:1153:2: ( 'FALSE' )
                    // InternalXMachine.g:1154:3: 'FALSE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFALSEKeyword_1()); 
                    }
                    match(input,50,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFALSEKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalXMachine.g:1159:2: ( 'TRUE' )
                    {
                    // InternalXMachine.g:1159:2: ( 'TRUE' )
                    // InternalXMachine.g:1160:3: 'TRUE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getTRUEKeyword_2()); 
                    }
                    match(input,51,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getTRUEKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalXMachine.g:1165:2: ( 'bool' )
                    {
                    // InternalXMachine.g:1165:2: ( 'bool' )
                    // InternalXMachine.g:1166:3: 'bool'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBoolKeyword_3()); 
                    }
                    match(input,52,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBoolKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalXMachine.g:1171:2: ( 'card' )
                    {
                    // InternalXMachine.g:1171:2: ( 'card' )
                    // InternalXMachine.g:1172:3: 'card'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getCardKeyword_4()); 
                    }
                    match(input,53,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getCardKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalXMachine.g:1177:2: ( 'dom' )
                    {
                    // InternalXMachine.g:1177:2: ( 'dom' )
                    // InternalXMachine.g:1178:3: 'dom'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDomKeyword_5()); 
                    }
                    match(input,54,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDomKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalXMachine.g:1183:2: ( 'finite' )
                    {
                    // InternalXMachine.g:1183:2: ( 'finite' )
                    // InternalXMachine.g:1184:3: 'finite'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFiniteKeyword_6()); 
                    }
                    match(input,55,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFiniteKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalXMachine.g:1189:2: ( 'id' )
                    {
                    // InternalXMachine.g:1189:2: ( 'id' )
                    // InternalXMachine.g:1190:3: 'id'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getIdKeyword_7()); 
                    }
                    match(input,56,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getIdKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalXMachine.g:1195:2: ( 'inter' )
                    {
                    // InternalXMachine.g:1195:2: ( 'inter' )
                    // InternalXMachine.g:1196:3: 'inter'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getInterKeyword_8()); 
                    }
                    match(input,57,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getInterKeyword_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalXMachine.g:1201:2: ( 'max' )
                    {
                    // InternalXMachine.g:1201:2: ( 'max' )
                    // InternalXMachine.g:1202:3: 'max'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMaxKeyword_9()); 
                    }
                    match(input,58,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMaxKeyword_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalXMachine.g:1207:2: ( 'min' )
                    {
                    // InternalXMachine.g:1207:2: ( 'min' )
                    // InternalXMachine.g:1208:3: 'min'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMinKeyword_10()); 
                    }
                    match(input,59,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMinKeyword_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalXMachine.g:1213:2: ( 'mod' )
                    {
                    // InternalXMachine.g:1213:2: ( 'mod' )
                    // InternalXMachine.g:1214:3: 'mod'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getModKeyword_11()); 
                    }
                    match(input,60,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getModKeyword_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalXMachine.g:1219:2: ( 'pred' )
                    {
                    // InternalXMachine.g:1219:2: ( 'pred' )
                    // InternalXMachine.g:1220:3: 'pred'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPredKeyword_12()); 
                    }
                    match(input,61,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPredKeyword_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalXMachine.g:1225:2: ( 'prj1' )
                    {
                    // InternalXMachine.g:1225:2: ( 'prj1' )
                    // InternalXMachine.g:1226:3: 'prj1'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj1Keyword_13()); 
                    }
                    match(input,62,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj1Keyword_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalXMachine.g:1231:2: ( 'prj2' )
                    {
                    // InternalXMachine.g:1231:2: ( 'prj2' )
                    // InternalXMachine.g:1232:3: 'prj2'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj2Keyword_14()); 
                    }
                    match(input,63,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj2Keyword_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalXMachine.g:1237:2: ( 'ran' )
                    {
                    // InternalXMachine.g:1237:2: ( 'ran' )
                    // InternalXMachine.g:1238:3: 'ran'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getRanKeyword_15()); 
                    }
                    match(input,64,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getRanKeyword_15()); 
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalXMachine.g:1243:2: ( 'succ' )
                    {
                    // InternalXMachine.g:1243:2: ( 'succ' )
                    // InternalXMachine.g:1244:3: 'succ'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getSuccKeyword_16()); 
                    }
                    match(input,65,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getSuccKeyword_16()); 
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalXMachine.g:1249:2: ( 'union' )
                    {
                    // InternalXMachine.g:1249:2: ( 'union' )
                    // InternalXMachine.g:1250:3: 'union'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getUnionKeyword_17()); 
                    }
                    match(input,66,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getUnionKeyword_17()); 
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalXMachine.g:1255:2: ( '\\u21151' )
                    {
                    // InternalXMachine.g:1255:2: ( '\\u21151' )
                    // InternalXMachine.g:1256:3: '\\u21151'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNDigitOneKeyword_18()); 
                    }
                    match(input,43,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNDigitOneKeyword_18()); 
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalXMachine.g:1261:2: ( 'NAT1' )
                    {
                    // InternalXMachine.g:1261:2: ( 'NAT1' )
                    // InternalXMachine.g:1262:3: 'NAT1'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getNAT1Keyword_19()); 
                    }
                    match(input,67,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getNAT1Keyword_19()); 
                    }

                    }


                    }
                    break;
                case 21 :
                    // InternalXMachine.g:1267:2: ( '\\u2115' )
                    {
                    // InternalXMachine.g:1267:2: ( '\\u2115' )
                    // InternalXMachine.g:1268:3: '\\u2115'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNKeyword_20()); 
                    }
                    match(input,44,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNKeyword_20()); 
                    }

                    }


                    }
                    break;
                case 22 :
                    // InternalXMachine.g:1273:2: ( 'NAT' )
                    {
                    // InternalXMachine.g:1273:2: ( 'NAT' )
                    // InternalXMachine.g:1274:3: 'NAT'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getNATKeyword_21()); 
                    }
                    match(input,68,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getNATKeyword_21()); 
                    }

                    }


                    }
                    break;
                case 23 :
                    // InternalXMachine.g:1279:2: ( '\\u21191' )
                    {
                    // InternalXMachine.g:1279:2: ( '\\u21191' )
                    // InternalXMachine.g:1280:3: '\\u21191'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPDigitOneKeyword_22()); 
                    }
                    match(input,69,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPDigitOneKeyword_22()); 
                    }

                    }


                    }
                    break;
                case 24 :
                    // InternalXMachine.g:1285:2: ( 'POW1' )
                    {
                    // InternalXMachine.g:1285:2: ( 'POW1' )
                    // InternalXMachine.g:1286:3: 'POW1'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPOW1Keyword_23()); 
                    }
                    match(input,70,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPOW1Keyword_23()); 
                    }

                    }


                    }
                    break;
                case 25 :
                    // InternalXMachine.g:1291:2: ( '\\u2119' )
                    {
                    // InternalXMachine.g:1291:2: ( '\\u2119' )
                    // InternalXMachine.g:1292:3: '\\u2119'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPKeyword_24()); 
                    }
                    match(input,71,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPKeyword_24()); 
                    }

                    }


                    }
                    break;
                case 26 :
                    // InternalXMachine.g:1297:2: ( 'POW' )
                    {
                    // InternalXMachine.g:1297:2: ( 'POW' )
                    // InternalXMachine.g:1298:3: 'POW'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPOWKeyword_25()); 
                    }
                    match(input,72,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPOWKeyword_25()); 
                    }

                    }


                    }
                    break;
                case 27 :
                    // InternalXMachine.g:1303:2: ( '\\u2124' )
                    {
                    // InternalXMachine.g:1303:2: ( '\\u2124' )
                    // InternalXMachine.g:1304:3: '\\u2124'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalZKeyword_26()); 
                    }
                    match(input,45,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalZKeyword_26()); 
                    }

                    }


                    }
                    break;
                case 28 :
                    // InternalXMachine.g:1309:2: ( 'INT' )
                    {
                    // InternalXMachine.g:1309:2: ( 'INT' )
                    // InternalXMachine.g:1310:3: 'INT'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getINTKeyword_27()); 
                    }
                    match(input,73,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getINTKeyword_27()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives"


    // $ANTLR start "rule__EVENTB_PREDICATE_SYMBOLS__Alternatives"
    // InternalXMachine.g:1319:1: rule__EVENTB_PREDICATE_SYMBOLS__Alternatives : ( ( '(' ) | ( ')' ) | ( '\\u21D4' ) | ( '<=>' ) | ( '\\u21D2' ) | ( '=>' ) | ( '\\u2227' ) | ( '&' ) | ( '\\u2228' ) | ( 'or' ) | ( '\\u00AC' ) | ( 'not' ) | ( '\\u22A4' ) | ( 'true' ) | ( '\\u22A5' ) | ( 'false' ) | ( '\\u2200' ) | ( '!' ) | ( '\\u2203' ) | ( '#' ) | ( ',' ) | ( '\\u00B7' ) | ( '.' ) | ( '=' ) | ( '\\u2260' ) | ( '/=' ) | ( '\\u2264' ) | ( '=<' ) | ( '<' ) | ( '\\u2265' ) | ( '>=' ) | ( '>' ) | ( '\\u2208' ) | ( ':' ) | ( '\\u2209' ) | ( '/:' ) | ( '\\u2282' ) | ( '<<:' ) | ( '\\u2284' ) | ( '/<<:' ) | ( '\\u2286' ) | ( '<:' ) | ( '\\u2288' ) | ( '/<:' ) | ( 'partition' ) );
    public final void rule__EVENTB_PREDICATE_SYMBOLS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:1323:1: ( ( '(' ) | ( ')' ) | ( '\\u21D4' ) | ( '<=>' ) | ( '\\u21D2' ) | ( '=>' ) | ( '\\u2227' ) | ( '&' ) | ( '\\u2228' ) | ( 'or' ) | ( '\\u00AC' ) | ( 'not' ) | ( '\\u22A4' ) | ( 'true' ) | ( '\\u22A5' ) | ( 'false' ) | ( '\\u2200' ) | ( '!' ) | ( '\\u2203' ) | ( '#' ) | ( ',' ) | ( '\\u00B7' ) | ( '.' ) | ( '=' ) | ( '\\u2260' ) | ( '/=' ) | ( '\\u2264' ) | ( '=<' ) | ( '<' ) | ( '\\u2265' ) | ( '>=' ) | ( '>' ) | ( '\\u2208' ) | ( ':' ) | ( '\\u2209' ) | ( '/:' ) | ( '\\u2282' ) | ( '<<:' ) | ( '\\u2284' ) | ( '/<<:' ) | ( '\\u2286' ) | ( '<:' ) | ( '\\u2288' ) | ( '/<:' ) | ( 'partition' ) )
            int alt13=45;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt13=1;
                }
                break;
            case 75:
                {
                alt13=2;
                }
                break;
            case 76:
                {
                alt13=3;
                }
                break;
            case 77:
                {
                alt13=4;
                }
                break;
            case 78:
                {
                alt13=5;
                }
                break;
            case 79:
                {
                alt13=6;
                }
                break;
            case 80:
                {
                alt13=7;
                }
                break;
            case 81:
                {
                alt13=8;
                }
                break;
            case 82:
                {
                alt13=9;
                }
                break;
            case 83:
                {
                alt13=10;
                }
                break;
            case 84:
                {
                alt13=11;
                }
                break;
            case 85:
                {
                alt13=12;
                }
                break;
            case 86:
                {
                alt13=13;
                }
                break;
            case 87:
                {
                alt13=14;
                }
                break;
            case 88:
                {
                alt13=15;
                }
                break;
            case 89:
                {
                alt13=16;
                }
                break;
            case 90:
                {
                alt13=17;
                }
                break;
            case 91:
                {
                alt13=18;
                }
                break;
            case 92:
                {
                alt13=19;
                }
                break;
            case 93:
                {
                alt13=20;
                }
                break;
            case 94:
                {
                alt13=21;
                }
                break;
            case 95:
                {
                alt13=22;
                }
                break;
            case 96:
                {
                alt13=23;
                }
                break;
            case 97:
                {
                alt13=24;
                }
                break;
            case 98:
                {
                alt13=25;
                }
                break;
            case 99:
                {
                alt13=26;
                }
                break;
            case 100:
                {
                alt13=27;
                }
                break;
            case 101:
                {
                alt13=28;
                }
                break;
            case 102:
                {
                alt13=29;
                }
                break;
            case 103:
                {
                alt13=30;
                }
                break;
            case 104:
                {
                alt13=31;
                }
                break;
            case 105:
                {
                alt13=32;
                }
                break;
            case 106:
                {
                alt13=33;
                }
                break;
            case 107:
                {
                alt13=34;
                }
                break;
            case 108:
                {
                alt13=35;
                }
                break;
            case 109:
                {
                alt13=36;
                }
                break;
            case 110:
                {
                alt13=37;
                }
                break;
            case 111:
                {
                alt13=38;
                }
                break;
            case 112:
                {
                alt13=39;
                }
                break;
            case 113:
                {
                alt13=40;
                }
                break;
            case 114:
                {
                alt13=41;
                }
                break;
            case 115:
                {
                alt13=42;
                }
                break;
            case 116:
                {
                alt13=43;
                }
                break;
            case 117:
                {
                alt13=44;
                }
                break;
            case 118:
                {
                alt13=45;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalXMachine.g:1324:2: ( '(' )
                    {
                    // InternalXMachine.g:1324:2: ( '(' )
                    // InternalXMachine.g:1325:3: '('
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftParenthesisKeyword_0()); 
                    }
                    match(input,74,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftParenthesisKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:1330:2: ( ')' )
                    {
                    // InternalXMachine.g:1330:2: ( ')' )
                    // InternalXMachine.g:1331:3: ')'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightParenthesisKeyword_1()); 
                    }
                    match(input,75,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightParenthesisKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalXMachine.g:1336:2: ( '\\u21D4' )
                    {
                    // InternalXMachine.g:1336:2: ( '\\u21D4' )
                    // InternalXMachine.g:1337:3: '\\u21D4'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftRightDoubleArrowKeyword_2()); 
                    }
                    match(input,76,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftRightDoubleArrowKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalXMachine.g:1342:2: ( '<=>' )
                    {
                    // InternalXMachine.g:1342:2: ( '<=>' )
                    // InternalXMachine.g:1343:3: '<=>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanSignEqualsSignGreaterThanSignKeyword_3()); 
                    }
                    match(input,77,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanSignEqualsSignGreaterThanSignKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalXMachine.g:1348:2: ( '\\u21D2' )
                    {
                    // InternalXMachine.g:1348:2: ( '\\u21D2' )
                    // InternalXMachine.g:1349:3: '\\u21D2'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightwardsDoubleArrowKeyword_4()); 
                    }
                    match(input,78,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightwardsDoubleArrowKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalXMachine.g:1354:2: ( '=>' )
                    {
                    // InternalXMachine.g:1354:2: ( '=>' )
                    // InternalXMachine.g:1355:3: '=>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getEqualsSignGreaterThanSignKeyword_5()); 
                    }
                    match(input,79,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getEqualsSignGreaterThanSignKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalXMachine.g:1360:2: ( '\\u2227' )
                    {
                    // InternalXMachine.g:1360:2: ( '\\u2227' )
                    // InternalXMachine.g:1361:3: '\\u2227'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalAndKeyword_6()); 
                    }
                    match(input,80,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalAndKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalXMachine.g:1366:2: ( '&' )
                    {
                    // InternalXMachine.g:1366:2: ( '&' )
                    // InternalXMachine.g:1367:3: '&'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAmpersandKeyword_7()); 
                    }
                    match(input,81,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAmpersandKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalXMachine.g:1372:2: ( '\\u2228' )
                    {
                    // InternalXMachine.g:1372:2: ( '\\u2228' )
                    // InternalXMachine.g:1373:3: '\\u2228'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalOrKeyword_8()); 
                    }
                    match(input,82,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalOrKeyword_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalXMachine.g:1378:2: ( 'or' )
                    {
                    // InternalXMachine.g:1378:2: ( 'or' )
                    // InternalXMachine.g:1379:3: 'or'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getOrKeyword_9()); 
                    }
                    match(input,83,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getOrKeyword_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalXMachine.g:1384:2: ( '\\u00AC' )
                    {
                    // InternalXMachine.g:1384:2: ( '\\u00AC' )
                    // InternalXMachine.g:1385:3: '\\u00AC'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotSignKeyword_10()); 
                    }
                    match(input,84,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotSignKeyword_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalXMachine.g:1390:2: ( 'not' )
                    {
                    // InternalXMachine.g:1390:2: ( 'not' )
                    // InternalXMachine.g:1391:3: 'not'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotKeyword_11()); 
                    }
                    match(input,85,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotKeyword_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalXMachine.g:1396:2: ( '\\u22A4' )
                    {
                    // InternalXMachine.g:1396:2: ( '\\u22A4' )
                    // InternalXMachine.g:1397:3: '\\u22A4'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getDownTackKeyword_12()); 
                    }
                    match(input,86,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getDownTackKeyword_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalXMachine.g:1402:2: ( 'true' )
                    {
                    // InternalXMachine.g:1402:2: ( 'true' )
                    // InternalXMachine.g:1403:3: 'true'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getTrueKeyword_13()); 
                    }
                    match(input,87,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getTrueKeyword_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalXMachine.g:1408:2: ( '\\u22A5' )
                    {
                    // InternalXMachine.g:1408:2: ( '\\u22A5' )
                    // InternalXMachine.g:1409:3: '\\u22A5'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getUpTackKeyword_14()); 
                    }
                    match(input,88,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getUpTackKeyword_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalXMachine.g:1414:2: ( 'false' )
                    {
                    // InternalXMachine.g:1414:2: ( 'false' )
                    // InternalXMachine.g:1415:3: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getFalseKeyword_15()); 
                    }
                    match(input,89,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getFalseKeyword_15()); 
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalXMachine.g:1420:2: ( '\\u2200' )
                    {
                    // InternalXMachine.g:1420:2: ( '\\u2200' )
                    // InternalXMachine.g:1421:3: '\\u2200'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getForAllKeyword_16()); 
                    }
                    match(input,90,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getForAllKeyword_16()); 
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalXMachine.g:1426:2: ( '!' )
                    {
                    // InternalXMachine.g:1426:2: ( '!' )
                    // InternalXMachine.g:1427:3: '!'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getExclamationMarkKeyword_17()); 
                    }
                    match(input,91,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getExclamationMarkKeyword_17()); 
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalXMachine.g:1432:2: ( '\\u2203' )
                    {
                    // InternalXMachine.g:1432:2: ( '\\u2203' )
                    // InternalXMachine.g:1433:3: '\\u2203'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getThereExistsKeyword_18()); 
                    }
                    match(input,92,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getThereExistsKeyword_18()); 
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalXMachine.g:1438:2: ( '#' )
                    {
                    // InternalXMachine.g:1438:2: ( '#' )
                    // InternalXMachine.g:1439:3: '#'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNumberSignKeyword_19()); 
                    }
                    match(input,93,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNumberSignKeyword_19()); 
                    }

                    }


                    }
                    break;
                case 21 :
                    // InternalXMachine.g:1444:2: ( ',' )
                    {
                    // InternalXMachine.g:1444:2: ( ',' )
                    // InternalXMachine.g:1445:3: ','
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getCommaKeyword_20()); 
                    }
                    match(input,94,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getCommaKeyword_20()); 
                    }

                    }


                    }
                    break;
                case 22 :
                    // InternalXMachine.g:1450:2: ( '\\u00B7' )
                    {
                    // InternalXMachine.g:1450:2: ( '\\u00B7' )
                    // InternalXMachine.g:1451:3: '\\u00B7'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getMiddleDotKeyword_21()); 
                    }
                    match(input,95,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getMiddleDotKeyword_21()); 
                    }

                    }


                    }
                    break;
                case 23 :
                    // InternalXMachine.g:1456:2: ( '.' )
                    {
                    // InternalXMachine.g:1456:2: ( '.' )
                    // InternalXMachine.g:1457:3: '.'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getFullStopKeyword_22()); 
                    }
                    match(input,96,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getFullStopKeyword_22()); 
                    }

                    }


                    }
                    break;
                case 24 :
                    // InternalXMachine.g:1462:2: ( '=' )
                    {
                    // InternalXMachine.g:1462:2: ( '=' )
                    // InternalXMachine.g:1463:3: '='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getEqualsSignKeyword_23()); 
                    }
                    match(input,97,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getEqualsSignKeyword_23()); 
                    }

                    }


                    }
                    break;
                case 25 :
                    // InternalXMachine.g:1468:2: ( '\\u2260' )
                    {
                    // InternalXMachine.g:1468:2: ( '\\u2260' )
                    // InternalXMachine.g:1469:3: '\\u2260'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotEqualToKeyword_24()); 
                    }
                    match(input,98,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotEqualToKeyword_24()); 
                    }

                    }


                    }
                    break;
                case 26 :
                    // InternalXMachine.g:1474:2: ( '/=' )
                    {
                    // InternalXMachine.g:1474:2: ( '/=' )
                    // InternalXMachine.g:1475:3: '/='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSolidusEqualsSignKeyword_25()); 
                    }
                    match(input,99,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSolidusEqualsSignKeyword_25()); 
                    }

                    }


                    }
                    break;
                case 27 :
                    // InternalXMachine.g:1480:2: ( '\\u2264' )
                    {
                    // InternalXMachine.g:1480:2: ( '\\u2264' )
                    // InternalXMachine.g:1481:3: '\\u2264'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanOrEqualToKeyword_26()); 
                    }
                    match(input,100,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanOrEqualToKeyword_26()); 
                    }

                    }


                    }
                    break;
                case 28 :
                    // InternalXMachine.g:1486:2: ( '=<' )
                    {
                    // InternalXMachine.g:1486:2: ( '=<' )
                    // InternalXMachine.g:1487:3: '=<'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getEqualsSignLessThanSignKeyword_27()); 
                    }
                    match(input,101,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getEqualsSignLessThanSignKeyword_27()); 
                    }

                    }


                    }
                    break;
                case 29 :
                    // InternalXMachine.g:1492:2: ( '<' )
                    {
                    // InternalXMachine.g:1492:2: ( '<' )
                    // InternalXMachine.g:1493:3: '<'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanSignKeyword_28()); 
                    }
                    match(input,102,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanSignKeyword_28()); 
                    }

                    }


                    }
                    break;
                case 30 :
                    // InternalXMachine.g:1498:2: ( '\\u2265' )
                    {
                    // InternalXMachine.g:1498:2: ( '\\u2265' )
                    // InternalXMachine.g:1499:3: '\\u2265'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanOrEqualToKeyword_29()); 
                    }
                    match(input,103,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanOrEqualToKeyword_29()); 
                    }

                    }


                    }
                    break;
                case 31 :
                    // InternalXMachine.g:1504:2: ( '>=' )
                    {
                    // InternalXMachine.g:1504:2: ( '>=' )
                    // InternalXMachine.g:1505:3: '>='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanSignEqualsSignKeyword_30()); 
                    }
                    match(input,104,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanSignEqualsSignKeyword_30()); 
                    }

                    }


                    }
                    break;
                case 32 :
                    // InternalXMachine.g:1510:2: ( '>' )
                    {
                    // InternalXMachine.g:1510:2: ( '>' )
                    // InternalXMachine.g:1511:3: '>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanSignKeyword_31()); 
                    }
                    match(input,105,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanSignKeyword_31()); 
                    }

                    }


                    }
                    break;
                case 33 :
                    // InternalXMachine.g:1516:2: ( '\\u2208' )
                    {
                    // InternalXMachine.g:1516:2: ( '\\u2208' )
                    // InternalXMachine.g:1517:3: '\\u2208'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getElementOfKeyword_32()); 
                    }
                    match(input,106,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getElementOfKeyword_32()); 
                    }

                    }


                    }
                    break;
                case 34 :
                    // InternalXMachine.g:1522:2: ( ':' )
                    {
                    // InternalXMachine.g:1522:2: ( ':' )
                    // InternalXMachine.g:1523:3: ':'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getColonKeyword_33()); 
                    }
                    match(input,107,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getColonKeyword_33()); 
                    }

                    }


                    }
                    break;
                case 35 :
                    // InternalXMachine.g:1528:2: ( '\\u2209' )
                    {
                    // InternalXMachine.g:1528:2: ( '\\u2209' )
                    // InternalXMachine.g:1529:3: '\\u2209'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotAnElementOfKeyword_34()); 
                    }
                    match(input,108,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotAnElementOfKeyword_34()); 
                    }

                    }


                    }
                    break;
                case 36 :
                    // InternalXMachine.g:1534:2: ( '/:' )
                    {
                    // InternalXMachine.g:1534:2: ( '/:' )
                    // InternalXMachine.g:1535:3: '/:'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSolidusColonKeyword_35()); 
                    }
                    match(input,109,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSolidusColonKeyword_35()); 
                    }

                    }


                    }
                    break;
                case 37 :
                    // InternalXMachine.g:1540:2: ( '\\u2282' )
                    {
                    // InternalXMachine.g:1540:2: ( '\\u2282' )
                    // InternalXMachine.g:1541:3: '\\u2282'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfKeyword_36()); 
                    }
                    match(input,110,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfKeyword_36()); 
                    }

                    }


                    }
                    break;
                case 38 :
                    // InternalXMachine.g:1546:2: ( '<<:' )
                    {
                    // InternalXMachine.g:1546:2: ( '<<:' )
                    // InternalXMachine.g:1547:3: '<<:'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanSignLessThanSignColonKeyword_37()); 
                    }
                    match(input,111,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanSignLessThanSignColonKeyword_37()); 
                    }

                    }


                    }
                    break;
                case 39 :
                    // InternalXMachine.g:1552:2: ( '\\u2284' )
                    {
                    // InternalXMachine.g:1552:2: ( '\\u2284' )
                    // InternalXMachine.g:1553:3: '\\u2284'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotASubsetOfKeyword_38()); 
                    }
                    match(input,112,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotASubsetOfKeyword_38()); 
                    }

                    }


                    }
                    break;
                case 40 :
                    // InternalXMachine.g:1558:2: ( '/<<:' )
                    {
                    // InternalXMachine.g:1558:2: ( '/<<:' )
                    // InternalXMachine.g:1559:3: '/<<:'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSolidusLessThanSignLessThanSignColonKeyword_39()); 
                    }
                    match(input,113,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSolidusLessThanSignLessThanSignColonKeyword_39()); 
                    }

                    }


                    }
                    break;
                case 41 :
                    // InternalXMachine.g:1564:2: ( '\\u2286' )
                    {
                    // InternalXMachine.g:1564:2: ( '\\u2286' )
                    // InternalXMachine.g:1565:3: '\\u2286'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfOrEqualToKeyword_40()); 
                    }
                    match(input,114,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfOrEqualToKeyword_40()); 
                    }

                    }


                    }
                    break;
                case 42 :
                    // InternalXMachine.g:1570:2: ( '<:' )
                    {
                    // InternalXMachine.g:1570:2: ( '<:' )
                    // InternalXMachine.g:1571:3: '<:'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanSignColonKeyword_41()); 
                    }
                    match(input,115,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanSignColonKeyword_41()); 
                    }

                    }


                    }
                    break;
                case 43 :
                    // InternalXMachine.g:1576:2: ( '\\u2288' )
                    {
                    // InternalXMachine.g:1576:2: ( '\\u2288' )
                    // InternalXMachine.g:1577:3: '\\u2288'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNeitherASubsetOfNorEqualToKeyword_42()); 
                    }
                    match(input,116,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNeitherASubsetOfNorEqualToKeyword_42()); 
                    }

                    }


                    }
                    break;
                case 44 :
                    // InternalXMachine.g:1582:2: ( '/<:' )
                    {
                    // InternalXMachine.g:1582:2: ( '/<:' )
                    // InternalXMachine.g:1583:3: '/<:'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSolidusLessThanSignColonKeyword_43()); 
                    }
                    match(input,117,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSolidusLessThanSignColonKeyword_43()); 
                    }

                    }


                    }
                    break;
                case 45 :
                    // InternalXMachine.g:1588:2: ( 'partition' )
                    {
                    // InternalXMachine.g:1588:2: ( 'partition' )
                    // InternalXMachine.g:1589:3: 'partition'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getPartitionKeyword_44()); 
                    }
                    match(input,118,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getPartitionKeyword_44()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_PREDICATE_SYMBOLS__Alternatives"


    // $ANTLR start "rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives"
    // InternalXMachine.g:1598:1: rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives : ( ( '\\u2194' ) | ( '<->' ) | ( '\\uE100' ) | ( '<<->' ) | ( '\\uE101' ) | ( '<->>' ) | ( '\\uE102' ) | ( '<<->>' ) | ( '\\u21F8' ) | ( '+->' ) | ( '\\u2192' ) | ( '-->' ) | ( '\\u2914' ) | ( '>+>' ) | ( '\\u21A3' ) | ( '>->' ) | ( '\\u2900' ) | ( '+>>' ) | ( '\\u21A0' ) | ( '->>' ) | ( '\\u2916' ) | ( '>->>' ) | ( '{' ) | ( '}' ) | ( '\\u21A6' ) | ( ',,' ) | ( '|->' ) | ( '\\u2205' ) | ( '{}' ) | ( '\\u2229' ) | ( '/\\\\' ) | ( '\\u222A' ) | ( '\\\\/' ) | ( '\\u2216' ) | ( '\\\\' ) | ( '\\u00D7' ) | ( '**' ) | ( '[' ) | ( ']' ) | ( '\\uE103' ) | ( '<+' ) | ( '\\u2218' ) | ( 'circ' ) | ( ';' ) | ( '\\u2297' ) | ( '><' ) | ( '\\u2225' ) | ( '||' ) | ( '\\u223C' ) | ( '~' ) | ( '\\u25C1' ) | ( '<|' ) | ( '\\u2A64' ) | ( '<<|' ) | ( '\\u25B7' ) | ( '|>' ) | ( '\\u2A65' ) | ( '|>>' ) | ( '\\u03BB' ) | ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0 ) ) | ( 'INTER' ) | ( '\\u22C3' ) | ( 'UNION' ) | ( '\\u2223' ) | ( '|' ) | ( '\\u2025' ) | ( '..' ) | ( '+' ) | ( '\\u2212' ) | ( '-' ) | ( '\\u2217' ) | ( '*' ) | ( '\\u00F7' ) | ( '/' ) | ( '^' ) );
    public final void rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:1602:1: ( ( '\\u2194' ) | ( '<->' ) | ( '\\uE100' ) | ( '<<->' ) | ( '\\uE101' ) | ( '<->>' ) | ( '\\uE102' ) | ( '<<->>' ) | ( '\\u21F8' ) | ( '+->' ) | ( '\\u2192' ) | ( '-->' ) | ( '\\u2914' ) | ( '>+>' ) | ( '\\u21A3' ) | ( '>->' ) | ( '\\u2900' ) | ( '+>>' ) | ( '\\u21A0' ) | ( '->>' ) | ( '\\u2916' ) | ( '>->>' ) | ( '{' ) | ( '}' ) | ( '\\u21A6' ) | ( ',,' ) | ( '|->' ) | ( '\\u2205' ) | ( '{}' ) | ( '\\u2229' ) | ( '/\\\\' ) | ( '\\u222A' ) | ( '\\\\/' ) | ( '\\u2216' ) | ( '\\\\' ) | ( '\\u00D7' ) | ( '**' ) | ( '[' ) | ( ']' ) | ( '\\uE103' ) | ( '<+' ) | ( '\\u2218' ) | ( 'circ' ) | ( ';' ) | ( '\\u2297' ) | ( '><' ) | ( '\\u2225' ) | ( '||' ) | ( '\\u223C' ) | ( '~' ) | ( '\\u25C1' ) | ( '<|' ) | ( '\\u2A64' ) | ( '<<|' ) | ( '\\u25B7' ) | ( '|>' ) | ( '\\u2A65' ) | ( '|>>' ) | ( '\\u03BB' ) | ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0 ) ) | ( 'INTER' ) | ( '\\u22C3' ) | ( 'UNION' ) | ( '\\u2223' ) | ( '|' ) | ( '\\u2025' ) | ( '..' ) | ( '+' ) | ( '\\u2212' ) | ( '-' ) | ( '\\u2217' ) | ( '*' ) | ( '\\u00F7' ) | ( '/' ) | ( '^' ) )
            int alt14=75;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt14=1;
                }
                break;
            case 19:
                {
                alt14=2;
                }
                break;
            case 20:
                {
                alt14=3;
                }
                break;
            case 21:
                {
                alt14=4;
                }
                break;
            case 22:
                {
                alt14=5;
                }
                break;
            case 23:
                {
                alt14=6;
                }
                break;
            case 24:
                {
                alt14=7;
                }
                break;
            case 25:
                {
                alt14=8;
                }
                break;
            case 26:
                {
                alt14=9;
                }
                break;
            case 27:
                {
                alt14=10;
                }
                break;
            case 28:
                {
                alt14=11;
                }
                break;
            case 29:
                {
                alt14=12;
                }
                break;
            case 30:
                {
                alt14=13;
                }
                break;
            case 31:
                {
                alt14=14;
                }
                break;
            case 32:
                {
                alt14=15;
                }
                break;
            case 33:
                {
                alt14=16;
                }
                break;
            case 34:
                {
                alt14=17;
                }
                break;
            case 35:
                {
                alt14=18;
                }
                break;
            case 36:
                {
                alt14=19;
                }
                break;
            case 37:
                {
                alt14=20;
                }
                break;
            case 38:
                {
                alt14=21;
                }
                break;
            case 39:
                {
                alt14=22;
                }
                break;
            case 119:
                {
                alt14=23;
                }
                break;
            case 120:
                {
                alt14=24;
                }
                break;
            case 121:
                {
                alt14=25;
                }
                break;
            case 122:
                {
                alt14=26;
                }
                break;
            case 123:
                {
                alt14=27;
                }
                break;
            case 124:
                {
                alt14=28;
                }
                break;
            case 125:
                {
                alt14=29;
                }
                break;
            case 126:
                {
                alt14=30;
                }
                break;
            case 127:
                {
                alt14=31;
                }
                break;
            case 128:
                {
                alt14=32;
                }
                break;
            case 129:
                {
                alt14=33;
                }
                break;
            case 130:
                {
                alt14=34;
                }
                break;
            case 131:
                {
                alt14=35;
                }
                break;
            case 40:
                {
                alt14=36;
                }
                break;
            case 41:
                {
                alt14=37;
                }
                break;
            case 132:
                {
                alt14=38;
                }
                break;
            case 133:
                {
                alt14=39;
                }
                break;
            case 134:
                {
                alt14=40;
                }
                break;
            case 135:
                {
                alt14=41;
                }
                break;
            case 136:
                {
                alt14=42;
                }
                break;
            case 137:
                {
                alt14=43;
                }
                break;
            case 138:
                {
                alt14=44;
                }
                break;
            case 139:
                {
                alt14=45;
                }
                break;
            case 140:
                {
                alt14=46;
                }
                break;
            case 141:
                {
                alt14=47;
                }
                break;
            case 142:
                {
                alt14=48;
                }
                break;
            case 143:
                {
                alt14=49;
                }
                break;
            case 144:
                {
                alt14=50;
                }
                break;
            case 145:
                {
                alt14=51;
                }
                break;
            case 146:
                {
                alt14=52;
                }
                break;
            case 147:
                {
                alt14=53;
                }
                break;
            case 148:
                {
                alt14=54;
                }
                break;
            case 149:
                {
                alt14=55;
                }
                break;
            case 150:
                {
                alt14=56;
                }
                break;
            case 151:
                {
                alt14=57;
                }
                break;
            case 152:
                {
                alt14=58;
                }
                break;
            case 153:
                {
                alt14=59;
                }
                break;
            case 206:
                {
                alt14=60;
                }
                break;
            case 154:
                {
                alt14=61;
                }
                break;
            case 155:
                {
                alt14=62;
                }
                break;
            case 156:
                {
                alt14=63;
                }
                break;
            case 157:
                {
                alt14=64;
                }
                break;
            case 158:
                {
                alt14=65;
                }
                break;
            case 159:
                {
                alt14=66;
                }
                break;
            case 160:
                {
                alt14=67;
                }
                break;
            case 161:
                {
                alt14=68;
                }
                break;
            case 162:
                {
                alt14=69;
                }
                break;
            case 163:
                {
                alt14=70;
                }
                break;
            case 164:
                {
                alt14=71;
                }
                break;
            case 165:
                {
                alt14=72;
                }
                break;
            case 166:
                {
                alt14=73;
                }
                break;
            case 167:
                {
                alt14=74;
                }
                break;
            case 168:
                {
                alt14=75;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalXMachine.g:1603:2: ( '\\u2194' )
                    {
                    // InternalXMachine.g:1603:2: ( '\\u2194' )
                    // InternalXMachine.g:1604:3: '\\u2194'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftRightArrowKeyword_0()); 
                    }
                    match(input,18,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftRightArrowKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:1609:2: ( '<->' )
                    {
                    // InternalXMachine.g:1609:2: ( '<->' )
                    // InternalXMachine.g:1610:3: '<->'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_1()); 
                    }
                    match(input,19,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalXMachine.g:1615:2: ( '\\uE100' )
                    {
                    // InternalXMachine.g:1615:2: ( '\\uE100' )
                    // InternalXMachine.g:1616:3: '\\uE100'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE100Keyword_2()); 
                    }
                    match(input,20,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE100Keyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalXMachine.g:1621:2: ( '<<->' )
                    {
                    // InternalXMachine.g:1621:2: ( '<<->' )
                    // InternalXMachine.g:1622:3: '<<->'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLessThanSignLessThanSignHyphenMinusGreaterThanSignKeyword_3()); 
                    }
                    match(input,21,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLessThanSignLessThanSignHyphenMinusGreaterThanSignKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalXMachine.g:1627:2: ( '\\uE101' )
                    {
                    // InternalXMachine.g:1627:2: ( '\\uE101' )
                    // InternalXMachine.g:1628:3: '\\uE101'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE101Keyword_4()); 
                    }
                    match(input,22,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE101Keyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalXMachine.g:1633:2: ( '<->>' )
                    {
                    // InternalXMachine.g:1633:2: ( '<->>' )
                    // InternalXMachine.g:1634:3: '<->>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLessThanSignHyphenMinusGreaterThanSignGreaterThanSignKeyword_5()); 
                    }
                    match(input,23,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLessThanSignHyphenMinusGreaterThanSignGreaterThanSignKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalXMachine.g:1639:2: ( '\\uE102' )
                    {
                    // InternalXMachine.g:1639:2: ( '\\uE102' )
                    // InternalXMachine.g:1640:3: '\\uE102'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE102Keyword_6()); 
                    }
                    match(input,24,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE102Keyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalXMachine.g:1645:2: ( '<<->>' )
                    {
                    // InternalXMachine.g:1645:2: ( '<<->>' )
                    // InternalXMachine.g:1646:3: '<<->>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLessThanSignLessThanSignHyphenMinusGreaterThanSignGreaterThanSignKeyword_7()); 
                    }
                    match(input,25,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLessThanSignLessThanSignHyphenMinusGreaterThanSignGreaterThanSignKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalXMachine.g:1651:2: ( '\\u21F8' )
                    {
                    // InternalXMachine.g:1651:2: ( '\\u21F8' )
                    // InternalXMachine.g:1652:3: '\\u21F8'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithVerticalStrokeKeyword_8()); 
                    }
                    match(input,26,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithVerticalStrokeKeyword_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalXMachine.g:1657:2: ( '+->' )
                    {
                    // InternalXMachine.g:1657:2: ( '+->' )
                    // InternalXMachine.g:1658:3: '+->'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPlusSignHyphenMinusGreaterThanSignKeyword_9()); 
                    }
                    match(input,27,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPlusSignHyphenMinusGreaterThanSignKeyword_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalXMachine.g:1663:2: ( '\\u2192' )
                    {
                    // InternalXMachine.g:1663:2: ( '\\u2192' )
                    // InternalXMachine.g:1664:3: '\\u2192'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowKeyword_10()); 
                    }
                    match(input,28,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowKeyword_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalXMachine.g:1669:2: ( '-->' )
                    {
                    // InternalXMachine.g:1669:2: ( '-->' )
                    // InternalXMachine.g:1670:3: '-->'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_11()); 
                    }
                    match(input,29,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalXMachine.g:1675:2: ( '\\u2914' )
                    {
                    // InternalXMachine.g:1675:2: ( '\\u2914' )
                    // InternalXMachine.g:1676:3: '\\u2914'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailWithVerticalStrokeKeyword_12()); 
                    }
                    match(input,30,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailWithVerticalStrokeKeyword_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalXMachine.g:1681:2: ( '>+>' )
                    {
                    // InternalXMachine.g:1681:2: ( '>+>' )
                    // InternalXMachine.g:1682:3: '>+>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreaterThanSignPlusSignGreaterThanSignKeyword_13()); 
                    }
                    match(input,31,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreaterThanSignPlusSignGreaterThanSignKeyword_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalXMachine.g:1687:2: ( '\\u21A3' )
                    {
                    // InternalXMachine.g:1687:2: ( '\\u21A3' )
                    // InternalXMachine.g:1688:3: '\\u21A3'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailKeyword_14()); 
                    }
                    match(input,32,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailKeyword_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalXMachine.g:1693:2: ( '>->' )
                    {
                    // InternalXMachine.g:1693:2: ( '>->' )
                    // InternalXMachine.g:1694:3: '>->'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreaterThanSignHyphenMinusGreaterThanSignKeyword_15()); 
                    }
                    match(input,33,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreaterThanSignHyphenMinusGreaterThanSignKeyword_15()); 
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalXMachine.g:1699:2: ( '\\u2900' )
                    {
                    // InternalXMachine.g:1699:2: ( '\\u2900' )
                    // InternalXMachine.g:1700:3: '\\u2900'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithVerticalStrokeKeyword_16()); 
                    }
                    match(input,34,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithVerticalStrokeKeyword_16()); 
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalXMachine.g:1705:2: ( '+>>' )
                    {
                    // InternalXMachine.g:1705:2: ( '+>>' )
                    // InternalXMachine.g:1706:3: '+>>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPlusSignGreaterThanSignGreaterThanSignKeyword_17()); 
                    }
                    match(input,35,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPlusSignGreaterThanSignGreaterThanSignKeyword_17()); 
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalXMachine.g:1711:2: ( '\\u21A0' )
                    {
                    // InternalXMachine.g:1711:2: ( '\\u21A0' )
                    // InternalXMachine.g:1712:3: '\\u21A0'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowKeyword_18()); 
                    }
                    match(input,36,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowKeyword_18()); 
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalXMachine.g:1717:2: ( '->>' )
                    {
                    // InternalXMachine.g:1717:2: ( '->>' )
                    // InternalXMachine.g:1718:3: '->>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_19()); 
                    }
                    match(input,37,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getHyphenMinusGreaterThanSignGreaterThanSignKeyword_19()); 
                    }

                    }


                    }
                    break;
                case 21 :
                    // InternalXMachine.g:1723:2: ( '\\u2916' )
                    {
                    // InternalXMachine.g:1723:2: ( '\\u2916' )
                    // InternalXMachine.g:1724:3: '\\u2916'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithTailKeyword_20()); 
                    }
                    match(input,38,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithTailKeyword_20()); 
                    }

                    }


                    }
                    break;
                case 22 :
                    // InternalXMachine.g:1729:2: ( '>->>' )
                    {
                    // InternalXMachine.g:1729:2: ( '>->>' )
                    // InternalXMachine.g:1730:3: '>->>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreaterThanSignHyphenMinusGreaterThanSignGreaterThanSignKeyword_21()); 
                    }
                    match(input,39,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreaterThanSignHyphenMinusGreaterThanSignGreaterThanSignKeyword_21()); 
                    }

                    }


                    }
                    break;
                case 23 :
                    // InternalXMachine.g:1735:2: ( '{' )
                    {
                    // InternalXMachine.g:1735:2: ( '{' )
                    // InternalXMachine.g:1736:3: '{'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftCurlyBracketKeyword_22()); 
                    }
                    match(input,119,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftCurlyBracketKeyword_22()); 
                    }

                    }


                    }
                    break;
                case 24 :
                    // InternalXMachine.g:1741:2: ( '}' )
                    {
                    // InternalXMachine.g:1741:2: ( '}' )
                    // InternalXMachine.g:1742:3: '}'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightCurlyBracketKeyword_23()); 
                    }
                    match(input,120,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightCurlyBracketKeyword_23()); 
                    }

                    }


                    }
                    break;
                case 25 :
                    // InternalXMachine.g:1747:2: ( '\\u21A6' )
                    {
                    // InternalXMachine.g:1747:2: ( '\\u21A6' )
                    // InternalXMachine.g:1748:3: '\\u21A6'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowFromBarKeyword_24()); 
                    }
                    match(input,121,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowFromBarKeyword_24()); 
                    }

                    }


                    }
                    break;
                case 26 :
                    // InternalXMachine.g:1753:2: ( ',,' )
                    {
                    // InternalXMachine.g:1753:2: ( ',,' )
                    // InternalXMachine.g:1754:3: ',,'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCommaCommaKeyword_25()); 
                    }
                    match(input,122,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCommaCommaKeyword_25()); 
                    }

                    }


                    }
                    break;
                case 27 :
                    // InternalXMachine.g:1759:2: ( '|->' )
                    {
                    // InternalXMachine.g:1759:2: ( '|->' )
                    // InternalXMachine.g:1760:3: '|->'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getVerticalLineHyphenMinusGreaterThanSignKeyword_26()); 
                    }
                    match(input,123,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getVerticalLineHyphenMinusGreaterThanSignKeyword_26()); 
                    }

                    }


                    }
                    break;
                case 28 :
                    // InternalXMachine.g:1765:2: ( '\\u2205' )
                    {
                    // InternalXMachine.g:1765:2: ( '\\u2205' )
                    // InternalXMachine.g:1766:3: '\\u2205'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getEmptySetKeyword_27()); 
                    }
                    match(input,124,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getEmptySetKeyword_27()); 
                    }

                    }


                    }
                    break;
                case 29 :
                    // InternalXMachine.g:1771:2: ( '{}' )
                    {
                    // InternalXMachine.g:1771:2: ( '{}' )
                    // InternalXMachine.g:1772:3: '{}'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftCurlyBracketRightCurlyBracketKeyword_28()); 
                    }
                    match(input,125,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftCurlyBracketRightCurlyBracketKeyword_28()); 
                    }

                    }


                    }
                    break;
                case 30 :
                    // InternalXMachine.g:1777:2: ( '\\u2229' )
                    {
                    // InternalXMachine.g:1777:2: ( '\\u2229' )
                    // InternalXMachine.g:1778:3: '\\u2229'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getIntersectionKeyword_29()); 
                    }
                    match(input,126,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getIntersectionKeyword_29()); 
                    }

                    }


                    }
                    break;
                case 31 :
                    // InternalXMachine.g:1783:2: ( '/\\\\' )
                    {
                    // InternalXMachine.g:1783:2: ( '/\\\\' )
                    // InternalXMachine.g:1784:3: '/\\\\'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSolidusReverseSolidusKeyword_30()); 
                    }
                    match(input,127,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSolidusReverseSolidusKeyword_30()); 
                    }

                    }


                    }
                    break;
                case 32 :
                    // InternalXMachine.g:1789:2: ( '\\u222A' )
                    {
                    // InternalXMachine.g:1789:2: ( '\\u222A' )
                    // InternalXMachine.g:1790:3: '\\u222A'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getUnionKeyword_31()); 
                    }
                    match(input,128,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getUnionKeyword_31()); 
                    }

                    }


                    }
                    break;
                case 33 :
                    // InternalXMachine.g:1795:2: ( '\\\\/' )
                    {
                    // InternalXMachine.g:1795:2: ( '\\\\/' )
                    // InternalXMachine.g:1796:3: '\\\\/'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getReverseSolidusSolidusKeyword_32()); 
                    }
                    match(input,129,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getReverseSolidusSolidusKeyword_32()); 
                    }

                    }


                    }
                    break;
                case 34 :
                    // InternalXMachine.g:1801:2: ( '\\u2216' )
                    {
                    // InternalXMachine.g:1801:2: ( '\\u2216' )
                    // InternalXMachine.g:1802:3: '\\u2216'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSetMinusKeyword_33()); 
                    }
                    match(input,130,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSetMinusKeyword_33()); 
                    }

                    }


                    }
                    break;
                case 35 :
                    // InternalXMachine.g:1807:2: ( '\\\\' )
                    {
                    // InternalXMachine.g:1807:2: ( '\\\\' )
                    // InternalXMachine.g:1808:3: '\\\\'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getBackslashKeyword_34()); 
                    }
                    match(input,131,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getBackslashKeyword_34()); 
                    }

                    }


                    }
                    break;
                case 36 :
                    // InternalXMachine.g:1813:2: ( '\\u00D7' )
                    {
                    // InternalXMachine.g:1813:2: ( '\\u00D7' )
                    // InternalXMachine.g:1814:3: '\\u00D7'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMultiplicationSignKeyword_35()); 
                    }
                    match(input,40,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMultiplicationSignKeyword_35()); 
                    }

                    }


                    }
                    break;
                case 37 :
                    // InternalXMachine.g:1819:2: ( '**' )
                    {
                    // InternalXMachine.g:1819:2: ( '**' )
                    // InternalXMachine.g:1820:3: '**'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskAsteriskKeyword_36()); 
                    }
                    match(input,41,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskAsteriskKeyword_36()); 
                    }

                    }


                    }
                    break;
                case 38 :
                    // InternalXMachine.g:1825:2: ( '[' )
                    {
                    // InternalXMachine.g:1825:2: ( '[' )
                    // InternalXMachine.g:1826:3: '['
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftSquareBracketKeyword_37()); 
                    }
                    match(input,132,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftSquareBracketKeyword_37()); 
                    }

                    }


                    }
                    break;
                case 39 :
                    // InternalXMachine.g:1831:2: ( ']' )
                    {
                    // InternalXMachine.g:1831:2: ( ']' )
                    // InternalXMachine.g:1832:3: ']'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightSquareBracketKeyword_38()); 
                    }
                    match(input,133,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightSquareBracketKeyword_38()); 
                    }

                    }


                    }
                    break;
                case 40 :
                    // InternalXMachine.g:1837:2: ( '\\uE103' )
                    {
                    // InternalXMachine.g:1837:2: ( '\\uE103' )
                    // InternalXMachine.g:1838:3: '\\uE103'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE103Keyword_39()); 
                    }
                    match(input,134,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE103Keyword_39()); 
                    }

                    }


                    }
                    break;
                case 41 :
                    // InternalXMachine.g:1843:2: ( '<+' )
                    {
                    // InternalXMachine.g:1843:2: ( '<+' )
                    // InternalXMachine.g:1844:3: '<+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLessThanSignPlusSignKeyword_40()); 
                    }
                    match(input,135,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLessThanSignPlusSignKeyword_40()); 
                    }

                    }


                    }
                    break;
                case 42 :
                    // InternalXMachine.g:1849:2: ( '\\u2218' )
                    {
                    // InternalXMachine.g:1849:2: ( '\\u2218' )
                    // InternalXMachine.g:1850:3: '\\u2218'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRingOperatorKeyword_41()); 
                    }
                    match(input,136,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRingOperatorKeyword_41()); 
                    }

                    }


                    }
                    break;
                case 43 :
                    // InternalXMachine.g:1855:2: ( 'circ' )
                    {
                    // InternalXMachine.g:1855:2: ( 'circ' )
                    // InternalXMachine.g:1856:3: 'circ'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircKeyword_42()); 
                    }
                    match(input,137,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircKeyword_42()); 
                    }

                    }


                    }
                    break;
                case 44 :
                    // InternalXMachine.g:1861:2: ( ';' )
                    {
                    // InternalXMachine.g:1861:2: ( ';' )
                    // InternalXMachine.g:1862:3: ';'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSemicolonKeyword_43()); 
                    }
                    match(input,138,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSemicolonKeyword_43()); 
                    }

                    }


                    }
                    break;
                case 45 :
                    // InternalXMachine.g:1867:2: ( '\\u2297' )
                    {
                    // InternalXMachine.g:1867:2: ( '\\u2297' )
                    // InternalXMachine.g:1868:3: '\\u2297'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircledTimesKeyword_44()); 
                    }
                    match(input,139,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircledTimesKeyword_44()); 
                    }

                    }


                    }
                    break;
                case 46 :
                    // InternalXMachine.g:1873:2: ( '><' )
                    {
                    // InternalXMachine.g:1873:2: ( '><' )
                    // InternalXMachine.g:1874:3: '><'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreaterThanSignLessThanSignKeyword_45()); 
                    }
                    match(input,140,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreaterThanSignLessThanSignKeyword_45()); 
                    }

                    }


                    }
                    break;
                case 47 :
                    // InternalXMachine.g:1879:2: ( '\\u2225' )
                    {
                    // InternalXMachine.g:1879:2: ( '\\u2225' )
                    // InternalXMachine.g:1880:3: '\\u2225'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getParallelToKeyword_46()); 
                    }
                    match(input,141,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getParallelToKeyword_46()); 
                    }

                    }


                    }
                    break;
                case 48 :
                    // InternalXMachine.g:1885:2: ( '||' )
                    {
                    // InternalXMachine.g:1885:2: ( '||' )
                    // InternalXMachine.g:1886:3: '||'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getVerticalLineVerticalLineKeyword_47()); 
                    }
                    match(input,142,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getVerticalLineVerticalLineKeyword_47()); 
                    }

                    }


                    }
                    break;
                case 49 :
                    // InternalXMachine.g:1891:2: ( '\\u223C' )
                    {
                    // InternalXMachine.g:1891:2: ( '\\u223C' )
                    // InternalXMachine.g:1892:3: '\\u223C'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTildeOperatorKeyword_48()); 
                    }
                    match(input,143,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTildeOperatorKeyword_48()); 
                    }

                    }


                    }
                    break;
                case 50 :
                    // InternalXMachine.g:1897:2: ( '~' )
                    {
                    // InternalXMachine.g:1897:2: ( '~' )
                    // InternalXMachine.g:1898:3: '~'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTildeKeyword_49()); 
                    }
                    match(input,144,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTildeKeyword_49()); 
                    }

                    }


                    }
                    break;
                case 51 :
                    // InternalXMachine.g:1903:2: ( '\\u25C1' )
                    {
                    // InternalXMachine.g:1903:2: ( '\\u25C1' )
                    // InternalXMachine.g:1904:3: '\\u25C1'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteLeftPointingTriangleKeyword_50()); 
                    }
                    match(input,145,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteLeftPointingTriangleKeyword_50()); 
                    }

                    }


                    }
                    break;
                case 52 :
                    // InternalXMachine.g:1909:2: ( '<|' )
                    {
                    // InternalXMachine.g:1909:2: ( '<|' )
                    // InternalXMachine.g:1910:3: '<|'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLessThanSignVerticalLineKeyword_51()); 
                    }
                    match(input,146,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLessThanSignVerticalLineKeyword_51()); 
                    }

                    }


                    }
                    break;
                case 53 :
                    // InternalXMachine.g:1915:2: ( '\\u2A64' )
                    {
                    // InternalXMachine.g:1915:2: ( '\\u2A64' )
                    // InternalXMachine.g:1916:3: '\\u2A64'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationDomainAntirestrictionKeyword_52()); 
                    }
                    match(input,147,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationDomainAntirestrictionKeyword_52()); 
                    }

                    }


                    }
                    break;
                case 54 :
                    // InternalXMachine.g:1921:2: ( '<<|' )
                    {
                    // InternalXMachine.g:1921:2: ( '<<|' )
                    // InternalXMachine.g:1922:3: '<<|'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLessThanSignLessThanSignVerticalLineKeyword_53()); 
                    }
                    match(input,148,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLessThanSignLessThanSignVerticalLineKeyword_53()); 
                    }

                    }


                    }
                    break;
                case 55 :
                    // InternalXMachine.g:1927:2: ( '\\u25B7' )
                    {
                    // InternalXMachine.g:1927:2: ( '\\u25B7' )
                    // InternalXMachine.g:1928:3: '\\u25B7'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteRightPointingTriangleKeyword_54()); 
                    }
                    match(input,149,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteRightPointingTriangleKeyword_54()); 
                    }

                    }


                    }
                    break;
                case 56 :
                    // InternalXMachine.g:1933:2: ( '|>' )
                    {
                    // InternalXMachine.g:1933:2: ( '|>' )
                    // InternalXMachine.g:1934:3: '|>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getVerticalLineGreaterThanSignKeyword_55()); 
                    }
                    match(input,150,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getVerticalLineGreaterThanSignKeyword_55()); 
                    }

                    }


                    }
                    break;
                case 57 :
                    // InternalXMachine.g:1939:2: ( '\\u2A65' )
                    {
                    // InternalXMachine.g:1939:2: ( '\\u2A65' )
                    // InternalXMachine.g:1940:3: '\\u2A65'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationRangeAntirestrictionKeyword_56()); 
                    }
                    match(input,151,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationRangeAntirestrictionKeyword_56()); 
                    }

                    }


                    }
                    break;
                case 58 :
                    // InternalXMachine.g:1945:2: ( '|>>' )
                    {
                    // InternalXMachine.g:1945:2: ( '|>>' )
                    // InternalXMachine.g:1946:3: '|>>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getVerticalLineGreaterThanSignGreaterThanSignKeyword_57()); 
                    }
                    match(input,152,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getVerticalLineGreaterThanSignGreaterThanSignKeyword_57()); 
                    }

                    }


                    }
                    break;
                case 59 :
                    // InternalXMachine.g:1951:2: ( '\\u03BB' )
                    {
                    // InternalXMachine.g:1951:2: ( '\\u03BB' )
                    // InternalXMachine.g:1952:3: '\\u03BB'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreekSmallLetterLamdaKeyword_58()); 
                    }
                    match(input,153,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreekSmallLetterLamdaKeyword_58()); 
                    }

                    }


                    }
                    break;
                case 60 :
                    // InternalXMachine.g:1957:2: ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0 ) )
                    {
                    // InternalXMachine.g:1957:2: ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0 ) )
                    // InternalXMachine.g:1958:3: ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGroup_59()); 
                    }
                    // InternalXMachine.g:1959:3: ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0 )
                    // InternalXMachine.g:1959:4: rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGroup_59()); 
                    }

                    }


                    }
                    break;
                case 61 :
                    // InternalXMachine.g:1963:2: ( 'INTER' )
                    {
                    // InternalXMachine.g:1963:2: ( 'INTER' )
                    // InternalXMachine.g:1964:3: 'INTER'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getINTERKeyword_60()); 
                    }
                    match(input,154,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getINTERKeyword_60()); 
                    }

                    }


                    }
                    break;
                case 62 :
                    // InternalXMachine.g:1969:2: ( '\\u22C3' )
                    {
                    // InternalXMachine.g:1969:2: ( '\\u22C3' )
                    // InternalXMachine.g:1970:3: '\\u22C3'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryUnionKeyword_61()); 
                    }
                    match(input,155,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryUnionKeyword_61()); 
                    }

                    }


                    }
                    break;
                case 63 :
                    // InternalXMachine.g:1975:2: ( 'UNION' )
                    {
                    // InternalXMachine.g:1975:2: ( 'UNION' )
                    // InternalXMachine.g:1976:3: 'UNION'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getUNIONKeyword_62()); 
                    }
                    match(input,156,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getUNIONKeyword_62()); 
                    }

                    }


                    }
                    break;
                case 64 :
                    // InternalXMachine.g:1981:2: ( '\\u2223' )
                    {
                    // InternalXMachine.g:1981:2: ( '\\u2223' )
                    // InternalXMachine.g:1982:3: '\\u2223'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDividesKeyword_63()); 
                    }
                    match(input,157,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDividesKeyword_63()); 
                    }

                    }


                    }
                    break;
                case 65 :
                    // InternalXMachine.g:1987:2: ( '|' )
                    {
                    // InternalXMachine.g:1987:2: ( '|' )
                    // InternalXMachine.g:1988:3: '|'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getVerticalLineKeyword_64()); 
                    }
                    match(input,158,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getVerticalLineKeyword_64()); 
                    }

                    }


                    }
                    break;
                case 66 :
                    // InternalXMachine.g:1993:2: ( '\\u2025' )
                    {
                    // InternalXMachine.g:1993:2: ( '\\u2025' )
                    // InternalXMachine.g:1994:3: '\\u2025'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTwoDotLeaderKeyword_65()); 
                    }
                    match(input,159,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTwoDotLeaderKeyword_65()); 
                    }

                    }


                    }
                    break;
                case 67 :
                    // InternalXMachine.g:1999:2: ( '..' )
                    {
                    // InternalXMachine.g:1999:2: ( '..' )
                    // InternalXMachine.g:2000:3: '..'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getFullStopFullStopKeyword_66()); 
                    }
                    match(input,160,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getFullStopFullStopKeyword_66()); 
                    }

                    }


                    }
                    break;
                case 68 :
                    // InternalXMachine.g:2005:2: ( '+' )
                    {
                    // InternalXMachine.g:2005:2: ( '+' )
                    // InternalXMachine.g:2006:3: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPlusSignKeyword_67()); 
                    }
                    match(input,161,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPlusSignKeyword_67()); 
                    }

                    }


                    }
                    break;
                case 69 :
                    // InternalXMachine.g:2011:2: ( '\\u2212' )
                    {
                    // InternalXMachine.g:2011:2: ( '\\u2212' )
                    // InternalXMachine.g:2012:3: '\\u2212'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMinusSignKeyword_68()); 
                    }
                    match(input,162,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMinusSignKeyword_68()); 
                    }

                    }


                    }
                    break;
                case 70 :
                    // InternalXMachine.g:2017:2: ( '-' )
                    {
                    // InternalXMachine.g:2017:2: ( '-' )
                    // InternalXMachine.g:2018:3: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getHyphenMinusKeyword_69()); 
                    }
                    match(input,163,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getHyphenMinusKeyword_69()); 
                    }

                    }


                    }
                    break;
                case 71 :
                    // InternalXMachine.g:2023:2: ( '\\u2217' )
                    {
                    // InternalXMachine.g:2023:2: ( '\\u2217' )
                    // InternalXMachine.g:2024:3: '\\u2217'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskOperatorKeyword_70()); 
                    }
                    match(input,164,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskOperatorKeyword_70()); 
                    }

                    }


                    }
                    break;
                case 72 :
                    // InternalXMachine.g:2029:2: ( '*' )
                    {
                    // InternalXMachine.g:2029:2: ( '*' )
                    // InternalXMachine.g:2030:3: '*'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskKeyword_71()); 
                    }
                    match(input,165,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskKeyword_71()); 
                    }

                    }


                    }
                    break;
                case 73 :
                    // InternalXMachine.g:2035:2: ( '\\u00F7' )
                    {
                    // InternalXMachine.g:2035:2: ( '\\u00F7' )
                    // InternalXMachine.g:2036:3: '\\u00F7'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDivisionSignKeyword_72()); 
                    }
                    match(input,166,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDivisionSignKeyword_72()); 
                    }

                    }


                    }
                    break;
                case 74 :
                    // InternalXMachine.g:2041:2: ( '/' )
                    {
                    // InternalXMachine.g:2041:2: ( '/' )
                    // InternalXMachine.g:2042:3: '/'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSolidusKeyword_73()); 
                    }
                    match(input,167,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSolidusKeyword_73()); 
                    }

                    }


                    }
                    break;
                case 75 :
                    // InternalXMachine.g:2047:2: ( '^' )
                    {
                    // InternalXMachine.g:2047:2: ( '^' )
                    // InternalXMachine.g:2048:3: '^'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircumflexAccentKeyword_74()); 
                    }
                    match(input,168,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircumflexAccentKeyword_74()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives"


    // $ANTLR start "rule__XRecord__Alternatives_2"
    // InternalXMachine.g:2057:1: rule__XRecord__Alternatives_2 : ( ( ( rule__XRecord__ExtendedAssignment_2_0 ) ) | ( ( rule__XRecord__RefinedAssignment_2_1 ) ) );
    public final void rule__XRecord__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2061:1: ( ( ( rule__XRecord__ExtendedAssignment_2_0 ) ) | ( ( rule__XRecord__RefinedAssignment_2_1 ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=169 && LA15_0<=170)) ) {
                alt15=1;
            }
            else if ( ((LA15_0>=171 && LA15_0<=172)) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalXMachine.g:2062:2: ( ( rule__XRecord__ExtendedAssignment_2_0 ) )
                    {
                    // InternalXMachine.g:2062:2: ( ( rule__XRecord__ExtendedAssignment_2_0 ) )
                    // InternalXMachine.g:2063:3: ( rule__XRecord__ExtendedAssignment_2_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXRecordAccess().getExtendedAssignment_2_0()); 
                    }
                    // InternalXMachine.g:2064:3: ( rule__XRecord__ExtendedAssignment_2_0 )
                    // InternalXMachine.g:2064:4: rule__XRecord__ExtendedAssignment_2_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XRecord__ExtendedAssignment_2_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXRecordAccess().getExtendedAssignment_2_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:2068:2: ( ( rule__XRecord__RefinedAssignment_2_1 ) )
                    {
                    // InternalXMachine.g:2068:2: ( ( rule__XRecord__RefinedAssignment_2_1 ) )
                    // InternalXMachine.g:2069:3: ( rule__XRecord__RefinedAssignment_2_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXRecordAccess().getRefinedAssignment_2_1()); 
                    }
                    // InternalXMachine.g:2070:3: ( rule__XRecord__RefinedAssignment_2_1 )
                    // InternalXMachine.g:2070:4: rule__XRecord__RefinedAssignment_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XRecord__RefinedAssignment_2_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXRecordAccess().getRefinedAssignment_2_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Alternatives_2"


    // $ANTLR start "rule__XRecord__ExtendedAlternatives_2_0_0"
    // InternalXMachine.g:2078:1: rule__XRecord__ExtendedAlternatives_2_0_0 : ( ( 'extended' ) | ( 'ext' ) );
    public final void rule__XRecord__ExtendedAlternatives_2_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2082:1: ( ( 'extended' ) | ( 'ext' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==169) ) {
                alt16=1;
            }
            else if ( (LA16_0==170) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalXMachine.g:2083:2: ( 'extended' )
                    {
                    // InternalXMachine.g:2083:2: ( 'extended' )
                    // InternalXMachine.g:2084:3: 'extended'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXRecordAccess().getExtendedExtendedKeyword_2_0_0_0()); 
                    }
                    match(input,169,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXRecordAccess().getExtendedExtendedKeyword_2_0_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:2089:2: ( 'ext' )
                    {
                    // InternalXMachine.g:2089:2: ( 'ext' )
                    // InternalXMachine.g:2090:3: 'ext'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXRecordAccess().getExtendedExtKeyword_2_0_0_1()); 
                    }
                    match(input,170,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXRecordAccess().getExtendedExtKeyword_2_0_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__ExtendedAlternatives_2_0_0"


    // $ANTLR start "rule__XRecord__RefinedAlternatives_2_1_0"
    // InternalXMachine.g:2099:1: rule__XRecord__RefinedAlternatives_2_1_0 : ( ( 'refined' ) | ( 'ref' ) );
    public final void rule__XRecord__RefinedAlternatives_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2103:1: ( ( 'refined' ) | ( 'ref' ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==171) ) {
                alt17=1;
            }
            else if ( (LA17_0==172) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalXMachine.g:2104:2: ( 'refined' )
                    {
                    // InternalXMachine.g:2104:2: ( 'refined' )
                    // InternalXMachine.g:2105:3: 'refined'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXRecordAccess().getRefinedRefinedKeyword_2_1_0_0()); 
                    }
                    match(input,171,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXRecordAccess().getRefinedRefinedKeyword_2_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:2110:2: ( 'ref' )
                    {
                    // InternalXMachine.g:2110:2: ( 'ref' )
                    // InternalXMachine.g:2111:3: 'ref'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXRecordAccess().getRefinedRefKeyword_2_1_0_1()); 
                    }
                    match(input,172,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXRecordAccess().getRefinedRefKeyword_2_1_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__RefinedAlternatives_2_1_0"


    // $ANTLR start "rule__XRecord__Alternatives_3"
    // InternalXMachine.g:2120:1: rule__XRecord__Alternatives_3 : ( ( 'record' ) | ( 'rec' ) );
    public final void rule__XRecord__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2124:1: ( ( 'record' ) | ( 'rec' ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==173) ) {
                alt18=1;
            }
            else if ( (LA18_0==174) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalXMachine.g:2125:2: ( 'record' )
                    {
                    // InternalXMachine.g:2125:2: ( 'record' )
                    // InternalXMachine.g:2126:3: 'record'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXRecordAccess().getRecordKeyword_3_0()); 
                    }
                    match(input,173,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXRecordAccess().getRecordKeyword_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:2131:2: ( 'rec' )
                    {
                    // InternalXMachine.g:2131:2: ( 'rec' )
                    // InternalXMachine.g:2132:3: 'rec'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXRecordAccess().getRecKeyword_3_1()); 
                    }
                    match(input,174,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXRecordAccess().getRecKeyword_3_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Alternatives_3"


    // $ANTLR start "rule__XRecord__Alternatives_5_0"
    // InternalXMachine.g:2141:1: rule__XRecord__Alternatives_5_0 : ( ( 'inherits' ) | ( 'ihr' ) );
    public final void rule__XRecord__Alternatives_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2145:1: ( ( 'inherits' ) | ( 'ihr' ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==175) ) {
                alt19=1;
            }
            else if ( (LA19_0==176) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalXMachine.g:2146:2: ( 'inherits' )
                    {
                    // InternalXMachine.g:2146:2: ( 'inherits' )
                    // InternalXMachine.g:2147:3: 'inherits'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXRecordAccess().getInheritsKeyword_5_0_0()); 
                    }
                    match(input,175,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXRecordAccess().getInheritsKeyword_5_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:2152:2: ( 'ihr' )
                    {
                    // InternalXMachine.g:2152:2: ( 'ihr' )
                    // InternalXMachine.g:2153:3: 'ihr'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXRecordAccess().getIhrKeyword_5_0_1()); 
                    }
                    match(input,176,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXRecordAccess().getIhrKeyword_5_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Alternatives_5_0"


    // $ANTLR start "rule__XRecord__Alternatives_6"
    // InternalXMachine.g:2162:1: rule__XRecord__Alternatives_6 : ( ( ( rule__XRecord__Group_6_0__0 ) ) | ( ( rule__XRecord__Group_6_1__0 ) ) );
    public final void rule__XRecord__Alternatives_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2166:1: ( ( ( rule__XRecord__Group_6_0__0 ) ) | ( ( rule__XRecord__Group_6_1__0 ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=177 && LA20_0<=178)) ) {
                alt20=1;
            }
            else if ( (LA20_0==208) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalXMachine.g:2167:2: ( ( rule__XRecord__Group_6_0__0 ) )
                    {
                    // InternalXMachine.g:2167:2: ( ( rule__XRecord__Group_6_0__0 ) )
                    // InternalXMachine.g:2168:3: ( rule__XRecord__Group_6_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXRecordAccess().getGroup_6_0()); 
                    }
                    // InternalXMachine.g:2169:3: ( rule__XRecord__Group_6_0__0 )
                    // InternalXMachine.g:2169:4: rule__XRecord__Group_6_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XRecord__Group_6_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXRecordAccess().getGroup_6_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:2173:2: ( ( rule__XRecord__Group_6_1__0 ) )
                    {
                    // InternalXMachine.g:2173:2: ( ( rule__XRecord__Group_6_1__0 ) )
                    // InternalXMachine.g:2174:3: ( rule__XRecord__Group_6_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXRecordAccess().getGroup_6_1()); 
                    }
                    // InternalXMachine.g:2175:3: ( rule__XRecord__Group_6_1__0 )
                    // InternalXMachine.g:2175:4: rule__XRecord__Group_6_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XRecord__Group_6_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXRecordAccess().getGroup_6_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Alternatives_6"


    // $ANTLR start "rule__XRecord__Alternatives_6_0_0"
    // InternalXMachine.g:2183:1: rule__XRecord__Alternatives_6_0_0 : ( ( 'field' ) | ( 'fld' ) );
    public final void rule__XRecord__Alternatives_6_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2187:1: ( ( 'field' ) | ( 'fld' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==177) ) {
                alt21=1;
            }
            else if ( (LA21_0==178) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalXMachine.g:2188:2: ( 'field' )
                    {
                    // InternalXMachine.g:2188:2: ( 'field' )
                    // InternalXMachine.g:2189:3: 'field'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXRecordAccess().getFieldKeyword_6_0_0_0()); 
                    }
                    match(input,177,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXRecordAccess().getFieldKeyword_6_0_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:2194:2: ( 'fld' )
                    {
                    // InternalXMachine.g:2194:2: ( 'fld' )
                    // InternalXMachine.g:2195:3: 'fld'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXRecordAccess().getFldKeyword_6_0_0_1()); 
                    }
                    match(input,178,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXRecordAccess().getFldKeyword_6_0_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Alternatives_6_0_0"


    // $ANTLR start "rule__XConvergence__Alternatives"
    // InternalXMachine.g:2204:1: rule__XConvergence__Alternatives : ( ( ( 'ordinary' ) ) | ( ( 'convergent' ) ) | ( ( 'anticipated' ) ) );
    public final void rule__XConvergence__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2208:1: ( ( ( 'ordinary' ) ) | ( ( 'convergent' ) ) | ( ( 'anticipated' ) ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 179:
                {
                alt22=1;
                }
                break;
            case 180:
                {
                alt22=2;
                }
                break;
            case 181:
                {
                alt22=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalXMachine.g:2209:2: ( ( 'ordinary' ) )
                    {
                    // InternalXMachine.g:2209:2: ( ( 'ordinary' ) )
                    // InternalXMachine.g:2210:3: ( 'ordinary' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXConvergenceAccess().getOrdinaryEnumLiteralDeclaration_0()); 
                    }
                    // InternalXMachine.g:2211:3: ( 'ordinary' )
                    // InternalXMachine.g:2211:4: 'ordinary'
                    {
                    match(input,179,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXConvergenceAccess().getOrdinaryEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:2215:2: ( ( 'convergent' ) )
                    {
                    // InternalXMachine.g:2215:2: ( ( 'convergent' ) )
                    // InternalXMachine.g:2216:3: ( 'convergent' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXConvergenceAccess().getConvergentEnumLiteralDeclaration_1()); 
                    }
                    // InternalXMachine.g:2217:3: ( 'convergent' )
                    // InternalXMachine.g:2217:4: 'convergent'
                    {
                    match(input,180,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXConvergenceAccess().getConvergentEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalXMachine.g:2221:2: ( ( 'anticipated' ) )
                    {
                    // InternalXMachine.g:2221:2: ( ( 'anticipated' ) )
                    // InternalXMachine.g:2222:3: ( 'anticipated' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXConvergenceAccess().getAnticipatedEnumLiteralDeclaration_2()); 
                    }
                    // InternalXMachine.g:2223:3: ( 'anticipated' )
                    // InternalXMachine.g:2223:4: 'anticipated'
                    {
                    match(input,181,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXConvergenceAccess().getAnticipatedEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConvergence__Alternatives"


    // $ANTLR start "rule__Multiplicity__Alternatives"
    // InternalXMachine.g:2231:1: rule__Multiplicity__Alternatives : ( ( ( 'one' ) ) | ( ( 'many' ) ) | ( ( 'opt' ) ) );
    public final void rule__Multiplicity__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2235:1: ( ( ( 'one' ) ) | ( ( 'many' ) ) | ( ( 'opt' ) ) )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 182:
                {
                alt23=1;
                }
                break;
            case 183:
                {
                alt23=2;
                }
                break;
            case 184:
                {
                alt23=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalXMachine.g:2236:2: ( ( 'one' ) )
                    {
                    // InternalXMachine.g:2236:2: ( ( 'one' ) )
                    // InternalXMachine.g:2237:3: ( 'one' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityAccess().getONEEnumLiteralDeclaration_0()); 
                    }
                    // InternalXMachine.g:2238:3: ( 'one' )
                    // InternalXMachine.g:2238:4: 'one'
                    {
                    match(input,182,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityAccess().getONEEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:2242:2: ( ( 'many' ) )
                    {
                    // InternalXMachine.g:2242:2: ( ( 'many' ) )
                    // InternalXMachine.g:2243:3: ( 'many' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityAccess().getMANYEnumLiteralDeclaration_1()); 
                    }
                    // InternalXMachine.g:2244:3: ( 'many' )
                    // InternalXMachine.g:2244:4: 'many'
                    {
                    match(input,183,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityAccess().getMANYEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalXMachine.g:2248:2: ( ( 'opt' ) )
                    {
                    // InternalXMachine.g:2248:2: ( ( 'opt' ) )
                    // InternalXMachine.g:2249:3: ( 'opt' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityAccess().getOPTIONALEnumLiteralDeclaration_2()); 
                    }
                    // InternalXMachine.g:2250:3: ( 'opt' )
                    // InternalXMachine.g:2250:4: 'opt'
                    {
                    match(input,184,FOLLOW_2); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityAccess().getOPTIONALEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplicity__Alternatives"


    // $ANTLR start "rule__Machine__Group__0"
    // InternalXMachine.g:2258:1: rule__Machine__Group__0 : rule__Machine__Group__0__Impl rule__Machine__Group__1 ;
    public final void rule__Machine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2262:1: ( rule__Machine__Group__0__Impl rule__Machine__Group__1 )
            // InternalXMachine.g:2263:2: rule__Machine__Group__0__Impl rule__Machine__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Machine__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Machine__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__0"


    // $ANTLR start "rule__Machine__Group__0__Impl"
    // InternalXMachine.g:2270:1: rule__Machine__Group__0__Impl : ( () ) ;
    public final void rule__Machine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2274:1: ( ( () ) )
            // InternalXMachine.g:2275:1: ( () )
            {
            // InternalXMachine.g:2275:1: ( () )
            // InternalXMachine.g:2276:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getMachineAction_0()); 
            }
            // InternalXMachine.g:2277:2: ()
            // InternalXMachine.g:2277:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getMachineAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__0__Impl"


    // $ANTLR start "rule__Machine__Group__1"
    // InternalXMachine.g:2285:1: rule__Machine__Group__1 : rule__Machine__Group__1__Impl rule__Machine__Group__2 ;
    public final void rule__Machine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2289:1: ( rule__Machine__Group__1__Impl rule__Machine__Group__2 )
            // InternalXMachine.g:2290:2: rule__Machine__Group__1__Impl rule__Machine__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Machine__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Machine__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__1"


    // $ANTLR start "rule__Machine__Group__1__Impl"
    // InternalXMachine.g:2297:1: rule__Machine__Group__1__Impl : ( ( rule__Machine__CommentAssignment_1 )? ) ;
    public final void rule__Machine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2301:1: ( ( ( rule__Machine__CommentAssignment_1 )? ) )
            // InternalXMachine.g:2302:1: ( ( rule__Machine__CommentAssignment_1 )? )
            {
            // InternalXMachine.g:2302:1: ( ( rule__Machine__CommentAssignment_1 )? )
            // InternalXMachine.g:2303:2: ( rule__Machine__CommentAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getCommentAssignment_1()); 
            }
            // InternalXMachine.g:2304:2: ( rule__Machine__CommentAssignment_1 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_STRING) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalXMachine.g:2304:3: rule__Machine__CommentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Machine__CommentAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getCommentAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__1__Impl"


    // $ANTLR start "rule__Machine__Group__2"
    // InternalXMachine.g:2312:1: rule__Machine__Group__2 : rule__Machine__Group__2__Impl rule__Machine__Group__3 ;
    public final void rule__Machine__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2316:1: ( rule__Machine__Group__2__Impl rule__Machine__Group__3 )
            // InternalXMachine.g:2317:2: rule__Machine__Group__2__Impl rule__Machine__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Machine__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Machine__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__2"


    // $ANTLR start "rule__Machine__Group__2__Impl"
    // InternalXMachine.g:2324:1: rule__Machine__Group__2__Impl : ( 'machine' ) ;
    public final void rule__Machine__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2328:1: ( ( 'machine' ) )
            // InternalXMachine.g:2329:1: ( 'machine' )
            {
            // InternalXMachine.g:2329:1: ( 'machine' )
            // InternalXMachine.g:2330:2: 'machine'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getMachineKeyword_2()); 
            }
            match(input,185,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getMachineKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__2__Impl"


    // $ANTLR start "rule__Machine__Group__3"
    // InternalXMachine.g:2339:1: rule__Machine__Group__3 : rule__Machine__Group__3__Impl rule__Machine__Group__4 ;
    public final void rule__Machine__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2343:1: ( rule__Machine__Group__3__Impl rule__Machine__Group__4 )
            // InternalXMachine.g:2344:2: rule__Machine__Group__3__Impl rule__Machine__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Machine__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Machine__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__3"


    // $ANTLR start "rule__Machine__Group__3__Impl"
    // InternalXMachine.g:2351:1: rule__Machine__Group__3__Impl : ( ( rule__Machine__NameAssignment_3 ) ) ;
    public final void rule__Machine__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2355:1: ( ( ( rule__Machine__NameAssignment_3 ) ) )
            // InternalXMachine.g:2356:1: ( ( rule__Machine__NameAssignment_3 ) )
            {
            // InternalXMachine.g:2356:1: ( ( rule__Machine__NameAssignment_3 ) )
            // InternalXMachine.g:2357:2: ( rule__Machine__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getNameAssignment_3()); 
            }
            // InternalXMachine.g:2358:2: ( rule__Machine__NameAssignment_3 )
            // InternalXMachine.g:2358:3: rule__Machine__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Machine__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__3__Impl"


    // $ANTLR start "rule__Machine__Group__4"
    // InternalXMachine.g:2366:1: rule__Machine__Group__4 : rule__Machine__Group__4__Impl rule__Machine__Group__5 ;
    public final void rule__Machine__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2370:1: ( rule__Machine__Group__4__Impl rule__Machine__Group__5 )
            // InternalXMachine.g:2371:2: rule__Machine__Group__4__Impl rule__Machine__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__Machine__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Machine__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__4"


    // $ANTLR start "rule__Machine__Group__4__Impl"
    // InternalXMachine.g:2378:1: rule__Machine__Group__4__Impl : ( ( rule__Machine__UnorderedGroup_4 ) ) ;
    public final void rule__Machine__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2382:1: ( ( ( rule__Machine__UnorderedGroup_4 ) ) )
            // InternalXMachine.g:2383:1: ( ( rule__Machine__UnorderedGroup_4 ) )
            {
            // InternalXMachine.g:2383:1: ( ( rule__Machine__UnorderedGroup_4 ) )
            // InternalXMachine.g:2384:2: ( rule__Machine__UnorderedGroup_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getUnorderedGroup_4()); 
            }
            // InternalXMachine.g:2385:2: ( rule__Machine__UnorderedGroup_4 )
            // InternalXMachine.g:2385:3: rule__Machine__UnorderedGroup_4
            {
            pushFollow(FOLLOW_2);
            rule__Machine__UnorderedGroup_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getUnorderedGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__4__Impl"


    // $ANTLR start "rule__Machine__Group__5"
    // InternalXMachine.g:2393:1: rule__Machine__Group__5 : rule__Machine__Group__5__Impl rule__Machine__Group__6 ;
    public final void rule__Machine__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2397:1: ( rule__Machine__Group__5__Impl rule__Machine__Group__6 )
            // InternalXMachine.g:2398:2: rule__Machine__Group__5__Impl rule__Machine__Group__6
            {
            pushFollow(FOLLOW_7);
            rule__Machine__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Machine__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__5"


    // $ANTLR start "rule__Machine__Group__5__Impl"
    // InternalXMachine.g:2405:1: rule__Machine__Group__5__Impl : ( ( rule__Machine__Group_5__0 )? ) ;
    public final void rule__Machine__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2409:1: ( ( ( rule__Machine__Group_5__0 )? ) )
            // InternalXMachine.g:2410:1: ( ( rule__Machine__Group_5__0 )? )
            {
            // InternalXMachine.g:2410:1: ( ( rule__Machine__Group_5__0 )? )
            // InternalXMachine.g:2411:2: ( rule__Machine__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getGroup_5()); 
            }
            // InternalXMachine.g:2412:2: ( rule__Machine__Group_5__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==189) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalXMachine.g:2412:3: rule__Machine__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Machine__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__5__Impl"


    // $ANTLR start "rule__Machine__Group__6"
    // InternalXMachine.g:2420:1: rule__Machine__Group__6 : rule__Machine__Group__6__Impl rule__Machine__Group__7 ;
    public final void rule__Machine__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2424:1: ( rule__Machine__Group__6__Impl rule__Machine__Group__7 )
            // InternalXMachine.g:2425:2: rule__Machine__Group__6__Impl rule__Machine__Group__7
            {
            pushFollow(FOLLOW_7);
            rule__Machine__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Machine__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__6"


    // $ANTLR start "rule__Machine__Group__6__Impl"
    // InternalXMachine.g:2432:1: rule__Machine__Group__6__Impl : ( ( rule__Machine__Alternatives_6 )* ) ;
    public final void rule__Machine__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2436:1: ( ( ( rule__Machine__Alternatives_6 )* ) )
            // InternalXMachine.g:2437:1: ( ( rule__Machine__Alternatives_6 )* )
            {
            // InternalXMachine.g:2437:1: ( ( rule__Machine__Alternatives_6 )* )
            // InternalXMachine.g:2438:2: ( rule__Machine__Alternatives_6 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getAlternatives_6()); 
            }
            // InternalXMachine.g:2439:2: ( rule__Machine__Alternatives_6 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_STRING||(LA26_0>=12 && LA26_0<=17)||(LA26_0>=169 && LA26_0<=174)||(LA26_0>=179 && LA26_0<=181)||LA26_0==195||(LA26_0>=201 && LA26_0<=202)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalXMachine.g:2439:3: rule__Machine__Alternatives_6
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Machine__Alternatives_6();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getAlternatives_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__6__Impl"


    // $ANTLR start "rule__Machine__Group__7"
    // InternalXMachine.g:2447:1: rule__Machine__Group__7 : rule__Machine__Group__7__Impl rule__Machine__Group__8 ;
    public final void rule__Machine__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2451:1: ( rule__Machine__Group__7__Impl rule__Machine__Group__8 )
            // InternalXMachine.g:2452:2: rule__Machine__Group__7__Impl rule__Machine__Group__8
            {
            pushFollow(FOLLOW_7);
            rule__Machine__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Machine__Group__8();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__7"


    // $ANTLR start "rule__Machine__Group__7__Impl"
    // InternalXMachine.g:2459:1: rule__Machine__Group__7__Impl : ( ( rule__Machine__Group_7__0 )? ) ;
    public final void rule__Machine__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2463:1: ( ( ( rule__Machine__Group_7__0 )? ) )
            // InternalXMachine.g:2464:1: ( ( rule__Machine__Group_7__0 )? )
            {
            // InternalXMachine.g:2464:1: ( ( rule__Machine__Group_7__0 )? )
            // InternalXMachine.g:2465:2: ( rule__Machine__Group_7__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getGroup_7()); 
            }
            // InternalXMachine.g:2466:2: ( rule__Machine__Group_7__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==190) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalXMachine.g:2466:3: rule__Machine__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Machine__Group_7__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getGroup_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__7__Impl"


    // $ANTLR start "rule__Machine__Group__8"
    // InternalXMachine.g:2474:1: rule__Machine__Group__8 : rule__Machine__Group__8__Impl ;
    public final void rule__Machine__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2478:1: ( rule__Machine__Group__8__Impl )
            // InternalXMachine.g:2479:2: rule__Machine__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Machine__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__8"


    // $ANTLR start "rule__Machine__Group__8__Impl"
    // InternalXMachine.g:2485:1: rule__Machine__Group__8__Impl : ( ( 'end' )? ) ;
    public final void rule__Machine__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2489:1: ( ( ( 'end' )? ) )
            // InternalXMachine.g:2490:1: ( ( 'end' )? )
            {
            // InternalXMachine.g:2490:1: ( ( 'end' )? )
            // InternalXMachine.g:2491:2: ( 'end' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getEndKeyword_8()); 
            }
            // InternalXMachine.g:2492:2: ( 'end' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==186) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalXMachine.g:2492:3: 'end'
                    {
                    match(input,186,FOLLOW_2); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getEndKeyword_8()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group__8__Impl"


    // $ANTLR start "rule__Machine__Group_4_1__0"
    // InternalXMachine.g:2501:1: rule__Machine__Group_4_1__0 : rule__Machine__Group_4_1__0__Impl rule__Machine__Group_4_1__1 ;
    public final void rule__Machine__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2505:1: ( rule__Machine__Group_4_1__0__Impl rule__Machine__Group_4_1__1 )
            // InternalXMachine.g:2506:2: rule__Machine__Group_4_1__0__Impl rule__Machine__Group_4_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Machine__Group_4_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Machine__Group_4_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_4_1__0"


    // $ANTLR start "rule__Machine__Group_4_1__0__Impl"
    // InternalXMachine.g:2513:1: rule__Machine__Group_4_1__0__Impl : ( 'refines' ) ;
    public final void rule__Machine__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2517:1: ( ( 'refines' ) )
            // InternalXMachine.g:2518:1: ( 'refines' )
            {
            // InternalXMachine.g:2518:1: ( 'refines' )
            // InternalXMachine.g:2519:2: 'refines'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getRefinesKeyword_4_1_0()); 
            }
            match(input,187,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getRefinesKeyword_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_4_1__0__Impl"


    // $ANTLR start "rule__Machine__Group_4_1__1"
    // InternalXMachine.g:2528:1: rule__Machine__Group_4_1__1 : rule__Machine__Group_4_1__1__Impl ;
    public final void rule__Machine__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2532:1: ( rule__Machine__Group_4_1__1__Impl )
            // InternalXMachine.g:2533:2: rule__Machine__Group_4_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Machine__Group_4_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_4_1__1"


    // $ANTLR start "rule__Machine__Group_4_1__1__Impl"
    // InternalXMachine.g:2539:1: rule__Machine__Group_4_1__1__Impl : ( ( rule__Machine__RefinesAssignment_4_1_1 ) ) ;
    public final void rule__Machine__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2543:1: ( ( ( rule__Machine__RefinesAssignment_4_1_1 ) ) )
            // InternalXMachine.g:2544:1: ( ( rule__Machine__RefinesAssignment_4_1_1 ) )
            {
            // InternalXMachine.g:2544:1: ( ( rule__Machine__RefinesAssignment_4_1_1 ) )
            // InternalXMachine.g:2545:2: ( rule__Machine__RefinesAssignment_4_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getRefinesAssignment_4_1_1()); 
            }
            // InternalXMachine.g:2546:2: ( rule__Machine__RefinesAssignment_4_1_1 )
            // InternalXMachine.g:2546:3: rule__Machine__RefinesAssignment_4_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Machine__RefinesAssignment_4_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getRefinesAssignment_4_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_4_1__1__Impl"


    // $ANTLR start "rule__Machine__Group_4_2__0"
    // InternalXMachine.g:2555:1: rule__Machine__Group_4_2__0 : rule__Machine__Group_4_2__0__Impl rule__Machine__Group_4_2__1 ;
    public final void rule__Machine__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2559:1: ( rule__Machine__Group_4_2__0__Impl rule__Machine__Group_4_2__1 )
            // InternalXMachine.g:2560:2: rule__Machine__Group_4_2__0__Impl rule__Machine__Group_4_2__1
            {
            pushFollow(FOLLOW_5);
            rule__Machine__Group_4_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Machine__Group_4_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_4_2__0"


    // $ANTLR start "rule__Machine__Group_4_2__0__Impl"
    // InternalXMachine.g:2567:1: rule__Machine__Group_4_2__0__Impl : ( 'sees' ) ;
    public final void rule__Machine__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2571:1: ( ( 'sees' ) )
            // InternalXMachine.g:2572:1: ( 'sees' )
            {
            // InternalXMachine.g:2572:1: ( 'sees' )
            // InternalXMachine.g:2573:2: 'sees'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getSeesKeyword_4_2_0()); 
            }
            match(input,188,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getSeesKeyword_4_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_4_2__0__Impl"


    // $ANTLR start "rule__Machine__Group_4_2__1"
    // InternalXMachine.g:2582:1: rule__Machine__Group_4_2__1 : rule__Machine__Group_4_2__1__Impl ;
    public final void rule__Machine__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2586:1: ( rule__Machine__Group_4_2__1__Impl )
            // InternalXMachine.g:2587:2: rule__Machine__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Machine__Group_4_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_4_2__1"


    // $ANTLR start "rule__Machine__Group_4_2__1__Impl"
    // InternalXMachine.g:2593:1: rule__Machine__Group_4_2__1__Impl : ( ( ( rule__Machine__SeesAssignment_4_2_1 ) ) ( ( rule__Machine__SeesAssignment_4_2_1 )* ) ) ;
    public final void rule__Machine__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2597:1: ( ( ( ( rule__Machine__SeesAssignment_4_2_1 ) ) ( ( rule__Machine__SeesAssignment_4_2_1 )* ) ) )
            // InternalXMachine.g:2598:1: ( ( ( rule__Machine__SeesAssignment_4_2_1 ) ) ( ( rule__Machine__SeesAssignment_4_2_1 )* ) )
            {
            // InternalXMachine.g:2598:1: ( ( ( rule__Machine__SeesAssignment_4_2_1 ) ) ( ( rule__Machine__SeesAssignment_4_2_1 )* ) )
            // InternalXMachine.g:2599:2: ( ( rule__Machine__SeesAssignment_4_2_1 ) ) ( ( rule__Machine__SeesAssignment_4_2_1 )* )
            {
            // InternalXMachine.g:2599:2: ( ( rule__Machine__SeesAssignment_4_2_1 ) )
            // InternalXMachine.g:2600:3: ( rule__Machine__SeesAssignment_4_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getSeesAssignment_4_2_1()); 
            }
            // InternalXMachine.g:2601:3: ( rule__Machine__SeesAssignment_4_2_1 )
            // InternalXMachine.g:2601:4: rule__Machine__SeesAssignment_4_2_1
            {
            pushFollow(FOLLOW_9);
            rule__Machine__SeesAssignment_4_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getSeesAssignment_4_2_1()); 
            }

            }

            // InternalXMachine.g:2604:2: ( ( rule__Machine__SeesAssignment_4_2_1 )* )
            // InternalXMachine.g:2605:3: ( rule__Machine__SeesAssignment_4_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getSeesAssignment_4_2_1()); 
            }
            // InternalXMachine.g:2606:3: ( rule__Machine__SeesAssignment_4_2_1 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalXMachine.g:2606:4: rule__Machine__SeesAssignment_4_2_1
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Machine__SeesAssignment_4_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getSeesAssignment_4_2_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_4_2__1__Impl"


    // $ANTLR start "rule__Machine__Group_5__0"
    // InternalXMachine.g:2616:1: rule__Machine__Group_5__0 : rule__Machine__Group_5__0__Impl rule__Machine__Group_5__1 ;
    public final void rule__Machine__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2620:1: ( rule__Machine__Group_5__0__Impl rule__Machine__Group_5__1 )
            // InternalXMachine.g:2621:2: rule__Machine__Group_5__0__Impl rule__Machine__Group_5__1
            {
            pushFollow(FOLLOW_5);
            rule__Machine__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Machine__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_5__0"


    // $ANTLR start "rule__Machine__Group_5__0__Impl"
    // InternalXMachine.g:2628:1: rule__Machine__Group_5__0__Impl : ( 'contains' ) ;
    public final void rule__Machine__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2632:1: ( ( 'contains' ) )
            // InternalXMachine.g:2633:1: ( 'contains' )
            {
            // InternalXMachine.g:2633:1: ( 'contains' )
            // InternalXMachine.g:2634:2: 'contains'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getContainsKeyword_5_0()); 
            }
            match(input,189,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getContainsKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_5__0__Impl"


    // $ANTLR start "rule__Machine__Group_5__1"
    // InternalXMachine.g:2643:1: rule__Machine__Group_5__1 : rule__Machine__Group_5__1__Impl ;
    public final void rule__Machine__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2647:1: ( rule__Machine__Group_5__1__Impl )
            // InternalXMachine.g:2648:2: rule__Machine__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Machine__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_5__1"


    // $ANTLR start "rule__Machine__Group_5__1__Impl"
    // InternalXMachine.g:2654:1: rule__Machine__Group_5__1__Impl : ( ( ( rule__Machine__OrderedChildrenAssignment_5_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_5_1 )* ) ) ;
    public final void rule__Machine__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2658:1: ( ( ( ( rule__Machine__OrderedChildrenAssignment_5_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_5_1 )* ) ) )
            // InternalXMachine.g:2659:1: ( ( ( rule__Machine__OrderedChildrenAssignment_5_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_5_1 )* ) )
            {
            // InternalXMachine.g:2659:1: ( ( ( rule__Machine__OrderedChildrenAssignment_5_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_5_1 )* ) )
            // InternalXMachine.g:2660:2: ( ( rule__Machine__OrderedChildrenAssignment_5_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_5_1 )* )
            {
            // InternalXMachine.g:2660:2: ( ( rule__Machine__OrderedChildrenAssignment_5_1 ) )
            // InternalXMachine.g:2661:3: ( rule__Machine__OrderedChildrenAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_5_1()); 
            }
            // InternalXMachine.g:2662:3: ( rule__Machine__OrderedChildrenAssignment_5_1 )
            // InternalXMachine.g:2662:4: rule__Machine__OrderedChildrenAssignment_5_1
            {
            pushFollow(FOLLOW_9);
            rule__Machine__OrderedChildrenAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_5_1()); 
            }

            }

            // InternalXMachine.g:2665:2: ( ( rule__Machine__OrderedChildrenAssignment_5_1 )* )
            // InternalXMachine.g:2666:3: ( rule__Machine__OrderedChildrenAssignment_5_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_5_1()); 
            }
            // InternalXMachine.g:2667:3: ( rule__Machine__OrderedChildrenAssignment_5_1 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalXMachine.g:2667:4: rule__Machine__OrderedChildrenAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Machine__OrderedChildrenAssignment_5_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_5_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_5__1__Impl"


    // $ANTLR start "rule__Machine__Group_6_0__0"
    // InternalXMachine.g:2677:1: rule__Machine__Group_6_0__0 : rule__Machine__Group_6_0__0__Impl rule__Machine__Group_6_0__1 ;
    public final void rule__Machine__Group_6_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2681:1: ( rule__Machine__Group_6_0__0__Impl rule__Machine__Group_6_0__1 )
            // InternalXMachine.g:2682:2: rule__Machine__Group_6_0__0__Impl rule__Machine__Group_6_0__1
            {
            pushFollow(FOLLOW_10);
            rule__Machine__Group_6_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Machine__Group_6_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_6_0__0"


    // $ANTLR start "rule__Machine__Group_6_0__0__Impl"
    // InternalXMachine.g:2689:1: rule__Machine__Group_6_0__0__Impl : ( ( rule__Machine__Alternatives_6_0_0 ) ) ;
    public final void rule__Machine__Group_6_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2693:1: ( ( ( rule__Machine__Alternatives_6_0_0 ) ) )
            // InternalXMachine.g:2694:1: ( ( rule__Machine__Alternatives_6_0_0 ) )
            {
            // InternalXMachine.g:2694:1: ( ( rule__Machine__Alternatives_6_0_0 ) )
            // InternalXMachine.g:2695:2: ( rule__Machine__Alternatives_6_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getAlternatives_6_0_0()); 
            }
            // InternalXMachine.g:2696:2: ( rule__Machine__Alternatives_6_0_0 )
            // InternalXMachine.g:2696:3: rule__Machine__Alternatives_6_0_0
            {
            pushFollow(FOLLOW_2);
            rule__Machine__Alternatives_6_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getAlternatives_6_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_6_0__0__Impl"


    // $ANTLR start "rule__Machine__Group_6_0__1"
    // InternalXMachine.g:2704:1: rule__Machine__Group_6_0__1 : rule__Machine__Group_6_0__1__Impl ;
    public final void rule__Machine__Group_6_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2708:1: ( rule__Machine__Group_6_0__1__Impl )
            // InternalXMachine.g:2709:2: rule__Machine__Group_6_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Machine__Group_6_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_6_0__1"


    // $ANTLR start "rule__Machine__Group_6_0__1__Impl"
    // InternalXMachine.g:2715:1: rule__Machine__Group_6_0__1__Impl : ( ( ( rule__Machine__OrderedChildrenAssignment_6_0_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_6_0_1 )* ) ) ;
    public final void rule__Machine__Group_6_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2719:1: ( ( ( ( rule__Machine__OrderedChildrenAssignment_6_0_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_6_0_1 )* ) ) )
            // InternalXMachine.g:2720:1: ( ( ( rule__Machine__OrderedChildrenAssignment_6_0_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_6_0_1 )* ) )
            {
            // InternalXMachine.g:2720:1: ( ( ( rule__Machine__OrderedChildrenAssignment_6_0_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_6_0_1 )* ) )
            // InternalXMachine.g:2721:2: ( ( rule__Machine__OrderedChildrenAssignment_6_0_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_6_0_1 )* )
            {
            // InternalXMachine.g:2721:2: ( ( rule__Machine__OrderedChildrenAssignment_6_0_1 ) )
            // InternalXMachine.g:2722:3: ( rule__Machine__OrderedChildrenAssignment_6_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_0_1()); 
            }
            // InternalXMachine.g:2723:3: ( rule__Machine__OrderedChildrenAssignment_6_0_1 )
            // InternalXMachine.g:2723:4: rule__Machine__OrderedChildrenAssignment_6_0_1
            {
            pushFollow(FOLLOW_11);
            rule__Machine__OrderedChildrenAssignment_6_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_0_1()); 
            }

            }

            // InternalXMachine.g:2726:2: ( ( rule__Machine__OrderedChildrenAssignment_6_0_1 )* )
            // InternalXMachine.g:2727:3: ( rule__Machine__OrderedChildrenAssignment_6_0_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_0_1()); 
            }
            // InternalXMachine.g:2728:3: ( rule__Machine__OrderedChildrenAssignment_6_0_1 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_STRING) ) {
                    int LA31_2 = input.LA(2);

                    if ( (LA31_2==RULE_ID) ) {
                        alt31=1;
                    }


                }
                else if ( (LA31_0==RULE_ID) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalXMachine.g:2728:4: rule__Machine__OrderedChildrenAssignment_6_0_1
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Machine__OrderedChildrenAssignment_6_0_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_0_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_6_0__1__Impl"


    // $ANTLR start "rule__Machine__Group_6_2__0"
    // InternalXMachine.g:2738:1: rule__Machine__Group_6_2__0 : rule__Machine__Group_6_2__0__Impl rule__Machine__Group_6_2__1 ;
    public final void rule__Machine__Group_6_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2742:1: ( rule__Machine__Group_6_2__0__Impl rule__Machine__Group_6_2__1 )
            // InternalXMachine.g:2743:2: rule__Machine__Group_6_2__0__Impl rule__Machine__Group_6_2__1
            {
            pushFollow(FOLLOW_12);
            rule__Machine__Group_6_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Machine__Group_6_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_6_2__0"


    // $ANTLR start "rule__Machine__Group_6_2__0__Impl"
    // InternalXMachine.g:2750:1: rule__Machine__Group_6_2__0__Impl : ( ( rule__Machine__Alternatives_6_2_0 ) ) ;
    public final void rule__Machine__Group_6_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2754:1: ( ( ( rule__Machine__Alternatives_6_2_0 ) ) )
            // InternalXMachine.g:2755:1: ( ( rule__Machine__Alternatives_6_2_0 ) )
            {
            // InternalXMachine.g:2755:1: ( ( rule__Machine__Alternatives_6_2_0 ) )
            // InternalXMachine.g:2756:2: ( rule__Machine__Alternatives_6_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getAlternatives_6_2_0()); 
            }
            // InternalXMachine.g:2757:2: ( rule__Machine__Alternatives_6_2_0 )
            // InternalXMachine.g:2757:3: rule__Machine__Alternatives_6_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Machine__Alternatives_6_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getAlternatives_6_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_6_2__0__Impl"


    // $ANTLR start "rule__Machine__Group_6_2__1"
    // InternalXMachine.g:2765:1: rule__Machine__Group_6_2__1 : rule__Machine__Group_6_2__1__Impl ;
    public final void rule__Machine__Group_6_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2769:1: ( rule__Machine__Group_6_2__1__Impl )
            // InternalXMachine.g:2770:2: rule__Machine__Group_6_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Machine__Group_6_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_6_2__1"


    // $ANTLR start "rule__Machine__Group_6_2__1__Impl"
    // InternalXMachine.g:2776:1: rule__Machine__Group_6_2__1__Impl : ( ( ( rule__Machine__OrderedChildrenAssignment_6_2_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_6_2_1 )* ) ) ;
    public final void rule__Machine__Group_6_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2780:1: ( ( ( ( rule__Machine__OrderedChildrenAssignment_6_2_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_6_2_1 )* ) ) )
            // InternalXMachine.g:2781:1: ( ( ( rule__Machine__OrderedChildrenAssignment_6_2_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_6_2_1 )* ) )
            {
            // InternalXMachine.g:2781:1: ( ( ( rule__Machine__OrderedChildrenAssignment_6_2_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_6_2_1 )* ) )
            // InternalXMachine.g:2782:2: ( ( rule__Machine__OrderedChildrenAssignment_6_2_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_6_2_1 )* )
            {
            // InternalXMachine.g:2782:2: ( ( rule__Machine__OrderedChildrenAssignment_6_2_1 ) )
            // InternalXMachine.g:2783:3: ( rule__Machine__OrderedChildrenAssignment_6_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_2_1()); 
            }
            // InternalXMachine.g:2784:3: ( rule__Machine__OrderedChildrenAssignment_6_2_1 )
            // InternalXMachine.g:2784:4: rule__Machine__OrderedChildrenAssignment_6_2_1
            {
            pushFollow(FOLLOW_13);
            rule__Machine__OrderedChildrenAssignment_6_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_2_1()); 
            }

            }

            // InternalXMachine.g:2787:2: ( ( rule__Machine__OrderedChildrenAssignment_6_2_1 )* )
            // InternalXMachine.g:2788:3: ( rule__Machine__OrderedChildrenAssignment_6_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_2_1()); 
            }
            // InternalXMachine.g:2789:3: ( rule__Machine__OrderedChildrenAssignment_6_2_1 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_STRING) ) {
                    int LA32_2 = input.LA(2);

                    if ( (LA32_2==RULE_XLABEL) ) {
                        alt32=1;
                    }


                }
                else if ( (LA32_0==RULE_XLABEL) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalXMachine.g:2789:4: rule__Machine__OrderedChildrenAssignment_6_2_1
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Machine__OrderedChildrenAssignment_6_2_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_6_2_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_6_2__1__Impl"


    // $ANTLR start "rule__Machine__Group_7__0"
    // InternalXMachine.g:2799:1: rule__Machine__Group_7__0 : rule__Machine__Group_7__0__Impl rule__Machine__Group_7__1 ;
    public final void rule__Machine__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2803:1: ( rule__Machine__Group_7__0__Impl rule__Machine__Group_7__1 )
            // InternalXMachine.g:2804:2: rule__Machine__Group_7__0__Impl rule__Machine__Group_7__1
            {
            pushFollow(FOLLOW_14);
            rule__Machine__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Machine__Group_7__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_7__0"


    // $ANTLR start "rule__Machine__Group_7__0__Impl"
    // InternalXMachine.g:2811:1: rule__Machine__Group_7__0__Impl : ( 'events' ) ;
    public final void rule__Machine__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2815:1: ( ( 'events' ) )
            // InternalXMachine.g:2816:1: ( 'events' )
            {
            // InternalXMachine.g:2816:1: ( 'events' )
            // InternalXMachine.g:2817:2: 'events'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getEventsKeyword_7_0()); 
            }
            match(input,190,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getEventsKeyword_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_7__0__Impl"


    // $ANTLR start "rule__Machine__Group_7__1"
    // InternalXMachine.g:2826:1: rule__Machine__Group_7__1 : rule__Machine__Group_7__1__Impl ;
    public final void rule__Machine__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2830:1: ( rule__Machine__Group_7__1__Impl )
            // InternalXMachine.g:2831:2: rule__Machine__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Machine__Group_7__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_7__1"


    // $ANTLR start "rule__Machine__Group_7__1__Impl"
    // InternalXMachine.g:2837:1: rule__Machine__Group_7__1__Impl : ( ( ( rule__Machine__OrderedChildrenAssignment_7_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_7_1 )* ) ) ;
    public final void rule__Machine__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2841:1: ( ( ( ( rule__Machine__OrderedChildrenAssignment_7_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_7_1 )* ) ) )
            // InternalXMachine.g:2842:1: ( ( ( rule__Machine__OrderedChildrenAssignment_7_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_7_1 )* ) )
            {
            // InternalXMachine.g:2842:1: ( ( ( rule__Machine__OrderedChildrenAssignment_7_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_7_1 )* ) )
            // InternalXMachine.g:2843:2: ( ( rule__Machine__OrderedChildrenAssignment_7_1 ) ) ( ( rule__Machine__OrderedChildrenAssignment_7_1 )* )
            {
            // InternalXMachine.g:2843:2: ( ( rule__Machine__OrderedChildrenAssignment_7_1 ) )
            // InternalXMachine.g:2844:3: ( rule__Machine__OrderedChildrenAssignment_7_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_7_1()); 
            }
            // InternalXMachine.g:2845:3: ( rule__Machine__OrderedChildrenAssignment_7_1 )
            // InternalXMachine.g:2845:4: rule__Machine__OrderedChildrenAssignment_7_1
            {
            pushFollow(FOLLOW_8);
            rule__Machine__OrderedChildrenAssignment_7_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_7_1()); 
            }

            }

            // InternalXMachine.g:2848:2: ( ( rule__Machine__OrderedChildrenAssignment_7_1 )* )
            // InternalXMachine.g:2849:3: ( rule__Machine__OrderedChildrenAssignment_7_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_7_1()); 
            }
            // InternalXMachine.g:2850:3: ( rule__Machine__OrderedChildrenAssignment_7_1 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_STRING||(LA33_0>=179 && LA33_0<=181)||LA33_0==202) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalXMachine.g:2850:4: rule__Machine__OrderedChildrenAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Machine__OrderedChildrenAssignment_7_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_7_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__Group_7__1__Impl"


    // $ANTLR start "rule__MContains__Group__0"
    // InternalXMachine.g:2860:1: rule__MContains__Group__0 : rule__MContains__Group__0__Impl rule__MContains__Group__1 ;
    public final void rule__MContains__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2864:1: ( rule__MContains__Group__0__Impl rule__MContains__Group__1 )
            // InternalXMachine.g:2865:2: rule__MContains__Group__0__Impl rule__MContains__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__MContains__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MContains__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MContains__Group__0"


    // $ANTLR start "rule__MContains__Group__0__Impl"
    // InternalXMachine.g:2872:1: rule__MContains__Group__0__Impl : ( () ) ;
    public final void rule__MContains__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2876:1: ( ( () ) )
            // InternalXMachine.g:2877:1: ( () )
            {
            // InternalXMachine.g:2877:1: ( () )
            // InternalXMachine.g:2878:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMContainsAccess().getContainmentAction_0()); 
            }
            // InternalXMachine.g:2879:2: ()
            // InternalXMachine.g:2879:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMContainsAccess().getContainmentAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MContains__Group__0__Impl"


    // $ANTLR start "rule__MContains__Group__1"
    // InternalXMachine.g:2887:1: rule__MContains__Group__1 : rule__MContains__Group__1__Impl ;
    public final void rule__MContains__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2891:1: ( rule__MContains__Group__1__Impl )
            // InternalXMachine.g:2892:2: rule__MContains__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MContains__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MContains__Group__1"


    // $ANTLR start "rule__MContains__Group__1__Impl"
    // InternalXMachine.g:2898:1: rule__MContains__Group__1__Impl : ( ( rule__MContains__ExtensionAssignment_1 ) ) ;
    public final void rule__MContains__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2902:1: ( ( ( rule__MContains__ExtensionAssignment_1 ) ) )
            // InternalXMachine.g:2903:1: ( ( rule__MContains__ExtensionAssignment_1 ) )
            {
            // InternalXMachine.g:2903:1: ( ( rule__MContains__ExtensionAssignment_1 ) )
            // InternalXMachine.g:2904:2: ( rule__MContains__ExtensionAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMContainsAccess().getExtensionAssignment_1()); 
            }
            // InternalXMachine.g:2905:2: ( rule__MContains__ExtensionAssignment_1 )
            // InternalXMachine.g:2905:3: rule__MContains__ExtensionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__MContains__ExtensionAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMContainsAccess().getExtensionAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MContains__Group__1__Impl"


    // $ANTLR start "rule__MIncludes__Group__0"
    // InternalXMachine.g:2914:1: rule__MIncludes__Group__0 : rule__MIncludes__Group__0__Impl rule__MIncludes__Group__1 ;
    public final void rule__MIncludes__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2918:1: ( rule__MIncludes__Group__0__Impl rule__MIncludes__Group__1 )
            // InternalXMachine.g:2919:2: rule__MIncludes__Group__0__Impl rule__MIncludes__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__MIncludes__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MIncludes__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group__0"


    // $ANTLR start "rule__MIncludes__Group__0__Impl"
    // InternalXMachine.g:2926:1: rule__MIncludes__Group__0__Impl : ( () ) ;
    public final void rule__MIncludes__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2930:1: ( ( () ) )
            // InternalXMachine.g:2931:1: ( () )
            {
            // InternalXMachine.g:2931:1: ( () )
            // InternalXMachine.g:2932:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getMachineInclusionAction_0()); 
            }
            // InternalXMachine.g:2933:2: ()
            // InternalXMachine.g:2933:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getMachineInclusionAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group__0__Impl"


    // $ANTLR start "rule__MIncludes__Group__1"
    // InternalXMachine.g:2941:1: rule__MIncludes__Group__1 : rule__MIncludes__Group__1__Impl rule__MIncludes__Group__2 ;
    public final void rule__MIncludes__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2945:1: ( rule__MIncludes__Group__1__Impl rule__MIncludes__Group__2 )
            // InternalXMachine.g:2946:2: rule__MIncludes__Group__1__Impl rule__MIncludes__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__MIncludes__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MIncludes__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group__1"


    // $ANTLR start "rule__MIncludes__Group__1__Impl"
    // InternalXMachine.g:2953:1: rule__MIncludes__Group__1__Impl : ( ( rule__MIncludes__Group_1__0 ) ) ;
    public final void rule__MIncludes__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2957:1: ( ( ( rule__MIncludes__Group_1__0 ) ) )
            // InternalXMachine.g:2958:1: ( ( rule__MIncludes__Group_1__0 ) )
            {
            // InternalXMachine.g:2958:1: ( ( rule__MIncludes__Group_1__0 ) )
            // InternalXMachine.g:2959:2: ( rule__MIncludes__Group_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getGroup_1()); 
            }
            // InternalXMachine.g:2960:2: ( rule__MIncludes__Group_1__0 )
            // InternalXMachine.g:2960:3: rule__MIncludes__Group_1__0
            {
            pushFollow(FOLLOW_2);
            rule__MIncludes__Group_1__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group__1__Impl"


    // $ANTLR start "rule__MIncludes__Group__2"
    // InternalXMachine.g:2968:1: rule__MIncludes__Group__2 : rule__MIncludes__Group__2__Impl rule__MIncludes__Group__3 ;
    public final void rule__MIncludes__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2972:1: ( rule__MIncludes__Group__2__Impl rule__MIncludes__Group__3 )
            // InternalXMachine.g:2973:2: rule__MIncludes__Group__2__Impl rule__MIncludes__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__MIncludes__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MIncludes__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group__2"


    // $ANTLR start "rule__MIncludes__Group__2__Impl"
    // InternalXMachine.g:2980:1: rule__MIncludes__Group__2__Impl : ( ( rule__MIncludes__Group_2__0 )? ) ;
    public final void rule__MIncludes__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2984:1: ( ( ( rule__MIncludes__Group_2__0 )? ) )
            // InternalXMachine.g:2985:1: ( ( rule__MIncludes__Group_2__0 )? )
            {
            // InternalXMachine.g:2985:1: ( ( rule__MIncludes__Group_2__0 )? )
            // InternalXMachine.g:2986:2: ( rule__MIncludes__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getGroup_2()); 
            }
            // InternalXMachine.g:2987:2: ( rule__MIncludes__Group_2__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==192) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalXMachine.g:2987:3: rule__MIncludes__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MIncludes__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group__2__Impl"


    // $ANTLR start "rule__MIncludes__Group__3"
    // InternalXMachine.g:2995:1: rule__MIncludes__Group__3 : rule__MIncludes__Group__3__Impl ;
    public final void rule__MIncludes__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:2999:1: ( rule__MIncludes__Group__3__Impl )
            // InternalXMachine.g:3000:2: rule__MIncludes__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MIncludes__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group__3"


    // $ANTLR start "rule__MIncludes__Group__3__Impl"
    // InternalXMachine.g:3006:1: rule__MIncludes__Group__3__Impl : ( ( rule__MIncludes__Group_3__0 )? ) ;
    public final void rule__MIncludes__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3010:1: ( ( ( rule__MIncludes__Group_3__0 )? ) )
            // InternalXMachine.g:3011:1: ( ( rule__MIncludes__Group_3__0 )? )
            {
            // InternalXMachine.g:3011:1: ( ( rule__MIncludes__Group_3__0 )? )
            // InternalXMachine.g:3012:2: ( rule__MIncludes__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getGroup_3()); 
            }
            // InternalXMachine.g:3013:2: ( rule__MIncludes__Group_3__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==193) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalXMachine.g:3013:3: rule__MIncludes__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MIncludes__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group__3__Impl"


    // $ANTLR start "rule__MIncludes__Group_1__0"
    // InternalXMachine.g:3022:1: rule__MIncludes__Group_1__0 : rule__MIncludes__Group_1__0__Impl rule__MIncludes__Group_1__1 ;
    public final void rule__MIncludes__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3026:1: ( rule__MIncludes__Group_1__0__Impl rule__MIncludes__Group_1__1 )
            // InternalXMachine.g:3027:2: rule__MIncludes__Group_1__0__Impl rule__MIncludes__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__MIncludes__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MIncludes__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group_1__0"


    // $ANTLR start "rule__MIncludes__Group_1__0__Impl"
    // InternalXMachine.g:3034:1: rule__MIncludes__Group_1__0__Impl : ( 'includes' ) ;
    public final void rule__MIncludes__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3038:1: ( ( 'includes' ) )
            // InternalXMachine.g:3039:1: ( 'includes' )
            {
            // InternalXMachine.g:3039:1: ( 'includes' )
            // InternalXMachine.g:3040:2: 'includes'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getIncludesKeyword_1_0()); 
            }
            match(input,191,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getIncludesKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group_1__0__Impl"


    // $ANTLR start "rule__MIncludes__Group_1__1"
    // InternalXMachine.g:3049:1: rule__MIncludes__Group_1__1 : rule__MIncludes__Group_1__1__Impl ;
    public final void rule__MIncludes__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3053:1: ( rule__MIncludes__Group_1__1__Impl )
            // InternalXMachine.g:3054:2: rule__MIncludes__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MIncludes__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group_1__1"


    // $ANTLR start "rule__MIncludes__Group_1__1__Impl"
    // InternalXMachine.g:3060:1: rule__MIncludes__Group_1__1__Impl : ( ( rule__MIncludes__AbstractMachineAssignment_1_1 ) ) ;
    public final void rule__MIncludes__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3064:1: ( ( ( rule__MIncludes__AbstractMachineAssignment_1_1 ) ) )
            // InternalXMachine.g:3065:1: ( ( rule__MIncludes__AbstractMachineAssignment_1_1 ) )
            {
            // InternalXMachine.g:3065:1: ( ( rule__MIncludes__AbstractMachineAssignment_1_1 ) )
            // InternalXMachine.g:3066:2: ( rule__MIncludes__AbstractMachineAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getAbstractMachineAssignment_1_1()); 
            }
            // InternalXMachine.g:3067:2: ( rule__MIncludes__AbstractMachineAssignment_1_1 )
            // InternalXMachine.g:3067:3: rule__MIncludes__AbstractMachineAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MIncludes__AbstractMachineAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getAbstractMachineAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group_1__1__Impl"


    // $ANTLR start "rule__MIncludes__Group_2__0"
    // InternalXMachine.g:3076:1: rule__MIncludes__Group_2__0 : rule__MIncludes__Group_2__0__Impl rule__MIncludes__Group_2__1 ;
    public final void rule__MIncludes__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3080:1: ( rule__MIncludes__Group_2__0__Impl rule__MIncludes__Group_2__1 )
            // InternalXMachine.g:3081:2: rule__MIncludes__Group_2__0__Impl rule__MIncludes__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__MIncludes__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MIncludes__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group_2__0"


    // $ANTLR start "rule__MIncludes__Group_2__0__Impl"
    // InternalXMachine.g:3088:1: rule__MIncludes__Group_2__0__Impl : ( 'to' ) ;
    public final void rule__MIncludes__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3092:1: ( ( 'to' ) )
            // InternalXMachine.g:3093:1: ( 'to' )
            {
            // InternalXMachine.g:3093:1: ( 'to' )
            // InternalXMachine.g:3094:2: 'to'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getToKeyword_2_0()); 
            }
            match(input,192,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getToKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group_2__0__Impl"


    // $ANTLR start "rule__MIncludes__Group_2__1"
    // InternalXMachine.g:3103:1: rule__MIncludes__Group_2__1 : rule__MIncludes__Group_2__1__Impl ;
    public final void rule__MIncludes__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3107:1: ( rule__MIncludes__Group_2__1__Impl )
            // InternalXMachine.g:3108:2: rule__MIncludes__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MIncludes__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group_2__1"


    // $ANTLR start "rule__MIncludes__Group_2__1__Impl"
    // InternalXMachine.g:3114:1: rule__MIncludes__Group_2__1__Impl : ( ( rule__MIncludes__ConcreteMachineAssignment_2_1 ) ) ;
    public final void rule__MIncludes__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3118:1: ( ( ( rule__MIncludes__ConcreteMachineAssignment_2_1 ) ) )
            // InternalXMachine.g:3119:1: ( ( rule__MIncludes__ConcreteMachineAssignment_2_1 ) )
            {
            // InternalXMachine.g:3119:1: ( ( rule__MIncludes__ConcreteMachineAssignment_2_1 ) )
            // InternalXMachine.g:3120:2: ( rule__MIncludes__ConcreteMachineAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getConcreteMachineAssignment_2_1()); 
            }
            // InternalXMachine.g:3121:2: ( rule__MIncludes__ConcreteMachineAssignment_2_1 )
            // InternalXMachine.g:3121:3: rule__MIncludes__ConcreteMachineAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__MIncludes__ConcreteMachineAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getConcreteMachineAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group_2__1__Impl"


    // $ANTLR start "rule__MIncludes__Group_3__0"
    // InternalXMachine.g:3130:1: rule__MIncludes__Group_3__0 : rule__MIncludes__Group_3__0__Impl rule__MIncludes__Group_3__1 ;
    public final void rule__MIncludes__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3134:1: ( rule__MIncludes__Group_3__0__Impl rule__MIncludes__Group_3__1 )
            // InternalXMachine.g:3135:2: rule__MIncludes__Group_3__0__Impl rule__MIncludes__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__MIncludes__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MIncludes__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group_3__0"


    // $ANTLR start "rule__MIncludes__Group_3__0__Impl"
    // InternalXMachine.g:3142:1: rule__MIncludes__Group_3__0__Impl : ( 'as' ) ;
    public final void rule__MIncludes__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3146:1: ( ( 'as' ) )
            // InternalXMachine.g:3147:1: ( 'as' )
            {
            // InternalXMachine.g:3147:1: ( 'as' )
            // InternalXMachine.g:3148:2: 'as'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getAsKeyword_3_0()); 
            }
            match(input,193,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getAsKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group_3__0__Impl"


    // $ANTLR start "rule__MIncludes__Group_3__1"
    // InternalXMachine.g:3157:1: rule__MIncludes__Group_3__1 : rule__MIncludes__Group_3__1__Impl rule__MIncludes__Group_3__2 ;
    public final void rule__MIncludes__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3161:1: ( rule__MIncludes__Group_3__1__Impl rule__MIncludes__Group_3__2 )
            // InternalXMachine.g:3162:2: rule__MIncludes__Group_3__1__Impl rule__MIncludes__Group_3__2
            {
            pushFollow(FOLLOW_5);
            rule__MIncludes__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MIncludes__Group_3__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group_3__1"


    // $ANTLR start "rule__MIncludes__Group_3__1__Impl"
    // InternalXMachine.g:3169:1: rule__MIncludes__Group_3__1__Impl : ( ( rule__MIncludes__PrefixesAssignment_3_1 ) ) ;
    public final void rule__MIncludes__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3173:1: ( ( ( rule__MIncludes__PrefixesAssignment_3_1 ) ) )
            // InternalXMachine.g:3174:1: ( ( rule__MIncludes__PrefixesAssignment_3_1 ) )
            {
            // InternalXMachine.g:3174:1: ( ( rule__MIncludes__PrefixesAssignment_3_1 ) )
            // InternalXMachine.g:3175:2: ( rule__MIncludes__PrefixesAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getPrefixesAssignment_3_1()); 
            }
            // InternalXMachine.g:3176:2: ( rule__MIncludes__PrefixesAssignment_3_1 )
            // InternalXMachine.g:3176:3: rule__MIncludes__PrefixesAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__MIncludes__PrefixesAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getPrefixesAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group_3__1__Impl"


    // $ANTLR start "rule__MIncludes__Group_3__2"
    // InternalXMachine.g:3184:1: rule__MIncludes__Group_3__2 : rule__MIncludes__Group_3__2__Impl ;
    public final void rule__MIncludes__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3188:1: ( rule__MIncludes__Group_3__2__Impl )
            // InternalXMachine.g:3189:2: rule__MIncludes__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MIncludes__Group_3__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group_3__2"


    // $ANTLR start "rule__MIncludes__Group_3__2__Impl"
    // InternalXMachine.g:3195:1: rule__MIncludes__Group_3__2__Impl : ( ( rule__MIncludes__PrefixesAssignment_3_2 )* ) ;
    public final void rule__MIncludes__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3199:1: ( ( ( rule__MIncludes__PrefixesAssignment_3_2 )* ) )
            // InternalXMachine.g:3200:1: ( ( rule__MIncludes__PrefixesAssignment_3_2 )* )
            {
            // InternalXMachine.g:3200:1: ( ( rule__MIncludes__PrefixesAssignment_3_2 )* )
            // InternalXMachine.g:3201:2: ( rule__MIncludes__PrefixesAssignment_3_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getPrefixesAssignment_3_2()); 
            }
            // InternalXMachine.g:3202:2: ( rule__MIncludes__PrefixesAssignment_3_2 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_ID) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalXMachine.g:3202:3: rule__MIncludes__PrefixesAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__MIncludes__PrefixesAssignment_3_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getPrefixesAssignment_3_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__Group_3__2__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalXMachine.g:3211:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3215:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalXMachine.g:3216:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalXMachine.g:3223:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3227:1: ( ( RULE_ID ) )
            // InternalXMachine.g:3228:1: ( RULE_ID )
            {
            // InternalXMachine.g:3228:1: ( RULE_ID )
            // InternalXMachine.g:3229:2: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalXMachine.g:3238:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3242:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalXMachine.g:3243:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalXMachine.g:3249:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )? ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3253:1: ( ( ( rule__QualifiedName__Group_1__0 )? ) )
            // InternalXMachine.g:3254:1: ( ( rule__QualifiedName__Group_1__0 )? )
            {
            // InternalXMachine.g:3254:1: ( ( rule__QualifiedName__Group_1__0 )? )
            // InternalXMachine.g:3255:2: ( rule__QualifiedName__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalXMachine.g:3256:2: ( rule__QualifiedName__Group_1__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==96) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalXMachine.g:3256:3: rule__QualifiedName__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__QualifiedName__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalXMachine.g:3265:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3269:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalXMachine.g:3270:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalXMachine.g:3277:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3281:1: ( ( '.' ) )
            // InternalXMachine.g:3282:1: ( '.' )
            {
            // InternalXMachine.g:3282:1: ( '.' )
            // InternalXMachine.g:3283:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            match(input,96,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalXMachine.g:3292:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3296:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalXMachine.g:3297:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalXMachine.g:3303:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3307:1: ( ( RULE_ID ) )
            // InternalXMachine.g:3308:1: ( RULE_ID )
            {
            // InternalXMachine.g:3308:1: ( RULE_ID )
            // InternalXMachine.g:3309:2: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__XMultipleVariable__Group__0"
    // InternalXMachine.g:3319:1: rule__XMultipleVariable__Group__0 : rule__XMultipleVariable__Group__0__Impl rule__XMultipleVariable__Group__1 ;
    public final void rule__XMultipleVariable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3323:1: ( rule__XMultipleVariable__Group__0__Impl rule__XMultipleVariable__Group__1 )
            // InternalXMachine.g:3324:2: rule__XMultipleVariable__Group__0__Impl rule__XMultipleVariable__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__XMultipleVariable__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XMultipleVariable__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleVariable__Group__0"


    // $ANTLR start "rule__XMultipleVariable__Group__0__Impl"
    // InternalXMachine.g:3331:1: rule__XMultipleVariable__Group__0__Impl : ( () ) ;
    public final void rule__XMultipleVariable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3335:1: ( ( () ) )
            // InternalXMachine.g:3336:1: ( () )
            {
            // InternalXMachine.g:3336:1: ( () )
            // InternalXMachine.g:3337:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXMultipleVariableAccess().getVariableAction_0()); 
            }
            // InternalXMachine.g:3338:2: ()
            // InternalXMachine.g:3338:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXMultipleVariableAccess().getVariableAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleVariable__Group__0__Impl"


    // $ANTLR start "rule__XMultipleVariable__Group__1"
    // InternalXMachine.g:3346:1: rule__XMultipleVariable__Group__1 : rule__XMultipleVariable__Group__1__Impl rule__XMultipleVariable__Group__2 ;
    public final void rule__XMultipleVariable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3350:1: ( rule__XMultipleVariable__Group__1__Impl rule__XMultipleVariable__Group__2 )
            // InternalXMachine.g:3351:2: rule__XMultipleVariable__Group__1__Impl rule__XMultipleVariable__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__XMultipleVariable__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XMultipleVariable__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleVariable__Group__1"


    // $ANTLR start "rule__XMultipleVariable__Group__1__Impl"
    // InternalXMachine.g:3358:1: rule__XMultipleVariable__Group__1__Impl : ( ( rule__XMultipleVariable__CommentAssignment_1 )? ) ;
    public final void rule__XMultipleVariable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3362:1: ( ( ( rule__XMultipleVariable__CommentAssignment_1 )? ) )
            // InternalXMachine.g:3363:1: ( ( rule__XMultipleVariable__CommentAssignment_1 )? )
            {
            // InternalXMachine.g:3363:1: ( ( rule__XMultipleVariable__CommentAssignment_1 )? )
            // InternalXMachine.g:3364:2: ( rule__XMultipleVariable__CommentAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXMultipleVariableAccess().getCommentAssignment_1()); 
            }
            // InternalXMachine.g:3365:2: ( rule__XMultipleVariable__CommentAssignment_1 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_STRING) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalXMachine.g:3365:3: rule__XMultipleVariable__CommentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XMultipleVariable__CommentAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXMultipleVariableAccess().getCommentAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleVariable__Group__1__Impl"


    // $ANTLR start "rule__XMultipleVariable__Group__2"
    // InternalXMachine.g:3373:1: rule__XMultipleVariable__Group__2 : rule__XMultipleVariable__Group__2__Impl ;
    public final void rule__XMultipleVariable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3377:1: ( rule__XMultipleVariable__Group__2__Impl )
            // InternalXMachine.g:3378:2: rule__XMultipleVariable__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XMultipleVariable__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleVariable__Group__2"


    // $ANTLR start "rule__XMultipleVariable__Group__2__Impl"
    // InternalXMachine.g:3384:1: rule__XMultipleVariable__Group__2__Impl : ( ( rule__XMultipleVariable__NameAssignment_2 ) ) ;
    public final void rule__XMultipleVariable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3388:1: ( ( ( rule__XMultipleVariable__NameAssignment_2 ) ) )
            // InternalXMachine.g:3389:1: ( ( rule__XMultipleVariable__NameAssignment_2 ) )
            {
            // InternalXMachine.g:3389:1: ( ( rule__XMultipleVariable__NameAssignment_2 ) )
            // InternalXMachine.g:3390:2: ( rule__XMultipleVariable__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXMultipleVariableAccess().getNameAssignment_2()); 
            }
            // InternalXMachine.g:3391:2: ( rule__XMultipleVariable__NameAssignment_2 )
            // InternalXMachine.g:3391:3: rule__XMultipleVariable__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__XMultipleVariable__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXMultipleVariableAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleVariable__Group__2__Impl"


    // $ANTLR start "rule__XIndividualVariable__Group__0"
    // InternalXMachine.g:3400:1: rule__XIndividualVariable__Group__0 : rule__XIndividualVariable__Group__0__Impl rule__XIndividualVariable__Group__1 ;
    public final void rule__XIndividualVariable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3404:1: ( rule__XIndividualVariable__Group__0__Impl rule__XIndividualVariable__Group__1 )
            // InternalXMachine.g:3405:2: rule__XIndividualVariable__Group__0__Impl rule__XIndividualVariable__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__XIndividualVariable__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group__0"


    // $ANTLR start "rule__XIndividualVariable__Group__0__Impl"
    // InternalXMachine.g:3412:1: rule__XIndividualVariable__Group__0__Impl : ( () ) ;
    public final void rule__XIndividualVariable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3416:1: ( ( () ) )
            // InternalXMachine.g:3417:1: ( () )
            {
            // InternalXMachine.g:3417:1: ( () )
            // InternalXMachine.g:3418:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getAgentTypedVariableAction_0()); 
            }
            // InternalXMachine.g:3419:2: ()
            // InternalXMachine.g:3419:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getAgentTypedVariableAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group__0__Impl"


    // $ANTLR start "rule__XIndividualVariable__Group__1"
    // InternalXMachine.g:3427:1: rule__XIndividualVariable__Group__1 : rule__XIndividualVariable__Group__1__Impl rule__XIndividualVariable__Group__2 ;
    public final void rule__XIndividualVariable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3431:1: ( rule__XIndividualVariable__Group__1__Impl rule__XIndividualVariable__Group__2 )
            // InternalXMachine.g:3432:2: rule__XIndividualVariable__Group__1__Impl rule__XIndividualVariable__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__XIndividualVariable__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group__1"


    // $ANTLR start "rule__XIndividualVariable__Group__1__Impl"
    // InternalXMachine.g:3439:1: rule__XIndividualVariable__Group__1__Impl : ( ( rule__XIndividualVariable__CommentAssignment_1 )? ) ;
    public final void rule__XIndividualVariable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3443:1: ( ( ( rule__XIndividualVariable__CommentAssignment_1 )? ) )
            // InternalXMachine.g:3444:1: ( ( rule__XIndividualVariable__CommentAssignment_1 )? )
            {
            // InternalXMachine.g:3444:1: ( ( rule__XIndividualVariable__CommentAssignment_1 )? )
            // InternalXMachine.g:3445:2: ( rule__XIndividualVariable__CommentAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getCommentAssignment_1()); 
            }
            // InternalXMachine.g:3446:2: ( rule__XIndividualVariable__CommentAssignment_1 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_STRING) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalXMachine.g:3446:3: rule__XIndividualVariable__CommentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XIndividualVariable__CommentAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getCommentAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group__1__Impl"


    // $ANTLR start "rule__XIndividualVariable__Group__2"
    // InternalXMachine.g:3454:1: rule__XIndividualVariable__Group__2 : rule__XIndividualVariable__Group__2__Impl rule__XIndividualVariable__Group__3 ;
    public final void rule__XIndividualVariable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3458:1: ( rule__XIndividualVariable__Group__2__Impl rule__XIndividualVariable__Group__3 )
            // InternalXMachine.g:3459:2: rule__XIndividualVariable__Group__2__Impl rule__XIndividualVariable__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__XIndividualVariable__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group__2"


    // $ANTLR start "rule__XIndividualVariable__Group__2__Impl"
    // InternalXMachine.g:3466:1: rule__XIndividualVariable__Group__2__Impl : ( ( rule__XIndividualVariable__Alternatives_2 ) ) ;
    public final void rule__XIndividualVariable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3470:1: ( ( ( rule__XIndividualVariable__Alternatives_2 ) ) )
            // InternalXMachine.g:3471:1: ( ( rule__XIndividualVariable__Alternatives_2 ) )
            {
            // InternalXMachine.g:3471:1: ( ( rule__XIndividualVariable__Alternatives_2 ) )
            // InternalXMachine.g:3472:2: ( rule__XIndividualVariable__Alternatives_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getAlternatives_2()); 
            }
            // InternalXMachine.g:3473:2: ( rule__XIndividualVariable__Alternatives_2 )
            // InternalXMachine.g:3473:3: rule__XIndividualVariable__Alternatives_2
            {
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__Alternatives_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getAlternatives_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group__2__Impl"


    // $ANTLR start "rule__XIndividualVariable__Group__3"
    // InternalXMachine.g:3481:1: rule__XIndividualVariable__Group__3 : rule__XIndividualVariable__Group__3__Impl rule__XIndividualVariable__Group__4 ;
    public final void rule__XIndividualVariable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3485:1: ( rule__XIndividualVariable__Group__3__Impl rule__XIndividualVariable__Group__4 )
            // InternalXMachine.g:3486:2: rule__XIndividualVariable__Group__3__Impl rule__XIndividualVariable__Group__4
            {
            pushFollow(FOLLOW_19);
            rule__XIndividualVariable__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group__3"


    // $ANTLR start "rule__XIndividualVariable__Group__3__Impl"
    // InternalXMachine.g:3493:1: rule__XIndividualVariable__Group__3__Impl : ( ( rule__XIndividualVariable__NameAssignment_3 ) ) ;
    public final void rule__XIndividualVariable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3497:1: ( ( ( rule__XIndividualVariable__NameAssignment_3 ) ) )
            // InternalXMachine.g:3498:1: ( ( rule__XIndividualVariable__NameAssignment_3 ) )
            {
            // InternalXMachine.g:3498:1: ( ( rule__XIndividualVariable__NameAssignment_3 ) )
            // InternalXMachine.g:3499:2: ( rule__XIndividualVariable__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getNameAssignment_3()); 
            }
            // InternalXMachine.g:3500:2: ( rule__XIndividualVariable__NameAssignment_3 )
            // InternalXMachine.g:3500:3: rule__XIndividualVariable__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group__3__Impl"


    // $ANTLR start "rule__XIndividualVariable__Group__4"
    // InternalXMachine.g:3508:1: rule__XIndividualVariable__Group__4 : rule__XIndividualVariable__Group__4__Impl rule__XIndividualVariable__Group__5 ;
    public final void rule__XIndividualVariable__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3512:1: ( rule__XIndividualVariable__Group__4__Impl rule__XIndividualVariable__Group__5 )
            // InternalXMachine.g:3513:2: rule__XIndividualVariable__Group__4__Impl rule__XIndividualVariable__Group__5
            {
            pushFollow(FOLLOW_19);
            rule__XIndividualVariable__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group__4"


    // $ANTLR start "rule__XIndividualVariable__Group__4__Impl"
    // InternalXMachine.g:3520:1: rule__XIndividualVariable__Group__4__Impl : ( ( rule__XIndividualVariable__Group_4__0 )? ) ;
    public final void rule__XIndividualVariable__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3524:1: ( ( ( rule__XIndividualVariable__Group_4__0 )? ) )
            // InternalXMachine.g:3525:1: ( ( rule__XIndividualVariable__Group_4__0 )? )
            {
            // InternalXMachine.g:3525:1: ( ( rule__XIndividualVariable__Group_4__0 )? )
            // InternalXMachine.g:3526:2: ( rule__XIndividualVariable__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getGroup_4()); 
            }
            // InternalXMachine.g:3527:2: ( rule__XIndividualVariable__Group_4__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==107) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalXMachine.g:3527:3: rule__XIndividualVariable__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XIndividualVariable__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group__4__Impl"


    // $ANTLR start "rule__XIndividualVariable__Group__5"
    // InternalXMachine.g:3535:1: rule__XIndividualVariable__Group__5 : rule__XIndividualVariable__Group__5__Impl rule__XIndividualVariable__Group__6 ;
    public final void rule__XIndividualVariable__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3539:1: ( rule__XIndividualVariable__Group__5__Impl rule__XIndividualVariable__Group__6 )
            // InternalXMachine.g:3540:2: rule__XIndividualVariable__Group__5__Impl rule__XIndividualVariable__Group__6
            {
            pushFollow(FOLLOW_19);
            rule__XIndividualVariable__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group__5"


    // $ANTLR start "rule__XIndividualVariable__Group__5__Impl"
    // InternalXMachine.g:3547:1: rule__XIndividualVariable__Group__5__Impl : ( ( rule__XIndividualVariable__Group_5__0 )? ) ;
    public final void rule__XIndividualVariable__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3551:1: ( ( ( rule__XIndividualVariable__Group_5__0 )? ) )
            // InternalXMachine.g:3552:1: ( ( rule__XIndividualVariable__Group_5__0 )? )
            {
            // InternalXMachine.g:3552:1: ( ( rule__XIndividualVariable__Group_5__0 )? )
            // InternalXMachine.g:3553:2: ( rule__XIndividualVariable__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getGroup_5()); 
            }
            // InternalXMachine.g:3554:2: ( rule__XIndividualVariable__Group_5__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==97) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalXMachine.g:3554:3: rule__XIndividualVariable__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XIndividualVariable__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group__5__Impl"


    // $ANTLR start "rule__XIndividualVariable__Group__6"
    // InternalXMachine.g:3562:1: rule__XIndividualVariable__Group__6 : rule__XIndividualVariable__Group__6__Impl ;
    public final void rule__XIndividualVariable__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3566:1: ( rule__XIndividualVariable__Group__6__Impl )
            // InternalXMachine.g:3567:2: rule__XIndividualVariable__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group__6"


    // $ANTLR start "rule__XIndividualVariable__Group__6__Impl"
    // InternalXMachine.g:3573:1: rule__XIndividualVariable__Group__6__Impl : ( ( rule__XIndividualVariable__Group_6__0 )? ) ;
    public final void rule__XIndividualVariable__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3577:1: ( ( ( rule__XIndividualVariable__Group_6__0 )? ) )
            // InternalXMachine.g:3578:1: ( ( rule__XIndividualVariable__Group_6__0 )? )
            {
            // InternalXMachine.g:3578:1: ( ( rule__XIndividualVariable__Group_6__0 )? )
            // InternalXMachine.g:3579:2: ( rule__XIndividualVariable__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getGroup_6()); 
            }
            // InternalXMachine.g:3580:2: ( rule__XIndividualVariable__Group_6__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==194) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalXMachine.g:3580:3: rule__XIndividualVariable__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XIndividualVariable__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getGroup_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group__6__Impl"


    // $ANTLR start "rule__XIndividualVariable__Group_4__0"
    // InternalXMachine.g:3589:1: rule__XIndividualVariable__Group_4__0 : rule__XIndividualVariable__Group_4__0__Impl rule__XIndividualVariable__Group_4__1 ;
    public final void rule__XIndividualVariable__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3593:1: ( rule__XIndividualVariable__Group_4__0__Impl rule__XIndividualVariable__Group_4__1 )
            // InternalXMachine.g:3594:2: rule__XIndividualVariable__Group_4__0__Impl rule__XIndividualVariable__Group_4__1
            {
            pushFollow(FOLLOW_20);
            rule__XIndividualVariable__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group_4__0"


    // $ANTLR start "rule__XIndividualVariable__Group_4__0__Impl"
    // InternalXMachine.g:3601:1: rule__XIndividualVariable__Group_4__0__Impl : ( ':' ) ;
    public final void rule__XIndividualVariable__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3605:1: ( ( ':' ) )
            // InternalXMachine.g:3606:1: ( ':' )
            {
            // InternalXMachine.g:3606:1: ( ':' )
            // InternalXMachine.g:3607:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getColonKeyword_4_0()); 
            }
            match(input,107,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getColonKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group_4__0__Impl"


    // $ANTLR start "rule__XIndividualVariable__Group_4__1"
    // InternalXMachine.g:3616:1: rule__XIndividualVariable__Group_4__1 : rule__XIndividualVariable__Group_4__1__Impl ;
    public final void rule__XIndividualVariable__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3620:1: ( rule__XIndividualVariable__Group_4__1__Impl )
            // InternalXMachine.g:3621:2: rule__XIndividualVariable__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group_4__1"


    // $ANTLR start "rule__XIndividualVariable__Group_4__1__Impl"
    // InternalXMachine.g:3627:1: rule__XIndividualVariable__Group_4__1__Impl : ( ( rule__XIndividualVariable__TypeAssignment_4_1 ) ) ;
    public final void rule__XIndividualVariable__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3631:1: ( ( ( rule__XIndividualVariable__TypeAssignment_4_1 ) ) )
            // InternalXMachine.g:3632:1: ( ( rule__XIndividualVariable__TypeAssignment_4_1 ) )
            {
            // InternalXMachine.g:3632:1: ( ( rule__XIndividualVariable__TypeAssignment_4_1 ) )
            // InternalXMachine.g:3633:2: ( rule__XIndividualVariable__TypeAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getTypeAssignment_4_1()); 
            }
            // InternalXMachine.g:3634:2: ( rule__XIndividualVariable__TypeAssignment_4_1 )
            // InternalXMachine.g:3634:3: rule__XIndividualVariable__TypeAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__TypeAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getTypeAssignment_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group_4__1__Impl"


    // $ANTLR start "rule__XIndividualVariable__Group_5__0"
    // InternalXMachine.g:3643:1: rule__XIndividualVariable__Group_5__0 : rule__XIndividualVariable__Group_5__0__Impl rule__XIndividualVariable__Group_5__1 ;
    public final void rule__XIndividualVariable__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3647:1: ( rule__XIndividualVariable__Group_5__0__Impl rule__XIndividualVariable__Group_5__1 )
            // InternalXMachine.g:3648:2: rule__XIndividualVariable__Group_5__0__Impl rule__XIndividualVariable__Group_5__1
            {
            pushFollow(FOLLOW_21);
            rule__XIndividualVariable__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group_5__0"


    // $ANTLR start "rule__XIndividualVariable__Group_5__0__Impl"
    // InternalXMachine.g:3655:1: rule__XIndividualVariable__Group_5__0__Impl : ( '=' ) ;
    public final void rule__XIndividualVariable__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3659:1: ( ( '=' ) )
            // InternalXMachine.g:3660:1: ( '=' )
            {
            // InternalXMachine.g:3660:1: ( '=' )
            // InternalXMachine.g:3661:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getEqualsSignKeyword_5_0()); 
            }
            match(input,97,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getEqualsSignKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group_5__0__Impl"


    // $ANTLR start "rule__XIndividualVariable__Group_5__1"
    // InternalXMachine.g:3670:1: rule__XIndividualVariable__Group_5__1 : rule__XIndividualVariable__Group_5__1__Impl ;
    public final void rule__XIndividualVariable__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3674:1: ( rule__XIndividualVariable__Group_5__1__Impl )
            // InternalXMachine.g:3675:2: rule__XIndividualVariable__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group_5__1"


    // $ANTLR start "rule__XIndividualVariable__Group_5__1__Impl"
    // InternalXMachine.g:3681:1: rule__XIndividualVariable__Group_5__1__Impl : ( ( rule__XIndividualVariable__ValueAssignment_5_1 ) ) ;
    public final void rule__XIndividualVariable__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3685:1: ( ( ( rule__XIndividualVariable__ValueAssignment_5_1 ) ) )
            // InternalXMachine.g:3686:1: ( ( rule__XIndividualVariable__ValueAssignment_5_1 ) )
            {
            // InternalXMachine.g:3686:1: ( ( rule__XIndividualVariable__ValueAssignment_5_1 ) )
            // InternalXMachine.g:3687:2: ( rule__XIndividualVariable__ValueAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getValueAssignment_5_1()); 
            }
            // InternalXMachine.g:3688:2: ( rule__XIndividualVariable__ValueAssignment_5_1 )
            // InternalXMachine.g:3688:3: rule__XIndividualVariable__ValueAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__ValueAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getValueAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group_5__1__Impl"


    // $ANTLR start "rule__XIndividualVariable__Group_6__0"
    // InternalXMachine.g:3697:1: rule__XIndividualVariable__Group_6__0 : rule__XIndividualVariable__Group_6__0__Impl rule__XIndividualVariable__Group_6__1 ;
    public final void rule__XIndividualVariable__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3701:1: ( rule__XIndividualVariable__Group_6__0__Impl rule__XIndividualVariable__Group_6__1 )
            // InternalXMachine.g:3702:2: rule__XIndividualVariable__Group_6__0__Impl rule__XIndividualVariable__Group_6__1
            {
            pushFollow(FOLLOW_5);
            rule__XIndividualVariable__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group_6__0"


    // $ANTLR start "rule__XIndividualVariable__Group_6__0__Impl"
    // InternalXMachine.g:3709:1: rule__XIndividualVariable__Group_6__0__Impl : ( 'visible' ) ;
    public final void rule__XIndividualVariable__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3713:1: ( ( 'visible' ) )
            // InternalXMachine.g:3714:1: ( 'visible' )
            {
            // InternalXMachine.g:3714:1: ( 'visible' )
            // InternalXMachine.g:3715:2: 'visible'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getVisibleKeyword_6_0()); 
            }
            match(input,194,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getVisibleKeyword_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group_6__0__Impl"


    // $ANTLR start "rule__XIndividualVariable__Group_6__1"
    // InternalXMachine.g:3724:1: rule__XIndividualVariable__Group_6__1 : rule__XIndividualVariable__Group_6__1__Impl ;
    public final void rule__XIndividualVariable__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3728:1: ( rule__XIndividualVariable__Group_6__1__Impl )
            // InternalXMachine.g:3729:2: rule__XIndividualVariable__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XIndividualVariable__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group_6__1"


    // $ANTLR start "rule__XIndividualVariable__Group_6__1__Impl"
    // InternalXMachine.g:3735:1: rule__XIndividualVariable__Group_6__1__Impl : ( ( ( rule__XIndividualVariable__AgentsAssignment_6_1 ) ) ( ( rule__XIndividualVariable__AgentsAssignment_6_1 )* ) ) ;
    public final void rule__XIndividualVariable__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3739:1: ( ( ( ( rule__XIndividualVariable__AgentsAssignment_6_1 ) ) ( ( rule__XIndividualVariable__AgentsAssignment_6_1 )* ) ) )
            // InternalXMachine.g:3740:1: ( ( ( rule__XIndividualVariable__AgentsAssignment_6_1 ) ) ( ( rule__XIndividualVariable__AgentsAssignment_6_1 )* ) )
            {
            // InternalXMachine.g:3740:1: ( ( ( rule__XIndividualVariable__AgentsAssignment_6_1 ) ) ( ( rule__XIndividualVariable__AgentsAssignment_6_1 )* ) )
            // InternalXMachine.g:3741:2: ( ( rule__XIndividualVariable__AgentsAssignment_6_1 ) ) ( ( rule__XIndividualVariable__AgentsAssignment_6_1 )* )
            {
            // InternalXMachine.g:3741:2: ( ( rule__XIndividualVariable__AgentsAssignment_6_1 ) )
            // InternalXMachine.g:3742:3: ( rule__XIndividualVariable__AgentsAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getAgentsAssignment_6_1()); 
            }
            // InternalXMachine.g:3743:3: ( rule__XIndividualVariable__AgentsAssignment_6_1 )
            // InternalXMachine.g:3743:4: rule__XIndividualVariable__AgentsAssignment_6_1
            {
            pushFollow(FOLLOW_9);
            rule__XIndividualVariable__AgentsAssignment_6_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getAgentsAssignment_6_1()); 
            }

            }

            // InternalXMachine.g:3746:2: ( ( rule__XIndividualVariable__AgentsAssignment_6_1 )* )
            // InternalXMachine.g:3747:3: ( rule__XIndividualVariable__AgentsAssignment_6_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getAgentsAssignment_6_1()); 
            }
            // InternalXMachine.g:3748:3: ( rule__XIndividualVariable__AgentsAssignment_6_1 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_ID) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalXMachine.g:3748:4: rule__XIndividualVariable__AgentsAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__XIndividualVariable__AgentsAssignment_6_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getAgentsAssignment_6_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__Group_6__1__Impl"


    // $ANTLR start "rule__XType__Group__0"
    // InternalXMachine.g:3758:1: rule__XType__Group__0 : rule__XType__Group__0__Impl rule__XType__Group__1 ;
    public final void rule__XType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3762:1: ( rule__XType__Group__0__Impl rule__XType__Group__1 )
            // InternalXMachine.g:3763:2: rule__XType__Group__0__Impl rule__XType__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__XType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XType__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group__0"


    // $ANTLR start "rule__XType__Group__0__Impl"
    // InternalXMachine.g:3770:1: rule__XType__Group__0__Impl : ( ruleXTypePrimitive ) ;
    public final void rule__XType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3774:1: ( ( ruleXTypePrimitive ) )
            // InternalXMachine.g:3775:1: ( ruleXTypePrimitive )
            {
            // InternalXMachine.g:3775:1: ( ruleXTypePrimitive )
            // InternalXMachine.g:3776:2: ruleXTypePrimitive
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypeAccess().getXTypePrimitiveParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXTypePrimitive();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypeAccess().getXTypePrimitiveParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group__0__Impl"


    // $ANTLR start "rule__XType__Group__1"
    // InternalXMachine.g:3785:1: rule__XType__Group__1 : rule__XType__Group__1__Impl ;
    public final void rule__XType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3789:1: ( rule__XType__Group__1__Impl )
            // InternalXMachine.g:3790:2: rule__XType__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group__1"


    // $ANTLR start "rule__XType__Group__1__Impl"
    // InternalXMachine.g:3796:1: rule__XType__Group__1__Impl : ( ( rule__XType__Group_1__0 )* ) ;
    public final void rule__XType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3800:1: ( ( ( rule__XType__Group_1__0 )* ) )
            // InternalXMachine.g:3801:1: ( ( rule__XType__Group_1__0 )* )
            {
            // InternalXMachine.g:3801:1: ( ( rule__XType__Group_1__0 )* )
            // InternalXMachine.g:3802:2: ( rule__XType__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypeAccess().getGroup_1()); 
            }
            // InternalXMachine.g:3803:2: ( rule__XType__Group_1__0 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=18 && LA44_0<=41)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalXMachine.g:3803:3: rule__XType__Group_1__0
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__XType__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypeAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group__1__Impl"


    // $ANTLR start "rule__XType__Group_1__0"
    // InternalXMachine.g:3812:1: rule__XType__Group_1__0 : rule__XType__Group_1__0__Impl rule__XType__Group_1__1 ;
    public final void rule__XType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3816:1: ( rule__XType__Group_1__0__Impl rule__XType__Group_1__1 )
            // InternalXMachine.g:3817:2: rule__XType__Group_1__0__Impl rule__XType__Group_1__1
            {
            pushFollow(FOLLOW_20);
            rule__XType__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XType__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_1__0"


    // $ANTLR start "rule__XType__Group_1__0__Impl"
    // InternalXMachine.g:3824:1: rule__XType__Group_1__0__Impl : ( ruleXTYPEOPERATOR ) ;
    public final void rule__XType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3828:1: ( ( ruleXTYPEOPERATOR ) )
            // InternalXMachine.g:3829:1: ( ruleXTYPEOPERATOR )
            {
            // InternalXMachine.g:3829:1: ( ruleXTYPEOPERATOR )
            // InternalXMachine.g:3830:2: ruleXTYPEOPERATOR
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypeAccess().getXTYPEOPERATORParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXTYPEOPERATOR();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypeAccess().getXTYPEOPERATORParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_1__0__Impl"


    // $ANTLR start "rule__XType__Group_1__1"
    // InternalXMachine.g:3839:1: rule__XType__Group_1__1 : rule__XType__Group_1__1__Impl ;
    public final void rule__XType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3843:1: ( rule__XType__Group_1__1__Impl )
            // InternalXMachine.g:3844:2: rule__XType__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XType__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_1__1"


    // $ANTLR start "rule__XType__Group_1__1__Impl"
    // InternalXMachine.g:3850:1: rule__XType__Group_1__1__Impl : ( ruleXTypePrimitive ) ;
    public final void rule__XType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3854:1: ( ( ruleXTypePrimitive ) )
            // InternalXMachine.g:3855:1: ( ruleXTypePrimitive )
            {
            // InternalXMachine.g:3855:1: ( ruleXTypePrimitive )
            // InternalXMachine.g:3856:2: ruleXTypePrimitive
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypeAccess().getXTypePrimitiveParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleXTypePrimitive();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypeAccess().getXTypePrimitiveParserRuleCall_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_1__1__Impl"


    // $ANTLR start "rule__XTypePrimitive__Group_5__0"
    // InternalXMachine.g:3866:1: rule__XTypePrimitive__Group_5__0 : rule__XTypePrimitive__Group_5__0__Impl rule__XTypePrimitive__Group_5__1 ;
    public final void rule__XTypePrimitive__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3870:1: ( rule__XTypePrimitive__Group_5__0__Impl rule__XTypePrimitive__Group_5__1 )
            // InternalXMachine.g:3871:2: rule__XTypePrimitive__Group_5__0__Impl rule__XTypePrimitive__Group_5__1
            {
            pushFollow(FOLLOW_20);
            rule__XTypePrimitive__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XTypePrimitive__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_5__0"


    // $ANTLR start "rule__XTypePrimitive__Group_5__0__Impl"
    // InternalXMachine.g:3878:1: rule__XTypePrimitive__Group_5__0__Impl : ( '(' ) ;
    public final void rule__XTypePrimitive__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3882:1: ( ( '(' ) )
            // InternalXMachine.g:3883:1: ( '(' )
            {
            // InternalXMachine.g:3883:1: ( '(' )
            // InternalXMachine.g:3884:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypePrimitiveAccess().getLeftParenthesisKeyword_5_0()); 
            }
            match(input,74,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypePrimitiveAccess().getLeftParenthesisKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_5__0__Impl"


    // $ANTLR start "rule__XTypePrimitive__Group_5__1"
    // InternalXMachine.g:3893:1: rule__XTypePrimitive__Group_5__1 : rule__XTypePrimitive__Group_5__1__Impl rule__XTypePrimitive__Group_5__2 ;
    public final void rule__XTypePrimitive__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3897:1: ( rule__XTypePrimitive__Group_5__1__Impl rule__XTypePrimitive__Group_5__2 )
            // InternalXMachine.g:3898:2: rule__XTypePrimitive__Group_5__1__Impl rule__XTypePrimitive__Group_5__2
            {
            pushFollow(FOLLOW_24);
            rule__XTypePrimitive__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XTypePrimitive__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_5__1"


    // $ANTLR start "rule__XTypePrimitive__Group_5__1__Impl"
    // InternalXMachine.g:3905:1: rule__XTypePrimitive__Group_5__1__Impl : ( ruleXType ) ;
    public final void rule__XTypePrimitive__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3909:1: ( ( ruleXType ) )
            // InternalXMachine.g:3910:1: ( ruleXType )
            {
            // InternalXMachine.g:3910:1: ( ruleXType )
            // InternalXMachine.g:3911:2: ruleXType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypePrimitiveAccess().getXTypeParserRuleCall_5_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleXType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypePrimitiveAccess().getXTypeParserRuleCall_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_5__1__Impl"


    // $ANTLR start "rule__XTypePrimitive__Group_5__2"
    // InternalXMachine.g:3920:1: rule__XTypePrimitive__Group_5__2 : rule__XTypePrimitive__Group_5__2__Impl ;
    public final void rule__XTypePrimitive__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3924:1: ( rule__XTypePrimitive__Group_5__2__Impl )
            // InternalXMachine.g:3925:2: rule__XTypePrimitive__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XTypePrimitive__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_5__2"


    // $ANTLR start "rule__XTypePrimitive__Group_5__2__Impl"
    // InternalXMachine.g:3931:1: rule__XTypePrimitive__Group_5__2__Impl : ( ')' ) ;
    public final void rule__XTypePrimitive__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3935:1: ( ( ')' ) )
            // InternalXMachine.g:3936:1: ( ')' )
            {
            // InternalXMachine.g:3936:1: ( ')' )
            // InternalXMachine.g:3937:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypePrimitiveAccess().getRightParenthesisKeyword_5_2()); 
            }
            match(input,75,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypePrimitiveAccess().getRightParenthesisKeyword_5_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_5__2__Impl"


    // $ANTLR start "rule__XTypePrimitive__Group_6__0"
    // InternalXMachine.g:3947:1: rule__XTypePrimitive__Group_6__0 : rule__XTypePrimitive__Group_6__0__Impl rule__XTypePrimitive__Group_6__1 ;
    public final void rule__XTypePrimitive__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3951:1: ( rule__XTypePrimitive__Group_6__0__Impl rule__XTypePrimitive__Group_6__1 )
            // InternalXMachine.g:3952:2: rule__XTypePrimitive__Group_6__0__Impl rule__XTypePrimitive__Group_6__1
            {
            pushFollow(FOLLOW_25);
            rule__XTypePrimitive__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XTypePrimitive__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_6__0"


    // $ANTLR start "rule__XTypePrimitive__Group_6__0__Impl"
    // InternalXMachine.g:3959:1: rule__XTypePrimitive__Group_6__0__Impl : ( '\\u2119' ) ;
    public final void rule__XTypePrimitive__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3963:1: ( ( '\\u2119' ) )
            // InternalXMachine.g:3964:1: ( '\\u2119' )
            {
            // InternalXMachine.g:3964:1: ( '\\u2119' )
            // InternalXMachine.g:3965:2: '\\u2119'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalPKeyword_6_0()); 
            }
            match(input,71,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalPKeyword_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_6__0__Impl"


    // $ANTLR start "rule__XTypePrimitive__Group_6__1"
    // InternalXMachine.g:3974:1: rule__XTypePrimitive__Group_6__1 : rule__XTypePrimitive__Group_6__1__Impl rule__XTypePrimitive__Group_6__2 ;
    public final void rule__XTypePrimitive__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3978:1: ( rule__XTypePrimitive__Group_6__1__Impl rule__XTypePrimitive__Group_6__2 )
            // InternalXMachine.g:3979:2: rule__XTypePrimitive__Group_6__1__Impl rule__XTypePrimitive__Group_6__2
            {
            pushFollow(FOLLOW_20);
            rule__XTypePrimitive__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XTypePrimitive__Group_6__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_6__1"


    // $ANTLR start "rule__XTypePrimitive__Group_6__1__Impl"
    // InternalXMachine.g:3986:1: rule__XTypePrimitive__Group_6__1__Impl : ( '(' ) ;
    public final void rule__XTypePrimitive__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:3990:1: ( ( '(' ) )
            // InternalXMachine.g:3991:1: ( '(' )
            {
            // InternalXMachine.g:3991:1: ( '(' )
            // InternalXMachine.g:3992:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypePrimitiveAccess().getLeftParenthesisKeyword_6_1()); 
            }
            match(input,74,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypePrimitiveAccess().getLeftParenthesisKeyword_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_6__1__Impl"


    // $ANTLR start "rule__XTypePrimitive__Group_6__2"
    // InternalXMachine.g:4001:1: rule__XTypePrimitive__Group_6__2 : rule__XTypePrimitive__Group_6__2__Impl rule__XTypePrimitive__Group_6__3 ;
    public final void rule__XTypePrimitive__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4005:1: ( rule__XTypePrimitive__Group_6__2__Impl rule__XTypePrimitive__Group_6__3 )
            // InternalXMachine.g:4006:2: rule__XTypePrimitive__Group_6__2__Impl rule__XTypePrimitive__Group_6__3
            {
            pushFollow(FOLLOW_24);
            rule__XTypePrimitive__Group_6__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XTypePrimitive__Group_6__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_6__2"


    // $ANTLR start "rule__XTypePrimitive__Group_6__2__Impl"
    // InternalXMachine.g:4013:1: rule__XTypePrimitive__Group_6__2__Impl : ( ruleXType ) ;
    public final void rule__XTypePrimitive__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4017:1: ( ( ruleXType ) )
            // InternalXMachine.g:4018:1: ( ruleXType )
            {
            // InternalXMachine.g:4018:1: ( ruleXType )
            // InternalXMachine.g:4019:2: ruleXType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypePrimitiveAccess().getXTypeParserRuleCall_6_2()); 
            }
            pushFollow(FOLLOW_2);
            ruleXType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypePrimitiveAccess().getXTypeParserRuleCall_6_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_6__2__Impl"


    // $ANTLR start "rule__XTypePrimitive__Group_6__3"
    // InternalXMachine.g:4028:1: rule__XTypePrimitive__Group_6__3 : rule__XTypePrimitive__Group_6__3__Impl ;
    public final void rule__XTypePrimitive__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4032:1: ( rule__XTypePrimitive__Group_6__3__Impl )
            // InternalXMachine.g:4033:2: rule__XTypePrimitive__Group_6__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XTypePrimitive__Group_6__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_6__3"


    // $ANTLR start "rule__XTypePrimitive__Group_6__3__Impl"
    // InternalXMachine.g:4039:1: rule__XTypePrimitive__Group_6__3__Impl : ( ')' ) ;
    public final void rule__XTypePrimitive__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4043:1: ( ( ')' ) )
            // InternalXMachine.g:4044:1: ( ')' )
            {
            // InternalXMachine.g:4044:1: ( ')' )
            // InternalXMachine.g:4045:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypePrimitiveAccess().getRightParenthesisKeyword_6_3()); 
            }
            match(input,75,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypePrimitiveAccess().getRightParenthesisKeyword_6_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_6__3__Impl"


    // $ANTLR start "rule__XTypePrimitive__Group_7__0"
    // InternalXMachine.g:4055:1: rule__XTypePrimitive__Group_7__0 : rule__XTypePrimitive__Group_7__0__Impl rule__XTypePrimitive__Group_7__1 ;
    public final void rule__XTypePrimitive__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4059:1: ( rule__XTypePrimitive__Group_7__0__Impl rule__XTypePrimitive__Group_7__1 )
            // InternalXMachine.g:4060:2: rule__XTypePrimitive__Group_7__0__Impl rule__XTypePrimitive__Group_7__1
            {
            pushFollow(FOLLOW_25);
            rule__XTypePrimitive__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XTypePrimitive__Group_7__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_7__0"


    // $ANTLR start "rule__XTypePrimitive__Group_7__0__Impl"
    // InternalXMachine.g:4067:1: rule__XTypePrimitive__Group_7__0__Impl : ( '\\u21191' ) ;
    public final void rule__XTypePrimitive__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4071:1: ( ( '\\u21191' ) )
            // InternalXMachine.g:4072:1: ( '\\u21191' )
            {
            // InternalXMachine.g:4072:1: ( '\\u21191' )
            // InternalXMachine.g:4073:2: '\\u21191'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalPDigitOneKeyword_7_0()); 
            }
            match(input,69,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalPDigitOneKeyword_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_7__0__Impl"


    // $ANTLR start "rule__XTypePrimitive__Group_7__1"
    // InternalXMachine.g:4082:1: rule__XTypePrimitive__Group_7__1 : rule__XTypePrimitive__Group_7__1__Impl rule__XTypePrimitive__Group_7__2 ;
    public final void rule__XTypePrimitive__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4086:1: ( rule__XTypePrimitive__Group_7__1__Impl rule__XTypePrimitive__Group_7__2 )
            // InternalXMachine.g:4087:2: rule__XTypePrimitive__Group_7__1__Impl rule__XTypePrimitive__Group_7__2
            {
            pushFollow(FOLLOW_20);
            rule__XTypePrimitive__Group_7__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XTypePrimitive__Group_7__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_7__1"


    // $ANTLR start "rule__XTypePrimitive__Group_7__1__Impl"
    // InternalXMachine.g:4094:1: rule__XTypePrimitive__Group_7__1__Impl : ( '(' ) ;
    public final void rule__XTypePrimitive__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4098:1: ( ( '(' ) )
            // InternalXMachine.g:4099:1: ( '(' )
            {
            // InternalXMachine.g:4099:1: ( '(' )
            // InternalXMachine.g:4100:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypePrimitiveAccess().getLeftParenthesisKeyword_7_1()); 
            }
            match(input,74,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypePrimitiveAccess().getLeftParenthesisKeyword_7_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_7__1__Impl"


    // $ANTLR start "rule__XTypePrimitive__Group_7__2"
    // InternalXMachine.g:4109:1: rule__XTypePrimitive__Group_7__2 : rule__XTypePrimitive__Group_7__2__Impl rule__XTypePrimitive__Group_7__3 ;
    public final void rule__XTypePrimitive__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4113:1: ( rule__XTypePrimitive__Group_7__2__Impl rule__XTypePrimitive__Group_7__3 )
            // InternalXMachine.g:4114:2: rule__XTypePrimitive__Group_7__2__Impl rule__XTypePrimitive__Group_7__3
            {
            pushFollow(FOLLOW_24);
            rule__XTypePrimitive__Group_7__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XTypePrimitive__Group_7__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_7__2"


    // $ANTLR start "rule__XTypePrimitive__Group_7__2__Impl"
    // InternalXMachine.g:4121:1: rule__XTypePrimitive__Group_7__2__Impl : ( ruleXType ) ;
    public final void rule__XTypePrimitive__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4125:1: ( ( ruleXType ) )
            // InternalXMachine.g:4126:1: ( ruleXType )
            {
            // InternalXMachine.g:4126:1: ( ruleXType )
            // InternalXMachine.g:4127:2: ruleXType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypePrimitiveAccess().getXTypeParserRuleCall_7_2()); 
            }
            pushFollow(FOLLOW_2);
            ruleXType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypePrimitiveAccess().getXTypeParserRuleCall_7_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_7__2__Impl"


    // $ANTLR start "rule__XTypePrimitive__Group_7__3"
    // InternalXMachine.g:4136:1: rule__XTypePrimitive__Group_7__3 : rule__XTypePrimitive__Group_7__3__Impl ;
    public final void rule__XTypePrimitive__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4140:1: ( rule__XTypePrimitive__Group_7__3__Impl )
            // InternalXMachine.g:4141:2: rule__XTypePrimitive__Group_7__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XTypePrimitive__Group_7__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_7__3"


    // $ANTLR start "rule__XTypePrimitive__Group_7__3__Impl"
    // InternalXMachine.g:4147:1: rule__XTypePrimitive__Group_7__3__Impl : ( ')' ) ;
    public final void rule__XTypePrimitive__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4151:1: ( ( ')' ) )
            // InternalXMachine.g:4152:1: ( ')' )
            {
            // InternalXMachine.g:4152:1: ( ')' )
            // InternalXMachine.g:4153:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXTypePrimitiveAccess().getRightParenthesisKeyword_7_3()); 
            }
            match(input,75,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXTypePrimitiveAccess().getRightParenthesisKeyword_7_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XTypePrimitive__Group_7__3__Impl"


    // $ANTLR start "rule__XMultipleInvariant__Group__0"
    // InternalXMachine.g:4163:1: rule__XMultipleInvariant__Group__0 : rule__XMultipleInvariant__Group__0__Impl rule__XMultipleInvariant__Group__1 ;
    public final void rule__XMultipleInvariant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4167:1: ( rule__XMultipleInvariant__Group__0__Impl rule__XMultipleInvariant__Group__1 )
            // InternalXMachine.g:4168:2: rule__XMultipleInvariant__Group__0__Impl rule__XMultipleInvariant__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__XMultipleInvariant__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XMultipleInvariant__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleInvariant__Group__0"


    // $ANTLR start "rule__XMultipleInvariant__Group__0__Impl"
    // InternalXMachine.g:4175:1: rule__XMultipleInvariant__Group__0__Impl : ( () ) ;
    public final void rule__XMultipleInvariant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4179:1: ( ( () ) )
            // InternalXMachine.g:4180:1: ( () )
            {
            // InternalXMachine.g:4180:1: ( () )
            // InternalXMachine.g:4181:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXMultipleInvariantAccess().getInvariantAction_0()); 
            }
            // InternalXMachine.g:4182:2: ()
            // InternalXMachine.g:4182:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXMultipleInvariantAccess().getInvariantAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleInvariant__Group__0__Impl"


    // $ANTLR start "rule__XMultipleInvariant__Group__1"
    // InternalXMachine.g:4190:1: rule__XMultipleInvariant__Group__1 : rule__XMultipleInvariant__Group__1__Impl rule__XMultipleInvariant__Group__2 ;
    public final void rule__XMultipleInvariant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4194:1: ( rule__XMultipleInvariant__Group__1__Impl rule__XMultipleInvariant__Group__2 )
            // InternalXMachine.g:4195:2: rule__XMultipleInvariant__Group__1__Impl rule__XMultipleInvariant__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__XMultipleInvariant__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XMultipleInvariant__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleInvariant__Group__1"


    // $ANTLR start "rule__XMultipleInvariant__Group__1__Impl"
    // InternalXMachine.g:4202:1: rule__XMultipleInvariant__Group__1__Impl : ( ( rule__XMultipleInvariant__CommentAssignment_1 )? ) ;
    public final void rule__XMultipleInvariant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4206:1: ( ( ( rule__XMultipleInvariant__CommentAssignment_1 )? ) )
            // InternalXMachine.g:4207:1: ( ( rule__XMultipleInvariant__CommentAssignment_1 )? )
            {
            // InternalXMachine.g:4207:1: ( ( rule__XMultipleInvariant__CommentAssignment_1 )? )
            // InternalXMachine.g:4208:2: ( rule__XMultipleInvariant__CommentAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXMultipleInvariantAccess().getCommentAssignment_1()); 
            }
            // InternalXMachine.g:4209:2: ( rule__XMultipleInvariant__CommentAssignment_1 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_STRING) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalXMachine.g:4209:3: rule__XMultipleInvariant__CommentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XMultipleInvariant__CommentAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXMultipleInvariantAccess().getCommentAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleInvariant__Group__1__Impl"


    // $ANTLR start "rule__XMultipleInvariant__Group__2"
    // InternalXMachine.g:4217:1: rule__XMultipleInvariant__Group__2 : rule__XMultipleInvariant__Group__2__Impl rule__XMultipleInvariant__Group__3 ;
    public final void rule__XMultipleInvariant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4221:1: ( rule__XMultipleInvariant__Group__2__Impl rule__XMultipleInvariant__Group__3 )
            // InternalXMachine.g:4222:2: rule__XMultipleInvariant__Group__2__Impl rule__XMultipleInvariant__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__XMultipleInvariant__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XMultipleInvariant__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleInvariant__Group__2"


    // $ANTLR start "rule__XMultipleInvariant__Group__2__Impl"
    // InternalXMachine.g:4229:1: rule__XMultipleInvariant__Group__2__Impl : ( ( rule__XMultipleInvariant__NameAssignment_2 ) ) ;
    public final void rule__XMultipleInvariant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4233:1: ( ( ( rule__XMultipleInvariant__NameAssignment_2 ) ) )
            // InternalXMachine.g:4234:1: ( ( rule__XMultipleInvariant__NameAssignment_2 ) )
            {
            // InternalXMachine.g:4234:1: ( ( rule__XMultipleInvariant__NameAssignment_2 ) )
            // InternalXMachine.g:4235:2: ( rule__XMultipleInvariant__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXMultipleInvariantAccess().getNameAssignment_2()); 
            }
            // InternalXMachine.g:4236:2: ( rule__XMultipleInvariant__NameAssignment_2 )
            // InternalXMachine.g:4236:3: rule__XMultipleInvariant__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__XMultipleInvariant__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXMultipleInvariantAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleInvariant__Group__2__Impl"


    // $ANTLR start "rule__XMultipleInvariant__Group__3"
    // InternalXMachine.g:4244:1: rule__XMultipleInvariant__Group__3 : rule__XMultipleInvariant__Group__3__Impl ;
    public final void rule__XMultipleInvariant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4248:1: ( rule__XMultipleInvariant__Group__3__Impl )
            // InternalXMachine.g:4249:2: rule__XMultipleInvariant__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XMultipleInvariant__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleInvariant__Group__3"


    // $ANTLR start "rule__XMultipleInvariant__Group__3__Impl"
    // InternalXMachine.g:4255:1: rule__XMultipleInvariant__Group__3__Impl : ( ( rule__XMultipleInvariant__PredicateAssignment_3 ) ) ;
    public final void rule__XMultipleInvariant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4259:1: ( ( ( rule__XMultipleInvariant__PredicateAssignment_3 ) ) )
            // InternalXMachine.g:4260:1: ( ( rule__XMultipleInvariant__PredicateAssignment_3 ) )
            {
            // InternalXMachine.g:4260:1: ( ( rule__XMultipleInvariant__PredicateAssignment_3 ) )
            // InternalXMachine.g:4261:2: ( rule__XMultipleInvariant__PredicateAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXMultipleInvariantAccess().getPredicateAssignment_3()); 
            }
            // InternalXMachine.g:4262:2: ( rule__XMultipleInvariant__PredicateAssignment_3 )
            // InternalXMachine.g:4262:3: rule__XMultipleInvariant__PredicateAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__XMultipleInvariant__PredicateAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXMultipleInvariantAccess().getPredicateAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleInvariant__Group__3__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group__0"
    // InternalXMachine.g:4271:1: rule__XIndividualInvariant__Group__0 : rule__XIndividualInvariant__Group__0__Impl rule__XIndividualInvariant__Group__1 ;
    public final void rule__XIndividualInvariant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4275:1: ( rule__XIndividualInvariant__Group__0__Impl rule__XIndividualInvariant__Group__1 )
            // InternalXMachine.g:4276:2: rule__XIndividualInvariant__Group__0__Impl rule__XIndividualInvariant__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__XIndividualInvariant__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__0"


    // $ANTLR start "rule__XIndividualInvariant__Group__0__Impl"
    // InternalXMachine.g:4283:1: rule__XIndividualInvariant__Group__0__Impl : ( () ) ;
    public final void rule__XIndividualInvariant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4287:1: ( ( () ) )
            // InternalXMachine.g:4288:1: ( () )
            {
            // InternalXMachine.g:4288:1: ( () )
            // InternalXMachine.g:4289:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getCompleteIgnoranceInvariantAction_0()); 
            }
            // InternalXMachine.g:4290:2: ()
            // InternalXMachine.g:4290:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getCompleteIgnoranceInvariantAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__0__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group__1"
    // InternalXMachine.g:4298:1: rule__XIndividualInvariant__Group__1 : rule__XIndividualInvariant__Group__1__Impl rule__XIndividualInvariant__Group__2 ;
    public final void rule__XIndividualInvariant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4302:1: ( rule__XIndividualInvariant__Group__1__Impl rule__XIndividualInvariant__Group__2 )
            // InternalXMachine.g:4303:2: rule__XIndividualInvariant__Group__1__Impl rule__XIndividualInvariant__Group__2
            {
            pushFollow(FOLLOW_26);
            rule__XIndividualInvariant__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__1"


    // $ANTLR start "rule__XIndividualInvariant__Group__1__Impl"
    // InternalXMachine.g:4310:1: rule__XIndividualInvariant__Group__1__Impl : ( ( rule__XIndividualInvariant__CommentAssignment_1 )? ) ;
    public final void rule__XIndividualInvariant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4314:1: ( ( ( rule__XIndividualInvariant__CommentAssignment_1 )? ) )
            // InternalXMachine.g:4315:1: ( ( rule__XIndividualInvariant__CommentAssignment_1 )? )
            {
            // InternalXMachine.g:4315:1: ( ( rule__XIndividualInvariant__CommentAssignment_1 )? )
            // InternalXMachine.g:4316:2: ( rule__XIndividualInvariant__CommentAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getCommentAssignment_1()); 
            }
            // InternalXMachine.g:4317:2: ( rule__XIndividualInvariant__CommentAssignment_1 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_STRING) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalXMachine.g:4317:3: rule__XIndividualInvariant__CommentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XIndividualInvariant__CommentAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getCommentAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__1__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group__2"
    // InternalXMachine.g:4325:1: rule__XIndividualInvariant__Group__2 : rule__XIndividualInvariant__Group__2__Impl rule__XIndividualInvariant__Group__3 ;
    public final void rule__XIndividualInvariant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4329:1: ( rule__XIndividualInvariant__Group__2__Impl rule__XIndividualInvariant__Group__3 )
            // InternalXMachine.g:4330:2: rule__XIndividualInvariant__Group__2__Impl rule__XIndividualInvariant__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__XIndividualInvariant__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__2"


    // $ANTLR start "rule__XIndividualInvariant__Group__2__Impl"
    // InternalXMachine.g:4337:1: rule__XIndividualInvariant__Group__2__Impl : ( 'complete' ) ;
    public final void rule__XIndividualInvariant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4341:1: ( ( 'complete' ) )
            // InternalXMachine.g:4342:1: ( 'complete' )
            {
            // InternalXMachine.g:4342:1: ( 'complete' )
            // InternalXMachine.g:4343:2: 'complete'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getCompleteKeyword_2()); 
            }
            match(input,195,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getCompleteKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__2__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group__3"
    // InternalXMachine.g:4352:1: rule__XIndividualInvariant__Group__3 : rule__XIndividualInvariant__Group__3__Impl rule__XIndividualInvariant__Group__4 ;
    public final void rule__XIndividualInvariant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4356:1: ( rule__XIndividualInvariant__Group__3__Impl rule__XIndividualInvariant__Group__4 )
            // InternalXMachine.g:4357:2: rule__XIndividualInvariant__Group__3__Impl rule__XIndividualInvariant__Group__4
            {
            pushFollow(FOLLOW_28);
            rule__XIndividualInvariant__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__3"


    // $ANTLR start "rule__XIndividualInvariant__Group__3__Impl"
    // InternalXMachine.g:4364:1: rule__XIndividualInvariant__Group__3__Impl : ( 'ignorance' ) ;
    public final void rule__XIndividualInvariant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4368:1: ( ( 'ignorance' ) )
            // InternalXMachine.g:4369:1: ( 'ignorance' )
            {
            // InternalXMachine.g:4369:1: ( 'ignorance' )
            // InternalXMachine.g:4370:2: 'ignorance'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getIgnoranceKeyword_3()); 
            }
            match(input,196,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getIgnoranceKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__3__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group__4"
    // InternalXMachine.g:4379:1: rule__XIndividualInvariant__Group__4 : rule__XIndividualInvariant__Group__4__Impl rule__XIndividualInvariant__Group__5 ;
    public final void rule__XIndividualInvariant__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4383:1: ( rule__XIndividualInvariant__Group__4__Impl rule__XIndividualInvariant__Group__5 )
            // InternalXMachine.g:4384:2: rule__XIndividualInvariant__Group__4__Impl rule__XIndividualInvariant__Group__5
            {
            pushFollow(FOLLOW_29);
            rule__XIndividualInvariant__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__4"


    // $ANTLR start "rule__XIndividualInvariant__Group__4__Impl"
    // InternalXMachine.g:4391:1: rule__XIndividualInvariant__Group__4__Impl : ( ( rule__XIndividualInvariant__NameAssignment_4 ) ) ;
    public final void rule__XIndividualInvariant__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4395:1: ( ( ( rule__XIndividualInvariant__NameAssignment_4 ) ) )
            // InternalXMachine.g:4396:1: ( ( rule__XIndividualInvariant__NameAssignment_4 ) )
            {
            // InternalXMachine.g:4396:1: ( ( rule__XIndividualInvariant__NameAssignment_4 ) )
            // InternalXMachine.g:4397:2: ( rule__XIndividualInvariant__NameAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getNameAssignment_4()); 
            }
            // InternalXMachine.g:4398:2: ( rule__XIndividualInvariant__NameAssignment_4 )
            // InternalXMachine.g:4398:3: rule__XIndividualInvariant__NameAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__NameAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getNameAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__4__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group__5"
    // InternalXMachine.g:4406:1: rule__XIndividualInvariant__Group__5 : rule__XIndividualInvariant__Group__5__Impl rule__XIndividualInvariant__Group__6 ;
    public final void rule__XIndividualInvariant__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4410:1: ( rule__XIndividualInvariant__Group__5__Impl rule__XIndividualInvariant__Group__6 )
            // InternalXMachine.g:4411:2: rule__XIndividualInvariant__Group__5__Impl rule__XIndividualInvariant__Group__6
            {
            pushFollow(FOLLOW_29);
            rule__XIndividualInvariant__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__5"


    // $ANTLR start "rule__XIndividualInvariant__Group__5__Impl"
    // InternalXMachine.g:4418:1: rule__XIndividualInvariant__Group__5__Impl : ( ( rule__XIndividualInvariant__Group_5__0 )? ) ;
    public final void rule__XIndividualInvariant__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4422:1: ( ( ( rule__XIndividualInvariant__Group_5__0 )? ) )
            // InternalXMachine.g:4423:1: ( ( rule__XIndividualInvariant__Group_5__0 )? )
            {
            // InternalXMachine.g:4423:1: ( ( rule__XIndividualInvariant__Group_5__0 )? )
            // InternalXMachine.g:4424:2: ( rule__XIndividualInvariant__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getGroup_5()); 
            }
            // InternalXMachine.g:4425:2: ( rule__XIndividualInvariant__Group_5__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==200) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalXMachine.g:4425:3: rule__XIndividualInvariant__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XIndividualInvariant__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__5__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group__6"
    // InternalXMachine.g:4433:1: rule__XIndividualInvariant__Group__6 : rule__XIndividualInvariant__Group__6__Impl rule__XIndividualInvariant__Group__7 ;
    public final void rule__XIndividualInvariant__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4437:1: ( rule__XIndividualInvariant__Group__6__Impl rule__XIndividualInvariant__Group__7 )
            // InternalXMachine.g:4438:2: rule__XIndividualInvariant__Group__6__Impl rule__XIndividualInvariant__Group__7
            {
            pushFollow(FOLLOW_30);
            rule__XIndividualInvariant__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__6"


    // $ANTLR start "rule__XIndividualInvariant__Group__6__Impl"
    // InternalXMachine.g:4445:1: rule__XIndividualInvariant__Group__6__Impl : ( 'knows' ) ;
    public final void rule__XIndividualInvariant__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4449:1: ( ( 'knows' ) )
            // InternalXMachine.g:4450:1: ( 'knows' )
            {
            // InternalXMachine.g:4450:1: ( 'knows' )
            // InternalXMachine.g:4451:2: 'knows'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getKnowsKeyword_6()); 
            }
            match(input,197,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getKnowsKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__6__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group__7"
    // InternalXMachine.g:4460:1: rule__XIndividualInvariant__Group__7 : rule__XIndividualInvariant__Group__7__Impl rule__XIndividualInvariant__Group__8 ;
    public final void rule__XIndividualInvariant__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4464:1: ( rule__XIndividualInvariant__Group__7__Impl rule__XIndividualInvariant__Group__8 )
            // InternalXMachine.g:4465:2: rule__XIndividualInvariant__Group__7__Impl rule__XIndividualInvariant__Group__8
            {
            pushFollow(FOLLOW_21);
            rule__XIndividualInvariant__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group__8();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__7"


    // $ANTLR start "rule__XIndividualInvariant__Group__7__Impl"
    // InternalXMachine.g:4472:1: rule__XIndividualInvariant__Group__7__Impl : ( 'only' ) ;
    public final void rule__XIndividualInvariant__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4476:1: ( ( 'only' ) )
            // InternalXMachine.g:4477:1: ( 'only' )
            {
            // InternalXMachine.g:4477:1: ( 'only' )
            // InternalXMachine.g:4478:2: 'only'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getOnlyKeyword_7()); 
            }
            match(input,198,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getOnlyKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__7__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group__8"
    // InternalXMachine.g:4487:1: rule__XIndividualInvariant__Group__8 : rule__XIndividualInvariant__Group__8__Impl rule__XIndividualInvariant__Group__9 ;
    public final void rule__XIndividualInvariant__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4491:1: ( rule__XIndividualInvariant__Group__8__Impl rule__XIndividualInvariant__Group__9 )
            // InternalXMachine.g:4492:2: rule__XIndividualInvariant__Group__8__Impl rule__XIndividualInvariant__Group__9
            {
            pushFollow(FOLLOW_31);
            rule__XIndividualInvariant__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group__9();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__8"


    // $ANTLR start "rule__XIndividualInvariant__Group__8__Impl"
    // InternalXMachine.g:4499:1: rule__XIndividualInvariant__Group__8__Impl : ( ( rule__XIndividualInvariant__FactAssignment_8 ) ) ;
    public final void rule__XIndividualInvariant__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4503:1: ( ( ( rule__XIndividualInvariant__FactAssignment_8 ) ) )
            // InternalXMachine.g:4504:1: ( ( rule__XIndividualInvariant__FactAssignment_8 ) )
            {
            // InternalXMachine.g:4504:1: ( ( rule__XIndividualInvariant__FactAssignment_8 ) )
            // InternalXMachine.g:4505:2: ( rule__XIndividualInvariant__FactAssignment_8 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getFactAssignment_8()); 
            }
            // InternalXMachine.g:4506:2: ( rule__XIndividualInvariant__FactAssignment_8 )
            // InternalXMachine.g:4506:3: rule__XIndividualInvariant__FactAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__FactAssignment_8();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getFactAssignment_8()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__8__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group__9"
    // InternalXMachine.g:4514:1: rule__XIndividualInvariant__Group__9 : rule__XIndividualInvariant__Group__9__Impl rule__XIndividualInvariant__Group__10 ;
    public final void rule__XIndividualInvariant__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4518:1: ( rule__XIndividualInvariant__Group__9__Impl rule__XIndividualInvariant__Group__10 )
            // InternalXMachine.g:4519:2: rule__XIndividualInvariant__Group__9__Impl rule__XIndividualInvariant__Group__10
            {
            pushFollow(FOLLOW_5);
            rule__XIndividualInvariant__Group__9__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group__10();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__9"


    // $ANTLR start "rule__XIndividualInvariant__Group__9__Impl"
    // InternalXMachine.g:4526:1: rule__XIndividualInvariant__Group__9__Impl : ( 'about' ) ;
    public final void rule__XIndividualInvariant__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4530:1: ( ( 'about' ) )
            // InternalXMachine.g:4531:1: ( 'about' )
            {
            // InternalXMachine.g:4531:1: ( 'about' )
            // InternalXMachine.g:4532:2: 'about'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getAboutKeyword_9()); 
            }
            match(input,199,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getAboutKeyword_9()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__9__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group__10"
    // InternalXMachine.g:4541:1: rule__XIndividualInvariant__Group__10 : rule__XIndividualInvariant__Group__10__Impl rule__XIndividualInvariant__Group__11 ;
    public final void rule__XIndividualInvariant__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4545:1: ( rule__XIndividualInvariant__Group__10__Impl rule__XIndividualInvariant__Group__11 )
            // InternalXMachine.g:4546:2: rule__XIndividualInvariant__Group__10__Impl rule__XIndividualInvariant__Group__11
            {
            pushFollow(FOLLOW_32);
            rule__XIndividualInvariant__Group__10__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group__11();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__10"


    // $ANTLR start "rule__XIndividualInvariant__Group__10__Impl"
    // InternalXMachine.g:4553:1: rule__XIndividualInvariant__Group__10__Impl : ( ( ( rule__XIndividualInvariant__VariablesAssignment_10 ) ) ( ( rule__XIndividualInvariant__VariablesAssignment_10 )* ) ) ;
    public final void rule__XIndividualInvariant__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4557:1: ( ( ( ( rule__XIndividualInvariant__VariablesAssignment_10 ) ) ( ( rule__XIndividualInvariant__VariablesAssignment_10 )* ) ) )
            // InternalXMachine.g:4558:1: ( ( ( rule__XIndividualInvariant__VariablesAssignment_10 ) ) ( ( rule__XIndividualInvariant__VariablesAssignment_10 )* ) )
            {
            // InternalXMachine.g:4558:1: ( ( ( rule__XIndividualInvariant__VariablesAssignment_10 ) ) ( ( rule__XIndividualInvariant__VariablesAssignment_10 )* ) )
            // InternalXMachine.g:4559:2: ( ( rule__XIndividualInvariant__VariablesAssignment_10 ) ) ( ( rule__XIndividualInvariant__VariablesAssignment_10 )* )
            {
            // InternalXMachine.g:4559:2: ( ( rule__XIndividualInvariant__VariablesAssignment_10 ) )
            // InternalXMachine.g:4560:3: ( rule__XIndividualInvariant__VariablesAssignment_10 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getVariablesAssignment_10()); 
            }
            // InternalXMachine.g:4561:3: ( rule__XIndividualInvariant__VariablesAssignment_10 )
            // InternalXMachine.g:4561:4: rule__XIndividualInvariant__VariablesAssignment_10
            {
            pushFollow(FOLLOW_9);
            rule__XIndividualInvariant__VariablesAssignment_10();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getVariablesAssignment_10()); 
            }

            }

            // InternalXMachine.g:4564:2: ( ( rule__XIndividualInvariant__VariablesAssignment_10 )* )
            // InternalXMachine.g:4565:3: ( rule__XIndividualInvariant__VariablesAssignment_10 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getVariablesAssignment_10()); 
            }
            // InternalXMachine.g:4566:3: ( rule__XIndividualInvariant__VariablesAssignment_10 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_ID) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalXMachine.g:4566:4: rule__XIndividualInvariant__VariablesAssignment_10
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__XIndividualInvariant__VariablesAssignment_10();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getVariablesAssignment_10()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__10__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group__11"
    // InternalXMachine.g:4575:1: rule__XIndividualInvariant__Group__11 : rule__XIndividualInvariant__Group__11__Impl ;
    public final void rule__XIndividualInvariant__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4579:1: ( rule__XIndividualInvariant__Group__11__Impl )
            // InternalXMachine.g:4580:2: rule__XIndividualInvariant__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group__11__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__11"


    // $ANTLR start "rule__XIndividualInvariant__Group__11__Impl"
    // InternalXMachine.g:4586:1: rule__XIndividualInvariant__Group__11__Impl : ( ( rule__XIndividualInvariant__Group_11__0 )? ) ;
    public final void rule__XIndividualInvariant__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4590:1: ( ( ( rule__XIndividualInvariant__Group_11__0 )? ) )
            // InternalXMachine.g:4591:1: ( ( rule__XIndividualInvariant__Group_11__0 )? )
            {
            // InternalXMachine.g:4591:1: ( ( rule__XIndividualInvariant__Group_11__0 )? )
            // InternalXMachine.g:4592:2: ( rule__XIndividualInvariant__Group_11__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getGroup_11()); 
            }
            // InternalXMachine.g:4593:2: ( rule__XIndividualInvariant__Group_11__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==194) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalXMachine.g:4593:3: rule__XIndividualInvariant__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XIndividualInvariant__Group_11__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getGroup_11()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group__11__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group_5__0"
    // InternalXMachine.g:4602:1: rule__XIndividualInvariant__Group_5__0 : rule__XIndividualInvariant__Group_5__0__Impl rule__XIndividualInvariant__Group_5__1 ;
    public final void rule__XIndividualInvariant__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4606:1: ( rule__XIndividualInvariant__Group_5__0__Impl rule__XIndividualInvariant__Group_5__1 )
            // InternalXMachine.g:4607:2: rule__XIndividualInvariant__Group_5__0__Impl rule__XIndividualInvariant__Group_5__1
            {
            pushFollow(FOLLOW_21);
            rule__XIndividualInvariant__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group_5__0"


    // $ANTLR start "rule__XIndividualInvariant__Group_5__0__Impl"
    // InternalXMachine.g:4614:1: rule__XIndividualInvariant__Group_5__0__Impl : ( 'if' ) ;
    public final void rule__XIndividualInvariant__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4618:1: ( ( 'if' ) )
            // InternalXMachine.g:4619:1: ( 'if' )
            {
            // InternalXMachine.g:4619:1: ( 'if' )
            // InternalXMachine.g:4620:2: 'if'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getIfKeyword_5_0()); 
            }
            match(input,200,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getIfKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group_5__0__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group_5__1"
    // InternalXMachine.g:4629:1: rule__XIndividualInvariant__Group_5__1 : rule__XIndividualInvariant__Group_5__1__Impl rule__XIndividualInvariant__Group_5__2 ;
    public final void rule__XIndividualInvariant__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4633:1: ( rule__XIndividualInvariant__Group_5__1__Impl rule__XIndividualInvariant__Group_5__2 )
            // InternalXMachine.g:4634:2: rule__XIndividualInvariant__Group_5__1__Impl rule__XIndividualInvariant__Group_5__2
            {
            pushFollow(FOLLOW_33);
            rule__XIndividualInvariant__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group_5__1"


    // $ANTLR start "rule__XIndividualInvariant__Group_5__1__Impl"
    // InternalXMachine.g:4641:1: rule__XIndividualInvariant__Group_5__1__Impl : ( ( rule__XIndividualInvariant__ConditionAssignment_5_1 ) ) ;
    public final void rule__XIndividualInvariant__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4645:1: ( ( ( rule__XIndividualInvariant__ConditionAssignment_5_1 ) ) )
            // InternalXMachine.g:4646:1: ( ( rule__XIndividualInvariant__ConditionAssignment_5_1 ) )
            {
            // InternalXMachine.g:4646:1: ( ( rule__XIndividualInvariant__ConditionAssignment_5_1 ) )
            // InternalXMachine.g:4647:2: ( rule__XIndividualInvariant__ConditionAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getConditionAssignment_5_1()); 
            }
            // InternalXMachine.g:4648:2: ( rule__XIndividualInvariant__ConditionAssignment_5_1 )
            // InternalXMachine.g:4648:3: rule__XIndividualInvariant__ConditionAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__ConditionAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getConditionAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group_5__1__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group_5__2"
    // InternalXMachine.g:4656:1: rule__XIndividualInvariant__Group_5__2 : rule__XIndividualInvariant__Group_5__2__Impl ;
    public final void rule__XIndividualInvariant__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4660:1: ( rule__XIndividualInvariant__Group_5__2__Impl )
            // InternalXMachine.g:4661:2: rule__XIndividualInvariant__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group_5__2"


    // $ANTLR start "rule__XIndividualInvariant__Group_5__2__Impl"
    // InternalXMachine.g:4667:1: rule__XIndividualInvariant__Group_5__2__Impl : ( 'then' ) ;
    public final void rule__XIndividualInvariant__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4671:1: ( ( 'then' ) )
            // InternalXMachine.g:4672:1: ( 'then' )
            {
            // InternalXMachine.g:4672:1: ( 'then' )
            // InternalXMachine.g:4673:2: 'then'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getThenKeyword_5_2()); 
            }
            match(input,48,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getThenKeyword_5_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group_5__2__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group_11__0"
    // InternalXMachine.g:4683:1: rule__XIndividualInvariant__Group_11__0 : rule__XIndividualInvariant__Group_11__0__Impl rule__XIndividualInvariant__Group_11__1 ;
    public final void rule__XIndividualInvariant__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4687:1: ( rule__XIndividualInvariant__Group_11__0__Impl rule__XIndividualInvariant__Group_11__1 )
            // InternalXMachine.g:4688:2: rule__XIndividualInvariant__Group_11__0__Impl rule__XIndividualInvariant__Group_11__1
            {
            pushFollow(FOLLOW_5);
            rule__XIndividualInvariant__Group_11__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group_11__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group_11__0"


    // $ANTLR start "rule__XIndividualInvariant__Group_11__0__Impl"
    // InternalXMachine.g:4695:1: rule__XIndividualInvariant__Group_11__0__Impl : ( 'visible' ) ;
    public final void rule__XIndividualInvariant__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4699:1: ( ( 'visible' ) )
            // InternalXMachine.g:4700:1: ( 'visible' )
            {
            // InternalXMachine.g:4700:1: ( 'visible' )
            // InternalXMachine.g:4701:2: 'visible'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getVisibleKeyword_11_0()); 
            }
            match(input,194,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getVisibleKeyword_11_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group_11__0__Impl"


    // $ANTLR start "rule__XIndividualInvariant__Group_11__1"
    // InternalXMachine.g:4710:1: rule__XIndividualInvariant__Group_11__1 : rule__XIndividualInvariant__Group_11__1__Impl ;
    public final void rule__XIndividualInvariant__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4714:1: ( rule__XIndividualInvariant__Group_11__1__Impl )
            // InternalXMachine.g:4715:2: rule__XIndividualInvariant__Group_11__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XIndividualInvariant__Group_11__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group_11__1"


    // $ANTLR start "rule__XIndividualInvariant__Group_11__1__Impl"
    // InternalXMachine.g:4721:1: rule__XIndividualInvariant__Group_11__1__Impl : ( ( ( rule__XIndividualInvariant__AgentsAssignment_11_1 ) ) ( ( rule__XIndividualInvariant__AgentsAssignment_11_1 )* ) ) ;
    public final void rule__XIndividualInvariant__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4725:1: ( ( ( ( rule__XIndividualInvariant__AgentsAssignment_11_1 ) ) ( ( rule__XIndividualInvariant__AgentsAssignment_11_1 )* ) ) )
            // InternalXMachine.g:4726:1: ( ( ( rule__XIndividualInvariant__AgentsAssignment_11_1 ) ) ( ( rule__XIndividualInvariant__AgentsAssignment_11_1 )* ) )
            {
            // InternalXMachine.g:4726:1: ( ( ( rule__XIndividualInvariant__AgentsAssignment_11_1 ) ) ( ( rule__XIndividualInvariant__AgentsAssignment_11_1 )* ) )
            // InternalXMachine.g:4727:2: ( ( rule__XIndividualInvariant__AgentsAssignment_11_1 ) ) ( ( rule__XIndividualInvariant__AgentsAssignment_11_1 )* )
            {
            // InternalXMachine.g:4727:2: ( ( rule__XIndividualInvariant__AgentsAssignment_11_1 ) )
            // InternalXMachine.g:4728:3: ( rule__XIndividualInvariant__AgentsAssignment_11_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getAgentsAssignment_11_1()); 
            }
            // InternalXMachine.g:4729:3: ( rule__XIndividualInvariant__AgentsAssignment_11_1 )
            // InternalXMachine.g:4729:4: rule__XIndividualInvariant__AgentsAssignment_11_1
            {
            pushFollow(FOLLOW_9);
            rule__XIndividualInvariant__AgentsAssignment_11_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getAgentsAssignment_11_1()); 
            }

            }

            // InternalXMachine.g:4732:2: ( ( rule__XIndividualInvariant__AgentsAssignment_11_1 )* )
            // InternalXMachine.g:4733:3: ( rule__XIndividualInvariant__AgentsAssignment_11_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getAgentsAssignment_11_1()); 
            }
            // InternalXMachine.g:4734:3: ( rule__XIndividualInvariant__AgentsAssignment_11_1 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_ID) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalXMachine.g:4734:4: rule__XIndividualInvariant__AgentsAssignment_11_1
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__XIndividualInvariant__AgentsAssignment_11_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getAgentsAssignment_11_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__Group_11__1__Impl"


    // $ANTLR start "rule__XVariant__Group__0"
    // InternalXMachine.g:4744:1: rule__XVariant__Group__0 : rule__XVariant__Group__0__Impl rule__XVariant__Group__1 ;
    public final void rule__XVariant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4748:1: ( rule__XVariant__Group__0__Impl rule__XVariant__Group__1 )
            // InternalXMachine.g:4749:2: rule__XVariant__Group__0__Impl rule__XVariant__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__XVariant__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XVariant__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XVariant__Group__0"


    // $ANTLR start "rule__XVariant__Group__0__Impl"
    // InternalXMachine.g:4756:1: rule__XVariant__Group__0__Impl : ( () ) ;
    public final void rule__XVariant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4760:1: ( ( () ) )
            // InternalXMachine.g:4761:1: ( () )
            {
            // InternalXMachine.g:4761:1: ( () )
            // InternalXMachine.g:4762:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXVariantAccess().getVariantAction_0()); 
            }
            // InternalXMachine.g:4763:2: ()
            // InternalXMachine.g:4763:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXVariantAccess().getVariantAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XVariant__Group__0__Impl"


    // $ANTLR start "rule__XVariant__Group__1"
    // InternalXMachine.g:4771:1: rule__XVariant__Group__1 : rule__XVariant__Group__1__Impl rule__XVariant__Group__2 ;
    public final void rule__XVariant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4775:1: ( rule__XVariant__Group__1__Impl rule__XVariant__Group__2 )
            // InternalXMachine.g:4776:2: rule__XVariant__Group__1__Impl rule__XVariant__Group__2
            {
            pushFollow(FOLLOW_34);
            rule__XVariant__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XVariant__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XVariant__Group__1"


    // $ANTLR start "rule__XVariant__Group__1__Impl"
    // InternalXMachine.g:4783:1: rule__XVariant__Group__1__Impl : ( ( rule__XVariant__CommentAssignment_1 )? ) ;
    public final void rule__XVariant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4787:1: ( ( ( rule__XVariant__CommentAssignment_1 )? ) )
            // InternalXMachine.g:4788:1: ( ( rule__XVariant__CommentAssignment_1 )? )
            {
            // InternalXMachine.g:4788:1: ( ( rule__XVariant__CommentAssignment_1 )? )
            // InternalXMachine.g:4789:2: ( rule__XVariant__CommentAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXVariantAccess().getCommentAssignment_1()); 
            }
            // InternalXMachine.g:4790:2: ( rule__XVariant__CommentAssignment_1 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_STRING) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalXMachine.g:4790:3: rule__XVariant__CommentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XVariant__CommentAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXVariantAccess().getCommentAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XVariant__Group__1__Impl"


    // $ANTLR start "rule__XVariant__Group__2"
    // InternalXMachine.g:4798:1: rule__XVariant__Group__2 : rule__XVariant__Group__2__Impl rule__XVariant__Group__3 ;
    public final void rule__XVariant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4802:1: ( rule__XVariant__Group__2__Impl rule__XVariant__Group__3 )
            // InternalXMachine.g:4803:2: rule__XVariant__Group__2__Impl rule__XVariant__Group__3
            {
            pushFollow(FOLLOW_28);
            rule__XVariant__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XVariant__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XVariant__Group__2"


    // $ANTLR start "rule__XVariant__Group__2__Impl"
    // InternalXMachine.g:4810:1: rule__XVariant__Group__2__Impl : ( 'variant' ) ;
    public final void rule__XVariant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4814:1: ( ( 'variant' ) )
            // InternalXMachine.g:4815:1: ( 'variant' )
            {
            // InternalXMachine.g:4815:1: ( 'variant' )
            // InternalXMachine.g:4816:2: 'variant'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXVariantAccess().getVariantKeyword_2()); 
            }
            match(input,201,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXVariantAccess().getVariantKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XVariant__Group__2__Impl"


    // $ANTLR start "rule__XVariant__Group__3"
    // InternalXMachine.g:4825:1: rule__XVariant__Group__3 : rule__XVariant__Group__3__Impl rule__XVariant__Group__4 ;
    public final void rule__XVariant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4829:1: ( rule__XVariant__Group__3__Impl rule__XVariant__Group__4 )
            // InternalXMachine.g:4830:2: rule__XVariant__Group__3__Impl rule__XVariant__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__XVariant__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XVariant__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XVariant__Group__3"


    // $ANTLR start "rule__XVariant__Group__3__Impl"
    // InternalXMachine.g:4837:1: rule__XVariant__Group__3__Impl : ( ( rule__XVariant__NameAssignment_3 ) ) ;
    public final void rule__XVariant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4841:1: ( ( ( rule__XVariant__NameAssignment_3 ) ) )
            // InternalXMachine.g:4842:1: ( ( rule__XVariant__NameAssignment_3 ) )
            {
            // InternalXMachine.g:4842:1: ( ( rule__XVariant__NameAssignment_3 ) )
            // InternalXMachine.g:4843:2: ( rule__XVariant__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXVariantAccess().getNameAssignment_3()); 
            }
            // InternalXMachine.g:4844:2: ( rule__XVariant__NameAssignment_3 )
            // InternalXMachine.g:4844:3: rule__XVariant__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__XVariant__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXVariantAccess().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XVariant__Group__3__Impl"


    // $ANTLR start "rule__XVariant__Group__4"
    // InternalXMachine.g:4852:1: rule__XVariant__Group__4 : rule__XVariant__Group__4__Impl ;
    public final void rule__XVariant__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4856:1: ( rule__XVariant__Group__4__Impl )
            // InternalXMachine.g:4857:2: rule__XVariant__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XVariant__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XVariant__Group__4"


    // $ANTLR start "rule__XVariant__Group__4__Impl"
    // InternalXMachine.g:4863:1: rule__XVariant__Group__4__Impl : ( ( rule__XVariant__ExpressionAssignment_4 ) ) ;
    public final void rule__XVariant__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4867:1: ( ( ( rule__XVariant__ExpressionAssignment_4 ) ) )
            // InternalXMachine.g:4868:1: ( ( rule__XVariant__ExpressionAssignment_4 ) )
            {
            // InternalXMachine.g:4868:1: ( ( rule__XVariant__ExpressionAssignment_4 ) )
            // InternalXMachine.g:4869:2: ( rule__XVariant__ExpressionAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXVariantAccess().getExpressionAssignment_4()); 
            }
            // InternalXMachine.g:4870:2: ( rule__XVariant__ExpressionAssignment_4 )
            // InternalXMachine.g:4870:3: rule__XVariant__ExpressionAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__XVariant__ExpressionAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXVariantAccess().getExpressionAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XVariant__Group__4__Impl"


    // $ANTLR start "rule__XEvent__Group__0"
    // InternalXMachine.g:4879:1: rule__XEvent__Group__0 : rule__XEvent__Group__0__Impl rule__XEvent__Group__1 ;
    public final void rule__XEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4883:1: ( rule__XEvent__Group__0__Impl rule__XEvent__Group__1 )
            // InternalXMachine.g:4884:2: rule__XEvent__Group__0__Impl rule__XEvent__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__XEvent__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__0"


    // $ANTLR start "rule__XEvent__Group__0__Impl"
    // InternalXMachine.g:4891:1: rule__XEvent__Group__0__Impl : ( () ) ;
    public final void rule__XEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4895:1: ( ( () ) )
            // InternalXMachine.g:4896:1: ( () )
            {
            // InternalXMachine.g:4896:1: ( () )
            // InternalXMachine.g:4897:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getEventAction_0()); 
            }
            // InternalXMachine.g:4898:2: ()
            // InternalXMachine.g:4898:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getEventAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__0__Impl"


    // $ANTLR start "rule__XEvent__Group__1"
    // InternalXMachine.g:4906:1: rule__XEvent__Group__1 : rule__XEvent__Group__1__Impl rule__XEvent__Group__2 ;
    public final void rule__XEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4910:1: ( rule__XEvent__Group__1__Impl rule__XEvent__Group__2 )
            // InternalXMachine.g:4911:2: rule__XEvent__Group__1__Impl rule__XEvent__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__XEvent__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__1"


    // $ANTLR start "rule__XEvent__Group__1__Impl"
    // InternalXMachine.g:4918:1: rule__XEvent__Group__1__Impl : ( ( rule__XEvent__CommentAssignment_1 )? ) ;
    public final void rule__XEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4922:1: ( ( ( rule__XEvent__CommentAssignment_1 )? ) )
            // InternalXMachine.g:4923:1: ( ( rule__XEvent__CommentAssignment_1 )? )
            {
            // InternalXMachine.g:4923:1: ( ( rule__XEvent__CommentAssignment_1 )? )
            // InternalXMachine.g:4924:2: ( rule__XEvent__CommentAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getCommentAssignment_1()); 
            }
            // InternalXMachine.g:4925:2: ( rule__XEvent__CommentAssignment_1 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_STRING) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalXMachine.g:4925:3: rule__XEvent__CommentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XEvent__CommentAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getCommentAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__1__Impl"


    // $ANTLR start "rule__XEvent__Group__2"
    // InternalXMachine.g:4933:1: rule__XEvent__Group__2 : rule__XEvent__Group__2__Impl rule__XEvent__Group__3 ;
    public final void rule__XEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4937:1: ( rule__XEvent__Group__2__Impl rule__XEvent__Group__3 )
            // InternalXMachine.g:4938:2: rule__XEvent__Group__2__Impl rule__XEvent__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__XEvent__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__2"


    // $ANTLR start "rule__XEvent__Group__2__Impl"
    // InternalXMachine.g:4945:1: rule__XEvent__Group__2__Impl : ( ( rule__XEvent__ConvergenceAssignment_2 )? ) ;
    public final void rule__XEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4949:1: ( ( ( rule__XEvent__ConvergenceAssignment_2 )? ) )
            // InternalXMachine.g:4950:1: ( ( rule__XEvent__ConvergenceAssignment_2 )? )
            {
            // InternalXMachine.g:4950:1: ( ( rule__XEvent__ConvergenceAssignment_2 )? )
            // InternalXMachine.g:4951:2: ( rule__XEvent__ConvergenceAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getConvergenceAssignment_2()); 
            }
            // InternalXMachine.g:4952:2: ( rule__XEvent__ConvergenceAssignment_2 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=179 && LA53_0<=181)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalXMachine.g:4952:3: rule__XEvent__ConvergenceAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__XEvent__ConvergenceAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getConvergenceAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__2__Impl"


    // $ANTLR start "rule__XEvent__Group__3"
    // InternalXMachine.g:4960:1: rule__XEvent__Group__3 : rule__XEvent__Group__3__Impl rule__XEvent__Group__4 ;
    public final void rule__XEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4964:1: ( rule__XEvent__Group__3__Impl rule__XEvent__Group__4 )
            // InternalXMachine.g:4965:2: rule__XEvent__Group__3__Impl rule__XEvent__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__XEvent__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__3"


    // $ANTLR start "rule__XEvent__Group__3__Impl"
    // InternalXMachine.g:4972:1: rule__XEvent__Group__3__Impl : ( 'event' ) ;
    public final void rule__XEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4976:1: ( ( 'event' ) )
            // InternalXMachine.g:4977:1: ( 'event' )
            {
            // InternalXMachine.g:4977:1: ( 'event' )
            // InternalXMachine.g:4978:2: 'event'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getEventKeyword_3()); 
            }
            match(input,202,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getEventKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__3__Impl"


    // $ANTLR start "rule__XEvent__Group__4"
    // InternalXMachine.g:4987:1: rule__XEvent__Group__4 : rule__XEvent__Group__4__Impl rule__XEvent__Group__5 ;
    public final void rule__XEvent__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:4991:1: ( rule__XEvent__Group__4__Impl rule__XEvent__Group__5 )
            // InternalXMachine.g:4992:2: rule__XEvent__Group__4__Impl rule__XEvent__Group__5
            {
            pushFollow(FOLLOW_35);
            rule__XEvent__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__4"


    // $ANTLR start "rule__XEvent__Group__4__Impl"
    // InternalXMachine.g:4999:1: rule__XEvent__Group__4__Impl : ( ( rule__XEvent__NameAssignment_4 ) ) ;
    public final void rule__XEvent__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5003:1: ( ( ( rule__XEvent__NameAssignment_4 ) ) )
            // InternalXMachine.g:5004:1: ( ( rule__XEvent__NameAssignment_4 ) )
            {
            // InternalXMachine.g:5004:1: ( ( rule__XEvent__NameAssignment_4 ) )
            // InternalXMachine.g:5005:2: ( rule__XEvent__NameAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getNameAssignment_4()); 
            }
            // InternalXMachine.g:5006:2: ( rule__XEvent__NameAssignment_4 )
            // InternalXMachine.g:5006:3: rule__XEvent__NameAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__XEvent__NameAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getNameAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__4__Impl"


    // $ANTLR start "rule__XEvent__Group__5"
    // InternalXMachine.g:5014:1: rule__XEvent__Group__5 : rule__XEvent__Group__5__Impl rule__XEvent__Group__6 ;
    public final void rule__XEvent__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5018:1: ( rule__XEvent__Group__5__Impl rule__XEvent__Group__6 )
            // InternalXMachine.g:5019:2: rule__XEvent__Group__5__Impl rule__XEvent__Group__6
            {
            pushFollow(FOLLOW_35);
            rule__XEvent__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__5"


    // $ANTLR start "rule__XEvent__Group__5__Impl"
    // InternalXMachine.g:5026:1: rule__XEvent__Group__5__Impl : ( ( rule__XEvent__Alternatives_5 )? ) ;
    public final void rule__XEvent__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5030:1: ( ( ( rule__XEvent__Alternatives_5 )? ) )
            // InternalXMachine.g:5031:1: ( ( rule__XEvent__Alternatives_5 )? )
            {
            // InternalXMachine.g:5031:1: ( ( rule__XEvent__Alternatives_5 )? )
            // InternalXMachine.g:5032:2: ( rule__XEvent__Alternatives_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getAlternatives_5()); 
            }
            // InternalXMachine.g:5033:2: ( rule__XEvent__Alternatives_5 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==187||LA54_0==209) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalXMachine.g:5033:3: rule__XEvent__Alternatives_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__XEvent__Alternatives_5();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getAlternatives_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__5__Impl"


    // $ANTLR start "rule__XEvent__Group__6"
    // InternalXMachine.g:5041:1: rule__XEvent__Group__6 : rule__XEvent__Group__6__Impl rule__XEvent__Group__7 ;
    public final void rule__XEvent__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5045:1: ( rule__XEvent__Group__6__Impl rule__XEvent__Group__7 )
            // InternalXMachine.g:5046:2: rule__XEvent__Group__6__Impl rule__XEvent__Group__7
            {
            pushFollow(FOLLOW_35);
            rule__XEvent__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__6"


    // $ANTLR start "rule__XEvent__Group__6__Impl"
    // InternalXMachine.g:5053:1: rule__XEvent__Group__6__Impl : ( ( rule__XEvent__Group_6__0 )? ) ;
    public final void rule__XEvent__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5057:1: ( ( ( rule__XEvent__Group_6__0 )? ) )
            // InternalXMachine.g:5058:1: ( ( rule__XEvent__Group_6__0 )? )
            {
            // InternalXMachine.g:5058:1: ( ( rule__XEvent__Group_6__0 )? )
            // InternalXMachine.g:5059:2: ( rule__XEvent__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getGroup_6()); 
            }
            // InternalXMachine.g:5060:2: ( rule__XEvent__Group_6__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==203) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalXMachine.g:5060:3: rule__XEvent__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XEvent__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getGroup_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__6__Impl"


    // $ANTLR start "rule__XEvent__Group__7"
    // InternalXMachine.g:5068:1: rule__XEvent__Group__7 : rule__XEvent__Group__7__Impl rule__XEvent__Group__8 ;
    public final void rule__XEvent__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5072:1: ( rule__XEvent__Group__7__Impl rule__XEvent__Group__8 )
            // InternalXMachine.g:5073:2: rule__XEvent__Group__7__Impl rule__XEvent__Group__8
            {
            pushFollow(FOLLOW_35);
            rule__XEvent__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group__8();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__7"


    // $ANTLR start "rule__XEvent__Group__7__Impl"
    // InternalXMachine.g:5080:1: rule__XEvent__Group__7__Impl : ( ( rule__XEvent__OrderedChildrenAssignment_7 )* ) ;
    public final void rule__XEvent__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5084:1: ( ( ( rule__XEvent__OrderedChildrenAssignment_7 )* ) )
            // InternalXMachine.g:5085:1: ( ( rule__XEvent__OrderedChildrenAssignment_7 )* )
            {
            // InternalXMachine.g:5085:1: ( ( rule__XEvent__OrderedChildrenAssignment_7 )* )
            // InternalXMachine.g:5086:2: ( rule__XEvent__OrderedChildrenAssignment_7 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_7()); 
            }
            // InternalXMachine.g:5087:2: ( rule__XEvent__OrderedChildrenAssignment_7 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==205) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalXMachine.g:5087:3: rule__XEvent__OrderedChildrenAssignment_7
            	    {
            	    pushFollow(FOLLOW_36);
            	    rule__XEvent__OrderedChildrenAssignment_7();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__7__Impl"


    // $ANTLR start "rule__XEvent__Group__8"
    // InternalXMachine.g:5095:1: rule__XEvent__Group__8 : rule__XEvent__Group__8__Impl rule__XEvent__Group__9 ;
    public final void rule__XEvent__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5099:1: ( rule__XEvent__Group__8__Impl rule__XEvent__Group__9 )
            // InternalXMachine.g:5100:2: rule__XEvent__Group__8__Impl rule__XEvent__Group__9
            {
            pushFollow(FOLLOW_35);
            rule__XEvent__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group__9();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__8"


    // $ANTLR start "rule__XEvent__Group__8__Impl"
    // InternalXMachine.g:5107:1: rule__XEvent__Group__8__Impl : ( ( rule__XEvent__Group_8__0 )? ) ;
    public final void rule__XEvent__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5111:1: ( ( ( rule__XEvent__Group_8__0 )? ) )
            // InternalXMachine.g:5112:1: ( ( rule__XEvent__Group_8__0 )? )
            {
            // InternalXMachine.g:5112:1: ( ( rule__XEvent__Group_8__0 )? )
            // InternalXMachine.g:5113:2: ( rule__XEvent__Group_8__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getGroup_8()); 
            }
            // InternalXMachine.g:5114:2: ( rule__XEvent__Group_8__0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=46 && LA57_0<=47)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalXMachine.g:5114:3: rule__XEvent__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XEvent__Group_8__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getGroup_8()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__8__Impl"


    // $ANTLR start "rule__XEvent__Group__9"
    // InternalXMachine.g:5122:1: rule__XEvent__Group__9 : rule__XEvent__Group__9__Impl rule__XEvent__Group__10 ;
    public final void rule__XEvent__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5126:1: ( rule__XEvent__Group__9__Impl rule__XEvent__Group__10 )
            // InternalXMachine.g:5127:2: rule__XEvent__Group__9__Impl rule__XEvent__Group__10
            {
            pushFollow(FOLLOW_35);
            rule__XEvent__Group__9__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group__10();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__9"


    // $ANTLR start "rule__XEvent__Group__9__Impl"
    // InternalXMachine.g:5134:1: rule__XEvent__Group__9__Impl : ( ( rule__XEvent__Group_9__0 )? ) ;
    public final void rule__XEvent__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5138:1: ( ( ( rule__XEvent__Group_9__0 )? ) )
            // InternalXMachine.g:5139:1: ( ( rule__XEvent__Group_9__0 )? )
            {
            // InternalXMachine.g:5139:1: ( ( rule__XEvent__Group_9__0 )? )
            // InternalXMachine.g:5140:2: ( rule__XEvent__Group_9__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getGroup_9()); 
            }
            // InternalXMachine.g:5141:2: ( rule__XEvent__Group_9__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=48 && LA58_0<=49)) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalXMachine.g:5141:3: rule__XEvent__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XEvent__Group_9__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getGroup_9()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__9__Impl"


    // $ANTLR start "rule__XEvent__Group__10"
    // InternalXMachine.g:5149:1: rule__XEvent__Group__10 : rule__XEvent__Group__10__Impl rule__XEvent__Group__11 ;
    public final void rule__XEvent__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5153:1: ( rule__XEvent__Group__10__Impl rule__XEvent__Group__11 )
            // InternalXMachine.g:5154:2: rule__XEvent__Group__10__Impl rule__XEvent__Group__11
            {
            pushFollow(FOLLOW_35);
            rule__XEvent__Group__10__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group__11();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__10"


    // $ANTLR start "rule__XEvent__Group__10__Impl"
    // InternalXMachine.g:5161:1: rule__XEvent__Group__10__Impl : ( ( rule__XEvent__Group_10__0 )? ) ;
    public final void rule__XEvent__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5165:1: ( ( ( rule__XEvent__Group_10__0 )? ) )
            // InternalXMachine.g:5166:1: ( ( rule__XEvent__Group_10__0 )? )
            {
            // InternalXMachine.g:5166:1: ( ( rule__XEvent__Group_10__0 )? )
            // InternalXMachine.g:5167:2: ( rule__XEvent__Group_10__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getGroup_10()); 
            }
            // InternalXMachine.g:5168:2: ( rule__XEvent__Group_10__0 )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==204) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalXMachine.g:5168:3: rule__XEvent__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XEvent__Group_10__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getGroup_10()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__10__Impl"


    // $ANTLR start "rule__XEvent__Group__11"
    // InternalXMachine.g:5176:1: rule__XEvent__Group__11 : rule__XEvent__Group__11__Impl ;
    public final void rule__XEvent__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5180:1: ( rule__XEvent__Group__11__Impl )
            // InternalXMachine.g:5181:2: rule__XEvent__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XEvent__Group__11__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__11"


    // $ANTLR start "rule__XEvent__Group__11__Impl"
    // InternalXMachine.g:5187:1: rule__XEvent__Group__11__Impl : ( 'end' ) ;
    public final void rule__XEvent__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5191:1: ( ( 'end' ) )
            // InternalXMachine.g:5192:1: ( 'end' )
            {
            // InternalXMachine.g:5192:1: ( 'end' )
            // InternalXMachine.g:5193:2: 'end'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getEndKeyword_11()); 
            }
            match(input,186,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getEndKeyword_11()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group__11__Impl"


    // $ANTLR start "rule__XEvent__Group_5_0__0"
    // InternalXMachine.g:5203:1: rule__XEvent__Group_5_0__0 : rule__XEvent__Group_5_0__0__Impl rule__XEvent__Group_5_0__1 ;
    public final void rule__XEvent__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5207:1: ( rule__XEvent__Group_5_0__0__Impl rule__XEvent__Group_5_0__1 )
            // InternalXMachine.g:5208:2: rule__XEvent__Group_5_0__0__Impl rule__XEvent__Group_5_0__1
            {
            pushFollow(FOLLOW_5);
            rule__XEvent__Group_5_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group_5_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_5_0__0"


    // $ANTLR start "rule__XEvent__Group_5_0__0__Impl"
    // InternalXMachine.g:5215:1: rule__XEvent__Group_5_0__0__Impl : ( 'refines' ) ;
    public final void rule__XEvent__Group_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5219:1: ( ( 'refines' ) )
            // InternalXMachine.g:5220:1: ( 'refines' )
            {
            // InternalXMachine.g:5220:1: ( 'refines' )
            // InternalXMachine.g:5221:2: 'refines'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getRefinesKeyword_5_0_0()); 
            }
            match(input,187,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getRefinesKeyword_5_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_5_0__0__Impl"


    // $ANTLR start "rule__XEvent__Group_5_0__1"
    // InternalXMachine.g:5230:1: rule__XEvent__Group_5_0__1 : rule__XEvent__Group_5_0__1__Impl ;
    public final void rule__XEvent__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5234:1: ( rule__XEvent__Group_5_0__1__Impl )
            // InternalXMachine.g:5235:2: rule__XEvent__Group_5_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XEvent__Group_5_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_5_0__1"


    // $ANTLR start "rule__XEvent__Group_5_0__1__Impl"
    // InternalXMachine.g:5241:1: rule__XEvent__Group_5_0__1__Impl : ( ( ( rule__XEvent__RefinesAssignment_5_0_1 ) ) ( ( rule__XEvent__RefinesAssignment_5_0_1 )* ) ) ;
    public final void rule__XEvent__Group_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5245:1: ( ( ( ( rule__XEvent__RefinesAssignment_5_0_1 ) ) ( ( rule__XEvent__RefinesAssignment_5_0_1 )* ) ) )
            // InternalXMachine.g:5246:1: ( ( ( rule__XEvent__RefinesAssignment_5_0_1 ) ) ( ( rule__XEvent__RefinesAssignment_5_0_1 )* ) )
            {
            // InternalXMachine.g:5246:1: ( ( ( rule__XEvent__RefinesAssignment_5_0_1 ) ) ( ( rule__XEvent__RefinesAssignment_5_0_1 )* ) )
            // InternalXMachine.g:5247:2: ( ( rule__XEvent__RefinesAssignment_5_0_1 ) ) ( ( rule__XEvent__RefinesAssignment_5_0_1 )* )
            {
            // InternalXMachine.g:5247:2: ( ( rule__XEvent__RefinesAssignment_5_0_1 ) )
            // InternalXMachine.g:5248:3: ( rule__XEvent__RefinesAssignment_5_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getRefinesAssignment_5_0_1()); 
            }
            // InternalXMachine.g:5249:3: ( rule__XEvent__RefinesAssignment_5_0_1 )
            // InternalXMachine.g:5249:4: rule__XEvent__RefinesAssignment_5_0_1
            {
            pushFollow(FOLLOW_9);
            rule__XEvent__RefinesAssignment_5_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getRefinesAssignment_5_0_1()); 
            }

            }

            // InternalXMachine.g:5252:2: ( ( rule__XEvent__RefinesAssignment_5_0_1 )* )
            // InternalXMachine.g:5253:3: ( rule__XEvent__RefinesAssignment_5_0_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getRefinesAssignment_5_0_1()); 
            }
            // InternalXMachine.g:5254:3: ( rule__XEvent__RefinesAssignment_5_0_1 )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_ID) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalXMachine.g:5254:4: rule__XEvent__RefinesAssignment_5_0_1
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__XEvent__RefinesAssignment_5_0_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getRefinesAssignment_5_0_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_5_0__1__Impl"


    // $ANTLR start "rule__XEvent__Group_5_1__0"
    // InternalXMachine.g:5264:1: rule__XEvent__Group_5_1__0 : rule__XEvent__Group_5_1__0__Impl rule__XEvent__Group_5_1__1 ;
    public final void rule__XEvent__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5268:1: ( rule__XEvent__Group_5_1__0__Impl rule__XEvent__Group_5_1__1 )
            // InternalXMachine.g:5269:2: rule__XEvent__Group_5_1__0__Impl rule__XEvent__Group_5_1__1
            {
            pushFollow(FOLLOW_5);
            rule__XEvent__Group_5_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group_5_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_5_1__0"


    // $ANTLR start "rule__XEvent__Group_5_1__0__Impl"
    // InternalXMachine.g:5276:1: rule__XEvent__Group_5_1__0__Impl : ( ( rule__XEvent__ExtendedAssignment_5_1_0 ) ) ;
    public final void rule__XEvent__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5280:1: ( ( ( rule__XEvent__ExtendedAssignment_5_1_0 ) ) )
            // InternalXMachine.g:5281:1: ( ( rule__XEvent__ExtendedAssignment_5_1_0 ) )
            {
            // InternalXMachine.g:5281:1: ( ( rule__XEvent__ExtendedAssignment_5_1_0 ) )
            // InternalXMachine.g:5282:2: ( rule__XEvent__ExtendedAssignment_5_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getExtendedAssignment_5_1_0()); 
            }
            // InternalXMachine.g:5283:2: ( rule__XEvent__ExtendedAssignment_5_1_0 )
            // InternalXMachine.g:5283:3: rule__XEvent__ExtendedAssignment_5_1_0
            {
            pushFollow(FOLLOW_2);
            rule__XEvent__ExtendedAssignment_5_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getExtendedAssignment_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_5_1__0__Impl"


    // $ANTLR start "rule__XEvent__Group_5_1__1"
    // InternalXMachine.g:5291:1: rule__XEvent__Group_5_1__1 : rule__XEvent__Group_5_1__1__Impl ;
    public final void rule__XEvent__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5295:1: ( rule__XEvent__Group_5_1__1__Impl )
            // InternalXMachine.g:5296:2: rule__XEvent__Group_5_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XEvent__Group_5_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_5_1__1"


    // $ANTLR start "rule__XEvent__Group_5_1__1__Impl"
    // InternalXMachine.g:5302:1: rule__XEvent__Group_5_1__1__Impl : ( ( rule__XEvent__RefinesAssignment_5_1_1 ) ) ;
    public final void rule__XEvent__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5306:1: ( ( ( rule__XEvent__RefinesAssignment_5_1_1 ) ) )
            // InternalXMachine.g:5307:1: ( ( rule__XEvent__RefinesAssignment_5_1_1 ) )
            {
            // InternalXMachine.g:5307:1: ( ( rule__XEvent__RefinesAssignment_5_1_1 ) )
            // InternalXMachine.g:5308:2: ( rule__XEvent__RefinesAssignment_5_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getRefinesAssignment_5_1_1()); 
            }
            // InternalXMachine.g:5309:2: ( rule__XEvent__RefinesAssignment_5_1_1 )
            // InternalXMachine.g:5309:3: rule__XEvent__RefinesAssignment_5_1_1
            {
            pushFollow(FOLLOW_2);
            rule__XEvent__RefinesAssignment_5_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getRefinesAssignment_5_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_5_1__1__Impl"


    // $ANTLR start "rule__XEvent__Group_6__0"
    // InternalXMachine.g:5318:1: rule__XEvent__Group_6__0 : rule__XEvent__Group_6__0__Impl rule__XEvent__Group_6__1 ;
    public final void rule__XEvent__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5322:1: ( rule__XEvent__Group_6__0__Impl rule__XEvent__Group_6__1 )
            // InternalXMachine.g:5323:2: rule__XEvent__Group_6__0__Impl rule__XEvent__Group_6__1
            {
            pushFollow(FOLLOW_10);
            rule__XEvent__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_6__0"


    // $ANTLR start "rule__XEvent__Group_6__0__Impl"
    // InternalXMachine.g:5330:1: rule__XEvent__Group_6__0__Impl : ( 'any' ) ;
    public final void rule__XEvent__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5334:1: ( ( 'any' ) )
            // InternalXMachine.g:5335:1: ( 'any' )
            {
            // InternalXMachine.g:5335:1: ( 'any' )
            // InternalXMachine.g:5336:2: 'any'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getAnyKeyword_6_0()); 
            }
            match(input,203,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getAnyKeyword_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_6__0__Impl"


    // $ANTLR start "rule__XEvent__Group_6__1"
    // InternalXMachine.g:5345:1: rule__XEvent__Group_6__1 : rule__XEvent__Group_6__1__Impl ;
    public final void rule__XEvent__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5349:1: ( rule__XEvent__Group_6__1__Impl )
            // InternalXMachine.g:5350:2: rule__XEvent__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XEvent__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_6__1"


    // $ANTLR start "rule__XEvent__Group_6__1__Impl"
    // InternalXMachine.g:5356:1: rule__XEvent__Group_6__1__Impl : ( ( ( rule__XEvent__OrderedChildrenAssignment_6_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_6_1 )* ) ) ;
    public final void rule__XEvent__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5360:1: ( ( ( ( rule__XEvent__OrderedChildrenAssignment_6_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_6_1 )* ) ) )
            // InternalXMachine.g:5361:1: ( ( ( rule__XEvent__OrderedChildrenAssignment_6_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_6_1 )* ) )
            {
            // InternalXMachine.g:5361:1: ( ( ( rule__XEvent__OrderedChildrenAssignment_6_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_6_1 )* ) )
            // InternalXMachine.g:5362:2: ( ( rule__XEvent__OrderedChildrenAssignment_6_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_6_1 )* )
            {
            // InternalXMachine.g:5362:2: ( ( rule__XEvent__OrderedChildrenAssignment_6_1 ) )
            // InternalXMachine.g:5363:3: ( rule__XEvent__OrderedChildrenAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_6_1()); 
            }
            // InternalXMachine.g:5364:3: ( rule__XEvent__OrderedChildrenAssignment_6_1 )
            // InternalXMachine.g:5364:4: rule__XEvent__OrderedChildrenAssignment_6_1
            {
            pushFollow(FOLLOW_11);
            rule__XEvent__OrderedChildrenAssignment_6_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_6_1()); 
            }

            }

            // InternalXMachine.g:5367:2: ( ( rule__XEvent__OrderedChildrenAssignment_6_1 )* )
            // InternalXMachine.g:5368:3: ( rule__XEvent__OrderedChildrenAssignment_6_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_6_1()); 
            }
            // InternalXMachine.g:5369:3: ( rule__XEvent__OrderedChildrenAssignment_6_1 )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==RULE_ID||LA61_0==RULE_STRING) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalXMachine.g:5369:4: rule__XEvent__OrderedChildrenAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__XEvent__OrderedChildrenAssignment_6_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_6_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_6__1__Impl"


    // $ANTLR start "rule__XEvent__Group_8__0"
    // InternalXMachine.g:5379:1: rule__XEvent__Group_8__0 : rule__XEvent__Group_8__0__Impl rule__XEvent__Group_8__1 ;
    public final void rule__XEvent__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5383:1: ( rule__XEvent__Group_8__0__Impl rule__XEvent__Group_8__1 )
            // InternalXMachine.g:5384:2: rule__XEvent__Group_8__0__Impl rule__XEvent__Group_8__1
            {
            pushFollow(FOLLOW_37);
            rule__XEvent__Group_8__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group_8__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_8__0"


    // $ANTLR start "rule__XEvent__Group_8__0__Impl"
    // InternalXMachine.g:5391:1: rule__XEvent__Group_8__0__Impl : ( ( rule__XEvent__Alternatives_8_0 ) ) ;
    public final void rule__XEvent__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5395:1: ( ( ( rule__XEvent__Alternatives_8_0 ) ) )
            // InternalXMachine.g:5396:1: ( ( rule__XEvent__Alternatives_8_0 ) )
            {
            // InternalXMachine.g:5396:1: ( ( rule__XEvent__Alternatives_8_0 ) )
            // InternalXMachine.g:5397:2: ( rule__XEvent__Alternatives_8_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getAlternatives_8_0()); 
            }
            // InternalXMachine.g:5398:2: ( rule__XEvent__Alternatives_8_0 )
            // InternalXMachine.g:5398:3: rule__XEvent__Alternatives_8_0
            {
            pushFollow(FOLLOW_2);
            rule__XEvent__Alternatives_8_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getAlternatives_8_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_8__0__Impl"


    // $ANTLR start "rule__XEvent__Group_8__1"
    // InternalXMachine.g:5406:1: rule__XEvent__Group_8__1 : rule__XEvent__Group_8__1__Impl ;
    public final void rule__XEvent__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5410:1: ( rule__XEvent__Group_8__1__Impl )
            // InternalXMachine.g:5411:2: rule__XEvent__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XEvent__Group_8__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_8__1"


    // $ANTLR start "rule__XEvent__Group_8__1__Impl"
    // InternalXMachine.g:5417:1: rule__XEvent__Group_8__1__Impl : ( ( ( rule__XEvent__OrderedChildrenAssignment_8_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_8_1 )* ) ) ;
    public final void rule__XEvent__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5421:1: ( ( ( ( rule__XEvent__OrderedChildrenAssignment_8_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_8_1 )* ) ) )
            // InternalXMachine.g:5422:1: ( ( ( rule__XEvent__OrderedChildrenAssignment_8_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_8_1 )* ) )
            {
            // InternalXMachine.g:5422:1: ( ( ( rule__XEvent__OrderedChildrenAssignment_8_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_8_1 )* ) )
            // InternalXMachine.g:5423:2: ( ( rule__XEvent__OrderedChildrenAssignment_8_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_8_1 )* )
            {
            // InternalXMachine.g:5423:2: ( ( rule__XEvent__OrderedChildrenAssignment_8_1 ) )
            // InternalXMachine.g:5424:3: ( rule__XEvent__OrderedChildrenAssignment_8_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_8_1()); 
            }
            // InternalXMachine.g:5425:3: ( rule__XEvent__OrderedChildrenAssignment_8_1 )
            // InternalXMachine.g:5425:4: rule__XEvent__OrderedChildrenAssignment_8_1
            {
            pushFollow(FOLLOW_38);
            rule__XEvent__OrderedChildrenAssignment_8_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_8_1()); 
            }

            }

            // InternalXMachine.g:5428:2: ( ( rule__XEvent__OrderedChildrenAssignment_8_1 )* )
            // InternalXMachine.g:5429:3: ( rule__XEvent__OrderedChildrenAssignment_8_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_8_1()); 
            }
            // InternalXMachine.g:5430:3: ( rule__XEvent__OrderedChildrenAssignment_8_1 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( ((LA62_0>=RULE_STRING && LA62_0<=RULE_XLABEL)||LA62_0==210) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalXMachine.g:5430:4: rule__XEvent__OrderedChildrenAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_38);
            	    rule__XEvent__OrderedChildrenAssignment_8_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_8_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_8__1__Impl"


    // $ANTLR start "rule__XEvent__Group_9__0"
    // InternalXMachine.g:5440:1: rule__XEvent__Group_9__0 : rule__XEvent__Group_9__0__Impl rule__XEvent__Group_9__1 ;
    public final void rule__XEvent__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5444:1: ( rule__XEvent__Group_9__0__Impl rule__XEvent__Group_9__1 )
            // InternalXMachine.g:5445:2: rule__XEvent__Group_9__0__Impl rule__XEvent__Group_9__1
            {
            pushFollow(FOLLOW_12);
            rule__XEvent__Group_9__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group_9__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_9__0"


    // $ANTLR start "rule__XEvent__Group_9__0__Impl"
    // InternalXMachine.g:5452:1: rule__XEvent__Group_9__0__Impl : ( ( rule__XEvent__Alternatives_9_0 ) ) ;
    public final void rule__XEvent__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5456:1: ( ( ( rule__XEvent__Alternatives_9_0 ) ) )
            // InternalXMachine.g:5457:1: ( ( rule__XEvent__Alternatives_9_0 ) )
            {
            // InternalXMachine.g:5457:1: ( ( rule__XEvent__Alternatives_9_0 ) )
            // InternalXMachine.g:5458:2: ( rule__XEvent__Alternatives_9_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getAlternatives_9_0()); 
            }
            // InternalXMachine.g:5459:2: ( rule__XEvent__Alternatives_9_0 )
            // InternalXMachine.g:5459:3: rule__XEvent__Alternatives_9_0
            {
            pushFollow(FOLLOW_2);
            rule__XEvent__Alternatives_9_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getAlternatives_9_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_9__0__Impl"


    // $ANTLR start "rule__XEvent__Group_9__1"
    // InternalXMachine.g:5467:1: rule__XEvent__Group_9__1 : rule__XEvent__Group_9__1__Impl ;
    public final void rule__XEvent__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5471:1: ( rule__XEvent__Group_9__1__Impl )
            // InternalXMachine.g:5472:2: rule__XEvent__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XEvent__Group_9__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_9__1"


    // $ANTLR start "rule__XEvent__Group_9__1__Impl"
    // InternalXMachine.g:5478:1: rule__XEvent__Group_9__1__Impl : ( ( ( rule__XEvent__OrderedChildrenAssignment_9_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_9_1 )* ) ) ;
    public final void rule__XEvent__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5482:1: ( ( ( ( rule__XEvent__OrderedChildrenAssignment_9_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_9_1 )* ) ) )
            // InternalXMachine.g:5483:1: ( ( ( rule__XEvent__OrderedChildrenAssignment_9_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_9_1 )* ) )
            {
            // InternalXMachine.g:5483:1: ( ( ( rule__XEvent__OrderedChildrenAssignment_9_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_9_1 )* ) )
            // InternalXMachine.g:5484:2: ( ( rule__XEvent__OrderedChildrenAssignment_9_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_9_1 )* )
            {
            // InternalXMachine.g:5484:2: ( ( rule__XEvent__OrderedChildrenAssignment_9_1 ) )
            // InternalXMachine.g:5485:3: ( rule__XEvent__OrderedChildrenAssignment_9_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_9_1()); 
            }
            // InternalXMachine.g:5486:3: ( rule__XEvent__OrderedChildrenAssignment_9_1 )
            // InternalXMachine.g:5486:4: rule__XEvent__OrderedChildrenAssignment_9_1
            {
            pushFollow(FOLLOW_13);
            rule__XEvent__OrderedChildrenAssignment_9_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_9_1()); 
            }

            }

            // InternalXMachine.g:5489:2: ( ( rule__XEvent__OrderedChildrenAssignment_9_1 )* )
            // InternalXMachine.g:5490:3: ( rule__XEvent__OrderedChildrenAssignment_9_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_9_1()); 
            }
            // InternalXMachine.g:5491:3: ( rule__XEvent__OrderedChildrenAssignment_9_1 )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( ((LA63_0>=RULE_STRING && LA63_0<=RULE_XLABEL)) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalXMachine.g:5491:4: rule__XEvent__OrderedChildrenAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__XEvent__OrderedChildrenAssignment_9_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_9_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_9__1__Impl"


    // $ANTLR start "rule__XEvent__Group_10__0"
    // InternalXMachine.g:5501:1: rule__XEvent__Group_10__0 : rule__XEvent__Group_10__0__Impl rule__XEvent__Group_10__1 ;
    public final void rule__XEvent__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5505:1: ( rule__XEvent__Group_10__0__Impl rule__XEvent__Group_10__1 )
            // InternalXMachine.g:5506:2: rule__XEvent__Group_10__0__Impl rule__XEvent__Group_10__1
            {
            pushFollow(FOLLOW_12);
            rule__XEvent__Group_10__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XEvent__Group_10__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_10__0"


    // $ANTLR start "rule__XEvent__Group_10__0__Impl"
    // InternalXMachine.g:5513:1: rule__XEvent__Group_10__0__Impl : ( 'with' ) ;
    public final void rule__XEvent__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5517:1: ( ( 'with' ) )
            // InternalXMachine.g:5518:1: ( 'with' )
            {
            // InternalXMachine.g:5518:1: ( 'with' )
            // InternalXMachine.g:5519:2: 'with'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getWithKeyword_10_0()); 
            }
            match(input,204,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getWithKeyword_10_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_10__0__Impl"


    // $ANTLR start "rule__XEvent__Group_10__1"
    // InternalXMachine.g:5528:1: rule__XEvent__Group_10__1 : rule__XEvent__Group_10__1__Impl ;
    public final void rule__XEvent__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5532:1: ( rule__XEvent__Group_10__1__Impl )
            // InternalXMachine.g:5533:2: rule__XEvent__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XEvent__Group_10__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_10__1"


    // $ANTLR start "rule__XEvent__Group_10__1__Impl"
    // InternalXMachine.g:5539:1: rule__XEvent__Group_10__1__Impl : ( ( ( rule__XEvent__OrderedChildrenAssignment_10_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_10_1 )* ) ) ;
    public final void rule__XEvent__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5543:1: ( ( ( ( rule__XEvent__OrderedChildrenAssignment_10_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_10_1 )* ) ) )
            // InternalXMachine.g:5544:1: ( ( ( rule__XEvent__OrderedChildrenAssignment_10_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_10_1 )* ) )
            {
            // InternalXMachine.g:5544:1: ( ( ( rule__XEvent__OrderedChildrenAssignment_10_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_10_1 )* ) )
            // InternalXMachine.g:5545:2: ( ( rule__XEvent__OrderedChildrenAssignment_10_1 ) ) ( ( rule__XEvent__OrderedChildrenAssignment_10_1 )* )
            {
            // InternalXMachine.g:5545:2: ( ( rule__XEvent__OrderedChildrenAssignment_10_1 ) )
            // InternalXMachine.g:5546:3: ( rule__XEvent__OrderedChildrenAssignment_10_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_10_1()); 
            }
            // InternalXMachine.g:5547:3: ( rule__XEvent__OrderedChildrenAssignment_10_1 )
            // InternalXMachine.g:5547:4: rule__XEvent__OrderedChildrenAssignment_10_1
            {
            pushFollow(FOLLOW_13);
            rule__XEvent__OrderedChildrenAssignment_10_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_10_1()); 
            }

            }

            // InternalXMachine.g:5550:2: ( ( rule__XEvent__OrderedChildrenAssignment_10_1 )* )
            // InternalXMachine.g:5551:3: ( rule__XEvent__OrderedChildrenAssignment_10_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_10_1()); 
            }
            // InternalXMachine.g:5552:3: ( rule__XEvent__OrderedChildrenAssignment_10_1 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( ((LA64_0>=RULE_STRING && LA64_0<=RULE_XLABEL)) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalXMachine.g:5552:4: rule__XEvent__OrderedChildrenAssignment_10_1
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__XEvent__OrderedChildrenAssignment_10_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getOrderedChildrenAssignment_10_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__Group_10__1__Impl"


    // $ANTLR start "rule__EventSync__Group__0"
    // InternalXMachine.g:5562:1: rule__EventSync__Group__0 : rule__EventSync__Group__0__Impl rule__EventSync__Group__1 ;
    public final void rule__EventSync__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5566:1: ( rule__EventSync__Group__0__Impl rule__EventSync__Group__1 )
            // InternalXMachine.g:5567:2: rule__EventSync__Group__0__Impl rule__EventSync__Group__1
            {
            pushFollow(FOLLOW_39);
            rule__EventSync__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EventSync__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSync__Group__0"


    // $ANTLR start "rule__EventSync__Group__0__Impl"
    // InternalXMachine.g:5574:1: rule__EventSync__Group__0__Impl : ( () ) ;
    public final void rule__EventSync__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5578:1: ( ( () ) )
            // InternalXMachine.g:5579:1: ( () )
            {
            // InternalXMachine.g:5579:1: ( () )
            // InternalXMachine.g:5580:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEventSyncAccess().getEventSynchronisationAction_0()); 
            }
            // InternalXMachine.g:5581:2: ()
            // InternalXMachine.g:5581:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEventSyncAccess().getEventSynchronisationAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSync__Group__0__Impl"


    // $ANTLR start "rule__EventSync__Group__1"
    // InternalXMachine.g:5589:1: rule__EventSync__Group__1 : rule__EventSync__Group__1__Impl ;
    public final void rule__EventSync__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5593:1: ( rule__EventSync__Group__1__Impl )
            // InternalXMachine.g:5594:2: rule__EventSync__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EventSync__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSync__Group__1"


    // $ANTLR start "rule__EventSync__Group__1__Impl"
    // InternalXMachine.g:5600:1: rule__EventSync__Group__1__Impl : ( ( rule__EventSync__Group_1__0 ) ) ;
    public final void rule__EventSync__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5604:1: ( ( ( rule__EventSync__Group_1__0 ) ) )
            // InternalXMachine.g:5605:1: ( ( rule__EventSync__Group_1__0 ) )
            {
            // InternalXMachine.g:5605:1: ( ( rule__EventSync__Group_1__0 ) )
            // InternalXMachine.g:5606:2: ( rule__EventSync__Group_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEventSyncAccess().getGroup_1()); 
            }
            // InternalXMachine.g:5607:2: ( rule__EventSync__Group_1__0 )
            // InternalXMachine.g:5607:3: rule__EventSync__Group_1__0
            {
            pushFollow(FOLLOW_2);
            rule__EventSync__Group_1__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEventSyncAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSync__Group__1__Impl"


    // $ANTLR start "rule__EventSync__Group_1__0"
    // InternalXMachine.g:5616:1: rule__EventSync__Group_1__0 : rule__EventSync__Group_1__0__Impl rule__EventSync__Group_1__1 ;
    public final void rule__EventSync__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5620:1: ( rule__EventSync__Group_1__0__Impl rule__EventSync__Group_1__1 )
            // InternalXMachine.g:5621:2: rule__EventSync__Group_1__0__Impl rule__EventSync__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__EventSync__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EventSync__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSync__Group_1__0"


    // $ANTLR start "rule__EventSync__Group_1__0__Impl"
    // InternalXMachine.g:5628:1: rule__EventSync__Group_1__0__Impl : ( 'synchronises' ) ;
    public final void rule__EventSync__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5632:1: ( ( 'synchronises' ) )
            // InternalXMachine.g:5633:1: ( 'synchronises' )
            {
            // InternalXMachine.g:5633:1: ( 'synchronises' )
            // InternalXMachine.g:5634:2: 'synchronises'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEventSyncAccess().getSynchronisesKeyword_1_0()); 
            }
            match(input,205,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEventSyncAccess().getSynchronisesKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSync__Group_1__0__Impl"


    // $ANTLR start "rule__EventSync__Group_1__1"
    // InternalXMachine.g:5643:1: rule__EventSync__Group_1__1 : rule__EventSync__Group_1__1__Impl rule__EventSync__Group_1__2 ;
    public final void rule__EventSync__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5647:1: ( rule__EventSync__Group_1__1__Impl rule__EventSync__Group_1__2 )
            // InternalXMachine.g:5648:2: rule__EventSync__Group_1__1__Impl rule__EventSync__Group_1__2
            {
            pushFollow(FOLLOW_5);
            rule__EventSync__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EventSync__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSync__Group_1__1"


    // $ANTLR start "rule__EventSync__Group_1__1__Impl"
    // InternalXMachine.g:5655:1: rule__EventSync__Group_1__1__Impl : ( ( rule__EventSync__Group_1_1__0 )? ) ;
    public final void rule__EventSync__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5659:1: ( ( ( rule__EventSync__Group_1_1__0 )? ) )
            // InternalXMachine.g:5660:1: ( ( rule__EventSync__Group_1_1__0 )? )
            {
            // InternalXMachine.g:5660:1: ( ( rule__EventSync__Group_1_1__0 )? )
            // InternalXMachine.g:5661:2: ( rule__EventSync__Group_1_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEventSyncAccess().getGroup_1_1()); 
            }
            // InternalXMachine.g:5662:2: ( rule__EventSync__Group_1_1__0 )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_ID) ) {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==96) ) {
                    alt65=1;
                }
            }
            switch (alt65) {
                case 1 :
                    // InternalXMachine.g:5662:3: rule__EventSync__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EventSync__Group_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEventSyncAccess().getGroup_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSync__Group_1__1__Impl"


    // $ANTLR start "rule__EventSync__Group_1__2"
    // InternalXMachine.g:5670:1: rule__EventSync__Group_1__2 : rule__EventSync__Group_1__2__Impl ;
    public final void rule__EventSync__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5674:1: ( rule__EventSync__Group_1__2__Impl )
            // InternalXMachine.g:5675:2: rule__EventSync__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EventSync__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSync__Group_1__2"


    // $ANTLR start "rule__EventSync__Group_1__2__Impl"
    // InternalXMachine.g:5681:1: rule__EventSync__Group_1__2__Impl : ( ( rule__EventSync__SynchronisedEventAssignment_1_2 ) ) ;
    public final void rule__EventSync__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5685:1: ( ( ( rule__EventSync__SynchronisedEventAssignment_1_2 ) ) )
            // InternalXMachine.g:5686:1: ( ( rule__EventSync__SynchronisedEventAssignment_1_2 ) )
            {
            // InternalXMachine.g:5686:1: ( ( rule__EventSync__SynchronisedEventAssignment_1_2 ) )
            // InternalXMachine.g:5687:2: ( rule__EventSync__SynchronisedEventAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEventSyncAccess().getSynchronisedEventAssignment_1_2()); 
            }
            // InternalXMachine.g:5688:2: ( rule__EventSync__SynchronisedEventAssignment_1_2 )
            // InternalXMachine.g:5688:3: rule__EventSync__SynchronisedEventAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__EventSync__SynchronisedEventAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEventSyncAccess().getSynchronisedEventAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSync__Group_1__2__Impl"


    // $ANTLR start "rule__EventSync__Group_1_1__0"
    // InternalXMachine.g:5697:1: rule__EventSync__Group_1_1__0 : rule__EventSync__Group_1_1__0__Impl rule__EventSync__Group_1_1__1 ;
    public final void rule__EventSync__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5701:1: ( rule__EventSync__Group_1_1__0__Impl rule__EventSync__Group_1_1__1 )
            // InternalXMachine.g:5702:2: rule__EventSync__Group_1_1__0__Impl rule__EventSync__Group_1_1__1
            {
            pushFollow(FOLLOW_17);
            rule__EventSync__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EventSync__Group_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSync__Group_1_1__0"


    // $ANTLR start "rule__EventSync__Group_1_1__0__Impl"
    // InternalXMachine.g:5709:1: rule__EventSync__Group_1_1__0__Impl : ( ( rule__EventSync__PrefixAssignment_1_1_0 ) ) ;
    public final void rule__EventSync__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5713:1: ( ( ( rule__EventSync__PrefixAssignment_1_1_0 ) ) )
            // InternalXMachine.g:5714:1: ( ( rule__EventSync__PrefixAssignment_1_1_0 ) )
            {
            // InternalXMachine.g:5714:1: ( ( rule__EventSync__PrefixAssignment_1_1_0 ) )
            // InternalXMachine.g:5715:2: ( rule__EventSync__PrefixAssignment_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEventSyncAccess().getPrefixAssignment_1_1_0()); 
            }
            // InternalXMachine.g:5716:2: ( rule__EventSync__PrefixAssignment_1_1_0 )
            // InternalXMachine.g:5716:3: rule__EventSync__PrefixAssignment_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__EventSync__PrefixAssignment_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEventSyncAccess().getPrefixAssignment_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSync__Group_1_1__0__Impl"


    // $ANTLR start "rule__EventSync__Group_1_1__1"
    // InternalXMachine.g:5724:1: rule__EventSync__Group_1_1__1 : rule__EventSync__Group_1_1__1__Impl ;
    public final void rule__EventSync__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5728:1: ( rule__EventSync__Group_1_1__1__Impl )
            // InternalXMachine.g:5729:2: rule__EventSync__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EventSync__Group_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSync__Group_1_1__1"


    // $ANTLR start "rule__EventSync__Group_1_1__1__Impl"
    // InternalXMachine.g:5735:1: rule__EventSync__Group_1_1__1__Impl : ( '.' ) ;
    public final void rule__EventSync__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5739:1: ( ( '.' ) )
            // InternalXMachine.g:5740:1: ( '.' )
            {
            // InternalXMachine.g:5740:1: ( '.' )
            // InternalXMachine.g:5741:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEventSyncAccess().getFullStopKeyword_1_1_1()); 
            }
            match(input,96,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEventSyncAccess().getFullStopKeyword_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSync__Group_1_1__1__Impl"


    // $ANTLR start "rule__XParameter__Group__0"
    // InternalXMachine.g:5751:1: rule__XParameter__Group__0 : rule__XParameter__Group__0__Impl rule__XParameter__Group__1 ;
    public final void rule__XParameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5755:1: ( rule__XParameter__Group__0__Impl rule__XParameter__Group__1 )
            // InternalXMachine.g:5756:2: rule__XParameter__Group__0__Impl rule__XParameter__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__XParameter__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XParameter__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XParameter__Group__0"


    // $ANTLR start "rule__XParameter__Group__0__Impl"
    // InternalXMachine.g:5763:1: rule__XParameter__Group__0__Impl : ( () ) ;
    public final void rule__XParameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5767:1: ( ( () ) )
            // InternalXMachine.g:5768:1: ( () )
            {
            // InternalXMachine.g:5768:1: ( () )
            // InternalXMachine.g:5769:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXParameterAccess().getParameterAction_0()); 
            }
            // InternalXMachine.g:5770:2: ()
            // InternalXMachine.g:5770:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXParameterAccess().getParameterAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XParameter__Group__0__Impl"


    // $ANTLR start "rule__XParameter__Group__1"
    // InternalXMachine.g:5778:1: rule__XParameter__Group__1 : rule__XParameter__Group__1__Impl rule__XParameter__Group__2 ;
    public final void rule__XParameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5782:1: ( rule__XParameter__Group__1__Impl rule__XParameter__Group__2 )
            // InternalXMachine.g:5783:2: rule__XParameter__Group__1__Impl rule__XParameter__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__XParameter__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XParameter__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XParameter__Group__1"


    // $ANTLR start "rule__XParameter__Group__1__Impl"
    // InternalXMachine.g:5790:1: rule__XParameter__Group__1__Impl : ( ( rule__XParameter__CommentAssignment_1 )? ) ;
    public final void rule__XParameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5794:1: ( ( ( rule__XParameter__CommentAssignment_1 )? ) )
            // InternalXMachine.g:5795:1: ( ( rule__XParameter__CommentAssignment_1 )? )
            {
            // InternalXMachine.g:5795:1: ( ( rule__XParameter__CommentAssignment_1 )? )
            // InternalXMachine.g:5796:2: ( rule__XParameter__CommentAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXParameterAccess().getCommentAssignment_1()); 
            }
            // InternalXMachine.g:5797:2: ( rule__XParameter__CommentAssignment_1 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_STRING) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalXMachine.g:5797:3: rule__XParameter__CommentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XParameter__CommentAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXParameterAccess().getCommentAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XParameter__Group__1__Impl"


    // $ANTLR start "rule__XParameter__Group__2"
    // InternalXMachine.g:5805:1: rule__XParameter__Group__2 : rule__XParameter__Group__2__Impl ;
    public final void rule__XParameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5809:1: ( rule__XParameter__Group__2__Impl )
            // InternalXMachine.g:5810:2: rule__XParameter__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XParameter__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XParameter__Group__2"


    // $ANTLR start "rule__XParameter__Group__2__Impl"
    // InternalXMachine.g:5816:1: rule__XParameter__Group__2__Impl : ( ( rule__XParameter__NameAssignment_2 ) ) ;
    public final void rule__XParameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5820:1: ( ( ( rule__XParameter__NameAssignment_2 ) ) )
            // InternalXMachine.g:5821:1: ( ( rule__XParameter__NameAssignment_2 ) )
            {
            // InternalXMachine.g:5821:1: ( ( rule__XParameter__NameAssignment_2 ) )
            // InternalXMachine.g:5822:2: ( rule__XParameter__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXParameterAccess().getNameAssignment_2()); 
            }
            // InternalXMachine.g:5823:2: ( rule__XParameter__NameAssignment_2 )
            // InternalXMachine.g:5823:3: rule__XParameter__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__XParameter__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXParameterAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XParameter__Group__2__Impl"


    // $ANTLR start "rule__XGuard__Group__0"
    // InternalXMachine.g:5832:1: rule__XGuard__Group__0 : rule__XGuard__Group__0__Impl rule__XGuard__Group__1 ;
    public final void rule__XGuard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5836:1: ( rule__XGuard__Group__0__Impl rule__XGuard__Group__1 )
            // InternalXMachine.g:5837:2: rule__XGuard__Group__0__Impl rule__XGuard__Group__1
            {
            pushFollow(FOLLOW_37);
            rule__XGuard__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XGuard__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XGuard__Group__0"


    // $ANTLR start "rule__XGuard__Group__0__Impl"
    // InternalXMachine.g:5844:1: rule__XGuard__Group__0__Impl : ( () ) ;
    public final void rule__XGuard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5848:1: ( ( () ) )
            // InternalXMachine.g:5849:1: ( () )
            {
            // InternalXMachine.g:5849:1: ( () )
            // InternalXMachine.g:5850:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXGuardAccess().getGuardAction_0()); 
            }
            // InternalXMachine.g:5851:2: ()
            // InternalXMachine.g:5851:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXGuardAccess().getGuardAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XGuard__Group__0__Impl"


    // $ANTLR start "rule__XGuard__Group__1"
    // InternalXMachine.g:5859:1: rule__XGuard__Group__1 : rule__XGuard__Group__1__Impl rule__XGuard__Group__2 ;
    public final void rule__XGuard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5863:1: ( rule__XGuard__Group__1__Impl rule__XGuard__Group__2 )
            // InternalXMachine.g:5864:2: rule__XGuard__Group__1__Impl rule__XGuard__Group__2
            {
            pushFollow(FOLLOW_37);
            rule__XGuard__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XGuard__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XGuard__Group__1"


    // $ANTLR start "rule__XGuard__Group__1__Impl"
    // InternalXMachine.g:5871:1: rule__XGuard__Group__1__Impl : ( ( rule__XGuard__CommentAssignment_1 )? ) ;
    public final void rule__XGuard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5875:1: ( ( ( rule__XGuard__CommentAssignment_1 )? ) )
            // InternalXMachine.g:5876:1: ( ( rule__XGuard__CommentAssignment_1 )? )
            {
            // InternalXMachine.g:5876:1: ( ( rule__XGuard__CommentAssignment_1 )? )
            // InternalXMachine.g:5877:2: ( rule__XGuard__CommentAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXGuardAccess().getCommentAssignment_1()); 
            }
            // InternalXMachine.g:5878:2: ( rule__XGuard__CommentAssignment_1 )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_STRING) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalXMachine.g:5878:3: rule__XGuard__CommentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XGuard__CommentAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXGuardAccess().getCommentAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XGuard__Group__1__Impl"


    // $ANTLR start "rule__XGuard__Group__2"
    // InternalXMachine.g:5886:1: rule__XGuard__Group__2 : rule__XGuard__Group__2__Impl rule__XGuard__Group__3 ;
    public final void rule__XGuard__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5890:1: ( rule__XGuard__Group__2__Impl rule__XGuard__Group__3 )
            // InternalXMachine.g:5891:2: rule__XGuard__Group__2__Impl rule__XGuard__Group__3
            {
            pushFollow(FOLLOW_37);
            rule__XGuard__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XGuard__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XGuard__Group__2"


    // $ANTLR start "rule__XGuard__Group__2__Impl"
    // InternalXMachine.g:5898:1: rule__XGuard__Group__2__Impl : ( ( rule__XGuard__TheoremAssignment_2 )? ) ;
    public final void rule__XGuard__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5902:1: ( ( ( rule__XGuard__TheoremAssignment_2 )? ) )
            // InternalXMachine.g:5903:1: ( ( rule__XGuard__TheoremAssignment_2 )? )
            {
            // InternalXMachine.g:5903:1: ( ( rule__XGuard__TheoremAssignment_2 )? )
            // InternalXMachine.g:5904:2: ( rule__XGuard__TheoremAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXGuardAccess().getTheoremAssignment_2()); 
            }
            // InternalXMachine.g:5905:2: ( rule__XGuard__TheoremAssignment_2 )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==210) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalXMachine.g:5905:3: rule__XGuard__TheoremAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__XGuard__TheoremAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXGuardAccess().getTheoremAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XGuard__Group__2__Impl"


    // $ANTLR start "rule__XGuard__Group__3"
    // InternalXMachine.g:5913:1: rule__XGuard__Group__3 : rule__XGuard__Group__3__Impl rule__XGuard__Group__4 ;
    public final void rule__XGuard__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5917:1: ( rule__XGuard__Group__3__Impl rule__XGuard__Group__4 )
            // InternalXMachine.g:5918:2: rule__XGuard__Group__3__Impl rule__XGuard__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__XGuard__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XGuard__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XGuard__Group__3"


    // $ANTLR start "rule__XGuard__Group__3__Impl"
    // InternalXMachine.g:5925:1: rule__XGuard__Group__3__Impl : ( ( rule__XGuard__NameAssignment_3 ) ) ;
    public final void rule__XGuard__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5929:1: ( ( ( rule__XGuard__NameAssignment_3 ) ) )
            // InternalXMachine.g:5930:1: ( ( rule__XGuard__NameAssignment_3 ) )
            {
            // InternalXMachine.g:5930:1: ( ( rule__XGuard__NameAssignment_3 ) )
            // InternalXMachine.g:5931:2: ( rule__XGuard__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXGuardAccess().getNameAssignment_3()); 
            }
            // InternalXMachine.g:5932:2: ( rule__XGuard__NameAssignment_3 )
            // InternalXMachine.g:5932:3: rule__XGuard__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__XGuard__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXGuardAccess().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XGuard__Group__3__Impl"


    // $ANTLR start "rule__XGuard__Group__4"
    // InternalXMachine.g:5940:1: rule__XGuard__Group__4 : rule__XGuard__Group__4__Impl ;
    public final void rule__XGuard__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5944:1: ( rule__XGuard__Group__4__Impl )
            // InternalXMachine.g:5945:2: rule__XGuard__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XGuard__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XGuard__Group__4"


    // $ANTLR start "rule__XGuard__Group__4__Impl"
    // InternalXMachine.g:5951:1: rule__XGuard__Group__4__Impl : ( ( rule__XGuard__PredicateAssignment_4 ) ) ;
    public final void rule__XGuard__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5955:1: ( ( ( rule__XGuard__PredicateAssignment_4 ) ) )
            // InternalXMachine.g:5956:1: ( ( rule__XGuard__PredicateAssignment_4 ) )
            {
            // InternalXMachine.g:5956:1: ( ( rule__XGuard__PredicateAssignment_4 ) )
            // InternalXMachine.g:5957:2: ( rule__XGuard__PredicateAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXGuardAccess().getPredicateAssignment_4()); 
            }
            // InternalXMachine.g:5958:2: ( rule__XGuard__PredicateAssignment_4 )
            // InternalXMachine.g:5958:3: rule__XGuard__PredicateAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__XGuard__PredicateAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXGuardAccess().getPredicateAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XGuard__Group__4__Impl"


    // $ANTLR start "rule__XWitness__Group__0"
    // InternalXMachine.g:5967:1: rule__XWitness__Group__0 : rule__XWitness__Group__0__Impl rule__XWitness__Group__1 ;
    public final void rule__XWitness__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5971:1: ( rule__XWitness__Group__0__Impl rule__XWitness__Group__1 )
            // InternalXMachine.g:5972:2: rule__XWitness__Group__0__Impl rule__XWitness__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__XWitness__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XWitness__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XWitness__Group__0"


    // $ANTLR start "rule__XWitness__Group__0__Impl"
    // InternalXMachine.g:5979:1: rule__XWitness__Group__0__Impl : ( () ) ;
    public final void rule__XWitness__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5983:1: ( ( () ) )
            // InternalXMachine.g:5984:1: ( () )
            {
            // InternalXMachine.g:5984:1: ( () )
            // InternalXMachine.g:5985:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXWitnessAccess().getWitnessAction_0()); 
            }
            // InternalXMachine.g:5986:2: ()
            // InternalXMachine.g:5986:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXWitnessAccess().getWitnessAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XWitness__Group__0__Impl"


    // $ANTLR start "rule__XWitness__Group__1"
    // InternalXMachine.g:5994:1: rule__XWitness__Group__1 : rule__XWitness__Group__1__Impl rule__XWitness__Group__2 ;
    public final void rule__XWitness__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:5998:1: ( rule__XWitness__Group__1__Impl rule__XWitness__Group__2 )
            // InternalXMachine.g:5999:2: rule__XWitness__Group__1__Impl rule__XWitness__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__XWitness__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XWitness__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XWitness__Group__1"


    // $ANTLR start "rule__XWitness__Group__1__Impl"
    // InternalXMachine.g:6006:1: rule__XWitness__Group__1__Impl : ( ( rule__XWitness__CommentAssignment_1 )? ) ;
    public final void rule__XWitness__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6010:1: ( ( ( rule__XWitness__CommentAssignment_1 )? ) )
            // InternalXMachine.g:6011:1: ( ( rule__XWitness__CommentAssignment_1 )? )
            {
            // InternalXMachine.g:6011:1: ( ( rule__XWitness__CommentAssignment_1 )? )
            // InternalXMachine.g:6012:2: ( rule__XWitness__CommentAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXWitnessAccess().getCommentAssignment_1()); 
            }
            // InternalXMachine.g:6013:2: ( rule__XWitness__CommentAssignment_1 )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_STRING) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalXMachine.g:6013:3: rule__XWitness__CommentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XWitness__CommentAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXWitnessAccess().getCommentAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XWitness__Group__1__Impl"


    // $ANTLR start "rule__XWitness__Group__2"
    // InternalXMachine.g:6021:1: rule__XWitness__Group__2 : rule__XWitness__Group__2__Impl rule__XWitness__Group__3 ;
    public final void rule__XWitness__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6025:1: ( rule__XWitness__Group__2__Impl rule__XWitness__Group__3 )
            // InternalXMachine.g:6026:2: rule__XWitness__Group__2__Impl rule__XWitness__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__XWitness__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XWitness__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XWitness__Group__2"


    // $ANTLR start "rule__XWitness__Group__2__Impl"
    // InternalXMachine.g:6033:1: rule__XWitness__Group__2__Impl : ( ( rule__XWitness__NameAssignment_2 ) ) ;
    public final void rule__XWitness__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6037:1: ( ( ( rule__XWitness__NameAssignment_2 ) ) )
            // InternalXMachine.g:6038:1: ( ( rule__XWitness__NameAssignment_2 ) )
            {
            // InternalXMachine.g:6038:1: ( ( rule__XWitness__NameAssignment_2 ) )
            // InternalXMachine.g:6039:2: ( rule__XWitness__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXWitnessAccess().getNameAssignment_2()); 
            }
            // InternalXMachine.g:6040:2: ( rule__XWitness__NameAssignment_2 )
            // InternalXMachine.g:6040:3: rule__XWitness__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__XWitness__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXWitnessAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XWitness__Group__2__Impl"


    // $ANTLR start "rule__XWitness__Group__3"
    // InternalXMachine.g:6048:1: rule__XWitness__Group__3 : rule__XWitness__Group__3__Impl ;
    public final void rule__XWitness__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6052:1: ( rule__XWitness__Group__3__Impl )
            // InternalXMachine.g:6053:2: rule__XWitness__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XWitness__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XWitness__Group__3"


    // $ANTLR start "rule__XWitness__Group__3__Impl"
    // InternalXMachine.g:6059:1: rule__XWitness__Group__3__Impl : ( ( rule__XWitness__PredicateAssignment_3 ) ) ;
    public final void rule__XWitness__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6063:1: ( ( ( rule__XWitness__PredicateAssignment_3 ) ) )
            // InternalXMachine.g:6064:1: ( ( rule__XWitness__PredicateAssignment_3 ) )
            {
            // InternalXMachine.g:6064:1: ( ( rule__XWitness__PredicateAssignment_3 ) )
            // InternalXMachine.g:6065:2: ( rule__XWitness__PredicateAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXWitnessAccess().getPredicateAssignment_3()); 
            }
            // InternalXMachine.g:6066:2: ( rule__XWitness__PredicateAssignment_3 )
            // InternalXMachine.g:6066:3: rule__XWitness__PredicateAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__XWitness__PredicateAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXWitnessAccess().getPredicateAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XWitness__Group__3__Impl"


    // $ANTLR start "rule__XAction__Group__0"
    // InternalXMachine.g:6075:1: rule__XAction__Group__0 : rule__XAction__Group__0__Impl rule__XAction__Group__1 ;
    public final void rule__XAction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6079:1: ( rule__XAction__Group__0__Impl rule__XAction__Group__1 )
            // InternalXMachine.g:6080:2: rule__XAction__Group__0__Impl rule__XAction__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__XAction__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XAction__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAction__Group__0"


    // $ANTLR start "rule__XAction__Group__0__Impl"
    // InternalXMachine.g:6087:1: rule__XAction__Group__0__Impl : ( () ) ;
    public final void rule__XAction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6091:1: ( ( () ) )
            // InternalXMachine.g:6092:1: ( () )
            {
            // InternalXMachine.g:6092:1: ( () )
            // InternalXMachine.g:6093:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXActionAccess().getActionAction_0()); 
            }
            // InternalXMachine.g:6094:2: ()
            // InternalXMachine.g:6094:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXActionAccess().getActionAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAction__Group__0__Impl"


    // $ANTLR start "rule__XAction__Group__1"
    // InternalXMachine.g:6102:1: rule__XAction__Group__1 : rule__XAction__Group__1__Impl rule__XAction__Group__2 ;
    public final void rule__XAction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6106:1: ( rule__XAction__Group__1__Impl rule__XAction__Group__2 )
            // InternalXMachine.g:6107:2: rule__XAction__Group__1__Impl rule__XAction__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__XAction__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XAction__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAction__Group__1"


    // $ANTLR start "rule__XAction__Group__1__Impl"
    // InternalXMachine.g:6114:1: rule__XAction__Group__1__Impl : ( ( rule__XAction__CommentAssignment_1 )? ) ;
    public final void rule__XAction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6118:1: ( ( ( rule__XAction__CommentAssignment_1 )? ) )
            // InternalXMachine.g:6119:1: ( ( rule__XAction__CommentAssignment_1 )? )
            {
            // InternalXMachine.g:6119:1: ( ( rule__XAction__CommentAssignment_1 )? )
            // InternalXMachine.g:6120:2: ( rule__XAction__CommentAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXActionAccess().getCommentAssignment_1()); 
            }
            // InternalXMachine.g:6121:2: ( rule__XAction__CommentAssignment_1 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_STRING) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalXMachine.g:6121:3: rule__XAction__CommentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XAction__CommentAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXActionAccess().getCommentAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAction__Group__1__Impl"


    // $ANTLR start "rule__XAction__Group__2"
    // InternalXMachine.g:6129:1: rule__XAction__Group__2 : rule__XAction__Group__2__Impl rule__XAction__Group__3 ;
    public final void rule__XAction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6133:1: ( rule__XAction__Group__2__Impl rule__XAction__Group__3 )
            // InternalXMachine.g:6134:2: rule__XAction__Group__2__Impl rule__XAction__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__XAction__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XAction__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAction__Group__2"


    // $ANTLR start "rule__XAction__Group__2__Impl"
    // InternalXMachine.g:6141:1: rule__XAction__Group__2__Impl : ( ( rule__XAction__NameAssignment_2 ) ) ;
    public final void rule__XAction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6145:1: ( ( ( rule__XAction__NameAssignment_2 ) ) )
            // InternalXMachine.g:6146:1: ( ( rule__XAction__NameAssignment_2 ) )
            {
            // InternalXMachine.g:6146:1: ( ( rule__XAction__NameAssignment_2 ) )
            // InternalXMachine.g:6147:2: ( rule__XAction__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXActionAccess().getNameAssignment_2()); 
            }
            // InternalXMachine.g:6148:2: ( rule__XAction__NameAssignment_2 )
            // InternalXMachine.g:6148:3: rule__XAction__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__XAction__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXActionAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAction__Group__2__Impl"


    // $ANTLR start "rule__XAction__Group__3"
    // InternalXMachine.g:6156:1: rule__XAction__Group__3 : rule__XAction__Group__3__Impl ;
    public final void rule__XAction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6160:1: ( rule__XAction__Group__3__Impl )
            // InternalXMachine.g:6161:2: rule__XAction__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XAction__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAction__Group__3"


    // $ANTLR start "rule__XAction__Group__3__Impl"
    // InternalXMachine.g:6167:1: rule__XAction__Group__3__Impl : ( ( rule__XAction__ActionAssignment_3 ) ) ;
    public final void rule__XAction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6171:1: ( ( ( rule__XAction__ActionAssignment_3 ) ) )
            // InternalXMachine.g:6172:1: ( ( rule__XAction__ActionAssignment_3 ) )
            {
            // InternalXMachine.g:6172:1: ( ( rule__XAction__ActionAssignment_3 ) )
            // InternalXMachine.g:6173:2: ( rule__XAction__ActionAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXActionAccess().getActionAssignment_3()); 
            }
            // InternalXMachine.g:6174:2: ( rule__XAction__ActionAssignment_3 )
            // InternalXMachine.g:6174:3: rule__XAction__ActionAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__XAction__ActionAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXActionAccess().getActionAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAction__Group__3__Impl"


    // $ANTLR start "rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0"
    // InternalXMachine.g:6183:1: rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0 : rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0__Impl rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__1 ;
    public final void rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6187:1: ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0__Impl rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__1 )
            // InternalXMachine.g:6188:2: rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0__Impl rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__1
            {
            pushFollow(FOLLOW_40);
            rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0"


    // $ANTLR start "rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0__Impl"
    // InternalXMachine.g:6195:1: rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0__Impl : ( '%' ) ;
    public final void rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6199:1: ( ( '%' ) )
            // InternalXMachine.g:6200:1: ( '%' )
            {
            // InternalXMachine.g:6200:1: ( '%' )
            // InternalXMachine.g:6201:2: '%'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPercentSignKeyword_59_0()); 
            }
            match(input,206,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPercentSignKeyword_59_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__0__Impl"


    // $ANTLR start "rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__1"
    // InternalXMachine.g:6210:1: rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__1 : rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__1__Impl ;
    public final void rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6214:1: ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__1__Impl )
            // InternalXMachine.g:6215:2: rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__1"


    // $ANTLR start "rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__1__Impl"
    // InternalXMachine.g:6221:1: rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__1__Impl : ( '\\u22C2' ) ;
    public final void rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6225:1: ( ( '\\u22C2' ) )
            // InternalXMachine.g:6226:1: ( '\\u22C2' )
            {
            // InternalXMachine.g:6226:1: ( '\\u22C2' )
            // InternalXMachine.g:6227:2: '\\u22C2'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryIntersectionKeyword_59_1()); 
            }
            match(input,207,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryIntersectionKeyword_59_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_EXPRESSION_SYMBOLS__Group_59__1__Impl"


    // $ANTLR start "rule__XRecord__Group__0"
    // InternalXMachine.g:6237:1: rule__XRecord__Group__0 : rule__XRecord__Group__0__Impl rule__XRecord__Group__1 ;
    public final void rule__XRecord__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6241:1: ( rule__XRecord__Group__0__Impl rule__XRecord__Group__1 )
            // InternalXMachine.g:6242:2: rule__XRecord__Group__0__Impl rule__XRecord__Group__1
            {
            pushFollow(FOLLOW_41);
            rule__XRecord__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XRecord__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group__0"


    // $ANTLR start "rule__XRecord__Group__0__Impl"
    // InternalXMachine.g:6249:1: rule__XRecord__Group__0__Impl : ( () ) ;
    public final void rule__XRecord__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6253:1: ( ( () ) )
            // InternalXMachine.g:6254:1: ( () )
            {
            // InternalXMachine.g:6254:1: ( () )
            // InternalXMachine.g:6255:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getRecordAction_0()); 
            }
            // InternalXMachine.g:6256:2: ()
            // InternalXMachine.g:6256:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getRecordAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group__0__Impl"


    // $ANTLR start "rule__XRecord__Group__1"
    // InternalXMachine.g:6264:1: rule__XRecord__Group__1 : rule__XRecord__Group__1__Impl rule__XRecord__Group__2 ;
    public final void rule__XRecord__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6268:1: ( rule__XRecord__Group__1__Impl rule__XRecord__Group__2 )
            // InternalXMachine.g:6269:2: rule__XRecord__Group__1__Impl rule__XRecord__Group__2
            {
            pushFollow(FOLLOW_41);
            rule__XRecord__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XRecord__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group__1"


    // $ANTLR start "rule__XRecord__Group__1__Impl"
    // InternalXMachine.g:6276:1: rule__XRecord__Group__1__Impl : ( ( rule__XRecord__CommentAssignment_1 )? ) ;
    public final void rule__XRecord__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6280:1: ( ( ( rule__XRecord__CommentAssignment_1 )? ) )
            // InternalXMachine.g:6281:1: ( ( rule__XRecord__CommentAssignment_1 )? )
            {
            // InternalXMachine.g:6281:1: ( ( rule__XRecord__CommentAssignment_1 )? )
            // InternalXMachine.g:6282:2: ( rule__XRecord__CommentAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getCommentAssignment_1()); 
            }
            // InternalXMachine.g:6283:2: ( rule__XRecord__CommentAssignment_1 )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_STRING) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalXMachine.g:6283:3: rule__XRecord__CommentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XRecord__CommentAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getCommentAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group__1__Impl"


    // $ANTLR start "rule__XRecord__Group__2"
    // InternalXMachine.g:6291:1: rule__XRecord__Group__2 : rule__XRecord__Group__2__Impl rule__XRecord__Group__3 ;
    public final void rule__XRecord__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6295:1: ( rule__XRecord__Group__2__Impl rule__XRecord__Group__3 )
            // InternalXMachine.g:6296:2: rule__XRecord__Group__2__Impl rule__XRecord__Group__3
            {
            pushFollow(FOLLOW_41);
            rule__XRecord__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XRecord__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group__2"


    // $ANTLR start "rule__XRecord__Group__2__Impl"
    // InternalXMachine.g:6303:1: rule__XRecord__Group__2__Impl : ( ( rule__XRecord__Alternatives_2 )? ) ;
    public final void rule__XRecord__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6307:1: ( ( ( rule__XRecord__Alternatives_2 )? ) )
            // InternalXMachine.g:6308:1: ( ( rule__XRecord__Alternatives_2 )? )
            {
            // InternalXMachine.g:6308:1: ( ( rule__XRecord__Alternatives_2 )? )
            // InternalXMachine.g:6309:2: ( rule__XRecord__Alternatives_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getAlternatives_2()); 
            }
            // InternalXMachine.g:6310:2: ( rule__XRecord__Alternatives_2 )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( ((LA72_0>=169 && LA72_0<=172)) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalXMachine.g:6310:3: rule__XRecord__Alternatives_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__XRecord__Alternatives_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getAlternatives_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group__2__Impl"


    // $ANTLR start "rule__XRecord__Group__3"
    // InternalXMachine.g:6318:1: rule__XRecord__Group__3 : rule__XRecord__Group__3__Impl rule__XRecord__Group__4 ;
    public final void rule__XRecord__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6322:1: ( rule__XRecord__Group__3__Impl rule__XRecord__Group__4 )
            // InternalXMachine.g:6323:2: rule__XRecord__Group__3__Impl rule__XRecord__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__XRecord__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XRecord__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group__3"


    // $ANTLR start "rule__XRecord__Group__3__Impl"
    // InternalXMachine.g:6330:1: rule__XRecord__Group__3__Impl : ( ( rule__XRecord__Alternatives_3 ) ) ;
    public final void rule__XRecord__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6334:1: ( ( ( rule__XRecord__Alternatives_3 ) ) )
            // InternalXMachine.g:6335:1: ( ( rule__XRecord__Alternatives_3 ) )
            {
            // InternalXMachine.g:6335:1: ( ( rule__XRecord__Alternatives_3 ) )
            // InternalXMachine.g:6336:2: ( rule__XRecord__Alternatives_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getAlternatives_3()); 
            }
            // InternalXMachine.g:6337:2: ( rule__XRecord__Alternatives_3 )
            // InternalXMachine.g:6337:3: rule__XRecord__Alternatives_3
            {
            pushFollow(FOLLOW_2);
            rule__XRecord__Alternatives_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getAlternatives_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group__3__Impl"


    // $ANTLR start "rule__XRecord__Group__4"
    // InternalXMachine.g:6345:1: rule__XRecord__Group__4 : rule__XRecord__Group__4__Impl rule__XRecord__Group__5 ;
    public final void rule__XRecord__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6349:1: ( rule__XRecord__Group__4__Impl rule__XRecord__Group__5 )
            // InternalXMachine.g:6350:2: rule__XRecord__Group__4__Impl rule__XRecord__Group__5
            {
            pushFollow(FOLLOW_42);
            rule__XRecord__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XRecord__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group__4"


    // $ANTLR start "rule__XRecord__Group__4__Impl"
    // InternalXMachine.g:6357:1: rule__XRecord__Group__4__Impl : ( ( rule__XRecord__NameAssignment_4 ) ) ;
    public final void rule__XRecord__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6361:1: ( ( ( rule__XRecord__NameAssignment_4 ) ) )
            // InternalXMachine.g:6362:1: ( ( rule__XRecord__NameAssignment_4 ) )
            {
            // InternalXMachine.g:6362:1: ( ( rule__XRecord__NameAssignment_4 ) )
            // InternalXMachine.g:6363:2: ( rule__XRecord__NameAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getNameAssignment_4()); 
            }
            // InternalXMachine.g:6364:2: ( rule__XRecord__NameAssignment_4 )
            // InternalXMachine.g:6364:3: rule__XRecord__NameAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__XRecord__NameAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getNameAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group__4__Impl"


    // $ANTLR start "rule__XRecord__Group__5"
    // InternalXMachine.g:6372:1: rule__XRecord__Group__5 : rule__XRecord__Group__5__Impl rule__XRecord__Group__6 ;
    public final void rule__XRecord__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6376:1: ( rule__XRecord__Group__5__Impl rule__XRecord__Group__6 )
            // InternalXMachine.g:6377:2: rule__XRecord__Group__5__Impl rule__XRecord__Group__6
            {
            pushFollow(FOLLOW_42);
            rule__XRecord__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XRecord__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group__5"


    // $ANTLR start "rule__XRecord__Group__5__Impl"
    // InternalXMachine.g:6384:1: rule__XRecord__Group__5__Impl : ( ( rule__XRecord__Group_5__0 )? ) ;
    public final void rule__XRecord__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6388:1: ( ( ( rule__XRecord__Group_5__0 )? ) )
            // InternalXMachine.g:6389:1: ( ( rule__XRecord__Group_5__0 )? )
            {
            // InternalXMachine.g:6389:1: ( ( rule__XRecord__Group_5__0 )? )
            // InternalXMachine.g:6390:2: ( rule__XRecord__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getGroup_5()); 
            }
            // InternalXMachine.g:6391:2: ( rule__XRecord__Group_5__0 )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=175 && LA73_0<=176)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalXMachine.g:6391:3: rule__XRecord__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XRecord__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group__5__Impl"


    // $ANTLR start "rule__XRecord__Group__6"
    // InternalXMachine.g:6399:1: rule__XRecord__Group__6 : rule__XRecord__Group__6__Impl rule__XRecord__Group__7 ;
    public final void rule__XRecord__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6403:1: ( rule__XRecord__Group__6__Impl rule__XRecord__Group__7 )
            // InternalXMachine.g:6404:2: rule__XRecord__Group__6__Impl rule__XRecord__Group__7
            {
            pushFollow(FOLLOW_42);
            rule__XRecord__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XRecord__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group__6"


    // $ANTLR start "rule__XRecord__Group__6__Impl"
    // InternalXMachine.g:6411:1: rule__XRecord__Group__6__Impl : ( ( rule__XRecord__Alternatives_6 )* ) ;
    public final void rule__XRecord__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6415:1: ( ( ( rule__XRecord__Alternatives_6 )* ) )
            // InternalXMachine.g:6416:1: ( ( rule__XRecord__Alternatives_6 )* )
            {
            // InternalXMachine.g:6416:1: ( ( rule__XRecord__Alternatives_6 )* )
            // InternalXMachine.g:6417:2: ( rule__XRecord__Alternatives_6 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getAlternatives_6()); 
            }
            // InternalXMachine.g:6418:2: ( rule__XRecord__Alternatives_6 )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( ((LA74_0>=177 && LA74_0<=178)||LA74_0==208) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalXMachine.g:6418:3: rule__XRecord__Alternatives_6
            	    {
            	    pushFollow(FOLLOW_43);
            	    rule__XRecord__Alternatives_6();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getAlternatives_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group__6__Impl"


    // $ANTLR start "rule__XRecord__Group__7"
    // InternalXMachine.g:6426:1: rule__XRecord__Group__7 : rule__XRecord__Group__7__Impl ;
    public final void rule__XRecord__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6430:1: ( rule__XRecord__Group__7__Impl )
            // InternalXMachine.g:6431:2: rule__XRecord__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XRecord__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group__7"


    // $ANTLR start "rule__XRecord__Group__7__Impl"
    // InternalXMachine.g:6437:1: rule__XRecord__Group__7__Impl : ( 'end' ) ;
    public final void rule__XRecord__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6441:1: ( ( 'end' ) )
            // InternalXMachine.g:6442:1: ( 'end' )
            {
            // InternalXMachine.g:6442:1: ( 'end' )
            // InternalXMachine.g:6443:2: 'end'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getEndKeyword_7()); 
            }
            match(input,186,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getEndKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group__7__Impl"


    // $ANTLR start "rule__XRecord__Group_5__0"
    // InternalXMachine.g:6453:1: rule__XRecord__Group_5__0 : rule__XRecord__Group_5__0__Impl rule__XRecord__Group_5__1 ;
    public final void rule__XRecord__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6457:1: ( rule__XRecord__Group_5__0__Impl rule__XRecord__Group_5__1 )
            // InternalXMachine.g:6458:2: rule__XRecord__Group_5__0__Impl rule__XRecord__Group_5__1
            {
            pushFollow(FOLLOW_5);
            rule__XRecord__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XRecord__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_5__0"


    // $ANTLR start "rule__XRecord__Group_5__0__Impl"
    // InternalXMachine.g:6465:1: rule__XRecord__Group_5__0__Impl : ( ( rule__XRecord__Alternatives_5_0 ) ) ;
    public final void rule__XRecord__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6469:1: ( ( ( rule__XRecord__Alternatives_5_0 ) ) )
            // InternalXMachine.g:6470:1: ( ( rule__XRecord__Alternatives_5_0 ) )
            {
            // InternalXMachine.g:6470:1: ( ( rule__XRecord__Alternatives_5_0 ) )
            // InternalXMachine.g:6471:2: ( rule__XRecord__Alternatives_5_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getAlternatives_5_0()); 
            }
            // InternalXMachine.g:6472:2: ( rule__XRecord__Alternatives_5_0 )
            // InternalXMachine.g:6472:3: rule__XRecord__Alternatives_5_0
            {
            pushFollow(FOLLOW_2);
            rule__XRecord__Alternatives_5_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getAlternatives_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_5__0__Impl"


    // $ANTLR start "rule__XRecord__Group_5__1"
    // InternalXMachine.g:6480:1: rule__XRecord__Group_5__1 : rule__XRecord__Group_5__1__Impl ;
    public final void rule__XRecord__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6484:1: ( rule__XRecord__Group_5__1__Impl )
            // InternalXMachine.g:6485:2: rule__XRecord__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XRecord__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_5__1"


    // $ANTLR start "rule__XRecord__Group_5__1__Impl"
    // InternalXMachine.g:6491:1: rule__XRecord__Group_5__1__Impl : ( ( rule__XRecord__InheritsNamesAssignment_5_1 ) ) ;
    public final void rule__XRecord__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6495:1: ( ( ( rule__XRecord__InheritsNamesAssignment_5_1 ) ) )
            // InternalXMachine.g:6496:1: ( ( rule__XRecord__InheritsNamesAssignment_5_1 ) )
            {
            // InternalXMachine.g:6496:1: ( ( rule__XRecord__InheritsNamesAssignment_5_1 ) )
            // InternalXMachine.g:6497:2: ( rule__XRecord__InheritsNamesAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getInheritsNamesAssignment_5_1()); 
            }
            // InternalXMachine.g:6498:2: ( rule__XRecord__InheritsNamesAssignment_5_1 )
            // InternalXMachine.g:6498:3: rule__XRecord__InheritsNamesAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__XRecord__InheritsNamesAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getInheritsNamesAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_5__1__Impl"


    // $ANTLR start "rule__XRecord__Group_6_0__0"
    // InternalXMachine.g:6507:1: rule__XRecord__Group_6_0__0 : rule__XRecord__Group_6_0__0__Impl rule__XRecord__Group_6_0__1 ;
    public final void rule__XRecord__Group_6_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6511:1: ( rule__XRecord__Group_6_0__0__Impl rule__XRecord__Group_6_0__1 )
            // InternalXMachine.g:6512:2: rule__XRecord__Group_6_0__0__Impl rule__XRecord__Group_6_0__1
            {
            pushFollow(FOLLOW_10);
            rule__XRecord__Group_6_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XRecord__Group_6_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_6_0__0"


    // $ANTLR start "rule__XRecord__Group_6_0__0__Impl"
    // InternalXMachine.g:6519:1: rule__XRecord__Group_6_0__0__Impl : ( ( rule__XRecord__Alternatives_6_0_0 ) ) ;
    public final void rule__XRecord__Group_6_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6523:1: ( ( ( rule__XRecord__Alternatives_6_0_0 ) ) )
            // InternalXMachine.g:6524:1: ( ( rule__XRecord__Alternatives_6_0_0 ) )
            {
            // InternalXMachine.g:6524:1: ( ( rule__XRecord__Alternatives_6_0_0 ) )
            // InternalXMachine.g:6525:2: ( rule__XRecord__Alternatives_6_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getAlternatives_6_0_0()); 
            }
            // InternalXMachine.g:6526:2: ( rule__XRecord__Alternatives_6_0_0 )
            // InternalXMachine.g:6526:3: rule__XRecord__Alternatives_6_0_0
            {
            pushFollow(FOLLOW_2);
            rule__XRecord__Alternatives_6_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getAlternatives_6_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_6_0__0__Impl"


    // $ANTLR start "rule__XRecord__Group_6_0__1"
    // InternalXMachine.g:6534:1: rule__XRecord__Group_6_0__1 : rule__XRecord__Group_6_0__1__Impl ;
    public final void rule__XRecord__Group_6_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6538:1: ( rule__XRecord__Group_6_0__1__Impl )
            // InternalXMachine.g:6539:2: rule__XRecord__Group_6_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XRecord__Group_6_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_6_0__1"


    // $ANTLR start "rule__XRecord__Group_6_0__1__Impl"
    // InternalXMachine.g:6545:1: rule__XRecord__Group_6_0__1__Impl : ( ( rule__XRecord__OrderedChildrenAssignment_6_0_1 ) ) ;
    public final void rule__XRecord__Group_6_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6549:1: ( ( ( rule__XRecord__OrderedChildrenAssignment_6_0_1 ) ) )
            // InternalXMachine.g:6550:1: ( ( rule__XRecord__OrderedChildrenAssignment_6_0_1 ) )
            {
            // InternalXMachine.g:6550:1: ( ( rule__XRecord__OrderedChildrenAssignment_6_0_1 ) )
            // InternalXMachine.g:6551:2: ( rule__XRecord__OrderedChildrenAssignment_6_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getOrderedChildrenAssignment_6_0_1()); 
            }
            // InternalXMachine.g:6552:2: ( rule__XRecord__OrderedChildrenAssignment_6_0_1 )
            // InternalXMachine.g:6552:3: rule__XRecord__OrderedChildrenAssignment_6_0_1
            {
            pushFollow(FOLLOW_2);
            rule__XRecord__OrderedChildrenAssignment_6_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getOrderedChildrenAssignment_6_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_6_0__1__Impl"


    // $ANTLR start "rule__XRecord__Group_6_1__0"
    // InternalXMachine.g:6561:1: rule__XRecord__Group_6_1__0 : rule__XRecord__Group_6_1__0__Impl rule__XRecord__Group_6_1__1 ;
    public final void rule__XRecord__Group_6_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6565:1: ( rule__XRecord__Group_6_1__0__Impl rule__XRecord__Group_6_1__1 )
            // InternalXMachine.g:6566:2: rule__XRecord__Group_6_1__0__Impl rule__XRecord__Group_6_1__1
            {
            pushFollow(FOLLOW_12);
            rule__XRecord__Group_6_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XRecord__Group_6_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_6_1__0"


    // $ANTLR start "rule__XRecord__Group_6_1__0__Impl"
    // InternalXMachine.g:6573:1: rule__XRecord__Group_6_1__0__Impl : ( 'constraint' ) ;
    public final void rule__XRecord__Group_6_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6577:1: ( ( 'constraint' ) )
            // InternalXMachine.g:6578:1: ( 'constraint' )
            {
            // InternalXMachine.g:6578:1: ( 'constraint' )
            // InternalXMachine.g:6579:2: 'constraint'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getConstraintKeyword_6_1_0()); 
            }
            match(input,208,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getConstraintKeyword_6_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_6_1__0__Impl"


    // $ANTLR start "rule__XRecord__Group_6_1__1"
    // InternalXMachine.g:6588:1: rule__XRecord__Group_6_1__1 : rule__XRecord__Group_6_1__1__Impl ;
    public final void rule__XRecord__Group_6_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6592:1: ( rule__XRecord__Group_6_1__1__Impl )
            // InternalXMachine.g:6593:2: rule__XRecord__Group_6_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XRecord__Group_6_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_6_1__1"


    // $ANTLR start "rule__XRecord__Group_6_1__1__Impl"
    // InternalXMachine.g:6599:1: rule__XRecord__Group_6_1__1__Impl : ( ( rule__XRecord__OrderedChildrenAssignment_6_1_1 ) ) ;
    public final void rule__XRecord__Group_6_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6603:1: ( ( ( rule__XRecord__OrderedChildrenAssignment_6_1_1 ) ) )
            // InternalXMachine.g:6604:1: ( ( rule__XRecord__OrderedChildrenAssignment_6_1_1 ) )
            {
            // InternalXMachine.g:6604:1: ( ( rule__XRecord__OrderedChildrenAssignment_6_1_1 ) )
            // InternalXMachine.g:6605:2: ( rule__XRecord__OrderedChildrenAssignment_6_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getOrderedChildrenAssignment_6_1_1()); 
            }
            // InternalXMachine.g:6606:2: ( rule__XRecord__OrderedChildrenAssignment_6_1_1 )
            // InternalXMachine.g:6606:3: rule__XRecord__OrderedChildrenAssignment_6_1_1
            {
            pushFollow(FOLLOW_2);
            rule__XRecord__OrderedChildrenAssignment_6_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getOrderedChildrenAssignment_6_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_6_1__1__Impl"


    // $ANTLR start "rule__Field__Group__0"
    // InternalXMachine.g:6615:1: rule__Field__Group__0 : rule__Field__Group__0__Impl rule__Field__Group__1 ;
    public final void rule__Field__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6619:1: ( rule__Field__Group__0__Impl rule__Field__Group__1 )
            // InternalXMachine.g:6620:2: rule__Field__Group__0__Impl rule__Field__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__Field__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Field__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__0"


    // $ANTLR start "rule__Field__Group__0__Impl"
    // InternalXMachine.g:6627:1: rule__Field__Group__0__Impl : ( () ) ;
    public final void rule__Field__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6631:1: ( ( () ) )
            // InternalXMachine.g:6632:1: ( () )
            {
            // InternalXMachine.g:6632:1: ( () )
            // InternalXMachine.g:6633:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getFieldAction_0()); 
            }
            // InternalXMachine.g:6634:2: ()
            // InternalXMachine.g:6634:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getFieldAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__0__Impl"


    // $ANTLR start "rule__Field__Group__1"
    // InternalXMachine.g:6642:1: rule__Field__Group__1 : rule__Field__Group__1__Impl rule__Field__Group__2 ;
    public final void rule__Field__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6646:1: ( rule__Field__Group__1__Impl rule__Field__Group__2 )
            // InternalXMachine.g:6647:2: rule__Field__Group__1__Impl rule__Field__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__Field__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Field__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__1"


    // $ANTLR start "rule__Field__Group__1__Impl"
    // InternalXMachine.g:6654:1: rule__Field__Group__1__Impl : ( ( rule__Field__CommentAssignment_1 )? ) ;
    public final void rule__Field__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6658:1: ( ( ( rule__Field__CommentAssignment_1 )? ) )
            // InternalXMachine.g:6659:1: ( ( rule__Field__CommentAssignment_1 )? )
            {
            // InternalXMachine.g:6659:1: ( ( rule__Field__CommentAssignment_1 )? )
            // InternalXMachine.g:6660:2: ( rule__Field__CommentAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getCommentAssignment_1()); 
            }
            // InternalXMachine.g:6661:2: ( rule__Field__CommentAssignment_1 )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_STRING) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalXMachine.g:6661:3: rule__Field__CommentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Field__CommentAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getCommentAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__1__Impl"


    // $ANTLR start "rule__Field__Group__2"
    // InternalXMachine.g:6669:1: rule__Field__Group__2 : rule__Field__Group__2__Impl rule__Field__Group__3 ;
    public final void rule__Field__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6673:1: ( rule__Field__Group__2__Impl rule__Field__Group__3 )
            // InternalXMachine.g:6674:2: rule__Field__Group__2__Impl rule__Field__Group__3
            {
            pushFollow(FOLLOW_44);
            rule__Field__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Field__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__2"


    // $ANTLR start "rule__Field__Group__2__Impl"
    // InternalXMachine.g:6681:1: rule__Field__Group__2__Impl : ( ( rule__Field__NameAssignment_2 ) ) ;
    public final void rule__Field__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6685:1: ( ( ( rule__Field__NameAssignment_2 ) ) )
            // InternalXMachine.g:6686:1: ( ( rule__Field__NameAssignment_2 ) )
            {
            // InternalXMachine.g:6686:1: ( ( rule__Field__NameAssignment_2 ) )
            // InternalXMachine.g:6687:2: ( rule__Field__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getNameAssignment_2()); 
            }
            // InternalXMachine.g:6688:2: ( rule__Field__NameAssignment_2 )
            // InternalXMachine.g:6688:3: rule__Field__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Field__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__2__Impl"


    // $ANTLR start "rule__Field__Group__3"
    // InternalXMachine.g:6696:1: rule__Field__Group__3 : rule__Field__Group__3__Impl rule__Field__Group__4 ;
    public final void rule__Field__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6700:1: ( rule__Field__Group__3__Impl rule__Field__Group__4 )
            // InternalXMachine.g:6701:2: rule__Field__Group__3__Impl rule__Field__Group__4
            {
            pushFollow(FOLLOW_45);
            rule__Field__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Field__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__3"


    // $ANTLR start "rule__Field__Group__3__Impl"
    // InternalXMachine.g:6708:1: rule__Field__Group__3__Impl : ( ':' ) ;
    public final void rule__Field__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6712:1: ( ( ':' ) )
            // InternalXMachine.g:6713:1: ( ':' )
            {
            // InternalXMachine.g:6713:1: ( ':' )
            // InternalXMachine.g:6714:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getColonKeyword_3()); 
            }
            match(input,107,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getColonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__3__Impl"


    // $ANTLR start "rule__Field__Group__4"
    // InternalXMachine.g:6723:1: rule__Field__Group__4 : rule__Field__Group__4__Impl rule__Field__Group__5 ;
    public final void rule__Field__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6727:1: ( rule__Field__Group__4__Impl rule__Field__Group__5 )
            // InternalXMachine.g:6728:2: rule__Field__Group__4__Impl rule__Field__Group__5
            {
            pushFollow(FOLLOW_45);
            rule__Field__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Field__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__4"


    // $ANTLR start "rule__Field__Group__4__Impl"
    // InternalXMachine.g:6735:1: rule__Field__Group__4__Impl : ( ( rule__Field__MultiplicityAssignment_4 )? ) ;
    public final void rule__Field__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6739:1: ( ( ( rule__Field__MultiplicityAssignment_4 )? ) )
            // InternalXMachine.g:6740:1: ( ( rule__Field__MultiplicityAssignment_4 )? )
            {
            // InternalXMachine.g:6740:1: ( ( rule__Field__MultiplicityAssignment_4 )? )
            // InternalXMachine.g:6741:2: ( rule__Field__MultiplicityAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getMultiplicityAssignment_4()); 
            }
            // InternalXMachine.g:6742:2: ( rule__Field__MultiplicityAssignment_4 )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( ((LA76_0>=182 && LA76_0<=184)) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalXMachine.g:6742:3: rule__Field__MultiplicityAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__Field__MultiplicityAssignment_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getMultiplicityAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__4__Impl"


    // $ANTLR start "rule__Field__Group__5"
    // InternalXMachine.g:6750:1: rule__Field__Group__5 : rule__Field__Group__5__Impl ;
    public final void rule__Field__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6754:1: ( rule__Field__Group__5__Impl )
            // InternalXMachine.g:6755:2: rule__Field__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Field__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__5"


    // $ANTLR start "rule__Field__Group__5__Impl"
    // InternalXMachine.g:6761:1: rule__Field__Group__5__Impl : ( ( rule__Field__TypeAssignment_5 ) ) ;
    public final void rule__Field__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6765:1: ( ( ( rule__Field__TypeAssignment_5 ) ) )
            // InternalXMachine.g:6766:1: ( ( rule__Field__TypeAssignment_5 ) )
            {
            // InternalXMachine.g:6766:1: ( ( rule__Field__TypeAssignment_5 ) )
            // InternalXMachine.g:6767:2: ( rule__Field__TypeAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getTypeAssignment_5()); 
            }
            // InternalXMachine.g:6768:2: ( rule__Field__TypeAssignment_5 )
            // InternalXMachine.g:6768:3: rule__Field__TypeAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Field__TypeAssignment_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getTypeAssignment_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__Group__5__Impl"


    // $ANTLR start "rule__XConstraint__Group__0"
    // InternalXMachine.g:6777:1: rule__XConstraint__Group__0 : rule__XConstraint__Group__0__Impl rule__XConstraint__Group__1 ;
    public final void rule__XConstraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6781:1: ( rule__XConstraint__Group__0__Impl rule__XConstraint__Group__1 )
            // InternalXMachine.g:6782:2: rule__XConstraint__Group__0__Impl rule__XConstraint__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__XConstraint__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XConstraint__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstraint__Group__0"


    // $ANTLR start "rule__XConstraint__Group__0__Impl"
    // InternalXMachine.g:6789:1: rule__XConstraint__Group__0__Impl : ( () ) ;
    public final void rule__XConstraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6793:1: ( ( () ) )
            // InternalXMachine.g:6794:1: ( () )
            {
            // InternalXMachine.g:6794:1: ( () )
            // InternalXMachine.g:6795:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXConstraintAccess().getConstraintAction_0()); 
            }
            // InternalXMachine.g:6796:2: ()
            // InternalXMachine.g:6796:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXConstraintAccess().getConstraintAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstraint__Group__0__Impl"


    // $ANTLR start "rule__XConstraint__Group__1"
    // InternalXMachine.g:6804:1: rule__XConstraint__Group__1 : rule__XConstraint__Group__1__Impl rule__XConstraint__Group__2 ;
    public final void rule__XConstraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6808:1: ( rule__XConstraint__Group__1__Impl rule__XConstraint__Group__2 )
            // InternalXMachine.g:6809:2: rule__XConstraint__Group__1__Impl rule__XConstraint__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__XConstraint__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XConstraint__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstraint__Group__1"


    // $ANTLR start "rule__XConstraint__Group__1__Impl"
    // InternalXMachine.g:6816:1: rule__XConstraint__Group__1__Impl : ( ( rule__XConstraint__CommentAssignment_1 )? ) ;
    public final void rule__XConstraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6820:1: ( ( ( rule__XConstraint__CommentAssignment_1 )? ) )
            // InternalXMachine.g:6821:1: ( ( rule__XConstraint__CommentAssignment_1 )? )
            {
            // InternalXMachine.g:6821:1: ( ( rule__XConstraint__CommentAssignment_1 )? )
            // InternalXMachine.g:6822:2: ( rule__XConstraint__CommentAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXConstraintAccess().getCommentAssignment_1()); 
            }
            // InternalXMachine.g:6823:2: ( rule__XConstraint__CommentAssignment_1 )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_STRING) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalXMachine.g:6823:3: rule__XConstraint__CommentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XConstraint__CommentAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXConstraintAccess().getCommentAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstraint__Group__1__Impl"


    // $ANTLR start "rule__XConstraint__Group__2"
    // InternalXMachine.g:6831:1: rule__XConstraint__Group__2 : rule__XConstraint__Group__2__Impl rule__XConstraint__Group__3 ;
    public final void rule__XConstraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6835:1: ( rule__XConstraint__Group__2__Impl rule__XConstraint__Group__3 )
            // InternalXMachine.g:6836:2: rule__XConstraint__Group__2__Impl rule__XConstraint__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__XConstraint__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__XConstraint__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstraint__Group__2"


    // $ANTLR start "rule__XConstraint__Group__2__Impl"
    // InternalXMachine.g:6843:1: rule__XConstraint__Group__2__Impl : ( ( rule__XConstraint__NameAssignment_2 ) ) ;
    public final void rule__XConstraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6847:1: ( ( ( rule__XConstraint__NameAssignment_2 ) ) )
            // InternalXMachine.g:6848:1: ( ( rule__XConstraint__NameAssignment_2 ) )
            {
            // InternalXMachine.g:6848:1: ( ( rule__XConstraint__NameAssignment_2 ) )
            // InternalXMachine.g:6849:2: ( rule__XConstraint__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXConstraintAccess().getNameAssignment_2()); 
            }
            // InternalXMachine.g:6850:2: ( rule__XConstraint__NameAssignment_2 )
            // InternalXMachine.g:6850:3: rule__XConstraint__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__XConstraint__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXConstraintAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstraint__Group__2__Impl"


    // $ANTLR start "rule__XConstraint__Group__3"
    // InternalXMachine.g:6858:1: rule__XConstraint__Group__3 : rule__XConstraint__Group__3__Impl ;
    public final void rule__XConstraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6862:1: ( rule__XConstraint__Group__3__Impl )
            // InternalXMachine.g:6863:2: rule__XConstraint__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XConstraint__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstraint__Group__3"


    // $ANTLR start "rule__XConstraint__Group__3__Impl"
    // InternalXMachine.g:6869:1: rule__XConstraint__Group__3__Impl : ( ( rule__XConstraint__PredicateAssignment_3 ) ) ;
    public final void rule__XConstraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6873:1: ( ( ( rule__XConstraint__PredicateAssignment_3 ) ) )
            // InternalXMachine.g:6874:1: ( ( rule__XConstraint__PredicateAssignment_3 ) )
            {
            // InternalXMachine.g:6874:1: ( ( rule__XConstraint__PredicateAssignment_3 ) )
            // InternalXMachine.g:6875:2: ( rule__XConstraint__PredicateAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXConstraintAccess().getPredicateAssignment_3()); 
            }
            // InternalXMachine.g:6876:2: ( rule__XConstraint__PredicateAssignment_3 )
            // InternalXMachine.g:6876:3: rule__XConstraint__PredicateAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__XConstraint__PredicateAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXConstraintAccess().getPredicateAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstraint__Group__3__Impl"


    // $ANTLR start "rule__Machine__UnorderedGroup_4"
    // InternalXMachine.g:6885:1: rule__Machine__UnorderedGroup_4 : ( rule__Machine__UnorderedGroup_4__0 )? ;
    public final void rule__Machine__UnorderedGroup_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getMachineAccess().getUnorderedGroup_4());
        	
        try {
            // InternalXMachine.g:6890:1: ( ( rule__Machine__UnorderedGroup_4__0 )? )
            // InternalXMachine.g:6891:2: ( rule__Machine__UnorderedGroup_4__0 )?
            {
            // InternalXMachine.g:6891:2: ( rule__Machine__UnorderedGroup_4__0 )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( LA78_0 == 191 && getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 0) ) {
                alt78=1;
            }
            else if ( LA78_0 == 187 && getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 1) ) {
                alt78=1;
            }
            else if ( LA78_0 == 188 && getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 2) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalXMachine.g:6891:2: rule__Machine__UnorderedGroup_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Machine__UnorderedGroup_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getMachineAccess().getUnorderedGroup_4());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__UnorderedGroup_4"


    // $ANTLR start "rule__Machine__UnorderedGroup_4__Impl"
    // InternalXMachine.g:6899:1: rule__Machine__UnorderedGroup_4__Impl : ( ({...}? => ( ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 ) ) ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 )=> rule__Machine__OrderedChildrenAssignment_4_0 )* ) ) ) ) | ({...}? => ( ( ( rule__Machine__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Machine__Group_4_2__0 ) ) ) ) ) ;
    public final void rule__Machine__UnorderedGroup_4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalXMachine.g:6904:1: ( ( ({...}? => ( ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 ) ) ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 )=> rule__Machine__OrderedChildrenAssignment_4_0 )* ) ) ) ) | ({...}? => ( ( ( rule__Machine__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Machine__Group_4_2__0 ) ) ) ) ) )
            // InternalXMachine.g:6905:3: ( ({...}? => ( ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 ) ) ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 )=> rule__Machine__OrderedChildrenAssignment_4_0 )* ) ) ) ) | ({...}? => ( ( ( rule__Machine__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Machine__Group_4_2__0 ) ) ) ) )
            {
            // InternalXMachine.g:6905:3: ( ({...}? => ( ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 ) ) ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 )=> rule__Machine__OrderedChildrenAssignment_4_0 )* ) ) ) ) | ({...}? => ( ( ( rule__Machine__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Machine__Group_4_2__0 ) ) ) ) )
            int alt80=3;
            int LA80_0 = input.LA(1);

            if ( LA80_0 == 191 && getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 0) ) {
                alt80=1;
            }
            else if ( LA80_0 == 187 && getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 1) ) {
                alt80=2;
            }
            else if ( LA80_0 == 188 && getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 2) ) {
                alt80=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // InternalXMachine.g:6906:3: ({...}? => ( ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 ) ) ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 )=> rule__Machine__OrderedChildrenAssignment_4_0 )* ) ) ) )
                    {
                    // InternalXMachine.g:6906:3: ({...}? => ( ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 ) ) ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 )=> rule__Machine__OrderedChildrenAssignment_4_0 )* ) ) ) )
                    // InternalXMachine.g:6907:4: {...}? => ( ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 ) ) ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 )=> rule__Machine__OrderedChildrenAssignment_4_0 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Machine__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 0)");
                    }
                    // InternalXMachine.g:6907:103: ( ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 ) ) ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 )=> rule__Machine__OrderedChildrenAssignment_4_0 )* ) ) )
                    // InternalXMachine.g:6908:5: ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 ) ) ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 )=> rule__Machine__OrderedChildrenAssignment_4_0 )* ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 0);
                    selected = true;
                    // InternalXMachine.g:6914:5: ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 ) ) ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 )=> rule__Machine__OrderedChildrenAssignment_4_0 )* ) )
                    // InternalXMachine.g:6915:6: ( ( rule__Machine__OrderedChildrenAssignment_4_0 ) ) ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 )=> rule__Machine__OrderedChildrenAssignment_4_0 )* )
                    {
                    // InternalXMachine.g:6915:6: ( ( rule__Machine__OrderedChildrenAssignment_4_0 ) )
                    // InternalXMachine.g:6916:7: ( rule__Machine__OrderedChildrenAssignment_4_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_4_0()); 
                    }
                    // InternalXMachine.g:6917:7: ( rule__Machine__OrderedChildrenAssignment_4_0 )
                    // InternalXMachine.g:6917:8: rule__Machine__OrderedChildrenAssignment_4_0
                    {
                    pushFollow(FOLLOW_46);
                    rule__Machine__OrderedChildrenAssignment_4_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_4_0()); 
                    }

                    }

                    // InternalXMachine.g:6920:6: ( ( ( rule__Machine__OrderedChildrenAssignment_4_0 )=> rule__Machine__OrderedChildrenAssignment_4_0 )* )
                    // InternalXMachine.g:6921:7: ( ( rule__Machine__OrderedChildrenAssignment_4_0 )=> rule__Machine__OrderedChildrenAssignment_4_0 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_4_0()); 
                    }
                    // InternalXMachine.g:6922:7: ( ( rule__Machine__OrderedChildrenAssignment_4_0 )=> rule__Machine__OrderedChildrenAssignment_4_0 )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==191) ) {
                            int LA79_1 = input.LA(2);

                            if ( (LA79_1==RULE_ID) ) {
                                int LA79_3 = input.LA(3);

                                if ( (synpred1_InternalXMachine()) ) {
                                    alt79=1;
                                }


                            }


                        }


                        switch (alt79) {
                    	case 1 :
                    	    // InternalXMachine.g:6922:8: ( rule__Machine__OrderedChildrenAssignment_4_0 )=> rule__Machine__OrderedChildrenAssignment_4_0
                    	    {
                    	    pushFollow(FOLLOW_46);
                    	    rule__Machine__OrderedChildrenAssignment_4_0();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop79;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMachineAccess().getOrderedChildrenAssignment_4_0()); 
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXMachine.g:6928:3: ({...}? => ( ( ( rule__Machine__Group_4_1__0 ) ) ) )
                    {
                    // InternalXMachine.g:6928:3: ({...}? => ( ( ( rule__Machine__Group_4_1__0 ) ) ) )
                    // InternalXMachine.g:6929:4: {...}? => ( ( ( rule__Machine__Group_4_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Machine__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 1)");
                    }
                    // InternalXMachine.g:6929:103: ( ( ( rule__Machine__Group_4_1__0 ) ) )
                    // InternalXMachine.g:6930:5: ( ( rule__Machine__Group_4_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 1);
                    selected = true;
                    // InternalXMachine.g:6936:5: ( ( rule__Machine__Group_4_1__0 ) )
                    // InternalXMachine.g:6937:6: ( rule__Machine__Group_4_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMachineAccess().getGroup_4_1()); 
                    }
                    // InternalXMachine.g:6938:6: ( rule__Machine__Group_4_1__0 )
                    // InternalXMachine.g:6938:7: rule__Machine__Group_4_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Machine__Group_4_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMachineAccess().getGroup_4_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalXMachine.g:6943:3: ({...}? => ( ( ( rule__Machine__Group_4_2__0 ) ) ) )
                    {
                    // InternalXMachine.g:6943:3: ({...}? => ( ( ( rule__Machine__Group_4_2__0 ) ) ) )
                    // InternalXMachine.g:6944:4: {...}? => ( ( ( rule__Machine__Group_4_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 2) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Machine__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 2)");
                    }
                    // InternalXMachine.g:6944:103: ( ( ( rule__Machine__Group_4_2__0 ) ) )
                    // InternalXMachine.g:6945:5: ( ( rule__Machine__Group_4_2__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 2);
                    selected = true;
                    // InternalXMachine.g:6951:5: ( ( rule__Machine__Group_4_2__0 ) )
                    // InternalXMachine.g:6952:6: ( rule__Machine__Group_4_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMachineAccess().getGroup_4_2()); 
                    }
                    // InternalXMachine.g:6953:6: ( rule__Machine__Group_4_2__0 )
                    // InternalXMachine.g:6953:7: rule__Machine__Group_4_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Machine__Group_4_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMachineAccess().getGroup_4_2()); 
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMachineAccess().getUnorderedGroup_4());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__UnorderedGroup_4__Impl"


    // $ANTLR start "rule__Machine__UnorderedGroup_4__0"
    // InternalXMachine.g:6966:1: rule__Machine__UnorderedGroup_4__0 : rule__Machine__UnorderedGroup_4__Impl ( rule__Machine__UnorderedGroup_4__1 )? ;
    public final void rule__Machine__UnorderedGroup_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6970:1: ( rule__Machine__UnorderedGroup_4__Impl ( rule__Machine__UnorderedGroup_4__1 )? )
            // InternalXMachine.g:6971:2: rule__Machine__UnorderedGroup_4__Impl ( rule__Machine__UnorderedGroup_4__1 )?
            {
            pushFollow(FOLLOW_47);
            rule__Machine__UnorderedGroup_4__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalXMachine.g:6972:2: ( rule__Machine__UnorderedGroup_4__1 )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( LA81_0 == 191 && getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 0) ) {
                alt81=1;
            }
            else if ( LA81_0 == 187 && getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 1) ) {
                alt81=1;
            }
            else if ( LA81_0 == 188 && getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 2) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalXMachine.g:6972:2: rule__Machine__UnorderedGroup_4__1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Machine__UnorderedGroup_4__1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__UnorderedGroup_4__0"


    // $ANTLR start "rule__Machine__UnorderedGroup_4__1"
    // InternalXMachine.g:6978:1: rule__Machine__UnorderedGroup_4__1 : rule__Machine__UnorderedGroup_4__Impl ( rule__Machine__UnorderedGroup_4__2 )? ;
    public final void rule__Machine__UnorderedGroup_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6982:1: ( rule__Machine__UnorderedGroup_4__Impl ( rule__Machine__UnorderedGroup_4__2 )? )
            // InternalXMachine.g:6983:2: rule__Machine__UnorderedGroup_4__Impl ( rule__Machine__UnorderedGroup_4__2 )?
            {
            pushFollow(FOLLOW_47);
            rule__Machine__UnorderedGroup_4__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalXMachine.g:6984:2: ( rule__Machine__UnorderedGroup_4__2 )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( LA82_0 == 191 && getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 0) ) {
                alt82=1;
            }
            else if ( LA82_0 == 187 && getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 1) ) {
                alt82=1;
            }
            else if ( LA82_0 == 188 && getUnorderedGroupHelper().canSelect(grammarAccess.getMachineAccess().getUnorderedGroup_4(), 2) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalXMachine.g:6984:2: rule__Machine__UnorderedGroup_4__2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Machine__UnorderedGroup_4__2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__UnorderedGroup_4__1"


    // $ANTLR start "rule__Machine__UnorderedGroup_4__2"
    // InternalXMachine.g:6990:1: rule__Machine__UnorderedGroup_4__2 : rule__Machine__UnorderedGroup_4__Impl ;
    public final void rule__Machine__UnorderedGroup_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:6994:1: ( rule__Machine__UnorderedGroup_4__Impl )
            // InternalXMachine.g:6995:2: rule__Machine__UnorderedGroup_4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Machine__UnorderedGroup_4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__UnorderedGroup_4__2"


    // $ANTLR start "rule__Machine__CommentAssignment_1"
    // InternalXMachine.g:7002:1: rule__Machine__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Machine__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7006:1: ( ( RULE_STRING ) )
            // InternalXMachine.g:7007:2: ( RULE_STRING )
            {
            // InternalXMachine.g:7007:2: ( RULE_STRING )
            // InternalXMachine.g:7008:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__CommentAssignment_1"


    // $ANTLR start "rule__Machine__NameAssignment_3"
    // InternalXMachine.g:7017:1: rule__Machine__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__Machine__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7021:1: ( ( RULE_ID ) )
            // InternalXMachine.g:7022:2: ( RULE_ID )
            {
            // InternalXMachine.g:7022:2: ( RULE_ID )
            // InternalXMachine.g:7023:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getNameIDTerminalRuleCall_3_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getNameIDTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__NameAssignment_3"


    // $ANTLR start "rule__Machine__OrderedChildrenAssignment_4_0"
    // InternalXMachine.g:7032:1: rule__Machine__OrderedChildrenAssignment_4_0 : ( ruleMIncludes ) ;
    public final void rule__Machine__OrderedChildrenAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7036:1: ( ( ruleMIncludes ) )
            // InternalXMachine.g:7037:2: ( ruleMIncludes )
            {
            // InternalXMachine.g:7037:2: ( ruleMIncludes )
            // InternalXMachine.g:7038:3: ruleMIncludes
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenMIncludesParserRuleCall_4_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMIncludes();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenMIncludesParserRuleCall_4_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__OrderedChildrenAssignment_4_0"


    // $ANTLR start "rule__Machine__RefinesAssignment_4_1_1"
    // InternalXMachine.g:7047:1: rule__Machine__RefinesAssignment_4_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Machine__RefinesAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7051:1: ( ( ( RULE_ID ) ) )
            // InternalXMachine.g:7052:2: ( ( RULE_ID ) )
            {
            // InternalXMachine.g:7052:2: ( ( RULE_ID ) )
            // InternalXMachine.g:7053:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getRefinesMachineCrossReference_4_1_1_0()); 
            }
            // InternalXMachine.g:7054:3: ( RULE_ID )
            // InternalXMachine.g:7055:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getRefinesMachineIDTerminalRuleCall_4_1_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getRefinesMachineIDTerminalRuleCall_4_1_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getRefinesMachineCrossReference_4_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__RefinesAssignment_4_1_1"


    // $ANTLR start "rule__Machine__SeesAssignment_4_2_1"
    // InternalXMachine.g:7066:1: rule__Machine__SeesAssignment_4_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Machine__SeesAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7070:1: ( ( ( RULE_ID ) ) )
            // InternalXMachine.g:7071:2: ( ( RULE_ID ) )
            {
            // InternalXMachine.g:7071:2: ( ( RULE_ID ) )
            // InternalXMachine.g:7072:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getSeesContextCrossReference_4_2_1_0()); 
            }
            // InternalXMachine.g:7073:3: ( RULE_ID )
            // InternalXMachine.g:7074:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getSeesContextIDTerminalRuleCall_4_2_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getSeesContextIDTerminalRuleCall_4_2_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getSeesContextCrossReference_4_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__SeesAssignment_4_2_1"


    // $ANTLR start "rule__Machine__OrderedChildrenAssignment_5_1"
    // InternalXMachine.g:7085:1: rule__Machine__OrderedChildrenAssignment_5_1 : ( ruleMContains ) ;
    public final void rule__Machine__OrderedChildrenAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7089:1: ( ( ruleMContains ) )
            // InternalXMachine.g:7090:2: ( ruleMContains )
            {
            // InternalXMachine.g:7090:2: ( ruleMContains )
            // InternalXMachine.g:7091:3: ruleMContains
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenMContainsParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMContains();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenMContainsParserRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__OrderedChildrenAssignment_5_1"


    // $ANTLR start "rule__Machine__OrderedChildrenAssignment_6_0_1"
    // InternalXMachine.g:7100:1: rule__Machine__OrderedChildrenAssignment_6_0_1 : ( ruleXMultipleVariable ) ;
    public final void rule__Machine__OrderedChildrenAssignment_6_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7104:1: ( ( ruleXMultipleVariable ) )
            // InternalXMachine.g:7105:2: ( ruleXMultipleVariable )
            {
            // InternalXMachine.g:7105:2: ( ruleXMultipleVariable )
            // InternalXMachine.g:7106:3: ruleXMultipleVariable
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenXMultipleVariableParserRuleCall_6_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXMultipleVariable();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenXMultipleVariableParserRuleCall_6_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__OrderedChildrenAssignment_6_0_1"


    // $ANTLR start "rule__Machine__OrderedChildrenAssignment_6_1"
    // InternalXMachine.g:7115:1: rule__Machine__OrderedChildrenAssignment_6_1 : ( ruleXIndividualVariable ) ;
    public final void rule__Machine__OrderedChildrenAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7119:1: ( ( ruleXIndividualVariable ) )
            // InternalXMachine.g:7120:2: ( ruleXIndividualVariable )
            {
            // InternalXMachine.g:7120:2: ( ruleXIndividualVariable )
            // InternalXMachine.g:7121:3: ruleXIndividualVariable
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenXIndividualVariableParserRuleCall_6_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXIndividualVariable();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenXIndividualVariableParserRuleCall_6_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__OrderedChildrenAssignment_6_1"


    // $ANTLR start "rule__Machine__OrderedChildrenAssignment_6_2_1"
    // InternalXMachine.g:7130:1: rule__Machine__OrderedChildrenAssignment_6_2_1 : ( ruleXMultipleInvariant ) ;
    public final void rule__Machine__OrderedChildrenAssignment_6_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7134:1: ( ( ruleXMultipleInvariant ) )
            // InternalXMachine.g:7135:2: ( ruleXMultipleInvariant )
            {
            // InternalXMachine.g:7135:2: ( ruleXMultipleInvariant )
            // InternalXMachine.g:7136:3: ruleXMultipleInvariant
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenXMultipleInvariantParserRuleCall_6_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXMultipleInvariant();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenXMultipleInvariantParserRuleCall_6_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__OrderedChildrenAssignment_6_2_1"


    // $ANTLR start "rule__Machine__OrderedChildrenAssignment_6_3"
    // InternalXMachine.g:7145:1: rule__Machine__OrderedChildrenAssignment_6_3 : ( ruleXIndividualInvariant ) ;
    public final void rule__Machine__OrderedChildrenAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7149:1: ( ( ruleXIndividualInvariant ) )
            // InternalXMachine.g:7150:2: ( ruleXIndividualInvariant )
            {
            // InternalXMachine.g:7150:2: ( ruleXIndividualInvariant )
            // InternalXMachine.g:7151:3: ruleXIndividualInvariant
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenXIndividualInvariantParserRuleCall_6_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXIndividualInvariant();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenXIndividualInvariantParserRuleCall_6_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__OrderedChildrenAssignment_6_3"


    // $ANTLR start "rule__Machine__OrderedChildrenAssignment_6_4"
    // InternalXMachine.g:7160:1: rule__Machine__OrderedChildrenAssignment_6_4 : ( ruleXRecord ) ;
    public final void rule__Machine__OrderedChildrenAssignment_6_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7164:1: ( ( ruleXRecord ) )
            // InternalXMachine.g:7165:2: ( ruleXRecord )
            {
            // InternalXMachine.g:7165:2: ( ruleXRecord )
            // InternalXMachine.g:7166:3: ruleXRecord
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenXRecordParserRuleCall_6_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXRecord();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenXRecordParserRuleCall_6_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__OrderedChildrenAssignment_6_4"


    // $ANTLR start "rule__Machine__OrderedChildrenAssignment_6_5"
    // InternalXMachine.g:7175:1: rule__Machine__OrderedChildrenAssignment_6_5 : ( ruleXVariant ) ;
    public final void rule__Machine__OrderedChildrenAssignment_6_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7179:1: ( ( ruleXVariant ) )
            // InternalXMachine.g:7180:2: ( ruleXVariant )
            {
            // InternalXMachine.g:7180:2: ( ruleXVariant )
            // InternalXMachine.g:7181:3: ruleXVariant
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenXVariantParserRuleCall_6_5_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXVariant();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenXVariantParserRuleCall_6_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__OrderedChildrenAssignment_6_5"


    // $ANTLR start "rule__Machine__OrderedChildrenAssignment_6_6"
    // InternalXMachine.g:7190:1: rule__Machine__OrderedChildrenAssignment_6_6 : ( ruleXEvent ) ;
    public final void rule__Machine__OrderedChildrenAssignment_6_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7194:1: ( ( ruleXEvent ) )
            // InternalXMachine.g:7195:2: ( ruleXEvent )
            {
            // InternalXMachine.g:7195:2: ( ruleXEvent )
            // InternalXMachine.g:7196:3: ruleXEvent
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenXEventParserRuleCall_6_6_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXEvent();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenXEventParserRuleCall_6_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__OrderedChildrenAssignment_6_6"


    // $ANTLR start "rule__Machine__OrderedChildrenAssignment_7_1"
    // InternalXMachine.g:7205:1: rule__Machine__OrderedChildrenAssignment_7_1 : ( ruleXEvent ) ;
    public final void rule__Machine__OrderedChildrenAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7209:1: ( ( ruleXEvent ) )
            // InternalXMachine.g:7210:2: ( ruleXEvent )
            {
            // InternalXMachine.g:7210:2: ( ruleXEvent )
            // InternalXMachine.g:7211:3: ruleXEvent
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMachineAccess().getOrderedChildrenXEventParserRuleCall_7_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXEvent();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMachineAccess().getOrderedChildrenXEventParserRuleCall_7_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__OrderedChildrenAssignment_7_1"


    // $ANTLR start "rule__MContains__ExtensionAssignment_1"
    // InternalXMachine.g:7220:1: rule__MContains__ExtensionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__MContains__ExtensionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7224:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXMachine.g:7225:2: ( ( ruleQualifiedName ) )
            {
            // InternalXMachine.g:7225:2: ( ( ruleQualifiedName ) )
            // InternalXMachine.g:7226:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMContainsAccess().getExtensionDiagramOwnerCrossReference_1_0()); 
            }
            // InternalXMachine.g:7227:3: ( ruleQualifiedName )
            // InternalXMachine.g:7228:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMContainsAccess().getExtensionDiagramOwnerQualifiedNameParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMContainsAccess().getExtensionDiagramOwnerQualifiedNameParserRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMContainsAccess().getExtensionDiagramOwnerCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MContains__ExtensionAssignment_1"


    // $ANTLR start "rule__MIncludes__AbstractMachineAssignment_1_1"
    // InternalXMachine.g:7239:1: rule__MIncludes__AbstractMachineAssignment_1_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__MIncludes__AbstractMachineAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7243:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXMachine.g:7244:2: ( ( ruleQualifiedName ) )
            {
            // InternalXMachine.g:7244:2: ( ( ruleQualifiedName ) )
            // InternalXMachine.g:7245:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getAbstractMachineMachineCrossReference_1_1_0()); 
            }
            // InternalXMachine.g:7246:3: ( ruleQualifiedName )
            // InternalXMachine.g:7247:4: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getAbstractMachineMachineQualifiedNameParserRuleCall_1_1_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getAbstractMachineMachineQualifiedNameParserRuleCall_1_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getAbstractMachineMachineCrossReference_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__AbstractMachineAssignment_1_1"


    // $ANTLR start "rule__MIncludes__ConcreteMachineAssignment_2_1"
    // InternalXMachine.g:7258:1: rule__MIncludes__ConcreteMachineAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__MIncludes__ConcreteMachineAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7262:1: ( ( ( RULE_ID ) ) )
            // InternalXMachine.g:7263:2: ( ( RULE_ID ) )
            {
            // InternalXMachine.g:7263:2: ( ( RULE_ID ) )
            // InternalXMachine.g:7264:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getConcreteMachineMachineCrossReference_2_1_0()); 
            }
            // InternalXMachine.g:7265:3: ( RULE_ID )
            // InternalXMachine.g:7266:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getConcreteMachineMachineIDTerminalRuleCall_2_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getConcreteMachineMachineIDTerminalRuleCall_2_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getConcreteMachineMachineCrossReference_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__ConcreteMachineAssignment_2_1"


    // $ANTLR start "rule__MIncludes__PrefixesAssignment_3_1"
    // InternalXMachine.g:7277:1: rule__MIncludes__PrefixesAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__MIncludes__PrefixesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7281:1: ( ( RULE_ID ) )
            // InternalXMachine.g:7282:2: ( RULE_ID )
            {
            // InternalXMachine.g:7282:2: ( RULE_ID )
            // InternalXMachine.g:7283:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getPrefixesIDTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getPrefixesIDTerminalRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__PrefixesAssignment_3_1"


    // $ANTLR start "rule__MIncludes__PrefixesAssignment_3_2"
    // InternalXMachine.g:7292:1: rule__MIncludes__PrefixesAssignment_3_2 : ( RULE_ID ) ;
    public final void rule__MIncludes__PrefixesAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7296:1: ( ( RULE_ID ) )
            // InternalXMachine.g:7297:2: ( RULE_ID )
            {
            // InternalXMachine.g:7297:2: ( RULE_ID )
            // InternalXMachine.g:7298:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIncludesAccess().getPrefixesIDTerminalRuleCall_3_2_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIncludesAccess().getPrefixesIDTerminalRuleCall_3_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MIncludes__PrefixesAssignment_3_2"


    // $ANTLR start "rule__XMultipleVariable__CommentAssignment_1"
    // InternalXMachine.g:7307:1: rule__XMultipleVariable__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XMultipleVariable__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7311:1: ( ( RULE_STRING ) )
            // InternalXMachine.g:7312:2: ( RULE_STRING )
            {
            // InternalXMachine.g:7312:2: ( RULE_STRING )
            // InternalXMachine.g:7313:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXMultipleVariableAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXMultipleVariableAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleVariable__CommentAssignment_1"


    // $ANTLR start "rule__XMultipleVariable__NameAssignment_2"
    // InternalXMachine.g:7322:1: rule__XMultipleVariable__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__XMultipleVariable__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7326:1: ( ( RULE_ID ) )
            // InternalXMachine.g:7327:2: ( RULE_ID )
            {
            // InternalXMachine.g:7327:2: ( RULE_ID )
            // InternalXMachine.g:7328:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXMultipleVariableAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXMultipleVariableAccess().getNameIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleVariable__NameAssignment_2"


    // $ANTLR start "rule__XIndividualVariable__CommentAssignment_1"
    // InternalXMachine.g:7337:1: rule__XIndividualVariable__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XIndividualVariable__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7341:1: ( ( RULE_STRING ) )
            // InternalXMachine.g:7342:2: ( RULE_STRING )
            {
            // InternalXMachine.g:7342:2: ( RULE_STRING )
            // InternalXMachine.g:7343:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__CommentAssignment_1"


    // $ANTLR start "rule__XIndividualVariable__NameAssignment_3"
    // InternalXMachine.g:7352:1: rule__XIndividualVariable__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__XIndividualVariable__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7356:1: ( ( RULE_ID ) )
            // InternalXMachine.g:7357:2: ( RULE_ID )
            {
            // InternalXMachine.g:7357:2: ( RULE_ID )
            // InternalXMachine.g:7358:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getNameIDTerminalRuleCall_3_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getNameIDTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__NameAssignment_3"


    // $ANTLR start "rule__XIndividualVariable__TypeAssignment_4_1"
    // InternalXMachine.g:7367:1: rule__XIndividualVariable__TypeAssignment_4_1 : ( ruleXType ) ;
    public final void rule__XIndividualVariable__TypeAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7371:1: ( ( ruleXType ) )
            // InternalXMachine.g:7372:2: ( ruleXType )
            {
            // InternalXMachine.g:7372:2: ( ruleXType )
            // InternalXMachine.g:7373:3: ruleXType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getTypeXTypeParserRuleCall_4_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getTypeXTypeParserRuleCall_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__TypeAssignment_4_1"


    // $ANTLR start "rule__XIndividualVariable__ValueAssignment_5_1"
    // InternalXMachine.g:7382:1: rule__XIndividualVariable__ValueAssignment_5_1 : ( ruleXFormula ) ;
    public final void rule__XIndividualVariable__ValueAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7386:1: ( ( ruleXFormula ) )
            // InternalXMachine.g:7387:2: ( ruleXFormula )
            {
            // InternalXMachine.g:7387:2: ( ruleXFormula )
            // InternalXMachine.g:7388:3: ruleXFormula
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getValueXFormulaParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXFormula();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getValueXFormulaParserRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__ValueAssignment_5_1"


    // $ANTLR start "rule__XIndividualVariable__AgentsAssignment_6_1"
    // InternalXMachine.g:7397:1: rule__XIndividualVariable__AgentsAssignment_6_1 : ( RULE_ID ) ;
    public final void rule__XIndividualVariable__AgentsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7401:1: ( ( RULE_ID ) )
            // InternalXMachine.g:7402:2: ( RULE_ID )
            {
            // InternalXMachine.g:7402:2: ( RULE_ID )
            // InternalXMachine.g:7403:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualVariableAccess().getAgentsIDTerminalRuleCall_6_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualVariableAccess().getAgentsIDTerminalRuleCall_6_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualVariable__AgentsAssignment_6_1"


    // $ANTLR start "rule__XMultipleInvariant__CommentAssignment_1"
    // InternalXMachine.g:7412:1: rule__XMultipleInvariant__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XMultipleInvariant__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7416:1: ( ( RULE_STRING ) )
            // InternalXMachine.g:7417:2: ( RULE_STRING )
            {
            // InternalXMachine.g:7417:2: ( RULE_STRING )
            // InternalXMachine.g:7418:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXMultipleInvariantAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXMultipleInvariantAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleInvariant__CommentAssignment_1"


    // $ANTLR start "rule__XMultipleInvariant__NameAssignment_2"
    // InternalXMachine.g:7427:1: rule__XMultipleInvariant__NameAssignment_2 : ( RULE_XLABEL ) ;
    public final void rule__XMultipleInvariant__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7431:1: ( ( RULE_XLABEL ) )
            // InternalXMachine.g:7432:2: ( RULE_XLABEL )
            {
            // InternalXMachine.g:7432:2: ( RULE_XLABEL )
            // InternalXMachine.g:7433:3: RULE_XLABEL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXMultipleInvariantAccess().getNameXLABELTerminalRuleCall_2_0()); 
            }
            match(input,RULE_XLABEL,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXMultipleInvariantAccess().getNameXLABELTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleInvariant__NameAssignment_2"


    // $ANTLR start "rule__XMultipleInvariant__PredicateAssignment_3"
    // InternalXMachine.g:7442:1: rule__XMultipleInvariant__PredicateAssignment_3 : ( ruleXFormula ) ;
    public final void rule__XMultipleInvariant__PredicateAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7446:1: ( ( ruleXFormula ) )
            // InternalXMachine.g:7447:2: ( ruleXFormula )
            {
            // InternalXMachine.g:7447:2: ( ruleXFormula )
            // InternalXMachine.g:7448:3: ruleXFormula
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXMultipleInvariantAccess().getPredicateXFormulaParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXFormula();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXMultipleInvariantAccess().getPredicateXFormulaParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XMultipleInvariant__PredicateAssignment_3"


    // $ANTLR start "rule__XIndividualInvariant__CommentAssignment_1"
    // InternalXMachine.g:7457:1: rule__XIndividualInvariant__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XIndividualInvariant__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7461:1: ( ( RULE_STRING ) )
            // InternalXMachine.g:7462:2: ( RULE_STRING )
            {
            // InternalXMachine.g:7462:2: ( RULE_STRING )
            // InternalXMachine.g:7463:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__CommentAssignment_1"


    // $ANTLR start "rule__XIndividualInvariant__NameAssignment_4"
    // InternalXMachine.g:7472:1: rule__XIndividualInvariant__NameAssignment_4 : ( RULE_XLABEL ) ;
    public final void rule__XIndividualInvariant__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7476:1: ( ( RULE_XLABEL ) )
            // InternalXMachine.g:7477:2: ( RULE_XLABEL )
            {
            // InternalXMachine.g:7477:2: ( RULE_XLABEL )
            // InternalXMachine.g:7478:3: RULE_XLABEL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getNameXLABELTerminalRuleCall_4_0()); 
            }
            match(input,RULE_XLABEL,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getNameXLABELTerminalRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__NameAssignment_4"


    // $ANTLR start "rule__XIndividualInvariant__ConditionAssignment_5_1"
    // InternalXMachine.g:7487:1: rule__XIndividualInvariant__ConditionAssignment_5_1 : ( ruleXFormula ) ;
    public final void rule__XIndividualInvariant__ConditionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7491:1: ( ( ruleXFormula ) )
            // InternalXMachine.g:7492:2: ( ruleXFormula )
            {
            // InternalXMachine.g:7492:2: ( ruleXFormula )
            // InternalXMachine.g:7493:3: ruleXFormula
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getConditionXFormulaParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXFormula();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getConditionXFormulaParserRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__ConditionAssignment_5_1"


    // $ANTLR start "rule__XIndividualInvariant__FactAssignment_8"
    // InternalXMachine.g:7502:1: rule__XIndividualInvariant__FactAssignment_8 : ( ruleXFormula ) ;
    public final void rule__XIndividualInvariant__FactAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7506:1: ( ( ruleXFormula ) )
            // InternalXMachine.g:7507:2: ( ruleXFormula )
            {
            // InternalXMachine.g:7507:2: ( ruleXFormula )
            // InternalXMachine.g:7508:3: ruleXFormula
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getFactXFormulaParserRuleCall_8_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXFormula();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getFactXFormulaParserRuleCall_8_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__FactAssignment_8"


    // $ANTLR start "rule__XIndividualInvariant__VariablesAssignment_10"
    // InternalXMachine.g:7517:1: rule__XIndividualInvariant__VariablesAssignment_10 : ( RULE_ID ) ;
    public final void rule__XIndividualInvariant__VariablesAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7521:1: ( ( RULE_ID ) )
            // InternalXMachine.g:7522:2: ( RULE_ID )
            {
            // InternalXMachine.g:7522:2: ( RULE_ID )
            // InternalXMachine.g:7523:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getVariablesIDTerminalRuleCall_10_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getVariablesIDTerminalRuleCall_10_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__VariablesAssignment_10"


    // $ANTLR start "rule__XIndividualInvariant__AgentsAssignment_11_1"
    // InternalXMachine.g:7532:1: rule__XIndividualInvariant__AgentsAssignment_11_1 : ( RULE_ID ) ;
    public final void rule__XIndividualInvariant__AgentsAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7536:1: ( ( RULE_ID ) )
            // InternalXMachine.g:7537:2: ( RULE_ID )
            {
            // InternalXMachine.g:7537:2: ( RULE_ID )
            // InternalXMachine.g:7538:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXIndividualInvariantAccess().getAgentsIDTerminalRuleCall_11_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXIndividualInvariantAccess().getAgentsIDTerminalRuleCall_11_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualInvariant__AgentsAssignment_11_1"


    // $ANTLR start "rule__XVariant__CommentAssignment_1"
    // InternalXMachine.g:7547:1: rule__XVariant__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XVariant__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7551:1: ( ( RULE_STRING ) )
            // InternalXMachine.g:7552:2: ( RULE_STRING )
            {
            // InternalXMachine.g:7552:2: ( RULE_STRING )
            // InternalXMachine.g:7553:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXVariantAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXVariantAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XVariant__CommentAssignment_1"


    // $ANTLR start "rule__XVariant__NameAssignment_3"
    // InternalXMachine.g:7562:1: rule__XVariant__NameAssignment_3 : ( RULE_XLABEL ) ;
    public final void rule__XVariant__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7566:1: ( ( RULE_XLABEL ) )
            // InternalXMachine.g:7567:2: ( RULE_XLABEL )
            {
            // InternalXMachine.g:7567:2: ( RULE_XLABEL )
            // InternalXMachine.g:7568:3: RULE_XLABEL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXVariantAccess().getNameXLABELTerminalRuleCall_3_0()); 
            }
            match(input,RULE_XLABEL,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXVariantAccess().getNameXLABELTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XVariant__NameAssignment_3"


    // $ANTLR start "rule__XVariant__ExpressionAssignment_4"
    // InternalXMachine.g:7577:1: rule__XVariant__ExpressionAssignment_4 : ( ruleXFormula ) ;
    public final void rule__XVariant__ExpressionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7581:1: ( ( ruleXFormula ) )
            // InternalXMachine.g:7582:2: ( ruleXFormula )
            {
            // InternalXMachine.g:7582:2: ( ruleXFormula )
            // InternalXMachine.g:7583:3: ruleXFormula
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXVariantAccess().getExpressionXFormulaParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXFormula();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXVariantAccess().getExpressionXFormulaParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XVariant__ExpressionAssignment_4"


    // $ANTLR start "rule__XEvent__CommentAssignment_1"
    // InternalXMachine.g:7592:1: rule__XEvent__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XEvent__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7596:1: ( ( RULE_STRING ) )
            // InternalXMachine.g:7597:2: ( RULE_STRING )
            {
            // InternalXMachine.g:7597:2: ( RULE_STRING )
            // InternalXMachine.g:7598:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__CommentAssignment_1"


    // $ANTLR start "rule__XEvent__ConvergenceAssignment_2"
    // InternalXMachine.g:7607:1: rule__XEvent__ConvergenceAssignment_2 : ( ruleXConvergence ) ;
    public final void rule__XEvent__ConvergenceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7611:1: ( ( ruleXConvergence ) )
            // InternalXMachine.g:7612:2: ( ruleXConvergence )
            {
            // InternalXMachine.g:7612:2: ( ruleXConvergence )
            // InternalXMachine.g:7613:3: ruleXConvergence
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getConvergenceXConvergenceEnumRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXConvergence();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getConvergenceXConvergenceEnumRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__ConvergenceAssignment_2"


    // $ANTLR start "rule__XEvent__NameAssignment_4"
    // InternalXMachine.g:7622:1: rule__XEvent__NameAssignment_4 : ( RULE_ID ) ;
    public final void rule__XEvent__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7626:1: ( ( RULE_ID ) )
            // InternalXMachine.g:7627:2: ( RULE_ID )
            {
            // InternalXMachine.g:7627:2: ( RULE_ID )
            // InternalXMachine.g:7628:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getNameIDTerminalRuleCall_4_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getNameIDTerminalRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__NameAssignment_4"


    // $ANTLR start "rule__XEvent__RefinesAssignment_5_0_1"
    // InternalXMachine.g:7637:1: rule__XEvent__RefinesAssignment_5_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__XEvent__RefinesAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7641:1: ( ( ( RULE_ID ) ) )
            // InternalXMachine.g:7642:2: ( ( RULE_ID ) )
            {
            // InternalXMachine.g:7642:2: ( ( RULE_ID ) )
            // InternalXMachine.g:7643:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getRefinesEventCrossReference_5_0_1_0()); 
            }
            // InternalXMachine.g:7644:3: ( RULE_ID )
            // InternalXMachine.g:7645:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getRefinesEventIDTerminalRuleCall_5_0_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getRefinesEventIDTerminalRuleCall_5_0_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getRefinesEventCrossReference_5_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__RefinesAssignment_5_0_1"


    // $ANTLR start "rule__XEvent__ExtendedAssignment_5_1_0"
    // InternalXMachine.g:7656:1: rule__XEvent__ExtendedAssignment_5_1_0 : ( ( 'extends' ) ) ;
    public final void rule__XEvent__ExtendedAssignment_5_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7660:1: ( ( ( 'extends' ) ) )
            // InternalXMachine.g:7661:2: ( ( 'extends' ) )
            {
            // InternalXMachine.g:7661:2: ( ( 'extends' ) )
            // InternalXMachine.g:7662:3: ( 'extends' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getExtendedExtendsKeyword_5_1_0_0()); 
            }
            // InternalXMachine.g:7663:3: ( 'extends' )
            // InternalXMachine.g:7664:4: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getExtendedExtendsKeyword_5_1_0_0()); 
            }
            match(input,209,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getExtendedExtendsKeyword_5_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getExtendedExtendsKeyword_5_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__ExtendedAssignment_5_1_0"


    // $ANTLR start "rule__XEvent__RefinesAssignment_5_1_1"
    // InternalXMachine.g:7675:1: rule__XEvent__RefinesAssignment_5_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__XEvent__RefinesAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7679:1: ( ( ( RULE_ID ) ) )
            // InternalXMachine.g:7680:2: ( ( RULE_ID ) )
            {
            // InternalXMachine.g:7680:2: ( ( RULE_ID ) )
            // InternalXMachine.g:7681:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getRefinesEventCrossReference_5_1_1_0()); 
            }
            // InternalXMachine.g:7682:3: ( RULE_ID )
            // InternalXMachine.g:7683:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getRefinesEventIDTerminalRuleCall_5_1_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getRefinesEventIDTerminalRuleCall_5_1_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getRefinesEventCrossReference_5_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__RefinesAssignment_5_1_1"


    // $ANTLR start "rule__XEvent__OrderedChildrenAssignment_6_1"
    // InternalXMachine.g:7694:1: rule__XEvent__OrderedChildrenAssignment_6_1 : ( ruleXParameter ) ;
    public final void rule__XEvent__OrderedChildrenAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7698:1: ( ( ruleXParameter ) )
            // InternalXMachine.g:7699:2: ( ruleXParameter )
            {
            // InternalXMachine.g:7699:2: ( ruleXParameter )
            // InternalXMachine.g:7700:3: ruleXParameter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getOrderedChildrenXParameterParserRuleCall_6_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getOrderedChildrenXParameterParserRuleCall_6_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__OrderedChildrenAssignment_6_1"


    // $ANTLR start "rule__XEvent__OrderedChildrenAssignment_7"
    // InternalXMachine.g:7709:1: rule__XEvent__OrderedChildrenAssignment_7 : ( ruleEventSync ) ;
    public final void rule__XEvent__OrderedChildrenAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7713:1: ( ( ruleEventSync ) )
            // InternalXMachine.g:7714:2: ( ruleEventSync )
            {
            // InternalXMachine.g:7714:2: ( ruleEventSync )
            // InternalXMachine.g:7715:3: ruleEventSync
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getOrderedChildrenEventSyncParserRuleCall_7_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleEventSync();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getOrderedChildrenEventSyncParserRuleCall_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__OrderedChildrenAssignment_7"


    // $ANTLR start "rule__XEvent__OrderedChildrenAssignment_8_1"
    // InternalXMachine.g:7724:1: rule__XEvent__OrderedChildrenAssignment_8_1 : ( ruleXGuard ) ;
    public final void rule__XEvent__OrderedChildrenAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7728:1: ( ( ruleXGuard ) )
            // InternalXMachine.g:7729:2: ( ruleXGuard )
            {
            // InternalXMachine.g:7729:2: ( ruleXGuard )
            // InternalXMachine.g:7730:3: ruleXGuard
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getOrderedChildrenXGuardParserRuleCall_8_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXGuard();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getOrderedChildrenXGuardParserRuleCall_8_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__OrderedChildrenAssignment_8_1"


    // $ANTLR start "rule__XEvent__OrderedChildrenAssignment_9_1"
    // InternalXMachine.g:7739:1: rule__XEvent__OrderedChildrenAssignment_9_1 : ( ruleXAction ) ;
    public final void rule__XEvent__OrderedChildrenAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7743:1: ( ( ruleXAction ) )
            // InternalXMachine.g:7744:2: ( ruleXAction )
            {
            // InternalXMachine.g:7744:2: ( ruleXAction )
            // InternalXMachine.g:7745:3: ruleXAction
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getOrderedChildrenXActionParserRuleCall_9_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXAction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getOrderedChildrenXActionParserRuleCall_9_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__OrderedChildrenAssignment_9_1"


    // $ANTLR start "rule__XEvent__OrderedChildrenAssignment_10_1"
    // InternalXMachine.g:7754:1: rule__XEvent__OrderedChildrenAssignment_10_1 : ( ruleXWitness ) ;
    public final void rule__XEvent__OrderedChildrenAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7758:1: ( ( ruleXWitness ) )
            // InternalXMachine.g:7759:2: ( ruleXWitness )
            {
            // InternalXMachine.g:7759:2: ( ruleXWitness )
            // InternalXMachine.g:7760:3: ruleXWitness
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXEventAccess().getOrderedChildrenXWitnessParserRuleCall_10_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXWitness();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXEventAccess().getOrderedChildrenXWitnessParserRuleCall_10_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEvent__OrderedChildrenAssignment_10_1"


    // $ANTLR start "rule__EventSync__PrefixAssignment_1_1_0"
    // InternalXMachine.g:7769:1: rule__EventSync__PrefixAssignment_1_1_0 : ( RULE_ID ) ;
    public final void rule__EventSync__PrefixAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7773:1: ( ( RULE_ID ) )
            // InternalXMachine.g:7774:2: ( RULE_ID )
            {
            // InternalXMachine.g:7774:2: ( RULE_ID )
            // InternalXMachine.g:7775:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEventSyncAccess().getPrefixIDTerminalRuleCall_1_1_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEventSyncAccess().getPrefixIDTerminalRuleCall_1_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSync__PrefixAssignment_1_1_0"


    // $ANTLR start "rule__EventSync__SynchronisedEventAssignment_1_2"
    // InternalXMachine.g:7784:1: rule__EventSync__SynchronisedEventAssignment_1_2 : ( ( RULE_ID ) ) ;
    public final void rule__EventSync__SynchronisedEventAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7788:1: ( ( ( RULE_ID ) ) )
            // InternalXMachine.g:7789:2: ( ( RULE_ID ) )
            {
            // InternalXMachine.g:7789:2: ( ( RULE_ID ) )
            // InternalXMachine.g:7790:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEventSyncAccess().getSynchronisedEventEventCrossReference_1_2_0()); 
            }
            // InternalXMachine.g:7791:3: ( RULE_ID )
            // InternalXMachine.g:7792:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEventSyncAccess().getSynchronisedEventEventIDTerminalRuleCall_1_2_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEventSyncAccess().getSynchronisedEventEventIDTerminalRuleCall_1_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEventSyncAccess().getSynchronisedEventEventCrossReference_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSync__SynchronisedEventAssignment_1_2"


    // $ANTLR start "rule__XParameter__CommentAssignment_1"
    // InternalXMachine.g:7803:1: rule__XParameter__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XParameter__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7807:1: ( ( RULE_STRING ) )
            // InternalXMachine.g:7808:2: ( RULE_STRING )
            {
            // InternalXMachine.g:7808:2: ( RULE_STRING )
            // InternalXMachine.g:7809:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXParameterAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXParameterAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XParameter__CommentAssignment_1"


    // $ANTLR start "rule__XParameter__NameAssignment_2"
    // InternalXMachine.g:7818:1: rule__XParameter__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__XParameter__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7822:1: ( ( RULE_ID ) )
            // InternalXMachine.g:7823:2: ( RULE_ID )
            {
            // InternalXMachine.g:7823:2: ( RULE_ID )
            // InternalXMachine.g:7824:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXParameterAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXParameterAccess().getNameIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XParameter__NameAssignment_2"


    // $ANTLR start "rule__XGuard__CommentAssignment_1"
    // InternalXMachine.g:7833:1: rule__XGuard__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XGuard__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7837:1: ( ( RULE_STRING ) )
            // InternalXMachine.g:7838:2: ( RULE_STRING )
            {
            // InternalXMachine.g:7838:2: ( RULE_STRING )
            // InternalXMachine.g:7839:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXGuardAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXGuardAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XGuard__CommentAssignment_1"


    // $ANTLR start "rule__XGuard__TheoremAssignment_2"
    // InternalXMachine.g:7848:1: rule__XGuard__TheoremAssignment_2 : ( ( 'theorem' ) ) ;
    public final void rule__XGuard__TheoremAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7852:1: ( ( ( 'theorem' ) ) )
            // InternalXMachine.g:7853:2: ( ( 'theorem' ) )
            {
            // InternalXMachine.g:7853:2: ( ( 'theorem' ) )
            // InternalXMachine.g:7854:3: ( 'theorem' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXGuardAccess().getTheoremTheoremKeyword_2_0()); 
            }
            // InternalXMachine.g:7855:3: ( 'theorem' )
            // InternalXMachine.g:7856:4: 'theorem'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXGuardAccess().getTheoremTheoremKeyword_2_0()); 
            }
            match(input,210,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXGuardAccess().getTheoremTheoremKeyword_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXGuardAccess().getTheoremTheoremKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XGuard__TheoremAssignment_2"


    // $ANTLR start "rule__XGuard__NameAssignment_3"
    // InternalXMachine.g:7867:1: rule__XGuard__NameAssignment_3 : ( RULE_XLABEL ) ;
    public final void rule__XGuard__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7871:1: ( ( RULE_XLABEL ) )
            // InternalXMachine.g:7872:2: ( RULE_XLABEL )
            {
            // InternalXMachine.g:7872:2: ( RULE_XLABEL )
            // InternalXMachine.g:7873:3: RULE_XLABEL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXGuardAccess().getNameXLABELTerminalRuleCall_3_0()); 
            }
            match(input,RULE_XLABEL,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXGuardAccess().getNameXLABELTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XGuard__NameAssignment_3"


    // $ANTLR start "rule__XGuard__PredicateAssignment_4"
    // InternalXMachine.g:7882:1: rule__XGuard__PredicateAssignment_4 : ( ruleXFormula ) ;
    public final void rule__XGuard__PredicateAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7886:1: ( ( ruleXFormula ) )
            // InternalXMachine.g:7887:2: ( ruleXFormula )
            {
            // InternalXMachine.g:7887:2: ( ruleXFormula )
            // InternalXMachine.g:7888:3: ruleXFormula
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXGuardAccess().getPredicateXFormulaParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXFormula();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXGuardAccess().getPredicateXFormulaParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XGuard__PredicateAssignment_4"


    // $ANTLR start "rule__XWitness__CommentAssignment_1"
    // InternalXMachine.g:7897:1: rule__XWitness__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XWitness__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7901:1: ( ( RULE_STRING ) )
            // InternalXMachine.g:7902:2: ( RULE_STRING )
            {
            // InternalXMachine.g:7902:2: ( RULE_STRING )
            // InternalXMachine.g:7903:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXWitnessAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXWitnessAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XWitness__CommentAssignment_1"


    // $ANTLR start "rule__XWitness__NameAssignment_2"
    // InternalXMachine.g:7912:1: rule__XWitness__NameAssignment_2 : ( RULE_XLABEL ) ;
    public final void rule__XWitness__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7916:1: ( ( RULE_XLABEL ) )
            // InternalXMachine.g:7917:2: ( RULE_XLABEL )
            {
            // InternalXMachine.g:7917:2: ( RULE_XLABEL )
            // InternalXMachine.g:7918:3: RULE_XLABEL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXWitnessAccess().getNameXLABELTerminalRuleCall_2_0()); 
            }
            match(input,RULE_XLABEL,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXWitnessAccess().getNameXLABELTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XWitness__NameAssignment_2"


    // $ANTLR start "rule__XWitness__PredicateAssignment_3"
    // InternalXMachine.g:7927:1: rule__XWitness__PredicateAssignment_3 : ( ruleXFormula ) ;
    public final void rule__XWitness__PredicateAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7931:1: ( ( ruleXFormula ) )
            // InternalXMachine.g:7932:2: ( ruleXFormula )
            {
            // InternalXMachine.g:7932:2: ( ruleXFormula )
            // InternalXMachine.g:7933:3: ruleXFormula
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXWitnessAccess().getPredicateXFormulaParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXFormula();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXWitnessAccess().getPredicateXFormulaParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XWitness__PredicateAssignment_3"


    // $ANTLR start "rule__XAction__CommentAssignment_1"
    // InternalXMachine.g:7942:1: rule__XAction__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XAction__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7946:1: ( ( RULE_STRING ) )
            // InternalXMachine.g:7947:2: ( RULE_STRING )
            {
            // InternalXMachine.g:7947:2: ( RULE_STRING )
            // InternalXMachine.g:7948:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXActionAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXActionAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAction__CommentAssignment_1"


    // $ANTLR start "rule__XAction__NameAssignment_2"
    // InternalXMachine.g:7957:1: rule__XAction__NameAssignment_2 : ( RULE_XLABEL ) ;
    public final void rule__XAction__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7961:1: ( ( RULE_XLABEL ) )
            // InternalXMachine.g:7962:2: ( RULE_XLABEL )
            {
            // InternalXMachine.g:7962:2: ( RULE_XLABEL )
            // InternalXMachine.g:7963:3: RULE_XLABEL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXActionAccess().getNameXLABELTerminalRuleCall_2_0()); 
            }
            match(input,RULE_XLABEL,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXActionAccess().getNameXLABELTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAction__NameAssignment_2"


    // $ANTLR start "rule__XAction__ActionAssignment_3"
    // InternalXMachine.g:7972:1: rule__XAction__ActionAssignment_3 : ( ruleXFormula ) ;
    public final void rule__XAction__ActionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7976:1: ( ( ruleXFormula ) )
            // InternalXMachine.g:7977:2: ( ruleXFormula )
            {
            // InternalXMachine.g:7977:2: ( ruleXFormula )
            // InternalXMachine.g:7978:3: ruleXFormula
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXActionAccess().getActionXFormulaParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXFormula();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXActionAccess().getActionXFormulaParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAction__ActionAssignment_3"


    // $ANTLR start "rule__XRecord__CommentAssignment_1"
    // InternalXMachine.g:7987:1: rule__XRecord__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XRecord__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:7991:1: ( ( RULE_STRING ) )
            // InternalXMachine.g:7992:2: ( RULE_STRING )
            {
            // InternalXMachine.g:7992:2: ( RULE_STRING )
            // InternalXMachine.g:7993:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__CommentAssignment_1"


    // $ANTLR start "rule__XRecord__ExtendedAssignment_2_0"
    // InternalXMachine.g:8002:1: rule__XRecord__ExtendedAssignment_2_0 : ( ( rule__XRecord__ExtendedAlternatives_2_0_0 ) ) ;
    public final void rule__XRecord__ExtendedAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:8006:1: ( ( ( rule__XRecord__ExtendedAlternatives_2_0_0 ) ) )
            // InternalXMachine.g:8007:2: ( ( rule__XRecord__ExtendedAlternatives_2_0_0 ) )
            {
            // InternalXMachine.g:8007:2: ( ( rule__XRecord__ExtendedAlternatives_2_0_0 ) )
            // InternalXMachine.g:8008:3: ( rule__XRecord__ExtendedAlternatives_2_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getExtendedAlternatives_2_0_0()); 
            }
            // InternalXMachine.g:8009:3: ( rule__XRecord__ExtendedAlternatives_2_0_0 )
            // InternalXMachine.g:8009:4: rule__XRecord__ExtendedAlternatives_2_0_0
            {
            pushFollow(FOLLOW_2);
            rule__XRecord__ExtendedAlternatives_2_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getExtendedAlternatives_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__ExtendedAssignment_2_0"


    // $ANTLR start "rule__XRecord__RefinedAssignment_2_1"
    // InternalXMachine.g:8017:1: rule__XRecord__RefinedAssignment_2_1 : ( ( rule__XRecord__RefinedAlternatives_2_1_0 ) ) ;
    public final void rule__XRecord__RefinedAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:8021:1: ( ( ( rule__XRecord__RefinedAlternatives_2_1_0 ) ) )
            // InternalXMachine.g:8022:2: ( ( rule__XRecord__RefinedAlternatives_2_1_0 ) )
            {
            // InternalXMachine.g:8022:2: ( ( rule__XRecord__RefinedAlternatives_2_1_0 ) )
            // InternalXMachine.g:8023:3: ( rule__XRecord__RefinedAlternatives_2_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getRefinedAlternatives_2_1_0()); 
            }
            // InternalXMachine.g:8024:3: ( rule__XRecord__RefinedAlternatives_2_1_0 )
            // InternalXMachine.g:8024:4: rule__XRecord__RefinedAlternatives_2_1_0
            {
            pushFollow(FOLLOW_2);
            rule__XRecord__RefinedAlternatives_2_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getRefinedAlternatives_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__RefinedAssignment_2_1"


    // $ANTLR start "rule__XRecord__NameAssignment_4"
    // InternalXMachine.g:8032:1: rule__XRecord__NameAssignment_4 : ( RULE_ID ) ;
    public final void rule__XRecord__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:8036:1: ( ( RULE_ID ) )
            // InternalXMachine.g:8037:2: ( RULE_ID )
            {
            // InternalXMachine.g:8037:2: ( RULE_ID )
            // InternalXMachine.g:8038:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getNameIDTerminalRuleCall_4_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getNameIDTerminalRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__NameAssignment_4"


    // $ANTLR start "rule__XRecord__InheritsNamesAssignment_5_1"
    // InternalXMachine.g:8047:1: rule__XRecord__InheritsNamesAssignment_5_1 : ( RULE_ID ) ;
    public final void rule__XRecord__InheritsNamesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:8051:1: ( ( RULE_ID ) )
            // InternalXMachine.g:8052:2: ( RULE_ID )
            {
            // InternalXMachine.g:8052:2: ( RULE_ID )
            // InternalXMachine.g:8053:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getInheritsNamesIDTerminalRuleCall_5_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getInheritsNamesIDTerminalRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__InheritsNamesAssignment_5_1"


    // $ANTLR start "rule__XRecord__OrderedChildrenAssignment_6_0_1"
    // InternalXMachine.g:8062:1: rule__XRecord__OrderedChildrenAssignment_6_0_1 : ( ruleField ) ;
    public final void rule__XRecord__OrderedChildrenAssignment_6_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:8066:1: ( ( ruleField ) )
            // InternalXMachine.g:8067:2: ( ruleField )
            {
            // InternalXMachine.g:8067:2: ( ruleField )
            // InternalXMachine.g:8068:3: ruleField
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getOrderedChildrenFieldParserRuleCall_6_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleField();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getOrderedChildrenFieldParserRuleCall_6_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__OrderedChildrenAssignment_6_0_1"


    // $ANTLR start "rule__XRecord__OrderedChildrenAssignment_6_1_1"
    // InternalXMachine.g:8077:1: rule__XRecord__OrderedChildrenAssignment_6_1_1 : ( ruleXConstraint ) ;
    public final void rule__XRecord__OrderedChildrenAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:8081:1: ( ( ruleXConstraint ) )
            // InternalXMachine.g:8082:2: ( ruleXConstraint )
            {
            // InternalXMachine.g:8082:2: ( ruleXConstraint )
            // InternalXMachine.g:8083:3: ruleXConstraint
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXRecordAccess().getOrderedChildrenXConstraintParserRuleCall_6_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXConstraint();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXRecordAccess().getOrderedChildrenXConstraintParserRuleCall_6_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__OrderedChildrenAssignment_6_1_1"


    // $ANTLR start "rule__Field__CommentAssignment_1"
    // InternalXMachine.g:8092:1: rule__Field__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Field__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:8096:1: ( ( RULE_STRING ) )
            // InternalXMachine.g:8097:2: ( RULE_STRING )
            {
            // InternalXMachine.g:8097:2: ( RULE_STRING )
            // InternalXMachine.g:8098:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__CommentAssignment_1"


    // $ANTLR start "rule__Field__NameAssignment_2"
    // InternalXMachine.g:8107:1: rule__Field__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Field__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:8111:1: ( ( RULE_ID ) )
            // InternalXMachine.g:8112:2: ( RULE_ID )
            {
            // InternalXMachine.g:8112:2: ( RULE_ID )
            // InternalXMachine.g:8113:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__NameAssignment_2"


    // $ANTLR start "rule__Field__MultiplicityAssignment_4"
    // InternalXMachine.g:8122:1: rule__Field__MultiplicityAssignment_4 : ( ruleMultiplicity ) ;
    public final void rule__Field__MultiplicityAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:8126:1: ( ( ruleMultiplicity ) )
            // InternalXMachine.g:8127:2: ( ruleMultiplicity )
            {
            // InternalXMachine.g:8127:2: ( ruleMultiplicity )
            // InternalXMachine.g:8128:3: ruleMultiplicity
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getMultiplicityMultiplicityEnumRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMultiplicity();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getMultiplicityMultiplicityEnumRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__MultiplicityAssignment_4"


    // $ANTLR start "rule__Field__TypeAssignment_5"
    // InternalXMachine.g:8137:1: rule__Field__TypeAssignment_5 : ( ruleXType ) ;
    public final void rule__Field__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:8141:1: ( ( ruleXType ) )
            // InternalXMachine.g:8142:2: ( ruleXType )
            {
            // InternalXMachine.g:8142:2: ( ruleXType )
            // InternalXMachine.g:8143:3: ruleXType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFieldAccess().getTypeXTypeParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFieldAccess().getTypeXTypeParserRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Field__TypeAssignment_5"


    // $ANTLR start "rule__XConstraint__CommentAssignment_1"
    // InternalXMachine.g:8152:1: rule__XConstraint__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XConstraint__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:8156:1: ( ( RULE_STRING ) )
            // InternalXMachine.g:8157:2: ( RULE_STRING )
            {
            // InternalXMachine.g:8157:2: ( RULE_STRING )
            // InternalXMachine.g:8158:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXConstraintAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXConstraintAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstraint__CommentAssignment_1"


    // $ANTLR start "rule__XConstraint__NameAssignment_2"
    // InternalXMachine.g:8167:1: rule__XConstraint__NameAssignment_2 : ( RULE_XLABEL ) ;
    public final void rule__XConstraint__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:8171:1: ( ( RULE_XLABEL ) )
            // InternalXMachine.g:8172:2: ( RULE_XLABEL )
            {
            // InternalXMachine.g:8172:2: ( RULE_XLABEL )
            // InternalXMachine.g:8173:3: RULE_XLABEL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXConstraintAccess().getNameXLABELTerminalRuleCall_2_0()); 
            }
            match(input,RULE_XLABEL,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXConstraintAccess().getNameXLABELTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstraint__NameAssignment_2"


    // $ANTLR start "rule__XConstraint__PredicateAssignment_3"
    // InternalXMachine.g:8182:1: rule__XConstraint__PredicateAssignment_3 : ( ruleXFormula ) ;
    public final void rule__XConstraint__PredicateAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXMachine.g:8186:1: ( ( ruleXFormula ) )
            // InternalXMachine.g:8187:2: ( ruleXFormula )
            {
            // InternalXMachine.g:8187:2: ( ruleXFormula )
            // InternalXMachine.g:8188:3: ruleXFormula
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXConstraintAccess().getPredicateXFormulaParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleXFormula();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXConstraintAccess().getPredicateXFormulaParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstraint__PredicateAssignment_3"

    // $ANTLR start synpred1_InternalXMachine
    public final void synpred1_InternalXMachine_fragment() throws RecognitionException {   
        // InternalXMachine.g:6922:8: ( rule__Machine__OrderedChildrenAssignment_4_0 )
        // InternalXMachine.g:6922:9: rule__Machine__OrderedChildrenAssignment_4_0
        {
        pushFollow(FOLLOW_2);
        rule__Machine__OrderedChildrenAssignment_4_0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalXMachine

    // Delegated rules

    public final boolean synpred1_InternalXMachine() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalXMachine_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xFFFC3FFFFFFC0032L,0xFFFFFFFFFFFFFFFFL,0x000001FFFFFFFFFFL,0x0000000000004000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x9800000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000003F040L,0x0000000000000000L,0x64387E0000000000L,0x0000000000000608L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000003F042L,0x0000000000000000L,0x00387E0000000000L,0x0000000000000608L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000000003F040L,0x0000000000000000L,0x00387E0000000000L,0x0000000000000608L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000030040L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000080200000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00003C0000000010L,0x00000000000004A0L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xFFFC3FFFFFFC0030L,0xFFFFFFFFFFFFFFFFL,0x000001FFFFFFFFFFL,0x0000000000004000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000003FFFFFC0000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000003FFFFFC0002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000120L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0003C00000000000L,0x0000000000000000L,0x0C00000000000000L,0x0000000000023800L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00000000000000C0L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x00000000000000C2L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000000L,0x00007E0000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0407800000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0006000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x00003C0000000010L,0x00000000000004A0L,0x01C0000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x9800000000000000L});

}
