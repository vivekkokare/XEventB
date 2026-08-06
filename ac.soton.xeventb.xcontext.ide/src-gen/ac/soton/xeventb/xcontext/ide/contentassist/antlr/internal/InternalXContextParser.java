package ac.soton.xeventb.xcontext.ide.contentassist.antlr.internal;

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
import ac.soton.xeventb.xcontext.services.XContextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXContextParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_UNTRANSLATED_TOKEN", "RULE_STRING", "RULE_XLABEL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'extend'", "'ext'", "'constant'", "'cst'", "'axiom'", "'axm'", "'theorem'", "'thm'", "'\\u2194'", "'\\uE100'", "'\\uE101'", "'\\uE102'", "'\\u21F8'", "'\\u2192'", "'\\u2914'", "'\\u21A3'", "'\\u2900'", "'\\u21A0'", "'\\u2916'", "'\\u00D7'", "'BOOL'", "'\\u21151'", "'\\u2115'", "'\\u2124'", "'FALSE'", "'TRUE'", "'bool'", "'card'", "'dom'", "'finite'", "'id'", "'inter'", "'max'", "'min'", "'mod'", "'pred'", "'prj1'", "'prj2'", "'ran'", "'succ'", "'union'", "'\\u21191'", "'\\u2119'", "'('", "')'", "'\\u21D4'", "'\\u21D2'", "'\\u2227'", "'&'", "'\\u2228'", "'\\u00AC'", "'\\u22A4'", "'\\u22A5'", "'\\u2200'", "'!'", "'\\u2203'", "'#'", "','", "'\\u00B7'", "'.'", "'='", "'\\u2260'", "'\\u2264'", "'<'", "'\\u2265'", "'>'", "'\\u2208'", "':'", "'\\u2209'", "'\\u2282'", "'\\u2284'", "'\\u2286'", "'\\u2288'", "'partition'", "'{'", "'}'", "'\\u21A6'", "'\\u2205'", "'\\u2229'", "'\\u222A'", "'\\u2216'", "'['", "']'", "'\\uE103'", "'\\u2218'", "';'", "'\\u2297'", "'\\u2225'", "'\\u223C'", "'\\u25C1'", "'\\u2A64'", "'\\u25B7'", "'\\u2A65'", "'\\u03BB'", "'\\u22C3'", "'\\u2223'", "'\\u2025'", "'+'", "'\\u2212'", "'-'", "'\\u2217'", "'*'", "'\\u00F7'", "'/'", "'^'", "'\\\\'", "'one'", "'many'", "'opt'", "'context'", "'end'", "'agents'", "'extends'", "'sets'", "'constants'", "'axioms'", "'set'", "'%'", "'\\u22C2'", "'record'", "'inherits'", "'field'", "'constraint'", "'extended'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__54=54;
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
    public static final int RULE_ML_COMMENT=9;
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
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int RULE_XLABEL=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int RULE_UNTRANSLATED_TOKEN=6;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalXContextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXContextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXContextParser.tokenNames; }
    public String getGrammarFileName() { return "InternalXContext.g"; }


    	private XContextGrammarAccess grammarAccess;

    	public void setGrammarAccess(XContextGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleXContext"
    // InternalXContext.g:53:1: entryRuleXContext : ruleXContext EOF ;
    public final void entryRuleXContext() throws RecognitionException {
        try {
            // InternalXContext.g:54:1: ( ruleXContext EOF )
            // InternalXContext.g:55:1: ruleXContext EOF
            {
             before(grammarAccess.getXContextRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleXContext();

            state._fsp--;

             after(grammarAccess.getXContextRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleXContext"


    // $ANTLR start "ruleXContext"
    // InternalXContext.g:62:1: ruleXContext : ( ( rule__XContext__Group__0 ) ) ;
    public final void ruleXContext() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:66:2: ( ( ( rule__XContext__Group__0 ) ) )
            // InternalXContext.g:67:2: ( ( rule__XContext__Group__0 ) )
            {
            // InternalXContext.g:67:2: ( ( rule__XContext__Group__0 ) )
            // InternalXContext.g:68:3: ( rule__XContext__Group__0 )
            {
             before(grammarAccess.getXContextAccess().getGroup()); 
            // InternalXContext.g:69:3: ( rule__XContext__Group__0 )
            // InternalXContext.g:69:4: rule__XContext__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXContextAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXContext"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalXContext.g:78:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalXContext.g:79:1: ( ruleQualifiedName EOF )
            // InternalXContext.g:80:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalXContext.g:87:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:91:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalXContext.g:92:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalXContext.g:92:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalXContext.g:93:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalXContext.g:94:3: ( rule__QualifiedName__Group__0 )
            // InternalXContext.g:94:4: rule__QualifiedName__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleXAgent"
    // InternalXContext.g:103:1: entryRuleXAgent : ruleXAgent EOF ;
    public final void entryRuleXAgent() throws RecognitionException {
        try {
            // InternalXContext.g:104:1: ( ruleXAgent EOF )
            // InternalXContext.g:105:1: ruleXAgent EOF
            {
             before(grammarAccess.getXAgentRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleXAgent();

            state._fsp--;

             after(grammarAccess.getXAgentRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleXAgent"


    // $ANTLR start "ruleXAgent"
    // InternalXContext.g:112:1: ruleXAgent : ( ( rule__XAgent__NameAssignment ) ) ;
    public final void ruleXAgent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:116:2: ( ( ( rule__XAgent__NameAssignment ) ) )
            // InternalXContext.g:117:2: ( ( rule__XAgent__NameAssignment ) )
            {
            // InternalXContext.g:117:2: ( ( rule__XAgent__NameAssignment ) )
            // InternalXContext.g:118:3: ( rule__XAgent__NameAssignment )
            {
             before(grammarAccess.getXAgentAccess().getNameAssignment()); 
            // InternalXContext.g:119:3: ( rule__XAgent__NameAssignment )
            // InternalXContext.g:119:4: rule__XAgent__NameAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XAgent__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getXAgentAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXAgent"


    // $ANTLR start "entryRuleXCarrierSet"
    // InternalXContext.g:128:1: entryRuleXCarrierSet : ruleXCarrierSet EOF ;
    public final void entryRuleXCarrierSet() throws RecognitionException {
        try {
            // InternalXContext.g:129:1: ( ruleXCarrierSet EOF )
            // InternalXContext.g:130:1: ruleXCarrierSet EOF
            {
             before(grammarAccess.getXCarrierSetRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleXCarrierSet();

            state._fsp--;

             after(grammarAccess.getXCarrierSetRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleXCarrierSet"


    // $ANTLR start "ruleXCarrierSet"
    // InternalXContext.g:137:1: ruleXCarrierSet : ( ( rule__XCarrierSet__Group__0 ) ) ;
    public final void ruleXCarrierSet() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:141:2: ( ( ( rule__XCarrierSet__Group__0 ) ) )
            // InternalXContext.g:142:2: ( ( rule__XCarrierSet__Group__0 ) )
            {
            // InternalXContext.g:142:2: ( ( rule__XCarrierSet__Group__0 ) )
            // InternalXContext.g:143:3: ( rule__XCarrierSet__Group__0 )
            {
             before(grammarAccess.getXCarrierSetAccess().getGroup()); 
            // InternalXContext.g:144:3: ( rule__XCarrierSet__Group__0 )
            // InternalXContext.g:144:4: rule__XCarrierSet__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XCarrierSet__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXCarrierSetAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXCarrierSet"


    // $ANTLR start "entryRuleXIndividualCarrierSet"
    // InternalXContext.g:153:1: entryRuleXIndividualCarrierSet : ruleXIndividualCarrierSet EOF ;
    public final void entryRuleXIndividualCarrierSet() throws RecognitionException {
        try {
            // InternalXContext.g:154:1: ( ruleXIndividualCarrierSet EOF )
            // InternalXContext.g:155:1: ruleXIndividualCarrierSet EOF
            {
             before(grammarAccess.getXIndividualCarrierSetRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleXIndividualCarrierSet();

            state._fsp--;

             after(grammarAccess.getXIndividualCarrierSetRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleXIndividualCarrierSet"


    // $ANTLR start "ruleXIndividualCarrierSet"
    // InternalXContext.g:162:1: ruleXIndividualCarrierSet : ( ( rule__XIndividualCarrierSet__Group__0 ) ) ;
    public final void ruleXIndividualCarrierSet() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:166:2: ( ( ( rule__XIndividualCarrierSet__Group__0 ) ) )
            // InternalXContext.g:167:2: ( ( rule__XIndividualCarrierSet__Group__0 ) )
            {
            // InternalXContext.g:167:2: ( ( rule__XIndividualCarrierSet__Group__0 ) )
            // InternalXContext.g:168:3: ( rule__XIndividualCarrierSet__Group__0 )
            {
             before(grammarAccess.getXIndividualCarrierSetAccess().getGroup()); 
            // InternalXContext.g:169:3: ( rule__XIndividualCarrierSet__Group__0 )
            // InternalXContext.g:169:4: rule__XIndividualCarrierSet__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualCarrierSet__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXIndividualCarrierSetAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXIndividualCarrierSet"


    // $ANTLR start "entryRuleXConstant"
    // InternalXContext.g:178:1: entryRuleXConstant : ruleXConstant EOF ;
    public final void entryRuleXConstant() throws RecognitionException {
        try {
            // InternalXContext.g:179:1: ( ruleXConstant EOF )
            // InternalXContext.g:180:1: ruleXConstant EOF
            {
             before(grammarAccess.getXConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleXConstant();

            state._fsp--;

             after(grammarAccess.getXConstantRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleXConstant"


    // $ANTLR start "ruleXConstant"
    // InternalXContext.g:187:1: ruleXConstant : ( ( rule__XConstant__Group__0 ) ) ;
    public final void ruleXConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:191:2: ( ( ( rule__XConstant__Group__0 ) ) )
            // InternalXContext.g:192:2: ( ( rule__XConstant__Group__0 ) )
            {
            // InternalXContext.g:192:2: ( ( rule__XConstant__Group__0 ) )
            // InternalXContext.g:193:3: ( rule__XConstant__Group__0 )
            {
             before(grammarAccess.getXConstantAccess().getGroup()); 
            // InternalXContext.g:194:3: ( rule__XConstant__Group__0 )
            // InternalXContext.g:194:4: rule__XConstant__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XConstant__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXConstantAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXConstant"


    // $ANTLR start "entryRuleXIndividualConstant"
    // InternalXContext.g:203:1: entryRuleXIndividualConstant : ruleXIndividualConstant EOF ;
    public final void entryRuleXIndividualConstant() throws RecognitionException {
        try {
            // InternalXContext.g:204:1: ( ruleXIndividualConstant EOF )
            // InternalXContext.g:205:1: ruleXIndividualConstant EOF
            {
             before(grammarAccess.getXIndividualConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleXIndividualConstant();

            state._fsp--;

             after(grammarAccess.getXIndividualConstantRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleXIndividualConstant"


    // $ANTLR start "ruleXIndividualConstant"
    // InternalXContext.g:212:1: ruleXIndividualConstant : ( ( rule__XIndividualConstant__Group__0 ) ) ;
    public final void ruleXIndividualConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:216:2: ( ( ( rule__XIndividualConstant__Group__0 ) ) )
            // InternalXContext.g:217:2: ( ( rule__XIndividualConstant__Group__0 ) )
            {
            // InternalXContext.g:217:2: ( ( rule__XIndividualConstant__Group__0 ) )
            // InternalXContext.g:218:3: ( rule__XIndividualConstant__Group__0 )
            {
             before(grammarAccess.getXIndividualConstantAccess().getGroup()); 
            // InternalXContext.g:219:3: ( rule__XIndividualConstant__Group__0 )
            // InternalXContext.g:219:4: rule__XIndividualConstant__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualConstant__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXIndividualConstantAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXIndividualConstant"


    // $ANTLR start "entryRuleXAxiom"
    // InternalXContext.g:228:1: entryRuleXAxiom : ruleXAxiom EOF ;
    public final void entryRuleXAxiom() throws RecognitionException {
        try {
            // InternalXContext.g:229:1: ( ruleXAxiom EOF )
            // InternalXContext.g:230:1: ruleXAxiom EOF
            {
             before(grammarAccess.getXAxiomRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleXAxiom();

            state._fsp--;

             after(grammarAccess.getXAxiomRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleXAxiom"


    // $ANTLR start "ruleXAxiom"
    // InternalXContext.g:237:1: ruleXAxiom : ( ( rule__XAxiom__Group__0 ) ) ;
    public final void ruleXAxiom() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:241:2: ( ( ( rule__XAxiom__Group__0 ) ) )
            // InternalXContext.g:242:2: ( ( rule__XAxiom__Group__0 ) )
            {
            // InternalXContext.g:242:2: ( ( rule__XAxiom__Group__0 ) )
            // InternalXContext.g:243:3: ( rule__XAxiom__Group__0 )
            {
             before(grammarAccess.getXAxiomAccess().getGroup()); 
            // InternalXContext.g:244:3: ( rule__XAxiom__Group__0 )
            // InternalXContext.g:244:4: rule__XAxiom__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XAxiom__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXAxiomAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXAxiom"


    // $ANTLR start "entryRuleXIndividualAxiom"
    // InternalXContext.g:253:1: entryRuleXIndividualAxiom : ruleXIndividualAxiom EOF ;
    public final void entryRuleXIndividualAxiom() throws RecognitionException {
        try {
            // InternalXContext.g:254:1: ( ruleXIndividualAxiom EOF )
            // InternalXContext.g:255:1: ruleXIndividualAxiom EOF
            {
             before(grammarAccess.getXIndividualAxiomRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleXIndividualAxiom();

            state._fsp--;

             after(grammarAccess.getXIndividualAxiomRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleXIndividualAxiom"


    // $ANTLR start "ruleXIndividualAxiom"
    // InternalXContext.g:262:1: ruleXIndividualAxiom : ( ( rule__XIndividualAxiom__Group__0 ) ) ;
    public final void ruleXIndividualAxiom() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:266:2: ( ( ( rule__XIndividualAxiom__Group__0 ) ) )
            // InternalXContext.g:267:2: ( ( rule__XIndividualAxiom__Group__0 ) )
            {
            // InternalXContext.g:267:2: ( ( rule__XIndividualAxiom__Group__0 ) )
            // InternalXContext.g:268:3: ( rule__XIndividualAxiom__Group__0 )
            {
             before(grammarAccess.getXIndividualAxiomAccess().getGroup()); 
            // InternalXContext.g:269:3: ( rule__XIndividualAxiom__Group__0 )
            // InternalXContext.g:269:4: rule__XIndividualAxiom__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualAxiom__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXIndividualAxiomAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXIndividualAxiom"


    // $ANTLR start "entryRuleXIndividualTheorem"
    // InternalXContext.g:278:1: entryRuleXIndividualTheorem : ruleXIndividualTheorem EOF ;
    public final void entryRuleXIndividualTheorem() throws RecognitionException {
        try {
            // InternalXContext.g:279:1: ( ruleXIndividualTheorem EOF )
            // InternalXContext.g:280:1: ruleXIndividualTheorem EOF
            {
             before(grammarAccess.getXIndividualTheoremRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleXIndividualTheorem();

            state._fsp--;

             after(grammarAccess.getXIndividualTheoremRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleXIndividualTheorem"


    // $ANTLR start "ruleXIndividualTheorem"
    // InternalXContext.g:287:1: ruleXIndividualTheorem : ( ( rule__XIndividualTheorem__Group__0 ) ) ;
    public final void ruleXIndividualTheorem() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:291:2: ( ( ( rule__XIndividualTheorem__Group__0 ) ) )
            // InternalXContext.g:292:2: ( ( rule__XIndividualTheorem__Group__0 ) )
            {
            // InternalXContext.g:292:2: ( ( rule__XIndividualTheorem__Group__0 ) )
            // InternalXContext.g:293:3: ( rule__XIndividualTheorem__Group__0 )
            {
             before(grammarAccess.getXIndividualTheoremAccess().getGroup()); 
            // InternalXContext.g:294:3: ( rule__XIndividualTheorem__Group__0 )
            // InternalXContext.g:294:4: rule__XIndividualTheorem__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualTheorem__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXIndividualTheoremAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXIndividualTheorem"


    // $ANTLR start "entryRuleXFormula"
    // InternalXContext.g:303:1: entryRuleXFormula : ruleXFormula EOF ;
    public final void entryRuleXFormula() throws RecognitionException {
        try {
            // InternalXContext.g:304:1: ( ruleXFormula EOF )
            // InternalXContext.g:305:1: ruleXFormula EOF
            {
             before(grammarAccess.getXFormulaRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleXFormula();

            state._fsp--;

             after(grammarAccess.getXFormulaRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalXContext.g:312:1: ruleXFormula : ( ( ( rule__XFormula__Alternatives ) ) ( ( rule__XFormula__Alternatives )* ) ) ;
    public final void ruleXFormula() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:316:2: ( ( ( ( rule__XFormula__Alternatives ) ) ( ( rule__XFormula__Alternatives )* ) ) )
            // InternalXContext.g:317:2: ( ( ( rule__XFormula__Alternatives ) ) ( ( rule__XFormula__Alternatives )* ) )
            {
            // InternalXContext.g:317:2: ( ( ( rule__XFormula__Alternatives ) ) ( ( rule__XFormula__Alternatives )* ) )
            // InternalXContext.g:318:3: ( ( rule__XFormula__Alternatives ) ) ( ( rule__XFormula__Alternatives )* )
            {
            // InternalXContext.g:318:3: ( ( rule__XFormula__Alternatives ) )
            // InternalXContext.g:319:4: ( rule__XFormula__Alternatives )
            {
             before(grammarAccess.getXFormulaAccess().getAlternatives()); 
            // InternalXContext.g:320:4: ( rule__XFormula__Alternatives )
            // InternalXContext.g:320:5: rule__XFormula__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__XFormula__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getXFormulaAccess().getAlternatives()); 

            }

            // InternalXContext.g:323:3: ( ( rule__XFormula__Alternatives )* )
            // InternalXContext.g:324:4: ( rule__XFormula__Alternatives )*
            {
             before(grammarAccess.getXFormulaAccess().getAlternatives()); 
            // InternalXContext.g:325:4: ( rule__XFormula__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_UNTRANSLATED_TOKEN)||(LA1_0>=21 && LA1_0<=118)||LA1_0==130) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalXContext.g:325:5: rule__XFormula__Alternatives
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__XFormula__Alternatives();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getXFormulaAccess().getAlternatives()); 

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


    // $ANTLR start "entryRuleXType"
    // InternalXContext.g:335:1: entryRuleXType : ruleXType EOF ;
    public final void entryRuleXType() throws RecognitionException {
        try {
            // InternalXContext.g:336:1: ( ruleXType EOF )
            // InternalXContext.g:337:1: ruleXType EOF
            {
             before(grammarAccess.getXTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleXType();

            state._fsp--;

             after(grammarAccess.getXTypeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalXContext.g:344:1: ruleXType : ( ( rule__XType__Group__0 ) ) ;
    public final void ruleXType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:348:2: ( ( ( rule__XType__Group__0 ) ) )
            // InternalXContext.g:349:2: ( ( rule__XType__Group__0 ) )
            {
            // InternalXContext.g:349:2: ( ( rule__XType__Group__0 ) )
            // InternalXContext.g:350:3: ( rule__XType__Group__0 )
            {
             before(grammarAccess.getXTypeAccess().getGroup()); 
            // InternalXContext.g:351:3: ( rule__XType__Group__0 )
            // InternalXContext.g:351:4: rule__XType__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXTypeAccess().getGroup()); 

            }


            }

        }
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
    // InternalXContext.g:360:1: entryRuleXTYPEOPERATOR : ruleXTYPEOPERATOR EOF ;
    public final void entryRuleXTYPEOPERATOR() throws RecognitionException {
        try {
            // InternalXContext.g:361:1: ( ruleXTYPEOPERATOR EOF )
            // InternalXContext.g:362:1: ruleXTYPEOPERATOR EOF
            {
             before(grammarAccess.getXTYPEOPERATORRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleXTYPEOPERATOR();

            state._fsp--;

             after(grammarAccess.getXTYPEOPERATORRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalXContext.g:369:1: ruleXTYPEOPERATOR : ( ( rule__XTYPEOPERATOR__Alternatives ) ) ;
    public final void ruleXTYPEOPERATOR() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:373:2: ( ( ( rule__XTYPEOPERATOR__Alternatives ) ) )
            // InternalXContext.g:374:2: ( ( rule__XTYPEOPERATOR__Alternatives ) )
            {
            // InternalXContext.g:374:2: ( ( rule__XTYPEOPERATOR__Alternatives ) )
            // InternalXContext.g:375:3: ( rule__XTYPEOPERATOR__Alternatives )
            {
             before(grammarAccess.getXTYPEOPERATORAccess().getAlternatives()); 
            // InternalXContext.g:376:3: ( rule__XTYPEOPERATOR__Alternatives )
            // InternalXContext.g:376:4: rule__XTYPEOPERATOR__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XTYPEOPERATOR__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getXTYPEOPERATORAccess().getAlternatives()); 

            }


            }

        }
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
    // InternalXContext.g:385:1: entryRuleXTypePrimitive : ruleXTypePrimitive EOF ;
    public final void entryRuleXTypePrimitive() throws RecognitionException {
        try {
            // InternalXContext.g:386:1: ( ruleXTypePrimitive EOF )
            // InternalXContext.g:387:1: ruleXTypePrimitive EOF
            {
             before(grammarAccess.getXTypePrimitiveRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleXTypePrimitive();

            state._fsp--;

             after(grammarAccess.getXTypePrimitiveRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalXContext.g:394:1: ruleXTypePrimitive : ( ( rule__XTypePrimitive__Alternatives ) ) ;
    public final void ruleXTypePrimitive() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:398:2: ( ( ( rule__XTypePrimitive__Alternatives ) ) )
            // InternalXContext.g:399:2: ( ( rule__XTypePrimitive__Alternatives ) )
            {
            // InternalXContext.g:399:2: ( ( rule__XTypePrimitive__Alternatives ) )
            // InternalXContext.g:400:3: ( rule__XTypePrimitive__Alternatives )
            {
             before(grammarAccess.getXTypePrimitiveAccess().getAlternatives()); 
            // InternalXContext.g:401:3: ( rule__XTypePrimitive__Alternatives )
            // InternalXContext.g:401:4: rule__XTypePrimitive__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XTypePrimitive__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getXTypePrimitiveAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleEVENTB_IDENTIFIER_KEYWORD"
    // InternalXContext.g:410:1: entryRuleEVENTB_IDENTIFIER_KEYWORD : ruleEVENTB_IDENTIFIER_KEYWORD EOF ;
    public final void entryRuleEVENTB_IDENTIFIER_KEYWORD() throws RecognitionException {
        try {
            // InternalXContext.g:411:1: ( ruleEVENTB_IDENTIFIER_KEYWORD EOF )
            // InternalXContext.g:412:1: ruleEVENTB_IDENTIFIER_KEYWORD EOF
            {
             before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEVENTB_IDENTIFIER_KEYWORD();

            state._fsp--;

             after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalXContext.g:419:1: ruleEVENTB_IDENTIFIER_KEYWORD : ( ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives ) ) ;
    public final void ruleEVENTB_IDENTIFIER_KEYWORD() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:423:2: ( ( ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives ) ) )
            // InternalXContext.g:424:2: ( ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives ) )
            {
            // InternalXContext.g:424:2: ( ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives ) )
            // InternalXContext.g:425:3: ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives )
            {
             before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getAlternatives()); 
            // InternalXContext.g:426:3: ( rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives )
            // InternalXContext.g:426:4: rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getAlternatives()); 

            }


            }

        }
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
    // InternalXContext.g:435:1: entryRuleEVENTB_PREDICATE_SYMBOLS : ruleEVENTB_PREDICATE_SYMBOLS EOF ;
    public final void entryRuleEVENTB_PREDICATE_SYMBOLS() throws RecognitionException {
        try {
            // InternalXContext.g:436:1: ( ruleEVENTB_PREDICATE_SYMBOLS EOF )
            // InternalXContext.g:437:1: ruleEVENTB_PREDICATE_SYMBOLS EOF
            {
             before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEVENTB_PREDICATE_SYMBOLS();

            state._fsp--;

             after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalXContext.g:444:1: ruleEVENTB_PREDICATE_SYMBOLS : ( ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives ) ) ;
    public final void ruleEVENTB_PREDICATE_SYMBOLS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:448:2: ( ( ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives ) ) )
            // InternalXContext.g:449:2: ( ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives ) )
            {
            // InternalXContext.g:449:2: ( ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives ) )
            // InternalXContext.g:450:3: ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives )
            {
             before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAlternatives()); 
            // InternalXContext.g:451:3: ( rule__EVENTB_PREDICATE_SYMBOLS__Alternatives )
            // InternalXContext.g:451:4: rule__EVENTB_PREDICATE_SYMBOLS__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EVENTB_PREDICATE_SYMBOLS__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAlternatives()); 

            }


            }

        }
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
    // InternalXContext.g:460:1: entryRuleEVENTB_EXPRESSION_SYMBOLS : ruleEVENTB_EXPRESSION_SYMBOLS EOF ;
    public final void entryRuleEVENTB_EXPRESSION_SYMBOLS() throws RecognitionException {
        try {
            // InternalXContext.g:461:1: ( ruleEVENTB_EXPRESSION_SYMBOLS EOF )
            // InternalXContext.g:462:1: ruleEVENTB_EXPRESSION_SYMBOLS EOF
            {
             before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEVENTB_EXPRESSION_SYMBOLS();

            state._fsp--;

             after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalXContext.g:469:1: ruleEVENTB_EXPRESSION_SYMBOLS : ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives ) ) ;
    public final void ruleEVENTB_EXPRESSION_SYMBOLS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:473:2: ( ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives ) ) )
            // InternalXContext.g:474:2: ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives ) )
            {
            // InternalXContext.g:474:2: ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives ) )
            // InternalXContext.g:475:3: ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives )
            {
             before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAlternatives()); 
            // InternalXContext.g:476:3: ( rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives )
            // InternalXContext.g:476:4: rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAlternatives()); 

            }


            }

        }
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
    // InternalXContext.g:485:1: entryRuleXRecord : ruleXRecord EOF ;
    public final void entryRuleXRecord() throws RecognitionException {
        try {
            // InternalXContext.g:486:1: ( ruleXRecord EOF )
            // InternalXContext.g:487:1: ruleXRecord EOF
            {
             before(grammarAccess.getXRecordRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleXRecord();

            state._fsp--;

             after(grammarAccess.getXRecordRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalXContext.g:494:1: ruleXRecord : ( ( rule__XRecord__Group__0 ) ) ;
    public final void ruleXRecord() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:498:2: ( ( ( rule__XRecord__Group__0 ) ) )
            // InternalXContext.g:499:2: ( ( rule__XRecord__Group__0 ) )
            {
            // InternalXContext.g:499:2: ( ( rule__XRecord__Group__0 ) )
            // InternalXContext.g:500:3: ( rule__XRecord__Group__0 )
            {
             before(grammarAccess.getXRecordAccess().getGroup()); 
            // InternalXContext.g:501:3: ( rule__XRecord__Group__0 )
            // InternalXContext.g:501:4: rule__XRecord__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXRecordAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleFieldType"
    // InternalXContext.g:510:1: entryRuleFieldType : ruleFieldType EOF ;
    public final void entryRuleFieldType() throws RecognitionException {
        try {
            // InternalXContext.g:511:1: ( ruleFieldType EOF )
            // InternalXContext.g:512:1: ruleFieldType EOF
            {
             before(grammarAccess.getFieldTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFieldType();

            state._fsp--;

             after(grammarAccess.getFieldTypeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleFieldType"


    // $ANTLR start "ruleFieldType"
    // InternalXContext.g:519:1: ruleFieldType : ( ( rule__FieldType__Alternatives ) ) ;
    public final void ruleFieldType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:523:2: ( ( ( rule__FieldType__Alternatives ) ) )
            // InternalXContext.g:524:2: ( ( rule__FieldType__Alternatives ) )
            {
            // InternalXContext.g:524:2: ( ( rule__FieldType__Alternatives ) )
            // InternalXContext.g:525:3: ( rule__FieldType__Alternatives )
            {
             before(grammarAccess.getFieldTypeAccess().getAlternatives()); 
            // InternalXContext.g:526:3: ( rule__FieldType__Alternatives )
            // InternalXContext.g:526:4: rule__FieldType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FieldType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFieldTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFieldType"


    // $ANTLR start "entryRuleField"
    // InternalXContext.g:535:1: entryRuleField : ruleField EOF ;
    public final void entryRuleField() throws RecognitionException {
        try {
            // InternalXContext.g:536:1: ( ruleField EOF )
            // InternalXContext.g:537:1: ruleField EOF
            {
             before(grammarAccess.getFieldRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleField();

            state._fsp--;

             after(grammarAccess.getFieldRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalXContext.g:544:1: ruleField : ( ( rule__Field__Group__0 ) ) ;
    public final void ruleField() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:548:2: ( ( ( rule__Field__Group__0 ) ) )
            // InternalXContext.g:549:2: ( ( rule__Field__Group__0 ) )
            {
            // InternalXContext.g:549:2: ( ( rule__Field__Group__0 ) )
            // InternalXContext.g:550:3: ( rule__Field__Group__0 )
            {
             before(grammarAccess.getFieldAccess().getGroup()); 
            // InternalXContext.g:551:3: ( rule__Field__Group__0 )
            // InternalXContext.g:551:4: rule__Field__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Field__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFieldAccess().getGroup()); 

            }


            }

        }
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
    // InternalXContext.g:560:1: entryRuleXConstraint : ruleXConstraint EOF ;
    public final void entryRuleXConstraint() throws RecognitionException {
        try {
            // InternalXContext.g:561:1: ( ruleXConstraint EOF )
            // InternalXContext.g:562:1: ruleXConstraint EOF
            {
             before(grammarAccess.getXConstraintRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleXConstraint();

            state._fsp--;

             after(grammarAccess.getXConstraintRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalXContext.g:569:1: ruleXConstraint : ( ( rule__XConstraint__Group__0 ) ) ;
    public final void ruleXConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:573:2: ( ( ( rule__XConstraint__Group__0 ) ) )
            // InternalXContext.g:574:2: ( ( rule__XConstraint__Group__0 ) )
            {
            // InternalXContext.g:574:2: ( ( rule__XConstraint__Group__0 ) )
            // InternalXContext.g:575:3: ( rule__XConstraint__Group__0 )
            {
             before(grammarAccess.getXConstraintAccess().getGroup()); 
            // InternalXContext.g:576:3: ( rule__XConstraint__Group__0 )
            // InternalXContext.g:576:4: rule__XConstraint__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XConstraint__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXConstraintAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "ruleMultiplicity"
    // InternalXContext.g:585:1: ruleMultiplicity : ( ( rule__Multiplicity__Alternatives ) ) ;
    public final void ruleMultiplicity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:589:1: ( ( ( rule__Multiplicity__Alternatives ) ) )
            // InternalXContext.g:590:2: ( ( rule__Multiplicity__Alternatives ) )
            {
            // InternalXContext.g:590:2: ( ( rule__Multiplicity__Alternatives ) )
            // InternalXContext.g:591:3: ( rule__Multiplicity__Alternatives )
            {
             before(grammarAccess.getMultiplicityAccess().getAlternatives()); 
            // InternalXContext.g:592:3: ( rule__Multiplicity__Alternatives )
            // InternalXContext.g:592:4: rule__Multiplicity__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Multiplicity__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicityAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "rule__XContext__Alternatives_5"
    // InternalXContext.g:600:1: rule__XContext__Alternatives_5 : ( ( ( rule__XContext__Group_5_0__0 ) ) | ( ( rule__XContext__Group_5_1__0 ) ) | ( ( rule__XContext__Group_5_2__0 ) ) | ( ( rule__XContext__OrderedChildrenAssignment_5_3 ) ) | ( ( rule__XContext__Group_5_4__0 ) ) | ( ( rule__XContext__OrderedChildrenAssignment_5_5 ) ) | ( ( rule__XContext__OrderedChildrenAssignment_5_6 ) ) | ( ( rule__XContext__Group_5_7__0 ) ) | ( ( rule__XContext__OrderedChildrenAssignment_5_8 ) ) | ( ( rule__XContext__OrderedChildrenAssignment_5_9 ) ) );
    public final void rule__XContext__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:604:1: ( ( ( rule__XContext__Group_5_0__0 ) ) | ( ( rule__XContext__Group_5_1__0 ) ) | ( ( rule__XContext__Group_5_2__0 ) ) | ( ( rule__XContext__OrderedChildrenAssignment_5_3 ) ) | ( ( rule__XContext__Group_5_4__0 ) ) | ( ( rule__XContext__OrderedChildrenAssignment_5_5 ) ) | ( ( rule__XContext__OrderedChildrenAssignment_5_6 ) ) | ( ( rule__XContext__Group_5_7__0 ) ) | ( ( rule__XContext__OrderedChildrenAssignment_5_8 ) ) | ( ( rule__XContext__OrderedChildrenAssignment_5_9 ) ) )
            int alt2=10;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalXContext.g:605:2: ( ( rule__XContext__Group_5_0__0 ) )
                    {
                    // InternalXContext.g:605:2: ( ( rule__XContext__Group_5_0__0 ) )
                    // InternalXContext.g:606:3: ( rule__XContext__Group_5_0__0 )
                    {
                     before(grammarAccess.getXContextAccess().getGroup_5_0()); 
                    // InternalXContext.g:607:3: ( rule__XContext__Group_5_0__0 )
                    // InternalXContext.g:607:4: rule__XContext__Group_5_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XContext__Group_5_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getXContextAccess().getGroup_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXContext.g:611:2: ( ( rule__XContext__Group_5_1__0 ) )
                    {
                    // InternalXContext.g:611:2: ( ( rule__XContext__Group_5_1__0 ) )
                    // InternalXContext.g:612:3: ( rule__XContext__Group_5_1__0 )
                    {
                     before(grammarAccess.getXContextAccess().getGroup_5_1()); 
                    // InternalXContext.g:613:3: ( rule__XContext__Group_5_1__0 )
                    // InternalXContext.g:613:4: rule__XContext__Group_5_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XContext__Group_5_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getXContextAccess().getGroup_5_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXContext.g:617:2: ( ( rule__XContext__Group_5_2__0 ) )
                    {
                    // InternalXContext.g:617:2: ( ( rule__XContext__Group_5_2__0 ) )
                    // InternalXContext.g:618:3: ( rule__XContext__Group_5_2__0 )
                    {
                     before(grammarAccess.getXContextAccess().getGroup_5_2()); 
                    // InternalXContext.g:619:3: ( rule__XContext__Group_5_2__0 )
                    // InternalXContext.g:619:4: rule__XContext__Group_5_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XContext__Group_5_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getXContextAccess().getGroup_5_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXContext.g:623:2: ( ( rule__XContext__OrderedChildrenAssignment_5_3 ) )
                    {
                    // InternalXContext.g:623:2: ( ( rule__XContext__OrderedChildrenAssignment_5_3 ) )
                    // InternalXContext.g:624:3: ( rule__XContext__OrderedChildrenAssignment_5_3 )
                    {
                     before(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_3()); 
                    // InternalXContext.g:625:3: ( rule__XContext__OrderedChildrenAssignment_5_3 )
                    // InternalXContext.g:625:4: rule__XContext__OrderedChildrenAssignment_5_3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XContext__OrderedChildrenAssignment_5_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXContext.g:629:2: ( ( rule__XContext__Group_5_4__0 ) )
                    {
                    // InternalXContext.g:629:2: ( ( rule__XContext__Group_5_4__0 ) )
                    // InternalXContext.g:630:3: ( rule__XContext__Group_5_4__0 )
                    {
                     before(grammarAccess.getXContextAccess().getGroup_5_4()); 
                    // InternalXContext.g:631:3: ( rule__XContext__Group_5_4__0 )
                    // InternalXContext.g:631:4: rule__XContext__Group_5_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XContext__Group_5_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getXContextAccess().getGroup_5_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXContext.g:635:2: ( ( rule__XContext__OrderedChildrenAssignment_5_5 ) )
                    {
                    // InternalXContext.g:635:2: ( ( rule__XContext__OrderedChildrenAssignment_5_5 ) )
                    // InternalXContext.g:636:3: ( rule__XContext__OrderedChildrenAssignment_5_5 )
                    {
                     before(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_5()); 
                    // InternalXContext.g:637:3: ( rule__XContext__OrderedChildrenAssignment_5_5 )
                    // InternalXContext.g:637:4: rule__XContext__OrderedChildrenAssignment_5_5
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XContext__OrderedChildrenAssignment_5_5();

                    state._fsp--;


                    }

                     after(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalXContext.g:641:2: ( ( rule__XContext__OrderedChildrenAssignment_5_6 ) )
                    {
                    // InternalXContext.g:641:2: ( ( rule__XContext__OrderedChildrenAssignment_5_6 ) )
                    // InternalXContext.g:642:3: ( rule__XContext__OrderedChildrenAssignment_5_6 )
                    {
                     before(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_6()); 
                    // InternalXContext.g:643:3: ( rule__XContext__OrderedChildrenAssignment_5_6 )
                    // InternalXContext.g:643:4: rule__XContext__OrderedChildrenAssignment_5_6
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XContext__OrderedChildrenAssignment_5_6();

                    state._fsp--;


                    }

                     after(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalXContext.g:647:2: ( ( rule__XContext__Group_5_7__0 ) )
                    {
                    // InternalXContext.g:647:2: ( ( rule__XContext__Group_5_7__0 ) )
                    // InternalXContext.g:648:3: ( rule__XContext__Group_5_7__0 )
                    {
                     before(grammarAccess.getXContextAccess().getGroup_5_7()); 
                    // InternalXContext.g:649:3: ( rule__XContext__Group_5_7__0 )
                    // InternalXContext.g:649:4: rule__XContext__Group_5_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XContext__Group_5_7__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getXContextAccess().getGroup_5_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalXContext.g:653:2: ( ( rule__XContext__OrderedChildrenAssignment_5_8 ) )
                    {
                    // InternalXContext.g:653:2: ( ( rule__XContext__OrderedChildrenAssignment_5_8 ) )
                    // InternalXContext.g:654:3: ( rule__XContext__OrderedChildrenAssignment_5_8 )
                    {
                     before(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_8()); 
                    // InternalXContext.g:655:3: ( rule__XContext__OrderedChildrenAssignment_5_8 )
                    // InternalXContext.g:655:4: rule__XContext__OrderedChildrenAssignment_5_8
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XContext__OrderedChildrenAssignment_5_8();

                    state._fsp--;


                    }

                     after(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalXContext.g:659:2: ( ( rule__XContext__OrderedChildrenAssignment_5_9 ) )
                    {
                    // InternalXContext.g:659:2: ( ( rule__XContext__OrderedChildrenAssignment_5_9 ) )
                    // InternalXContext.g:660:3: ( rule__XContext__OrderedChildrenAssignment_5_9 )
                    {
                     before(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_9()); 
                    // InternalXContext.g:661:3: ( rule__XContext__OrderedChildrenAssignment_5_9 )
                    // InternalXContext.g:661:4: rule__XContext__OrderedChildrenAssignment_5_9
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XContext__OrderedChildrenAssignment_5_9();

                    state._fsp--;


                    }

                     after(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_9()); 

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
    // $ANTLR end "rule__XContext__Alternatives_5"


    // $ANTLR start "rule__XContext__Alternatives_5_1_0"
    // InternalXContext.g:669:1: rule__XContext__Alternatives_5_1_0 : ( ( 'extend' ) | ( 'ext' ) );
    public final void rule__XContext__Alternatives_5_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:673:1: ( ( 'extend' ) | ( 'ext' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalXContext.g:674:2: ( 'extend' )
                    {
                    // InternalXContext.g:674:2: ( 'extend' )
                    // InternalXContext.g:675:3: 'extend'
                    {
                     before(grammarAccess.getXContextAccess().getExtendKeyword_5_1_0_0()); 
                    match(input,13,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXContextAccess().getExtendKeyword_5_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXContext.g:680:2: ( 'ext' )
                    {
                    // InternalXContext.g:680:2: ( 'ext' )
                    // InternalXContext.g:681:3: 'ext'
                    {
                     before(grammarAccess.getXContextAccess().getExtKeyword_5_1_0_1()); 
                    match(input,14,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXContextAccess().getExtKeyword_5_1_0_1()); 

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
    // $ANTLR end "rule__XContext__Alternatives_5_1_0"


    // $ANTLR start "rule__XIndividualConstant__Alternatives_2"
    // InternalXContext.g:690:1: rule__XIndividualConstant__Alternatives_2 : ( ( 'constant' ) | ( 'cst' ) );
    public final void rule__XIndividualConstant__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:694:1: ( ( 'constant' ) | ( 'cst' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            else if ( (LA4_0==16) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalXContext.g:695:2: ( 'constant' )
                    {
                    // InternalXContext.g:695:2: ( 'constant' )
                    // InternalXContext.g:696:3: 'constant'
                    {
                     before(grammarAccess.getXIndividualConstantAccess().getConstantKeyword_2_0()); 
                    match(input,15,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXIndividualConstantAccess().getConstantKeyword_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXContext.g:701:2: ( 'cst' )
                    {
                    // InternalXContext.g:701:2: ( 'cst' )
                    // InternalXContext.g:702:3: 'cst'
                    {
                     before(grammarAccess.getXIndividualConstantAccess().getCstKeyword_2_1()); 
                    match(input,16,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXIndividualConstantAccess().getCstKeyword_2_1()); 

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
    // $ANTLR end "rule__XIndividualConstant__Alternatives_2"


    // $ANTLR start "rule__XIndividualAxiom__Alternatives_2"
    // InternalXContext.g:711:1: rule__XIndividualAxiom__Alternatives_2 : ( ( 'axiom' ) | ( 'axm' ) );
    public final void rule__XIndividualAxiom__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:715:1: ( ( 'axiom' ) | ( 'axm' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            else if ( (LA5_0==18) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalXContext.g:716:2: ( 'axiom' )
                    {
                    // InternalXContext.g:716:2: ( 'axiom' )
                    // InternalXContext.g:717:3: 'axiom'
                    {
                     before(grammarAccess.getXIndividualAxiomAccess().getAxiomKeyword_2_0()); 
                    match(input,17,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXIndividualAxiomAccess().getAxiomKeyword_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXContext.g:722:2: ( 'axm' )
                    {
                    // InternalXContext.g:722:2: ( 'axm' )
                    // InternalXContext.g:723:3: 'axm'
                    {
                     before(grammarAccess.getXIndividualAxiomAccess().getAxmKeyword_2_1()); 
                    match(input,18,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXIndividualAxiomAccess().getAxmKeyword_2_1()); 

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
    // $ANTLR end "rule__XIndividualAxiom__Alternatives_2"


    // $ANTLR start "rule__XIndividualTheorem__TheoremAlternatives_2_0"
    // InternalXContext.g:732:1: rule__XIndividualTheorem__TheoremAlternatives_2_0 : ( ( 'theorem' ) | ( 'thm' ) );
    public final void rule__XIndividualTheorem__TheoremAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:736:1: ( ( 'theorem' ) | ( 'thm' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            else if ( (LA6_0==20) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalXContext.g:737:2: ( 'theorem' )
                    {
                    // InternalXContext.g:737:2: ( 'theorem' )
                    // InternalXContext.g:738:3: 'theorem'
                    {
                     before(grammarAccess.getXIndividualTheoremAccess().getTheoremTheoremKeyword_2_0_0()); 
                    match(input,19,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXIndividualTheoremAccess().getTheoremTheoremKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXContext.g:743:2: ( 'thm' )
                    {
                    // InternalXContext.g:743:2: ( 'thm' )
                    // InternalXContext.g:744:3: 'thm'
                    {
                     before(grammarAccess.getXIndividualTheoremAccess().getTheoremThmKeyword_2_0_1()); 
                    match(input,20,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXIndividualTheoremAccess().getTheoremThmKeyword_2_0_1()); 

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
    // $ANTLR end "rule__XIndividualTheorem__TheoremAlternatives_2_0"


    // $ANTLR start "rule__XFormula__Alternatives"
    // InternalXContext.g:753:1: rule__XFormula__Alternatives : ( ( ruleEVENTB_IDENTIFIER_KEYWORD ) | ( ruleEVENTB_PREDICATE_SYMBOLS ) | ( ruleEVENTB_EXPRESSION_SYMBOLS ) | ( RULE_ID ) | ( RULE_INT ) | ( RULE_UNTRANSLATED_TOKEN ) );
    public final void rule__XFormula__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:757:1: ( ( ruleEVENTB_IDENTIFIER_KEYWORD ) | ( ruleEVENTB_PREDICATE_SYMBOLS ) | ( ruleEVENTB_EXPRESSION_SYMBOLS ) | ( RULE_ID ) | ( RULE_INT ) | ( RULE_UNTRANSLATED_TOKEN ) )
            int alt7=6;
            switch ( input.LA(1) ) {
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
                {
                alt7=1;
                }
                break;
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
                {
                alt7=2;
                }
                break;
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
            case 130:
                {
                alt7=3;
                }
                break;
            case RULE_ID:
                {
                alt7=4;
                }
                break;
            case RULE_INT:
                {
                alt7=5;
                }
                break;
            case RULE_UNTRANSLATED_TOKEN:
                {
                alt7=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalXContext.g:758:2: ( ruleEVENTB_IDENTIFIER_KEYWORD )
                    {
                    // InternalXContext.g:758:2: ( ruleEVENTB_IDENTIFIER_KEYWORD )
                    // InternalXContext.g:759:3: ruleEVENTB_IDENTIFIER_KEYWORD
                    {
                     before(grammarAccess.getXFormulaAccess().getEVENTB_IDENTIFIER_KEYWORDParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleEVENTB_IDENTIFIER_KEYWORD();

                    state._fsp--;

                     after(grammarAccess.getXFormulaAccess().getEVENTB_IDENTIFIER_KEYWORDParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXContext.g:764:2: ( ruleEVENTB_PREDICATE_SYMBOLS )
                    {
                    // InternalXContext.g:764:2: ( ruleEVENTB_PREDICATE_SYMBOLS )
                    // InternalXContext.g:765:3: ruleEVENTB_PREDICATE_SYMBOLS
                    {
                     before(grammarAccess.getXFormulaAccess().getEVENTB_PREDICATE_SYMBOLSParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleEVENTB_PREDICATE_SYMBOLS();

                    state._fsp--;

                     after(grammarAccess.getXFormulaAccess().getEVENTB_PREDICATE_SYMBOLSParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXContext.g:770:2: ( ruleEVENTB_EXPRESSION_SYMBOLS )
                    {
                    // InternalXContext.g:770:2: ( ruleEVENTB_EXPRESSION_SYMBOLS )
                    // InternalXContext.g:771:3: ruleEVENTB_EXPRESSION_SYMBOLS
                    {
                     before(grammarAccess.getXFormulaAccess().getEVENTB_EXPRESSION_SYMBOLSParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleEVENTB_EXPRESSION_SYMBOLS();

                    state._fsp--;

                     after(grammarAccess.getXFormulaAccess().getEVENTB_EXPRESSION_SYMBOLSParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXContext.g:776:2: ( RULE_ID )
                    {
                    // InternalXContext.g:776:2: ( RULE_ID )
                    // InternalXContext.g:777:3: RULE_ID
                    {
                     before(grammarAccess.getXFormulaAccess().getIDTerminalRuleCall_3()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXFormulaAccess().getIDTerminalRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXContext.g:782:2: ( RULE_INT )
                    {
                    // InternalXContext.g:782:2: ( RULE_INT )
                    // InternalXContext.g:783:3: RULE_INT
                    {
                     before(grammarAccess.getXFormulaAccess().getINTTerminalRuleCall_4()); 
                    match(input,RULE_INT,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXFormulaAccess().getINTTerminalRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXContext.g:788:2: ( RULE_UNTRANSLATED_TOKEN )
                    {
                    // InternalXContext.g:788:2: ( RULE_UNTRANSLATED_TOKEN )
                    // InternalXContext.g:789:3: RULE_UNTRANSLATED_TOKEN
                    {
                     before(grammarAccess.getXFormulaAccess().getUNTRANSLATED_TOKENTerminalRuleCall_5()); 
                    match(input,RULE_UNTRANSLATED_TOKEN,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXFormulaAccess().getUNTRANSLATED_TOKENTerminalRuleCall_5()); 

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


    // $ANTLR start "rule__XTYPEOPERATOR__Alternatives"
    // InternalXContext.g:798:1: rule__XTYPEOPERATOR__Alternatives : ( ( '\\u2194' ) | ( '\\uE100' ) | ( '\\uE101' ) | ( '\\uE102' ) | ( '\\u21F8' ) | ( '\\u2192' ) | ( '\\u2914' ) | ( '\\u21A3' ) | ( '\\u2900' ) | ( '\\u21A0' ) | ( '\\u2916' ) | ( '\\u00D7' ) );
    public final void rule__XTYPEOPERATOR__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:802:1: ( ( '\\u2194' ) | ( '\\uE100' ) | ( '\\uE101' ) | ( '\\uE102' ) | ( '\\u21F8' ) | ( '\\u2192' ) | ( '\\u2914' ) | ( '\\u21A3' ) | ( '\\u2900' ) | ( '\\u21A0' ) | ( '\\u2916' ) | ( '\\u00D7' ) )
            int alt8=12;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt8=1;
                }
                break;
            case 22:
                {
                alt8=2;
                }
                break;
            case 23:
                {
                alt8=3;
                }
                break;
            case 24:
                {
                alt8=4;
                }
                break;
            case 25:
                {
                alt8=5;
                }
                break;
            case 26:
                {
                alt8=6;
                }
                break;
            case 27:
                {
                alt8=7;
                }
                break;
            case 28:
                {
                alt8=8;
                }
                break;
            case 29:
                {
                alt8=9;
                }
                break;
            case 30:
                {
                alt8=10;
                }
                break;
            case 31:
                {
                alt8=11;
                }
                break;
            case 32:
                {
                alt8=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalXContext.g:803:2: ( '\\u2194' )
                    {
                    // InternalXContext.g:803:2: ( '\\u2194' )
                    // InternalXContext.g:804:3: '\\u2194'
                    {
                     before(grammarAccess.getXTYPEOPERATORAccess().getLeftRightArrowKeyword_0()); 
                    match(input,21,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTYPEOPERATORAccess().getLeftRightArrowKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXContext.g:809:2: ( '\\uE100' )
                    {
                    // InternalXContext.g:809:2: ( '\\uE100' )
                    // InternalXContext.g:810:3: '\\uE100'
                    {
                     before(grammarAccess.getXTYPEOPERATORAccess().getPrivateUseAreaE100Keyword_1()); 
                    match(input,22,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTYPEOPERATORAccess().getPrivateUseAreaE100Keyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXContext.g:815:2: ( '\\uE101' )
                    {
                    // InternalXContext.g:815:2: ( '\\uE101' )
                    // InternalXContext.g:816:3: '\\uE101'
                    {
                     before(grammarAccess.getXTYPEOPERATORAccess().getPrivateUseAreaE101Keyword_2()); 
                    match(input,23,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTYPEOPERATORAccess().getPrivateUseAreaE101Keyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXContext.g:821:2: ( '\\uE102' )
                    {
                    // InternalXContext.g:821:2: ( '\\uE102' )
                    // InternalXContext.g:822:3: '\\uE102'
                    {
                     before(grammarAccess.getXTYPEOPERATORAccess().getPrivateUseAreaE102Keyword_3()); 
                    match(input,24,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTYPEOPERATORAccess().getPrivateUseAreaE102Keyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXContext.g:827:2: ( '\\u21F8' )
                    {
                    // InternalXContext.g:827:2: ( '\\u21F8' )
                    // InternalXContext.g:828:3: '\\u21F8'
                    {
                     before(grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowWithVerticalStrokeKeyword_4()); 
                    match(input,25,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowWithVerticalStrokeKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXContext.g:833:2: ( '\\u2192' )
                    {
                    // InternalXContext.g:833:2: ( '\\u2192' )
                    // InternalXContext.g:834:3: '\\u2192'
                    {
                     before(grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowKeyword_5()); 
                    match(input,26,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalXContext.g:839:2: ( '\\u2914' )
                    {
                    // InternalXContext.g:839:2: ( '\\u2914' )
                    // InternalXContext.g:840:3: '\\u2914'
                    {
                     before(grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowWithTailWithVerticalStrokeKeyword_6()); 
                    match(input,27,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowWithTailWithVerticalStrokeKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalXContext.g:845:2: ( '\\u21A3' )
                    {
                    // InternalXContext.g:845:2: ( '\\u21A3' )
                    // InternalXContext.g:846:3: '\\u21A3'
                    {
                     before(grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowWithTailKeyword_7()); 
                    match(input,28,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowWithTailKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalXContext.g:851:2: ( '\\u2900' )
                    {
                    // InternalXContext.g:851:2: ( '\\u2900' )
                    // InternalXContext.g:852:3: '\\u2900'
                    {
                     before(grammarAccess.getXTYPEOPERATORAccess().getRightwardsTwoHeadedArrowWithVerticalStrokeKeyword_8()); 
                    match(input,29,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTYPEOPERATORAccess().getRightwardsTwoHeadedArrowWithVerticalStrokeKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalXContext.g:857:2: ( '\\u21A0' )
                    {
                    // InternalXContext.g:857:2: ( '\\u21A0' )
                    // InternalXContext.g:858:3: '\\u21A0'
                    {
                     before(grammarAccess.getXTYPEOPERATORAccess().getRightwardsTwoHeadedArrowKeyword_9()); 
                    match(input,30,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTYPEOPERATORAccess().getRightwardsTwoHeadedArrowKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalXContext.g:863:2: ( '\\u2916' )
                    {
                    // InternalXContext.g:863:2: ( '\\u2916' )
                    // InternalXContext.g:864:3: '\\u2916'
                    {
                     before(grammarAccess.getXTYPEOPERATORAccess().getRightwardsTwoHeadedArrowWithTailKeyword_10()); 
                    match(input,31,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTYPEOPERATORAccess().getRightwardsTwoHeadedArrowWithTailKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalXContext.g:869:2: ( '\\u00D7' )
                    {
                    // InternalXContext.g:869:2: ( '\\u00D7' )
                    // InternalXContext.g:870:3: '\\u00D7'
                    {
                     before(grammarAccess.getXTYPEOPERATORAccess().getMultiplicationSignKeyword_11()); 
                    match(input,32,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTYPEOPERATORAccess().getMultiplicationSignKeyword_11()); 

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
    // InternalXContext.g:879:1: rule__XTypePrimitive__Alternatives : ( ( RULE_ID ) | ( 'BOOL' ) | ( '\\u21151' ) | ( '\\u2115' ) | ( '\\u2124' ) | ( ( rule__XTypePrimitive__Group_5__0 ) ) | ( ( rule__XTypePrimitive__Group_6__0 ) ) | ( ( rule__XTypePrimitive__Group_7__0 ) ) );
    public final void rule__XTypePrimitive__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:883:1: ( ( RULE_ID ) | ( 'BOOL' ) | ( '\\u21151' ) | ( '\\u2115' ) | ( '\\u2124' ) | ( ( rule__XTypePrimitive__Group_5__0 ) ) | ( ( rule__XTypePrimitive__Group_6__0 ) ) | ( ( rule__XTypePrimitive__Group_7__0 ) ) )
            int alt9=8;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt9=1;
                }
                break;
            case 33:
                {
                alt9=2;
                }
                break;
            case 34:
                {
                alt9=3;
                }
                break;
            case 35:
                {
                alt9=4;
                }
                break;
            case 36:
                {
                alt9=5;
                }
                break;
            case 56:
                {
                alt9=6;
                }
                break;
            case 55:
                {
                alt9=7;
                }
                break;
            case 54:
                {
                alt9=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalXContext.g:884:2: ( RULE_ID )
                    {
                    // InternalXContext.g:884:2: ( RULE_ID )
                    // InternalXContext.g:885:3: RULE_ID
                    {
                     before(grammarAccess.getXTypePrimitiveAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTypePrimitiveAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXContext.g:890:2: ( 'BOOL' )
                    {
                    // InternalXContext.g:890:2: ( 'BOOL' )
                    // InternalXContext.g:891:3: 'BOOL'
                    {
                     before(grammarAccess.getXTypePrimitiveAccess().getBOOLKeyword_1()); 
                    match(input,33,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTypePrimitiveAccess().getBOOLKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXContext.g:896:2: ( '\\u21151' )
                    {
                    // InternalXContext.g:896:2: ( '\\u21151' )
                    // InternalXContext.g:897:3: '\\u21151'
                    {
                     before(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalNDigitOneKeyword_2()); 
                    match(input,34,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalNDigitOneKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXContext.g:902:2: ( '\\u2115' )
                    {
                    // InternalXContext.g:902:2: ( '\\u2115' )
                    // InternalXContext.g:903:3: '\\u2115'
                    {
                     before(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalNKeyword_3()); 
                    match(input,35,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalNKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXContext.g:908:2: ( '\\u2124' )
                    {
                    // InternalXContext.g:908:2: ( '\\u2124' )
                    // InternalXContext.g:909:3: '\\u2124'
                    {
                     before(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalZKeyword_4()); 
                    match(input,36,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalZKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXContext.g:914:2: ( ( rule__XTypePrimitive__Group_5__0 ) )
                    {
                    // InternalXContext.g:914:2: ( ( rule__XTypePrimitive__Group_5__0 ) )
                    // InternalXContext.g:915:3: ( rule__XTypePrimitive__Group_5__0 )
                    {
                     before(grammarAccess.getXTypePrimitiveAccess().getGroup_5()); 
                    // InternalXContext.g:916:3: ( rule__XTypePrimitive__Group_5__0 )
                    // InternalXContext.g:916:4: rule__XTypePrimitive__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XTypePrimitive__Group_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getXTypePrimitiveAccess().getGroup_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalXContext.g:920:2: ( ( rule__XTypePrimitive__Group_6__0 ) )
                    {
                    // InternalXContext.g:920:2: ( ( rule__XTypePrimitive__Group_6__0 ) )
                    // InternalXContext.g:921:3: ( rule__XTypePrimitive__Group_6__0 )
                    {
                     before(grammarAccess.getXTypePrimitiveAccess().getGroup_6()); 
                    // InternalXContext.g:922:3: ( rule__XTypePrimitive__Group_6__0 )
                    // InternalXContext.g:922:4: rule__XTypePrimitive__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XTypePrimitive__Group_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getXTypePrimitiveAccess().getGroup_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalXContext.g:926:2: ( ( rule__XTypePrimitive__Group_7__0 ) )
                    {
                    // InternalXContext.g:926:2: ( ( rule__XTypePrimitive__Group_7__0 ) )
                    // InternalXContext.g:927:3: ( rule__XTypePrimitive__Group_7__0 )
                    {
                     before(grammarAccess.getXTypePrimitiveAccess().getGroup_7()); 
                    // InternalXContext.g:928:3: ( rule__XTypePrimitive__Group_7__0 )
                    // InternalXContext.g:928:4: rule__XTypePrimitive__Group_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XTypePrimitive__Group_7__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getXTypePrimitiveAccess().getGroup_7()); 

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


    // $ANTLR start "rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives"
    // InternalXContext.g:936:1: rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives : ( ( 'BOOL' ) | ( 'FALSE' ) | ( 'TRUE' ) | ( 'bool' ) | ( 'card' ) | ( 'dom' ) | ( 'finite' ) | ( 'id' ) | ( 'inter' ) | ( 'max' ) | ( 'min' ) | ( 'mod' ) | ( 'pred' ) | ( 'prj1' ) | ( 'prj2' ) | ( 'ran' ) | ( 'succ' ) | ( 'union' ) | ( '\\u21151' ) | ( '\\u2115' ) | ( '\\u21191' ) | ( '\\u2119' ) | ( '\\u2124' ) );
    public final void rule__EVENTB_IDENTIFIER_KEYWORD__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:940:1: ( ( 'BOOL' ) | ( 'FALSE' ) | ( 'TRUE' ) | ( 'bool' ) | ( 'card' ) | ( 'dom' ) | ( 'finite' ) | ( 'id' ) | ( 'inter' ) | ( 'max' ) | ( 'min' ) | ( 'mod' ) | ( 'pred' ) | ( 'prj1' ) | ( 'prj2' ) | ( 'ran' ) | ( 'succ' ) | ( 'union' ) | ( '\\u21151' ) | ( '\\u2115' ) | ( '\\u21191' ) | ( '\\u2119' ) | ( '\\u2124' ) )
            int alt10=23;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt10=1;
                }
                break;
            case 37:
                {
                alt10=2;
                }
                break;
            case 38:
                {
                alt10=3;
                }
                break;
            case 39:
                {
                alt10=4;
                }
                break;
            case 40:
                {
                alt10=5;
                }
                break;
            case 41:
                {
                alt10=6;
                }
                break;
            case 42:
                {
                alt10=7;
                }
                break;
            case 43:
                {
                alt10=8;
                }
                break;
            case 44:
                {
                alt10=9;
                }
                break;
            case 45:
                {
                alt10=10;
                }
                break;
            case 46:
                {
                alt10=11;
                }
                break;
            case 47:
                {
                alt10=12;
                }
                break;
            case 48:
                {
                alt10=13;
                }
                break;
            case 49:
                {
                alt10=14;
                }
                break;
            case 50:
                {
                alt10=15;
                }
                break;
            case 51:
                {
                alt10=16;
                }
                break;
            case 52:
                {
                alt10=17;
                }
                break;
            case 53:
                {
                alt10=18;
                }
                break;
            case 34:
                {
                alt10=19;
                }
                break;
            case 35:
                {
                alt10=20;
                }
                break;
            case 54:
                {
                alt10=21;
                }
                break;
            case 55:
                {
                alt10=22;
                }
                break;
            case 36:
                {
                alt10=23;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalXContext.g:941:2: ( 'BOOL' )
                    {
                    // InternalXContext.g:941:2: ( 'BOOL' )
                    // InternalXContext.g:942:3: 'BOOL'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBOOLKeyword_0()); 
                    match(input,33,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBOOLKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXContext.g:947:2: ( 'FALSE' )
                    {
                    // InternalXContext.g:947:2: ( 'FALSE' )
                    // InternalXContext.g:948:3: 'FALSE'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFALSEKeyword_1()); 
                    match(input,37,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFALSEKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXContext.g:953:2: ( 'TRUE' )
                    {
                    // InternalXContext.g:953:2: ( 'TRUE' )
                    // InternalXContext.g:954:3: 'TRUE'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getTRUEKeyword_2()); 
                    match(input,38,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getTRUEKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXContext.g:959:2: ( 'bool' )
                    {
                    // InternalXContext.g:959:2: ( 'bool' )
                    // InternalXContext.g:960:3: 'bool'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBoolKeyword_3()); 
                    match(input,39,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBoolKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXContext.g:965:2: ( 'card' )
                    {
                    // InternalXContext.g:965:2: ( 'card' )
                    // InternalXContext.g:966:3: 'card'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getCardKeyword_4()); 
                    match(input,40,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getCardKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXContext.g:971:2: ( 'dom' )
                    {
                    // InternalXContext.g:971:2: ( 'dom' )
                    // InternalXContext.g:972:3: 'dom'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDomKeyword_5()); 
                    match(input,41,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDomKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalXContext.g:977:2: ( 'finite' )
                    {
                    // InternalXContext.g:977:2: ( 'finite' )
                    // InternalXContext.g:978:3: 'finite'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFiniteKeyword_6()); 
                    match(input,42,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFiniteKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalXContext.g:983:2: ( 'id' )
                    {
                    // InternalXContext.g:983:2: ( 'id' )
                    // InternalXContext.g:984:3: 'id'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getIdKeyword_7()); 
                    match(input,43,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getIdKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalXContext.g:989:2: ( 'inter' )
                    {
                    // InternalXContext.g:989:2: ( 'inter' )
                    // InternalXContext.g:990:3: 'inter'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getInterKeyword_8()); 
                    match(input,44,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getInterKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalXContext.g:995:2: ( 'max' )
                    {
                    // InternalXContext.g:995:2: ( 'max' )
                    // InternalXContext.g:996:3: 'max'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMaxKeyword_9()); 
                    match(input,45,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMaxKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalXContext.g:1001:2: ( 'min' )
                    {
                    // InternalXContext.g:1001:2: ( 'min' )
                    // InternalXContext.g:1002:3: 'min'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMinKeyword_10()); 
                    match(input,46,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMinKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalXContext.g:1007:2: ( 'mod' )
                    {
                    // InternalXContext.g:1007:2: ( 'mod' )
                    // InternalXContext.g:1008:3: 'mod'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getModKeyword_11()); 
                    match(input,47,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getModKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalXContext.g:1013:2: ( 'pred' )
                    {
                    // InternalXContext.g:1013:2: ( 'pred' )
                    // InternalXContext.g:1014:3: 'pred'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPredKeyword_12()); 
                    match(input,48,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPredKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalXContext.g:1019:2: ( 'prj1' )
                    {
                    // InternalXContext.g:1019:2: ( 'prj1' )
                    // InternalXContext.g:1020:3: 'prj1'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj1Keyword_13()); 
                    match(input,49,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj1Keyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalXContext.g:1025:2: ( 'prj2' )
                    {
                    // InternalXContext.g:1025:2: ( 'prj2' )
                    // InternalXContext.g:1026:3: 'prj2'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj2Keyword_14()); 
                    match(input,50,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj2Keyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalXContext.g:1031:2: ( 'ran' )
                    {
                    // InternalXContext.g:1031:2: ( 'ran' )
                    // InternalXContext.g:1032:3: 'ran'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getRanKeyword_15()); 
                    match(input,51,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getRanKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalXContext.g:1037:2: ( 'succ' )
                    {
                    // InternalXContext.g:1037:2: ( 'succ' )
                    // InternalXContext.g:1038:3: 'succ'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getSuccKeyword_16()); 
                    match(input,52,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getSuccKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalXContext.g:1043:2: ( 'union' )
                    {
                    // InternalXContext.g:1043:2: ( 'union' )
                    // InternalXContext.g:1044:3: 'union'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getUnionKeyword_17()); 
                    match(input,53,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getUnionKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalXContext.g:1049:2: ( '\\u21151' )
                    {
                    // InternalXContext.g:1049:2: ( '\\u21151' )
                    // InternalXContext.g:1050:3: '\\u21151'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNDigitOneKeyword_18()); 
                    match(input,34,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNDigitOneKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalXContext.g:1055:2: ( '\\u2115' )
                    {
                    // InternalXContext.g:1055:2: ( '\\u2115' )
                    // InternalXContext.g:1056:3: '\\u2115'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNKeyword_19()); 
                    match(input,35,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalXContext.g:1061:2: ( '\\u21191' )
                    {
                    // InternalXContext.g:1061:2: ( '\\u21191' )
                    // InternalXContext.g:1062:3: '\\u21191'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPDigitOneKeyword_20()); 
                    match(input,54,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPDigitOneKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalXContext.g:1067:2: ( '\\u2119' )
                    {
                    // InternalXContext.g:1067:2: ( '\\u2119' )
                    // InternalXContext.g:1068:3: '\\u2119'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPKeyword_21()); 
                    match(input,55,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalXContext.g:1073:2: ( '\\u2124' )
                    {
                    // InternalXContext.g:1073:2: ( '\\u2124' )
                    // InternalXContext.g:1074:3: '\\u2124'
                    {
                     before(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalZKeyword_22()); 
                    match(input,36,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalZKeyword_22()); 

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
    // InternalXContext.g:1083:1: rule__EVENTB_PREDICATE_SYMBOLS__Alternatives : ( ( '(' ) | ( ')' ) | ( '\\u21D4' ) | ( '\\u21D2' ) | ( '\\u2227' ) | ( '&' ) | ( '\\u2228' ) | ( '\\u00AC' ) | ( '\\u22A4' ) | ( '\\u22A5' ) | ( '\\u2200' ) | ( '!' ) | ( '\\u2203' ) | ( '#' ) | ( ',' ) | ( '\\u00B7' ) | ( '.' ) | ( '=' ) | ( '\\u2260' ) | ( '\\u2264' ) | ( '<' ) | ( '\\u2265' ) | ( '>' ) | ( '\\u2208' ) | ( ':' ) | ( '\\u2209' ) | ( '\\u2282' ) | ( '\\u2284' ) | ( '\\u2286' ) | ( '\\u2288' ) | ( 'partition' ) );
    public final void rule__EVENTB_PREDICATE_SYMBOLS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1087:1: ( ( '(' ) | ( ')' ) | ( '\\u21D4' ) | ( '\\u21D2' ) | ( '\\u2227' ) | ( '&' ) | ( '\\u2228' ) | ( '\\u00AC' ) | ( '\\u22A4' ) | ( '\\u22A5' ) | ( '\\u2200' ) | ( '!' ) | ( '\\u2203' ) | ( '#' ) | ( ',' ) | ( '\\u00B7' ) | ( '.' ) | ( '=' ) | ( '\\u2260' ) | ( '\\u2264' ) | ( '<' ) | ( '\\u2265' ) | ( '>' ) | ( '\\u2208' ) | ( ':' ) | ( '\\u2209' ) | ( '\\u2282' ) | ( '\\u2284' ) | ( '\\u2286' ) | ( '\\u2288' ) | ( 'partition' ) )
            int alt11=31;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt11=1;
                }
                break;
            case 57:
                {
                alt11=2;
                }
                break;
            case 58:
                {
                alt11=3;
                }
                break;
            case 59:
                {
                alt11=4;
                }
                break;
            case 60:
                {
                alt11=5;
                }
                break;
            case 61:
                {
                alt11=6;
                }
                break;
            case 62:
                {
                alt11=7;
                }
                break;
            case 63:
                {
                alt11=8;
                }
                break;
            case 64:
                {
                alt11=9;
                }
                break;
            case 65:
                {
                alt11=10;
                }
                break;
            case 66:
                {
                alt11=11;
                }
                break;
            case 67:
                {
                alt11=12;
                }
                break;
            case 68:
                {
                alt11=13;
                }
                break;
            case 69:
                {
                alt11=14;
                }
                break;
            case 70:
                {
                alt11=15;
                }
                break;
            case 71:
                {
                alt11=16;
                }
                break;
            case 72:
                {
                alt11=17;
                }
                break;
            case 73:
                {
                alt11=18;
                }
                break;
            case 74:
                {
                alt11=19;
                }
                break;
            case 75:
                {
                alt11=20;
                }
                break;
            case 76:
                {
                alt11=21;
                }
                break;
            case 77:
                {
                alt11=22;
                }
                break;
            case 78:
                {
                alt11=23;
                }
                break;
            case 79:
                {
                alt11=24;
                }
                break;
            case 80:
                {
                alt11=25;
                }
                break;
            case 81:
                {
                alt11=26;
                }
                break;
            case 82:
                {
                alt11=27;
                }
                break;
            case 83:
                {
                alt11=28;
                }
                break;
            case 84:
                {
                alt11=29;
                }
                break;
            case 85:
                {
                alt11=30;
                }
                break;
            case 86:
                {
                alt11=31;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalXContext.g:1088:2: ( '(' )
                    {
                    // InternalXContext.g:1088:2: ( '(' )
                    // InternalXContext.g:1089:3: '('
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftParenthesisKeyword_0()); 
                    match(input,56,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftParenthesisKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXContext.g:1094:2: ( ')' )
                    {
                    // InternalXContext.g:1094:2: ( ')' )
                    // InternalXContext.g:1095:3: ')'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightParenthesisKeyword_1()); 
                    match(input,57,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightParenthesisKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXContext.g:1100:2: ( '\\u21D4' )
                    {
                    // InternalXContext.g:1100:2: ( '\\u21D4' )
                    // InternalXContext.g:1101:3: '\\u21D4'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftRightDoubleArrowKeyword_2()); 
                    match(input,58,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftRightDoubleArrowKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXContext.g:1106:2: ( '\\u21D2' )
                    {
                    // InternalXContext.g:1106:2: ( '\\u21D2' )
                    // InternalXContext.g:1107:3: '\\u21D2'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightwardsDoubleArrowKeyword_3()); 
                    match(input,59,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightwardsDoubleArrowKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXContext.g:1112:2: ( '\\u2227' )
                    {
                    // InternalXContext.g:1112:2: ( '\\u2227' )
                    // InternalXContext.g:1113:3: '\\u2227'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalAndKeyword_4()); 
                    match(input,60,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalAndKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXContext.g:1118:2: ( '&' )
                    {
                    // InternalXContext.g:1118:2: ( '&' )
                    // InternalXContext.g:1119:3: '&'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAmpersandKeyword_5()); 
                    match(input,61,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAmpersandKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalXContext.g:1124:2: ( '\\u2228' )
                    {
                    // InternalXContext.g:1124:2: ( '\\u2228' )
                    // InternalXContext.g:1125:3: '\\u2228'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalOrKeyword_6()); 
                    match(input,62,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalOrKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalXContext.g:1130:2: ( '\\u00AC' )
                    {
                    // InternalXContext.g:1130:2: ( '\\u00AC' )
                    // InternalXContext.g:1131:3: '\\u00AC'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotSignKeyword_7()); 
                    match(input,63,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotSignKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalXContext.g:1136:2: ( '\\u22A4' )
                    {
                    // InternalXContext.g:1136:2: ( '\\u22A4' )
                    // InternalXContext.g:1137:3: '\\u22A4'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getDownTackKeyword_8()); 
                    match(input,64,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getDownTackKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalXContext.g:1142:2: ( '\\u22A5' )
                    {
                    // InternalXContext.g:1142:2: ( '\\u22A5' )
                    // InternalXContext.g:1143:3: '\\u22A5'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getUpTackKeyword_9()); 
                    match(input,65,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getUpTackKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalXContext.g:1148:2: ( '\\u2200' )
                    {
                    // InternalXContext.g:1148:2: ( '\\u2200' )
                    // InternalXContext.g:1149:3: '\\u2200'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getForAllKeyword_10()); 
                    match(input,66,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getForAllKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalXContext.g:1154:2: ( '!' )
                    {
                    // InternalXContext.g:1154:2: ( '!' )
                    // InternalXContext.g:1155:3: '!'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getExclamationMarkKeyword_11()); 
                    match(input,67,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getExclamationMarkKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalXContext.g:1160:2: ( '\\u2203' )
                    {
                    // InternalXContext.g:1160:2: ( '\\u2203' )
                    // InternalXContext.g:1161:3: '\\u2203'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getThereExistsKeyword_12()); 
                    match(input,68,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getThereExistsKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalXContext.g:1166:2: ( '#' )
                    {
                    // InternalXContext.g:1166:2: ( '#' )
                    // InternalXContext.g:1167:3: '#'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNumberSignKeyword_13()); 
                    match(input,69,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNumberSignKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalXContext.g:1172:2: ( ',' )
                    {
                    // InternalXContext.g:1172:2: ( ',' )
                    // InternalXContext.g:1173:3: ','
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getCommaKeyword_14()); 
                    match(input,70,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getCommaKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalXContext.g:1178:2: ( '\\u00B7' )
                    {
                    // InternalXContext.g:1178:2: ( '\\u00B7' )
                    // InternalXContext.g:1179:3: '\\u00B7'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getMiddleDotKeyword_15()); 
                    match(input,71,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getMiddleDotKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalXContext.g:1184:2: ( '.' )
                    {
                    // InternalXContext.g:1184:2: ( '.' )
                    // InternalXContext.g:1185:3: '.'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getFullStopKeyword_16()); 
                    match(input,72,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getFullStopKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalXContext.g:1190:2: ( '=' )
                    {
                    // InternalXContext.g:1190:2: ( '=' )
                    // InternalXContext.g:1191:3: '='
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getEqualsSignKeyword_17()); 
                    match(input,73,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getEqualsSignKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalXContext.g:1196:2: ( '\\u2260' )
                    {
                    // InternalXContext.g:1196:2: ( '\\u2260' )
                    // InternalXContext.g:1197:3: '\\u2260'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotEqualToKeyword_18()); 
                    match(input,74,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotEqualToKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalXContext.g:1202:2: ( '\\u2264' )
                    {
                    // InternalXContext.g:1202:2: ( '\\u2264' )
                    // InternalXContext.g:1203:3: '\\u2264'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanOrEqualToKeyword_19()); 
                    match(input,75,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanOrEqualToKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalXContext.g:1208:2: ( '<' )
                    {
                    // InternalXContext.g:1208:2: ( '<' )
                    // InternalXContext.g:1209:3: '<'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanSignKeyword_20()); 
                    match(input,76,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanSignKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalXContext.g:1214:2: ( '\\u2265' )
                    {
                    // InternalXContext.g:1214:2: ( '\\u2265' )
                    // InternalXContext.g:1215:3: '\\u2265'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanOrEqualToKeyword_21()); 
                    match(input,77,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanOrEqualToKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalXContext.g:1220:2: ( '>' )
                    {
                    // InternalXContext.g:1220:2: ( '>' )
                    // InternalXContext.g:1221:3: '>'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanSignKeyword_22()); 
                    match(input,78,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanSignKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalXContext.g:1226:2: ( '\\u2208' )
                    {
                    // InternalXContext.g:1226:2: ( '\\u2208' )
                    // InternalXContext.g:1227:3: '\\u2208'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getElementOfKeyword_23()); 
                    match(input,79,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getElementOfKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalXContext.g:1232:2: ( ':' )
                    {
                    // InternalXContext.g:1232:2: ( ':' )
                    // InternalXContext.g:1233:3: ':'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getColonKeyword_24()); 
                    match(input,80,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getColonKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalXContext.g:1238:2: ( '\\u2209' )
                    {
                    // InternalXContext.g:1238:2: ( '\\u2209' )
                    // InternalXContext.g:1239:3: '\\u2209'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotAnElementOfKeyword_25()); 
                    match(input,81,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotAnElementOfKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalXContext.g:1244:2: ( '\\u2282' )
                    {
                    // InternalXContext.g:1244:2: ( '\\u2282' )
                    // InternalXContext.g:1245:3: '\\u2282'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfKeyword_26()); 
                    match(input,82,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalXContext.g:1250:2: ( '\\u2284' )
                    {
                    // InternalXContext.g:1250:2: ( '\\u2284' )
                    // InternalXContext.g:1251:3: '\\u2284'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotASubsetOfKeyword_27()); 
                    match(input,83,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotASubsetOfKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalXContext.g:1256:2: ( '\\u2286' )
                    {
                    // InternalXContext.g:1256:2: ( '\\u2286' )
                    // InternalXContext.g:1257:3: '\\u2286'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfOrEqualToKeyword_28()); 
                    match(input,84,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfOrEqualToKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalXContext.g:1262:2: ( '\\u2288' )
                    {
                    // InternalXContext.g:1262:2: ( '\\u2288' )
                    // InternalXContext.g:1263:3: '\\u2288'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNeitherASubsetOfNorEqualToKeyword_29()); 
                    match(input,85,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNeitherASubsetOfNorEqualToKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalXContext.g:1268:2: ( 'partition' )
                    {
                    // InternalXContext.g:1268:2: ( 'partition' )
                    // InternalXContext.g:1269:3: 'partition'
                    {
                     before(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getPartitionKeyword_30()); 
                    match(input,86,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getPartitionKeyword_30()); 

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
    // InternalXContext.g:1278:1: rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives : ( ( '\\u2194' ) | ( '\\uE100' ) | ( '\\uE101' ) | ( '\\uE102' ) | ( '\\u21F8' ) | ( '\\u2192' ) | ( '\\u2914' ) | ( '\\u21A3' ) | ( '\\u2900' ) | ( '\\u21A0' ) | ( '\\u2916' ) | ( '{' ) | ( '}' ) | ( '\\u21A6' ) | ( '\\u2205' ) | ( '\\u2229' ) | ( '\\u222A' ) | ( '\\u2216' ) | ( '\\u00D7' ) | ( '[' ) | ( ']' ) | ( '\\uE103' ) | ( '\\u2218' ) | ( ';' ) | ( '\\u2297' ) | ( '\\u2225' ) | ( '\\u223C' ) | ( '\\u25C1' ) | ( '\\u2A64' ) | ( '\\u25B7' ) | ( '\\u2A65' ) | ( '\\u03BB' ) | ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0 ) ) | ( '\\u22C3' ) | ( '\\u2223' ) | ( '\\u2025' ) | ( '+' ) | ( '\\u2212' ) | ( '-' ) | ( '\\u2217' ) | ( '*' ) | ( '\\u00F7' ) | ( '/' ) | ( '^' ) | ( '\\\\' ) );
    public final void rule__EVENTB_EXPRESSION_SYMBOLS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1282:1: ( ( '\\u2194' ) | ( '\\uE100' ) | ( '\\uE101' ) | ( '\\uE102' ) | ( '\\u21F8' ) | ( '\\u2192' ) | ( '\\u2914' ) | ( '\\u21A3' ) | ( '\\u2900' ) | ( '\\u21A0' ) | ( '\\u2916' ) | ( '{' ) | ( '}' ) | ( '\\u21A6' ) | ( '\\u2205' ) | ( '\\u2229' ) | ( '\\u222A' ) | ( '\\u2216' ) | ( '\\u00D7' ) | ( '[' ) | ( ']' ) | ( '\\uE103' ) | ( '\\u2218' ) | ( ';' ) | ( '\\u2297' ) | ( '\\u2225' ) | ( '\\u223C' ) | ( '\\u25C1' ) | ( '\\u2A64' ) | ( '\\u25B7' ) | ( '\\u2A65' ) | ( '\\u03BB' ) | ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0 ) ) | ( '\\u22C3' ) | ( '\\u2223' ) | ( '\\u2025' ) | ( '+' ) | ( '\\u2212' ) | ( '-' ) | ( '\\u2217' ) | ( '*' ) | ( '\\u00F7' ) | ( '/' ) | ( '^' ) | ( '\\\\' ) )
            int alt12=45;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt12=1;
                }
                break;
            case 22:
                {
                alt12=2;
                }
                break;
            case 23:
                {
                alt12=3;
                }
                break;
            case 24:
                {
                alt12=4;
                }
                break;
            case 25:
                {
                alt12=5;
                }
                break;
            case 26:
                {
                alt12=6;
                }
                break;
            case 27:
                {
                alt12=7;
                }
                break;
            case 28:
                {
                alt12=8;
                }
                break;
            case 29:
                {
                alt12=9;
                }
                break;
            case 30:
                {
                alt12=10;
                }
                break;
            case 31:
                {
                alt12=11;
                }
                break;
            case 87:
                {
                alt12=12;
                }
                break;
            case 88:
                {
                alt12=13;
                }
                break;
            case 89:
                {
                alt12=14;
                }
                break;
            case 90:
                {
                alt12=15;
                }
                break;
            case 91:
                {
                alt12=16;
                }
                break;
            case 92:
                {
                alt12=17;
                }
                break;
            case 93:
                {
                alt12=18;
                }
                break;
            case 32:
                {
                alt12=19;
                }
                break;
            case 94:
                {
                alt12=20;
                }
                break;
            case 95:
                {
                alt12=21;
                }
                break;
            case 96:
                {
                alt12=22;
                }
                break;
            case 97:
                {
                alt12=23;
                }
                break;
            case 98:
                {
                alt12=24;
                }
                break;
            case 99:
                {
                alt12=25;
                }
                break;
            case 100:
                {
                alt12=26;
                }
                break;
            case 101:
                {
                alt12=27;
                }
                break;
            case 102:
                {
                alt12=28;
                }
                break;
            case 103:
                {
                alt12=29;
                }
                break;
            case 104:
                {
                alt12=30;
                }
                break;
            case 105:
                {
                alt12=31;
                }
                break;
            case 106:
                {
                alt12=32;
                }
                break;
            case 130:
                {
                alt12=33;
                }
                break;
            case 107:
                {
                alt12=34;
                }
                break;
            case 108:
                {
                alt12=35;
                }
                break;
            case 109:
                {
                alt12=36;
                }
                break;
            case 110:
                {
                alt12=37;
                }
                break;
            case 111:
                {
                alt12=38;
                }
                break;
            case 112:
                {
                alt12=39;
                }
                break;
            case 113:
                {
                alt12=40;
                }
                break;
            case 114:
                {
                alt12=41;
                }
                break;
            case 115:
                {
                alt12=42;
                }
                break;
            case 116:
                {
                alt12=43;
                }
                break;
            case 117:
                {
                alt12=44;
                }
                break;
            case 118:
                {
                alt12=45;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalXContext.g:1283:2: ( '\\u2194' )
                    {
                    // InternalXContext.g:1283:2: ( '\\u2194' )
                    // InternalXContext.g:1284:3: '\\u2194'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftRightArrowKeyword_0()); 
                    match(input,21,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftRightArrowKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXContext.g:1289:2: ( '\\uE100' )
                    {
                    // InternalXContext.g:1289:2: ( '\\uE100' )
                    // InternalXContext.g:1290:3: '\\uE100'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE100Keyword_1()); 
                    match(input,22,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE100Keyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXContext.g:1295:2: ( '\\uE101' )
                    {
                    // InternalXContext.g:1295:2: ( '\\uE101' )
                    // InternalXContext.g:1296:3: '\\uE101'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE101Keyword_2()); 
                    match(input,23,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE101Keyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXContext.g:1301:2: ( '\\uE102' )
                    {
                    // InternalXContext.g:1301:2: ( '\\uE102' )
                    // InternalXContext.g:1302:3: '\\uE102'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE102Keyword_3()); 
                    match(input,24,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE102Keyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXContext.g:1307:2: ( '\\u21F8' )
                    {
                    // InternalXContext.g:1307:2: ( '\\u21F8' )
                    // InternalXContext.g:1308:3: '\\u21F8'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithVerticalStrokeKeyword_4()); 
                    match(input,25,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithVerticalStrokeKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXContext.g:1313:2: ( '\\u2192' )
                    {
                    // InternalXContext.g:1313:2: ( '\\u2192' )
                    // InternalXContext.g:1314:3: '\\u2192'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowKeyword_5()); 
                    match(input,26,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalXContext.g:1319:2: ( '\\u2914' )
                    {
                    // InternalXContext.g:1319:2: ( '\\u2914' )
                    // InternalXContext.g:1320:3: '\\u2914'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailWithVerticalStrokeKeyword_6()); 
                    match(input,27,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailWithVerticalStrokeKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalXContext.g:1325:2: ( '\\u21A3' )
                    {
                    // InternalXContext.g:1325:2: ( '\\u21A3' )
                    // InternalXContext.g:1326:3: '\\u21A3'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailKeyword_7()); 
                    match(input,28,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalXContext.g:1331:2: ( '\\u2900' )
                    {
                    // InternalXContext.g:1331:2: ( '\\u2900' )
                    // InternalXContext.g:1332:3: '\\u2900'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithVerticalStrokeKeyword_8()); 
                    match(input,29,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithVerticalStrokeKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalXContext.g:1337:2: ( '\\u21A0' )
                    {
                    // InternalXContext.g:1337:2: ( '\\u21A0' )
                    // InternalXContext.g:1338:3: '\\u21A0'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowKeyword_9()); 
                    match(input,30,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalXContext.g:1343:2: ( '\\u2916' )
                    {
                    // InternalXContext.g:1343:2: ( '\\u2916' )
                    // InternalXContext.g:1344:3: '\\u2916'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithTailKeyword_10()); 
                    match(input,31,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithTailKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalXContext.g:1349:2: ( '{' )
                    {
                    // InternalXContext.g:1349:2: ( '{' )
                    // InternalXContext.g:1350:3: '{'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftCurlyBracketKeyword_11()); 
                    match(input,87,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftCurlyBracketKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalXContext.g:1355:2: ( '}' )
                    {
                    // InternalXContext.g:1355:2: ( '}' )
                    // InternalXContext.g:1356:3: '}'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightCurlyBracketKeyword_12()); 
                    match(input,88,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightCurlyBracketKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalXContext.g:1361:2: ( '\\u21A6' )
                    {
                    // InternalXContext.g:1361:2: ( '\\u21A6' )
                    // InternalXContext.g:1362:3: '\\u21A6'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowFromBarKeyword_13()); 
                    match(input,89,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowFromBarKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalXContext.g:1367:2: ( '\\u2205' )
                    {
                    // InternalXContext.g:1367:2: ( '\\u2205' )
                    // InternalXContext.g:1368:3: '\\u2205'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getEmptySetKeyword_14()); 
                    match(input,90,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getEmptySetKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalXContext.g:1373:2: ( '\\u2229' )
                    {
                    // InternalXContext.g:1373:2: ( '\\u2229' )
                    // InternalXContext.g:1374:3: '\\u2229'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getIntersectionKeyword_15()); 
                    match(input,91,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getIntersectionKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalXContext.g:1379:2: ( '\\u222A' )
                    {
                    // InternalXContext.g:1379:2: ( '\\u222A' )
                    // InternalXContext.g:1380:3: '\\u222A'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getUnionKeyword_16()); 
                    match(input,92,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getUnionKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalXContext.g:1385:2: ( '\\u2216' )
                    {
                    // InternalXContext.g:1385:2: ( '\\u2216' )
                    // InternalXContext.g:1386:3: '\\u2216'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSetMinusKeyword_17()); 
                    match(input,93,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSetMinusKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalXContext.g:1391:2: ( '\\u00D7' )
                    {
                    // InternalXContext.g:1391:2: ( '\\u00D7' )
                    // InternalXContext.g:1392:3: '\\u00D7'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMultiplicationSignKeyword_18()); 
                    match(input,32,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMultiplicationSignKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalXContext.g:1397:2: ( '[' )
                    {
                    // InternalXContext.g:1397:2: ( '[' )
                    // InternalXContext.g:1398:3: '['
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftSquareBracketKeyword_19()); 
                    match(input,94,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftSquareBracketKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalXContext.g:1403:2: ( ']' )
                    {
                    // InternalXContext.g:1403:2: ( ']' )
                    // InternalXContext.g:1404:3: ']'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightSquareBracketKeyword_20()); 
                    match(input,95,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightSquareBracketKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalXContext.g:1409:2: ( '\\uE103' )
                    {
                    // InternalXContext.g:1409:2: ( '\\uE103' )
                    // InternalXContext.g:1410:3: '\\uE103'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE103Keyword_21()); 
                    match(input,96,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE103Keyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalXContext.g:1415:2: ( '\\u2218' )
                    {
                    // InternalXContext.g:1415:2: ( '\\u2218' )
                    // InternalXContext.g:1416:3: '\\u2218'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRingOperatorKeyword_22()); 
                    match(input,97,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRingOperatorKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalXContext.g:1421:2: ( ';' )
                    {
                    // InternalXContext.g:1421:2: ( ';' )
                    // InternalXContext.g:1422:3: ';'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSemicolonKeyword_23()); 
                    match(input,98,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSemicolonKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalXContext.g:1427:2: ( '\\u2297' )
                    {
                    // InternalXContext.g:1427:2: ( '\\u2297' )
                    // InternalXContext.g:1428:3: '\\u2297'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircledTimesKeyword_24()); 
                    match(input,99,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircledTimesKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalXContext.g:1433:2: ( '\\u2225' )
                    {
                    // InternalXContext.g:1433:2: ( '\\u2225' )
                    // InternalXContext.g:1434:3: '\\u2225'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getParallelToKeyword_25()); 
                    match(input,100,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getParallelToKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalXContext.g:1439:2: ( '\\u223C' )
                    {
                    // InternalXContext.g:1439:2: ( '\\u223C' )
                    // InternalXContext.g:1440:3: '\\u223C'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTildeOperatorKeyword_26()); 
                    match(input,101,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTildeOperatorKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalXContext.g:1445:2: ( '\\u25C1' )
                    {
                    // InternalXContext.g:1445:2: ( '\\u25C1' )
                    // InternalXContext.g:1446:3: '\\u25C1'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteLeftPointingTriangleKeyword_27()); 
                    match(input,102,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteLeftPointingTriangleKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalXContext.g:1451:2: ( '\\u2A64' )
                    {
                    // InternalXContext.g:1451:2: ( '\\u2A64' )
                    // InternalXContext.g:1452:3: '\\u2A64'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationDomainAntirestrictionKeyword_28()); 
                    match(input,103,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationDomainAntirestrictionKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalXContext.g:1457:2: ( '\\u25B7' )
                    {
                    // InternalXContext.g:1457:2: ( '\\u25B7' )
                    // InternalXContext.g:1458:3: '\\u25B7'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteRightPointingTriangleKeyword_29()); 
                    match(input,104,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteRightPointingTriangleKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalXContext.g:1463:2: ( '\\u2A65' )
                    {
                    // InternalXContext.g:1463:2: ( '\\u2A65' )
                    // InternalXContext.g:1464:3: '\\u2A65'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationRangeAntirestrictionKeyword_30()); 
                    match(input,105,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationRangeAntirestrictionKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalXContext.g:1469:2: ( '\\u03BB' )
                    {
                    // InternalXContext.g:1469:2: ( '\\u03BB' )
                    // InternalXContext.g:1470:3: '\\u03BB'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreekSmallLetterLamdaKeyword_31()); 
                    match(input,106,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreekSmallLetterLamdaKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalXContext.g:1475:2: ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0 ) )
                    {
                    // InternalXContext.g:1475:2: ( ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0 ) )
                    // InternalXContext.g:1476:3: ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0 )
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGroup_32()); 
                    // InternalXContext.g:1477:3: ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0 )
                    // InternalXContext.g:1477:4: rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGroup_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalXContext.g:1481:2: ( '\\u22C3' )
                    {
                    // InternalXContext.g:1481:2: ( '\\u22C3' )
                    // InternalXContext.g:1482:3: '\\u22C3'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryUnionKeyword_33()); 
                    match(input,107,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryUnionKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalXContext.g:1487:2: ( '\\u2223' )
                    {
                    // InternalXContext.g:1487:2: ( '\\u2223' )
                    // InternalXContext.g:1488:3: '\\u2223'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDividesKeyword_34()); 
                    match(input,108,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDividesKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalXContext.g:1493:2: ( '\\u2025' )
                    {
                    // InternalXContext.g:1493:2: ( '\\u2025' )
                    // InternalXContext.g:1494:3: '\\u2025'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTwoDotLeaderKeyword_35()); 
                    match(input,109,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTwoDotLeaderKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalXContext.g:1499:2: ( '+' )
                    {
                    // InternalXContext.g:1499:2: ( '+' )
                    // InternalXContext.g:1500:3: '+'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPlusSignKeyword_36()); 
                    match(input,110,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPlusSignKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalXContext.g:1505:2: ( '\\u2212' )
                    {
                    // InternalXContext.g:1505:2: ( '\\u2212' )
                    // InternalXContext.g:1506:3: '\\u2212'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMinusSignKeyword_37()); 
                    match(input,111,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMinusSignKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalXContext.g:1511:2: ( '-' )
                    {
                    // InternalXContext.g:1511:2: ( '-' )
                    // InternalXContext.g:1512:3: '-'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getHyphenMinusKeyword_38()); 
                    match(input,112,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getHyphenMinusKeyword_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalXContext.g:1517:2: ( '\\u2217' )
                    {
                    // InternalXContext.g:1517:2: ( '\\u2217' )
                    // InternalXContext.g:1518:3: '\\u2217'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskOperatorKeyword_39()); 
                    match(input,113,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskOperatorKeyword_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalXContext.g:1523:2: ( '*' )
                    {
                    // InternalXContext.g:1523:2: ( '*' )
                    // InternalXContext.g:1524:3: '*'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskKeyword_40()); 
                    match(input,114,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskKeyword_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalXContext.g:1529:2: ( '\\u00F7' )
                    {
                    // InternalXContext.g:1529:2: ( '\\u00F7' )
                    // InternalXContext.g:1530:3: '\\u00F7'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDivisionSignKeyword_41()); 
                    match(input,115,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDivisionSignKeyword_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalXContext.g:1535:2: ( '/' )
                    {
                    // InternalXContext.g:1535:2: ( '/' )
                    // InternalXContext.g:1536:3: '/'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSolidusKeyword_42()); 
                    match(input,116,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSolidusKeyword_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalXContext.g:1541:2: ( '^' )
                    {
                    // InternalXContext.g:1541:2: ( '^' )
                    // InternalXContext.g:1542:3: '^'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircumflexAccentKeyword_43()); 
                    match(input,117,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircumflexAccentKeyword_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalXContext.g:1547:2: ( '\\\\' )
                    {
                    // InternalXContext.g:1547:2: ( '\\\\' )
                    // InternalXContext.g:1548:3: '\\\\'
                    {
                     before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getBackslashKeyword_44()); 
                    match(input,118,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getBackslashKeyword_44()); 

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


    // $ANTLR start "rule__XRecord__Alternatives_5"
    // InternalXContext.g:1557:1: rule__XRecord__Alternatives_5 : ( ( ( rule__XRecord__Group_5_0__0 ) ) | ( ( rule__XRecord__Group_5_1__0 ) ) );
    public final void rule__XRecord__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1561:1: ( ( ( rule__XRecord__Group_5_0__0 ) ) | ( ( rule__XRecord__Group_5_1__0 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==134) ) {
                alt13=1;
            }
            else if ( (LA13_0==135) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalXContext.g:1562:2: ( ( rule__XRecord__Group_5_0__0 ) )
                    {
                    // InternalXContext.g:1562:2: ( ( rule__XRecord__Group_5_0__0 ) )
                    // InternalXContext.g:1563:3: ( rule__XRecord__Group_5_0__0 )
                    {
                     before(grammarAccess.getXRecordAccess().getGroup_5_0()); 
                    // InternalXContext.g:1564:3: ( rule__XRecord__Group_5_0__0 )
                    // InternalXContext.g:1564:4: rule__XRecord__Group_5_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XRecord__Group_5_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getXRecordAccess().getGroup_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXContext.g:1568:2: ( ( rule__XRecord__Group_5_1__0 ) )
                    {
                    // InternalXContext.g:1568:2: ( ( rule__XRecord__Group_5_1__0 ) )
                    // InternalXContext.g:1569:3: ( rule__XRecord__Group_5_1__0 )
                    {
                     before(grammarAccess.getXRecordAccess().getGroup_5_1()); 
                    // InternalXContext.g:1570:3: ( rule__XRecord__Group_5_1__0 )
                    // InternalXContext.g:1570:4: rule__XRecord__Group_5_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XRecord__Group_5_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getXRecordAccess().getGroup_5_1()); 

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
    // $ANTLR end "rule__XRecord__Alternatives_5"


    // $ANTLR start "rule__FieldType__Alternatives"
    // InternalXContext.g:1578:1: rule__FieldType__Alternatives : ( ( RULE_ID ) | ( ruleEVENTB_IDENTIFIER_KEYWORD ) );
    public final void rule__FieldType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1582:1: ( ( RULE_ID ) | ( ruleEVENTB_IDENTIFIER_KEYWORD ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            else if ( ((LA14_0>=33 && LA14_0<=55)) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalXContext.g:1583:2: ( RULE_ID )
                    {
                    // InternalXContext.g:1583:2: ( RULE_ID )
                    // InternalXContext.g:1584:3: RULE_ID
                    {
                     before(grammarAccess.getFieldTypeAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getFieldTypeAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXContext.g:1589:2: ( ruleEVENTB_IDENTIFIER_KEYWORD )
                    {
                    // InternalXContext.g:1589:2: ( ruleEVENTB_IDENTIFIER_KEYWORD )
                    // InternalXContext.g:1590:3: ruleEVENTB_IDENTIFIER_KEYWORD
                    {
                     before(grammarAccess.getFieldTypeAccess().getEVENTB_IDENTIFIER_KEYWORDParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleEVENTB_IDENTIFIER_KEYWORD();

                    state._fsp--;

                     after(grammarAccess.getFieldTypeAccess().getEVENTB_IDENTIFIER_KEYWORDParserRuleCall_1()); 

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
    // $ANTLR end "rule__FieldType__Alternatives"


    // $ANTLR start "rule__Multiplicity__Alternatives"
    // InternalXContext.g:1599:1: rule__Multiplicity__Alternatives : ( ( ( 'one' ) ) | ( ( 'many' ) ) | ( ( 'opt' ) ) );
    public final void rule__Multiplicity__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1603:1: ( ( ( 'one' ) ) | ( ( 'many' ) ) | ( ( 'opt' ) ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 119:
                {
                alt15=1;
                }
                break;
            case 120:
                {
                alt15=2;
                }
                break;
            case 121:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalXContext.g:1604:2: ( ( 'one' ) )
                    {
                    // InternalXContext.g:1604:2: ( ( 'one' ) )
                    // InternalXContext.g:1605:3: ( 'one' )
                    {
                     before(grammarAccess.getMultiplicityAccess().getONEEnumLiteralDeclaration_0()); 
                    // InternalXContext.g:1606:3: ( 'one' )
                    // InternalXContext.g:1606:4: 'one'
                    {
                    match(input,119,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getMultiplicityAccess().getONEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXContext.g:1610:2: ( ( 'many' ) )
                    {
                    // InternalXContext.g:1610:2: ( ( 'many' ) )
                    // InternalXContext.g:1611:3: ( 'many' )
                    {
                     before(grammarAccess.getMultiplicityAccess().getMANYEnumLiteralDeclaration_1()); 
                    // InternalXContext.g:1612:3: ( 'many' )
                    // InternalXContext.g:1612:4: 'many'
                    {
                    match(input,120,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getMultiplicityAccess().getMANYEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXContext.g:1616:2: ( ( 'opt' ) )
                    {
                    // InternalXContext.g:1616:2: ( ( 'opt' ) )
                    // InternalXContext.g:1617:3: ( 'opt' )
                    {
                     before(grammarAccess.getMultiplicityAccess().getOPTIONALEnumLiteralDeclaration_2()); 
                    // InternalXContext.g:1618:3: ( 'opt' )
                    // InternalXContext.g:1618:4: 'opt'
                    {
                    match(input,121,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getMultiplicityAccess().getOPTIONALEnumLiteralDeclaration_2()); 

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


    // $ANTLR start "rule__XContext__Group__0"
    // InternalXContext.g:1626:1: rule__XContext__Group__0 : rule__XContext__Group__0__Impl rule__XContext__Group__1 ;
    public final void rule__XContext__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1630:1: ( rule__XContext__Group__0__Impl rule__XContext__Group__1 )
            // InternalXContext.g:1631:2: rule__XContext__Group__0__Impl rule__XContext__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__XContext__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group__0"


    // $ANTLR start "rule__XContext__Group__0__Impl"
    // InternalXContext.g:1638:1: rule__XContext__Group__0__Impl : ( () ) ;
    public final void rule__XContext__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1642:1: ( ( () ) )
            // InternalXContext.g:1643:1: ( () )
            {
            // InternalXContext.g:1643:1: ( () )
            // InternalXContext.g:1644:2: ()
            {
             before(grammarAccess.getXContextAccess().getContextAction_0()); 
            // InternalXContext.g:1645:2: ()
            // InternalXContext.g:1645:3: 
            {
            }

             after(grammarAccess.getXContextAccess().getContextAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group__0__Impl"


    // $ANTLR start "rule__XContext__Group__1"
    // InternalXContext.g:1653:1: rule__XContext__Group__1 : rule__XContext__Group__1__Impl rule__XContext__Group__2 ;
    public final void rule__XContext__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1657:1: ( rule__XContext__Group__1__Impl rule__XContext__Group__2 )
            // InternalXContext.g:1658:2: rule__XContext__Group__1__Impl rule__XContext__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__XContext__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group__1"


    // $ANTLR start "rule__XContext__Group__1__Impl"
    // InternalXContext.g:1665:1: rule__XContext__Group__1__Impl : ( ( rule__XContext__CommentAssignment_1 )? ) ;
    public final void rule__XContext__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1669:1: ( ( ( rule__XContext__CommentAssignment_1 )? ) )
            // InternalXContext.g:1670:1: ( ( rule__XContext__CommentAssignment_1 )? )
            {
            // InternalXContext.g:1670:1: ( ( rule__XContext__CommentAssignment_1 )? )
            // InternalXContext.g:1671:2: ( rule__XContext__CommentAssignment_1 )?
            {
             before(grammarAccess.getXContextAccess().getCommentAssignment_1()); 
            // InternalXContext.g:1672:2: ( rule__XContext__CommentAssignment_1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_STRING) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalXContext.g:1672:3: rule__XContext__CommentAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XContext__CommentAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXContextAccess().getCommentAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group__1__Impl"


    // $ANTLR start "rule__XContext__Group__2"
    // InternalXContext.g:1680:1: rule__XContext__Group__2 : rule__XContext__Group__2__Impl rule__XContext__Group__3 ;
    public final void rule__XContext__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1684:1: ( rule__XContext__Group__2__Impl rule__XContext__Group__3 )
            // InternalXContext.g:1685:2: rule__XContext__Group__2__Impl rule__XContext__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__XContext__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group__2"


    // $ANTLR start "rule__XContext__Group__2__Impl"
    // InternalXContext.g:1692:1: rule__XContext__Group__2__Impl : ( 'context' ) ;
    public final void rule__XContext__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1696:1: ( ( 'context' ) )
            // InternalXContext.g:1697:1: ( 'context' )
            {
            // InternalXContext.g:1697:1: ( 'context' )
            // InternalXContext.g:1698:2: 'context'
            {
             before(grammarAccess.getXContextAccess().getContextKeyword_2()); 
            match(input,122,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXContextAccess().getContextKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group__2__Impl"


    // $ANTLR start "rule__XContext__Group__3"
    // InternalXContext.g:1707:1: rule__XContext__Group__3 : rule__XContext__Group__3__Impl rule__XContext__Group__4 ;
    public final void rule__XContext__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1711:1: ( rule__XContext__Group__3__Impl rule__XContext__Group__4 )
            // InternalXContext.g:1712:2: rule__XContext__Group__3__Impl rule__XContext__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__XContext__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group__3"


    // $ANTLR start "rule__XContext__Group__3__Impl"
    // InternalXContext.g:1719:1: rule__XContext__Group__3__Impl : ( ( rule__XContext__NameAssignment_3 ) ) ;
    public final void rule__XContext__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1723:1: ( ( ( rule__XContext__NameAssignment_3 ) ) )
            // InternalXContext.g:1724:1: ( ( rule__XContext__NameAssignment_3 ) )
            {
            // InternalXContext.g:1724:1: ( ( rule__XContext__NameAssignment_3 ) )
            // InternalXContext.g:1725:2: ( rule__XContext__NameAssignment_3 )
            {
             before(grammarAccess.getXContextAccess().getNameAssignment_3()); 
            // InternalXContext.g:1726:2: ( rule__XContext__NameAssignment_3 )
            // InternalXContext.g:1726:3: rule__XContext__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getXContextAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group__3__Impl"


    // $ANTLR start "rule__XContext__Group__4"
    // InternalXContext.g:1734:1: rule__XContext__Group__4 : rule__XContext__Group__4__Impl rule__XContext__Group__5 ;
    public final void rule__XContext__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1738:1: ( rule__XContext__Group__4__Impl rule__XContext__Group__5 )
            // InternalXContext.g:1739:2: rule__XContext__Group__4__Impl rule__XContext__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__XContext__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group__4"


    // $ANTLR start "rule__XContext__Group__4__Impl"
    // InternalXContext.g:1746:1: rule__XContext__Group__4__Impl : ( ( rule__XContext__Group_4__0 )? ) ;
    public final void rule__XContext__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1750:1: ( ( ( rule__XContext__Group_4__0 )? ) )
            // InternalXContext.g:1751:1: ( ( rule__XContext__Group_4__0 )? )
            {
            // InternalXContext.g:1751:1: ( ( rule__XContext__Group_4__0 )? )
            // InternalXContext.g:1752:2: ( rule__XContext__Group_4__0 )?
            {
             before(grammarAccess.getXContextAccess().getGroup_4()); 
            // InternalXContext.g:1753:2: ( rule__XContext__Group_4__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==124) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalXContext.g:1753:3: rule__XContext__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XContext__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXContextAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group__4__Impl"


    // $ANTLR start "rule__XContext__Group__5"
    // InternalXContext.g:1761:1: rule__XContext__Group__5 : rule__XContext__Group__5__Impl rule__XContext__Group__6 ;
    public final void rule__XContext__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1765:1: ( rule__XContext__Group__5__Impl rule__XContext__Group__6 )
            // InternalXContext.g:1766:2: rule__XContext__Group__5__Impl rule__XContext__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__XContext__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group__5"


    // $ANTLR start "rule__XContext__Group__5__Impl"
    // InternalXContext.g:1773:1: rule__XContext__Group__5__Impl : ( ( rule__XContext__Alternatives_5 )* ) ;
    public final void rule__XContext__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1777:1: ( ( ( rule__XContext__Alternatives_5 )* ) )
            // InternalXContext.g:1778:1: ( ( rule__XContext__Alternatives_5 )* )
            {
            // InternalXContext.g:1778:1: ( ( rule__XContext__Alternatives_5 )* )
            // InternalXContext.g:1779:2: ( rule__XContext__Alternatives_5 )*
            {
             before(grammarAccess.getXContextAccess().getAlternatives_5()); 
            // InternalXContext.g:1780:2: ( rule__XContext__Alternatives_5 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_STRING||(LA18_0>=13 && LA18_0<=20)||(LA18_0>=125 && LA18_0<=129)||LA18_0==132||LA18_0==136) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalXContext.g:1780:3: rule__XContext__Alternatives_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__XContext__Alternatives_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getXContextAccess().getAlternatives_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group__5__Impl"


    // $ANTLR start "rule__XContext__Group__6"
    // InternalXContext.g:1788:1: rule__XContext__Group__6 : rule__XContext__Group__6__Impl ;
    public final void rule__XContext__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1792:1: ( rule__XContext__Group__6__Impl )
            // InternalXContext.g:1793:2: rule__XContext__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group__6"


    // $ANTLR start "rule__XContext__Group__6__Impl"
    // InternalXContext.g:1799:1: rule__XContext__Group__6__Impl : ( ( 'end' )? ) ;
    public final void rule__XContext__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1803:1: ( ( ( 'end' )? ) )
            // InternalXContext.g:1804:1: ( ( 'end' )? )
            {
            // InternalXContext.g:1804:1: ( ( 'end' )? )
            // InternalXContext.g:1805:2: ( 'end' )?
            {
             before(grammarAccess.getXContextAccess().getEndKeyword_6()); 
            // InternalXContext.g:1806:2: ( 'end' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==123) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalXContext.g:1806:3: 'end'
                    {
                    match(input,123,FollowSets000.FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getXContextAccess().getEndKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group__6__Impl"


    // $ANTLR start "rule__XContext__Group_4__0"
    // InternalXContext.g:1815:1: rule__XContext__Group_4__0 : rule__XContext__Group_4__0__Impl rule__XContext__Group_4__1 ;
    public final void rule__XContext__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1819:1: ( rule__XContext__Group_4__0__Impl rule__XContext__Group_4__1 )
            // InternalXContext.g:1820:2: rule__XContext__Group_4__0__Impl rule__XContext__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__XContext__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_4__0"


    // $ANTLR start "rule__XContext__Group_4__0__Impl"
    // InternalXContext.g:1827:1: rule__XContext__Group_4__0__Impl : ( 'agents' ) ;
    public final void rule__XContext__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1831:1: ( ( 'agents' ) )
            // InternalXContext.g:1832:1: ( 'agents' )
            {
            // InternalXContext.g:1832:1: ( 'agents' )
            // InternalXContext.g:1833:2: 'agents'
            {
             before(grammarAccess.getXContextAccess().getAgentsKeyword_4_0()); 
            match(input,124,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXContextAccess().getAgentsKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_4__0__Impl"


    // $ANTLR start "rule__XContext__Group_4__1"
    // InternalXContext.g:1842:1: rule__XContext__Group_4__1 : rule__XContext__Group_4__1__Impl ;
    public final void rule__XContext__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1846:1: ( rule__XContext__Group_4__1__Impl )
            // InternalXContext.g:1847:2: rule__XContext__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_4__1"


    // $ANTLR start "rule__XContext__Group_4__1__Impl"
    // InternalXContext.g:1853:1: rule__XContext__Group_4__1__Impl : ( ( ( rule__XContext__OrderedChildrenAssignment_4_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_4_1 )* ) ) ;
    public final void rule__XContext__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1857:1: ( ( ( ( rule__XContext__OrderedChildrenAssignment_4_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_4_1 )* ) ) )
            // InternalXContext.g:1858:1: ( ( ( rule__XContext__OrderedChildrenAssignment_4_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_4_1 )* ) )
            {
            // InternalXContext.g:1858:1: ( ( ( rule__XContext__OrderedChildrenAssignment_4_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_4_1 )* ) )
            // InternalXContext.g:1859:2: ( ( rule__XContext__OrderedChildrenAssignment_4_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_4_1 )* )
            {
            // InternalXContext.g:1859:2: ( ( rule__XContext__OrderedChildrenAssignment_4_1 ) )
            // InternalXContext.g:1860:3: ( rule__XContext__OrderedChildrenAssignment_4_1 )
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_4_1()); 
            // InternalXContext.g:1861:3: ( rule__XContext__OrderedChildrenAssignment_4_1 )
            // InternalXContext.g:1861:4: rule__XContext__OrderedChildrenAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__XContext__OrderedChildrenAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_4_1()); 

            }

            // InternalXContext.g:1864:2: ( ( rule__XContext__OrderedChildrenAssignment_4_1 )* )
            // InternalXContext.g:1865:3: ( rule__XContext__OrderedChildrenAssignment_4_1 )*
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_4_1()); 
            // InternalXContext.g:1866:3: ( rule__XContext__OrderedChildrenAssignment_4_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalXContext.g:1866:4: rule__XContext__OrderedChildrenAssignment_4_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__XContext__OrderedChildrenAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_4_1()); 

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
    // $ANTLR end "rule__XContext__Group_4__1__Impl"


    // $ANTLR start "rule__XContext__Group_5_0__0"
    // InternalXContext.g:1876:1: rule__XContext__Group_5_0__0 : rule__XContext__Group_5_0__0__Impl rule__XContext__Group_5_0__1 ;
    public final void rule__XContext__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1880:1: ( rule__XContext__Group_5_0__0__Impl rule__XContext__Group_5_0__1 )
            // InternalXContext.g:1881:2: rule__XContext__Group_5_0__0__Impl rule__XContext__Group_5_0__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__XContext__Group_5_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group_5_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_5_0__0"


    // $ANTLR start "rule__XContext__Group_5_0__0__Impl"
    // InternalXContext.g:1888:1: rule__XContext__Group_5_0__0__Impl : ( 'extends' ) ;
    public final void rule__XContext__Group_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1892:1: ( ( 'extends' ) )
            // InternalXContext.g:1893:1: ( 'extends' )
            {
            // InternalXContext.g:1893:1: ( 'extends' )
            // InternalXContext.g:1894:2: 'extends'
            {
             before(grammarAccess.getXContextAccess().getExtendsKeyword_5_0_0()); 
            match(input,125,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXContextAccess().getExtendsKeyword_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_5_0__0__Impl"


    // $ANTLR start "rule__XContext__Group_5_0__1"
    // InternalXContext.g:1903:1: rule__XContext__Group_5_0__1 : rule__XContext__Group_5_0__1__Impl ;
    public final void rule__XContext__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1907:1: ( rule__XContext__Group_5_0__1__Impl )
            // InternalXContext.g:1908:2: rule__XContext__Group_5_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group_5_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_5_0__1"


    // $ANTLR start "rule__XContext__Group_5_0__1__Impl"
    // InternalXContext.g:1914:1: rule__XContext__Group_5_0__1__Impl : ( ( ( rule__XContext__ExtendsAssignment_5_0_1 ) ) ( ( rule__XContext__ExtendsAssignment_5_0_1 )* ) ) ;
    public final void rule__XContext__Group_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1918:1: ( ( ( ( rule__XContext__ExtendsAssignment_5_0_1 ) ) ( ( rule__XContext__ExtendsAssignment_5_0_1 )* ) ) )
            // InternalXContext.g:1919:1: ( ( ( rule__XContext__ExtendsAssignment_5_0_1 ) ) ( ( rule__XContext__ExtendsAssignment_5_0_1 )* ) )
            {
            // InternalXContext.g:1919:1: ( ( ( rule__XContext__ExtendsAssignment_5_0_1 ) ) ( ( rule__XContext__ExtendsAssignment_5_0_1 )* ) )
            // InternalXContext.g:1920:2: ( ( rule__XContext__ExtendsAssignment_5_0_1 ) ) ( ( rule__XContext__ExtendsAssignment_5_0_1 )* )
            {
            // InternalXContext.g:1920:2: ( ( rule__XContext__ExtendsAssignment_5_0_1 ) )
            // InternalXContext.g:1921:3: ( rule__XContext__ExtendsAssignment_5_0_1 )
            {
             before(grammarAccess.getXContextAccess().getExtendsAssignment_5_0_1()); 
            // InternalXContext.g:1922:3: ( rule__XContext__ExtendsAssignment_5_0_1 )
            // InternalXContext.g:1922:4: rule__XContext__ExtendsAssignment_5_0_1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__XContext__ExtendsAssignment_5_0_1();

            state._fsp--;


            }

             after(grammarAccess.getXContextAccess().getExtendsAssignment_5_0_1()); 

            }

            // InternalXContext.g:1925:2: ( ( rule__XContext__ExtendsAssignment_5_0_1 )* )
            // InternalXContext.g:1926:3: ( rule__XContext__ExtendsAssignment_5_0_1 )*
            {
             before(grammarAccess.getXContextAccess().getExtendsAssignment_5_0_1()); 
            // InternalXContext.g:1927:3: ( rule__XContext__ExtendsAssignment_5_0_1 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalXContext.g:1927:4: rule__XContext__ExtendsAssignment_5_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__XContext__ExtendsAssignment_5_0_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getXContextAccess().getExtendsAssignment_5_0_1()); 

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
    // $ANTLR end "rule__XContext__Group_5_0__1__Impl"


    // $ANTLR start "rule__XContext__Group_5_1__0"
    // InternalXContext.g:1937:1: rule__XContext__Group_5_1__0 : rule__XContext__Group_5_1__0__Impl rule__XContext__Group_5_1__1 ;
    public final void rule__XContext__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1941:1: ( rule__XContext__Group_5_1__0__Impl rule__XContext__Group_5_1__1 )
            // InternalXContext.g:1942:2: rule__XContext__Group_5_1__0__Impl rule__XContext__Group_5_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__XContext__Group_5_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group_5_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_5_1__0"


    // $ANTLR start "rule__XContext__Group_5_1__0__Impl"
    // InternalXContext.g:1949:1: rule__XContext__Group_5_1__0__Impl : ( ( rule__XContext__Alternatives_5_1_0 ) ) ;
    public final void rule__XContext__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1953:1: ( ( ( rule__XContext__Alternatives_5_1_0 ) ) )
            // InternalXContext.g:1954:1: ( ( rule__XContext__Alternatives_5_1_0 ) )
            {
            // InternalXContext.g:1954:1: ( ( rule__XContext__Alternatives_5_1_0 ) )
            // InternalXContext.g:1955:2: ( rule__XContext__Alternatives_5_1_0 )
            {
             before(grammarAccess.getXContextAccess().getAlternatives_5_1_0()); 
            // InternalXContext.g:1956:2: ( rule__XContext__Alternatives_5_1_0 )
            // InternalXContext.g:1956:3: rule__XContext__Alternatives_5_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Alternatives_5_1_0();

            state._fsp--;


            }

             after(grammarAccess.getXContextAccess().getAlternatives_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_5_1__0__Impl"


    // $ANTLR start "rule__XContext__Group_5_1__1"
    // InternalXContext.g:1964:1: rule__XContext__Group_5_1__1 : rule__XContext__Group_5_1__1__Impl ;
    public final void rule__XContext__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1968:1: ( rule__XContext__Group_5_1__1__Impl )
            // InternalXContext.g:1969:2: rule__XContext__Group_5_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group_5_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_5_1__1"


    // $ANTLR start "rule__XContext__Group_5_1__1__Impl"
    // InternalXContext.g:1975:1: rule__XContext__Group_5_1__1__Impl : ( ( rule__XContext__ExtendsAssignment_5_1_1 ) ) ;
    public final void rule__XContext__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1979:1: ( ( ( rule__XContext__ExtendsAssignment_5_1_1 ) ) )
            // InternalXContext.g:1980:1: ( ( rule__XContext__ExtendsAssignment_5_1_1 ) )
            {
            // InternalXContext.g:1980:1: ( ( rule__XContext__ExtendsAssignment_5_1_1 ) )
            // InternalXContext.g:1981:2: ( rule__XContext__ExtendsAssignment_5_1_1 )
            {
             before(grammarAccess.getXContextAccess().getExtendsAssignment_5_1_1()); 
            // InternalXContext.g:1982:2: ( rule__XContext__ExtendsAssignment_5_1_1 )
            // InternalXContext.g:1982:3: rule__XContext__ExtendsAssignment_5_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__ExtendsAssignment_5_1_1();

            state._fsp--;


            }

             after(grammarAccess.getXContextAccess().getExtendsAssignment_5_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_5_1__1__Impl"


    // $ANTLR start "rule__XContext__Group_5_2__0"
    // InternalXContext.g:1991:1: rule__XContext__Group_5_2__0 : rule__XContext__Group_5_2__0__Impl rule__XContext__Group_5_2__1 ;
    public final void rule__XContext__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:1995:1: ( rule__XContext__Group_5_2__0__Impl rule__XContext__Group_5_2__1 )
            // InternalXContext.g:1996:2: rule__XContext__Group_5_2__0__Impl rule__XContext__Group_5_2__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__XContext__Group_5_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group_5_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_5_2__0"


    // $ANTLR start "rule__XContext__Group_5_2__0__Impl"
    // InternalXContext.g:2003:1: rule__XContext__Group_5_2__0__Impl : ( 'sets' ) ;
    public final void rule__XContext__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2007:1: ( ( 'sets' ) )
            // InternalXContext.g:2008:1: ( 'sets' )
            {
            // InternalXContext.g:2008:1: ( 'sets' )
            // InternalXContext.g:2009:2: 'sets'
            {
             before(grammarAccess.getXContextAccess().getSetsKeyword_5_2_0()); 
            match(input,126,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXContextAccess().getSetsKeyword_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_5_2__0__Impl"


    // $ANTLR start "rule__XContext__Group_5_2__1"
    // InternalXContext.g:2018:1: rule__XContext__Group_5_2__1 : rule__XContext__Group_5_2__1__Impl ;
    public final void rule__XContext__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2022:1: ( rule__XContext__Group_5_2__1__Impl )
            // InternalXContext.g:2023:2: rule__XContext__Group_5_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group_5_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_5_2__1"


    // $ANTLR start "rule__XContext__Group_5_2__1__Impl"
    // InternalXContext.g:2029:1: rule__XContext__Group_5_2__1__Impl : ( ( ( rule__XContext__OrderedChildrenAssignment_5_2_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_5_2_1 )* ) ) ;
    public final void rule__XContext__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2033:1: ( ( ( ( rule__XContext__OrderedChildrenAssignment_5_2_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_5_2_1 )* ) ) )
            // InternalXContext.g:2034:1: ( ( ( rule__XContext__OrderedChildrenAssignment_5_2_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_5_2_1 )* ) )
            {
            // InternalXContext.g:2034:1: ( ( ( rule__XContext__OrderedChildrenAssignment_5_2_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_5_2_1 )* ) )
            // InternalXContext.g:2035:2: ( ( rule__XContext__OrderedChildrenAssignment_5_2_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_5_2_1 )* )
            {
            // InternalXContext.g:2035:2: ( ( rule__XContext__OrderedChildrenAssignment_5_2_1 ) )
            // InternalXContext.g:2036:3: ( rule__XContext__OrderedChildrenAssignment_5_2_1 )
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_2_1()); 
            // InternalXContext.g:2037:3: ( rule__XContext__OrderedChildrenAssignment_5_2_1 )
            // InternalXContext.g:2037:4: rule__XContext__OrderedChildrenAssignment_5_2_1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__XContext__OrderedChildrenAssignment_5_2_1();

            state._fsp--;


            }

             after(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_2_1()); 

            }

            // InternalXContext.g:2040:2: ( ( rule__XContext__OrderedChildrenAssignment_5_2_1 )* )
            // InternalXContext.g:2041:3: ( rule__XContext__OrderedChildrenAssignment_5_2_1 )*
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_2_1()); 
            // InternalXContext.g:2042:3: ( rule__XContext__OrderedChildrenAssignment_5_2_1 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_STRING) ) {
                    int LA22_2 = input.LA(2);

                    if ( (LA22_2==RULE_ID) ) {
                        alt22=1;
                    }


                }
                else if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalXContext.g:2042:4: rule__XContext__OrderedChildrenAssignment_5_2_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    rule__XContext__OrderedChildrenAssignment_5_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_2_1()); 

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
    // $ANTLR end "rule__XContext__Group_5_2__1__Impl"


    // $ANTLR start "rule__XContext__Group_5_4__0"
    // InternalXContext.g:2052:1: rule__XContext__Group_5_4__0 : rule__XContext__Group_5_4__0__Impl rule__XContext__Group_5_4__1 ;
    public final void rule__XContext__Group_5_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2056:1: ( rule__XContext__Group_5_4__0__Impl rule__XContext__Group_5_4__1 )
            // InternalXContext.g:2057:2: rule__XContext__Group_5_4__0__Impl rule__XContext__Group_5_4__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__XContext__Group_5_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group_5_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_5_4__0"


    // $ANTLR start "rule__XContext__Group_5_4__0__Impl"
    // InternalXContext.g:2064:1: rule__XContext__Group_5_4__0__Impl : ( 'constants' ) ;
    public final void rule__XContext__Group_5_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2068:1: ( ( 'constants' ) )
            // InternalXContext.g:2069:1: ( 'constants' )
            {
            // InternalXContext.g:2069:1: ( 'constants' )
            // InternalXContext.g:2070:2: 'constants'
            {
             before(grammarAccess.getXContextAccess().getConstantsKeyword_5_4_0()); 
            match(input,127,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXContextAccess().getConstantsKeyword_5_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_5_4__0__Impl"


    // $ANTLR start "rule__XContext__Group_5_4__1"
    // InternalXContext.g:2079:1: rule__XContext__Group_5_4__1 : rule__XContext__Group_5_4__1__Impl ;
    public final void rule__XContext__Group_5_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2083:1: ( rule__XContext__Group_5_4__1__Impl )
            // InternalXContext.g:2084:2: rule__XContext__Group_5_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group_5_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_5_4__1"


    // $ANTLR start "rule__XContext__Group_5_4__1__Impl"
    // InternalXContext.g:2090:1: rule__XContext__Group_5_4__1__Impl : ( ( ( rule__XContext__OrderedChildrenAssignment_5_4_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_5_4_1 )* ) ) ;
    public final void rule__XContext__Group_5_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2094:1: ( ( ( ( rule__XContext__OrderedChildrenAssignment_5_4_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_5_4_1 )* ) ) )
            // InternalXContext.g:2095:1: ( ( ( rule__XContext__OrderedChildrenAssignment_5_4_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_5_4_1 )* ) )
            {
            // InternalXContext.g:2095:1: ( ( ( rule__XContext__OrderedChildrenAssignment_5_4_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_5_4_1 )* ) )
            // InternalXContext.g:2096:2: ( ( rule__XContext__OrderedChildrenAssignment_5_4_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_5_4_1 )* )
            {
            // InternalXContext.g:2096:2: ( ( rule__XContext__OrderedChildrenAssignment_5_4_1 ) )
            // InternalXContext.g:2097:3: ( rule__XContext__OrderedChildrenAssignment_5_4_1 )
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_4_1()); 
            // InternalXContext.g:2098:3: ( rule__XContext__OrderedChildrenAssignment_5_4_1 )
            // InternalXContext.g:2098:4: rule__XContext__OrderedChildrenAssignment_5_4_1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__XContext__OrderedChildrenAssignment_5_4_1();

            state._fsp--;


            }

             after(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_4_1()); 

            }

            // InternalXContext.g:2101:2: ( ( rule__XContext__OrderedChildrenAssignment_5_4_1 )* )
            // InternalXContext.g:2102:3: ( rule__XContext__OrderedChildrenAssignment_5_4_1 )*
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_4_1()); 
            // InternalXContext.g:2103:3: ( rule__XContext__OrderedChildrenAssignment_5_4_1 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_STRING) ) {
                    int LA23_2 = input.LA(2);

                    if ( (LA23_2==RULE_ID) ) {
                        alt23=1;
                    }


                }
                else if ( (LA23_0==RULE_ID) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalXContext.g:2103:4: rule__XContext__OrderedChildrenAssignment_5_4_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    rule__XContext__OrderedChildrenAssignment_5_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_4_1()); 

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
    // $ANTLR end "rule__XContext__Group_5_4__1__Impl"


    // $ANTLR start "rule__XContext__Group_5_7__0"
    // InternalXContext.g:2113:1: rule__XContext__Group_5_7__0 : rule__XContext__Group_5_7__0__Impl rule__XContext__Group_5_7__1 ;
    public final void rule__XContext__Group_5_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2117:1: ( rule__XContext__Group_5_7__0__Impl rule__XContext__Group_5_7__1 )
            // InternalXContext.g:2118:2: rule__XContext__Group_5_7__0__Impl rule__XContext__Group_5_7__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__XContext__Group_5_7__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group_5_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_5_7__0"


    // $ANTLR start "rule__XContext__Group_5_7__0__Impl"
    // InternalXContext.g:2125:1: rule__XContext__Group_5_7__0__Impl : ( 'axioms' ) ;
    public final void rule__XContext__Group_5_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2129:1: ( ( 'axioms' ) )
            // InternalXContext.g:2130:1: ( 'axioms' )
            {
            // InternalXContext.g:2130:1: ( 'axioms' )
            // InternalXContext.g:2131:2: 'axioms'
            {
             before(grammarAccess.getXContextAccess().getAxiomsKeyword_5_7_0()); 
            match(input,128,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXContextAccess().getAxiomsKeyword_5_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_5_7__0__Impl"


    // $ANTLR start "rule__XContext__Group_5_7__1"
    // InternalXContext.g:2140:1: rule__XContext__Group_5_7__1 : rule__XContext__Group_5_7__1__Impl ;
    public final void rule__XContext__Group_5_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2144:1: ( rule__XContext__Group_5_7__1__Impl )
            // InternalXContext.g:2145:2: rule__XContext__Group_5_7__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XContext__Group_5_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__Group_5_7__1"


    // $ANTLR start "rule__XContext__Group_5_7__1__Impl"
    // InternalXContext.g:2151:1: rule__XContext__Group_5_7__1__Impl : ( ( ( rule__XContext__OrderedChildrenAssignment_5_7_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_5_7_1 )* ) ) ;
    public final void rule__XContext__Group_5_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2155:1: ( ( ( ( rule__XContext__OrderedChildrenAssignment_5_7_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_5_7_1 )* ) ) )
            // InternalXContext.g:2156:1: ( ( ( rule__XContext__OrderedChildrenAssignment_5_7_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_5_7_1 )* ) )
            {
            // InternalXContext.g:2156:1: ( ( ( rule__XContext__OrderedChildrenAssignment_5_7_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_5_7_1 )* ) )
            // InternalXContext.g:2157:2: ( ( rule__XContext__OrderedChildrenAssignment_5_7_1 ) ) ( ( rule__XContext__OrderedChildrenAssignment_5_7_1 )* )
            {
            // InternalXContext.g:2157:2: ( ( rule__XContext__OrderedChildrenAssignment_5_7_1 ) )
            // InternalXContext.g:2158:3: ( rule__XContext__OrderedChildrenAssignment_5_7_1 )
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_7_1()); 
            // InternalXContext.g:2159:3: ( rule__XContext__OrderedChildrenAssignment_5_7_1 )
            // InternalXContext.g:2159:4: rule__XContext__OrderedChildrenAssignment_5_7_1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__XContext__OrderedChildrenAssignment_5_7_1();

            state._fsp--;


            }

             after(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_7_1()); 

            }

            // InternalXContext.g:2162:2: ( ( rule__XContext__OrderedChildrenAssignment_5_7_1 )* )
            // InternalXContext.g:2163:3: ( rule__XContext__OrderedChildrenAssignment_5_7_1 )*
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_7_1()); 
            // InternalXContext.g:2164:3: ( rule__XContext__OrderedChildrenAssignment_5_7_1 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_STRING) ) {
                    int LA24_2 = input.LA(2);

                    if ( (LA24_2==RULE_XLABEL) ) {
                        alt24=1;
                    }


                }
                else if ( (LA24_0==RULE_XLABEL) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalXContext.g:2164:4: rule__XContext__OrderedChildrenAssignment_5_7_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_12);
            	    rule__XContext__OrderedChildrenAssignment_5_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getXContextAccess().getOrderedChildrenAssignment_5_7_1()); 

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
    // $ANTLR end "rule__XContext__Group_5_7__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalXContext.g:2174:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2178:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalXContext.g:2179:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:2186:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2190:1: ( ( RULE_ID ) )
            // InternalXContext.g:2191:1: ( RULE_ID )
            {
            // InternalXContext.g:2191:1: ( RULE_ID )
            // InternalXContext.g:2192:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
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
    // InternalXContext.g:2201:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2205:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalXContext.g:2206:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:2212:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2216:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalXContext.g:2217:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalXContext.g:2217:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalXContext.g:2218:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalXContext.g:2219:2: ( rule__QualifiedName__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==72) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalXContext.g:2219:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
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
    // InternalXContext.g:2228:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2232:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalXContext.g:2233:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:2240:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2244:1: ( ( '.' ) )
            // InternalXContext.g:2245:1: ( '.' )
            {
            // InternalXContext.g:2245:1: ( '.' )
            // InternalXContext.g:2246:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,72,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
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
    // InternalXContext.g:2255:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2259:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalXContext.g:2260:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:2266:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2270:1: ( ( RULE_ID ) )
            // InternalXContext.g:2271:1: ( RULE_ID )
            {
            // InternalXContext.g:2271:1: ( RULE_ID )
            // InternalXContext.g:2272:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__XCarrierSet__Group__0"
    // InternalXContext.g:2282:1: rule__XCarrierSet__Group__0 : rule__XCarrierSet__Group__0__Impl rule__XCarrierSet__Group__1 ;
    public final void rule__XCarrierSet__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2286:1: ( rule__XCarrierSet__Group__0__Impl rule__XCarrierSet__Group__1 )
            // InternalXContext.g:2287:2: rule__XCarrierSet__Group__0__Impl rule__XCarrierSet__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__XCarrierSet__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XCarrierSet__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XCarrierSet__Group__0"


    // $ANTLR start "rule__XCarrierSet__Group__0__Impl"
    // InternalXContext.g:2294:1: rule__XCarrierSet__Group__0__Impl : ( () ) ;
    public final void rule__XCarrierSet__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2298:1: ( ( () ) )
            // InternalXContext.g:2299:1: ( () )
            {
            // InternalXContext.g:2299:1: ( () )
            // InternalXContext.g:2300:2: ()
            {
             before(grammarAccess.getXCarrierSetAccess().getCarrierSetAction_0()); 
            // InternalXContext.g:2301:2: ()
            // InternalXContext.g:2301:3: 
            {
            }

             after(grammarAccess.getXCarrierSetAccess().getCarrierSetAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XCarrierSet__Group__0__Impl"


    // $ANTLR start "rule__XCarrierSet__Group__1"
    // InternalXContext.g:2309:1: rule__XCarrierSet__Group__1 : rule__XCarrierSet__Group__1__Impl rule__XCarrierSet__Group__2 ;
    public final void rule__XCarrierSet__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2313:1: ( rule__XCarrierSet__Group__1__Impl rule__XCarrierSet__Group__2 )
            // InternalXContext.g:2314:2: rule__XCarrierSet__Group__1__Impl rule__XCarrierSet__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__XCarrierSet__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XCarrierSet__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XCarrierSet__Group__1"


    // $ANTLR start "rule__XCarrierSet__Group__1__Impl"
    // InternalXContext.g:2321:1: rule__XCarrierSet__Group__1__Impl : ( ( rule__XCarrierSet__CommentAssignment_1 )? ) ;
    public final void rule__XCarrierSet__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2325:1: ( ( ( rule__XCarrierSet__CommentAssignment_1 )? ) )
            // InternalXContext.g:2326:1: ( ( rule__XCarrierSet__CommentAssignment_1 )? )
            {
            // InternalXContext.g:2326:1: ( ( rule__XCarrierSet__CommentAssignment_1 )? )
            // InternalXContext.g:2327:2: ( rule__XCarrierSet__CommentAssignment_1 )?
            {
             before(grammarAccess.getXCarrierSetAccess().getCommentAssignment_1()); 
            // InternalXContext.g:2328:2: ( rule__XCarrierSet__CommentAssignment_1 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_STRING) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalXContext.g:2328:3: rule__XCarrierSet__CommentAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XCarrierSet__CommentAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXCarrierSetAccess().getCommentAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XCarrierSet__Group__1__Impl"


    // $ANTLR start "rule__XCarrierSet__Group__2"
    // InternalXContext.g:2336:1: rule__XCarrierSet__Group__2 : rule__XCarrierSet__Group__2__Impl ;
    public final void rule__XCarrierSet__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2340:1: ( rule__XCarrierSet__Group__2__Impl )
            // InternalXContext.g:2341:2: rule__XCarrierSet__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XCarrierSet__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XCarrierSet__Group__2"


    // $ANTLR start "rule__XCarrierSet__Group__2__Impl"
    // InternalXContext.g:2347:1: rule__XCarrierSet__Group__2__Impl : ( ( rule__XCarrierSet__NameAssignment_2 ) ) ;
    public final void rule__XCarrierSet__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2351:1: ( ( ( rule__XCarrierSet__NameAssignment_2 ) ) )
            // InternalXContext.g:2352:1: ( ( rule__XCarrierSet__NameAssignment_2 ) )
            {
            // InternalXContext.g:2352:1: ( ( rule__XCarrierSet__NameAssignment_2 ) )
            // InternalXContext.g:2353:2: ( rule__XCarrierSet__NameAssignment_2 )
            {
             before(grammarAccess.getXCarrierSetAccess().getNameAssignment_2()); 
            // InternalXContext.g:2354:2: ( rule__XCarrierSet__NameAssignment_2 )
            // InternalXContext.g:2354:3: rule__XCarrierSet__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XCarrierSet__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getXCarrierSetAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XCarrierSet__Group__2__Impl"


    // $ANTLR start "rule__XIndividualCarrierSet__Group__0"
    // InternalXContext.g:2363:1: rule__XIndividualCarrierSet__Group__0 : rule__XIndividualCarrierSet__Group__0__Impl rule__XIndividualCarrierSet__Group__1 ;
    public final void rule__XIndividualCarrierSet__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2367:1: ( rule__XIndividualCarrierSet__Group__0__Impl rule__XIndividualCarrierSet__Group__1 )
            // InternalXContext.g:2368:2: rule__XIndividualCarrierSet__Group__0__Impl rule__XIndividualCarrierSet__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__XIndividualCarrierSet__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualCarrierSet__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualCarrierSet__Group__0"


    // $ANTLR start "rule__XIndividualCarrierSet__Group__0__Impl"
    // InternalXContext.g:2375:1: rule__XIndividualCarrierSet__Group__0__Impl : ( () ) ;
    public final void rule__XIndividualCarrierSet__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2379:1: ( ( () ) )
            // InternalXContext.g:2380:1: ( () )
            {
            // InternalXContext.g:2380:1: ( () )
            // InternalXContext.g:2381:2: ()
            {
             before(grammarAccess.getXIndividualCarrierSetAccess().getCarrierSetAction_0()); 
            // InternalXContext.g:2382:2: ()
            // InternalXContext.g:2382:3: 
            {
            }

             after(grammarAccess.getXIndividualCarrierSetAccess().getCarrierSetAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualCarrierSet__Group__0__Impl"


    // $ANTLR start "rule__XIndividualCarrierSet__Group__1"
    // InternalXContext.g:2390:1: rule__XIndividualCarrierSet__Group__1 : rule__XIndividualCarrierSet__Group__1__Impl rule__XIndividualCarrierSet__Group__2 ;
    public final void rule__XIndividualCarrierSet__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2394:1: ( rule__XIndividualCarrierSet__Group__1__Impl rule__XIndividualCarrierSet__Group__2 )
            // InternalXContext.g:2395:2: rule__XIndividualCarrierSet__Group__1__Impl rule__XIndividualCarrierSet__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__XIndividualCarrierSet__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualCarrierSet__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualCarrierSet__Group__1"


    // $ANTLR start "rule__XIndividualCarrierSet__Group__1__Impl"
    // InternalXContext.g:2402:1: rule__XIndividualCarrierSet__Group__1__Impl : ( ( rule__XIndividualCarrierSet__CommentAssignment_1 )? ) ;
    public final void rule__XIndividualCarrierSet__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2406:1: ( ( ( rule__XIndividualCarrierSet__CommentAssignment_1 )? ) )
            // InternalXContext.g:2407:1: ( ( rule__XIndividualCarrierSet__CommentAssignment_1 )? )
            {
            // InternalXContext.g:2407:1: ( ( rule__XIndividualCarrierSet__CommentAssignment_1 )? )
            // InternalXContext.g:2408:2: ( rule__XIndividualCarrierSet__CommentAssignment_1 )?
            {
             before(grammarAccess.getXIndividualCarrierSetAccess().getCommentAssignment_1()); 
            // InternalXContext.g:2409:2: ( rule__XIndividualCarrierSet__CommentAssignment_1 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_STRING) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalXContext.g:2409:3: rule__XIndividualCarrierSet__CommentAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XIndividualCarrierSet__CommentAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXIndividualCarrierSetAccess().getCommentAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualCarrierSet__Group__1__Impl"


    // $ANTLR start "rule__XIndividualCarrierSet__Group__2"
    // InternalXContext.g:2417:1: rule__XIndividualCarrierSet__Group__2 : rule__XIndividualCarrierSet__Group__2__Impl rule__XIndividualCarrierSet__Group__3 ;
    public final void rule__XIndividualCarrierSet__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2421:1: ( rule__XIndividualCarrierSet__Group__2__Impl rule__XIndividualCarrierSet__Group__3 )
            // InternalXContext.g:2422:2: rule__XIndividualCarrierSet__Group__2__Impl rule__XIndividualCarrierSet__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__XIndividualCarrierSet__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualCarrierSet__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualCarrierSet__Group__2"


    // $ANTLR start "rule__XIndividualCarrierSet__Group__2__Impl"
    // InternalXContext.g:2429:1: rule__XIndividualCarrierSet__Group__2__Impl : ( 'set' ) ;
    public final void rule__XIndividualCarrierSet__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2433:1: ( ( 'set' ) )
            // InternalXContext.g:2434:1: ( 'set' )
            {
            // InternalXContext.g:2434:1: ( 'set' )
            // InternalXContext.g:2435:2: 'set'
            {
             before(grammarAccess.getXIndividualCarrierSetAccess().getSetKeyword_2()); 
            match(input,129,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXIndividualCarrierSetAccess().getSetKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualCarrierSet__Group__2__Impl"


    // $ANTLR start "rule__XIndividualCarrierSet__Group__3"
    // InternalXContext.g:2444:1: rule__XIndividualCarrierSet__Group__3 : rule__XIndividualCarrierSet__Group__3__Impl ;
    public final void rule__XIndividualCarrierSet__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2448:1: ( rule__XIndividualCarrierSet__Group__3__Impl )
            // InternalXContext.g:2449:2: rule__XIndividualCarrierSet__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualCarrierSet__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualCarrierSet__Group__3"


    // $ANTLR start "rule__XIndividualCarrierSet__Group__3__Impl"
    // InternalXContext.g:2455:1: rule__XIndividualCarrierSet__Group__3__Impl : ( ( rule__XIndividualCarrierSet__NameAssignment_3 ) ) ;
    public final void rule__XIndividualCarrierSet__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2459:1: ( ( ( rule__XIndividualCarrierSet__NameAssignment_3 ) ) )
            // InternalXContext.g:2460:1: ( ( rule__XIndividualCarrierSet__NameAssignment_3 ) )
            {
            // InternalXContext.g:2460:1: ( ( rule__XIndividualCarrierSet__NameAssignment_3 ) )
            // InternalXContext.g:2461:2: ( rule__XIndividualCarrierSet__NameAssignment_3 )
            {
             before(grammarAccess.getXIndividualCarrierSetAccess().getNameAssignment_3()); 
            // InternalXContext.g:2462:2: ( rule__XIndividualCarrierSet__NameAssignment_3 )
            // InternalXContext.g:2462:3: rule__XIndividualCarrierSet__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualCarrierSet__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getXIndividualCarrierSetAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualCarrierSet__Group__3__Impl"


    // $ANTLR start "rule__XConstant__Group__0"
    // InternalXContext.g:2471:1: rule__XConstant__Group__0 : rule__XConstant__Group__0__Impl rule__XConstant__Group__1 ;
    public final void rule__XConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2475:1: ( rule__XConstant__Group__0__Impl rule__XConstant__Group__1 )
            // InternalXContext.g:2476:2: rule__XConstant__Group__0__Impl rule__XConstant__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__XConstant__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XConstant__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstant__Group__0"


    // $ANTLR start "rule__XConstant__Group__0__Impl"
    // InternalXContext.g:2483:1: rule__XConstant__Group__0__Impl : ( () ) ;
    public final void rule__XConstant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2487:1: ( ( () ) )
            // InternalXContext.g:2488:1: ( () )
            {
            // InternalXContext.g:2488:1: ( () )
            // InternalXContext.g:2489:2: ()
            {
             before(grammarAccess.getXConstantAccess().getConstantAction_0()); 
            // InternalXContext.g:2490:2: ()
            // InternalXContext.g:2490:3: 
            {
            }

             after(grammarAccess.getXConstantAccess().getConstantAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstant__Group__0__Impl"


    // $ANTLR start "rule__XConstant__Group__1"
    // InternalXContext.g:2498:1: rule__XConstant__Group__1 : rule__XConstant__Group__1__Impl rule__XConstant__Group__2 ;
    public final void rule__XConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2502:1: ( rule__XConstant__Group__1__Impl rule__XConstant__Group__2 )
            // InternalXContext.g:2503:2: rule__XConstant__Group__1__Impl rule__XConstant__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__XConstant__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XConstant__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstant__Group__1"


    // $ANTLR start "rule__XConstant__Group__1__Impl"
    // InternalXContext.g:2510:1: rule__XConstant__Group__1__Impl : ( ( rule__XConstant__CommentAssignment_1 )? ) ;
    public final void rule__XConstant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2514:1: ( ( ( rule__XConstant__CommentAssignment_1 )? ) )
            // InternalXContext.g:2515:1: ( ( rule__XConstant__CommentAssignment_1 )? )
            {
            // InternalXContext.g:2515:1: ( ( rule__XConstant__CommentAssignment_1 )? )
            // InternalXContext.g:2516:2: ( rule__XConstant__CommentAssignment_1 )?
            {
             before(grammarAccess.getXConstantAccess().getCommentAssignment_1()); 
            // InternalXContext.g:2517:2: ( rule__XConstant__CommentAssignment_1 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_STRING) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalXContext.g:2517:3: rule__XConstant__CommentAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XConstant__CommentAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXConstantAccess().getCommentAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstant__Group__1__Impl"


    // $ANTLR start "rule__XConstant__Group__2"
    // InternalXContext.g:2525:1: rule__XConstant__Group__2 : rule__XConstant__Group__2__Impl ;
    public final void rule__XConstant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2529:1: ( rule__XConstant__Group__2__Impl )
            // InternalXContext.g:2530:2: rule__XConstant__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XConstant__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstant__Group__2"


    // $ANTLR start "rule__XConstant__Group__2__Impl"
    // InternalXContext.g:2536:1: rule__XConstant__Group__2__Impl : ( ( rule__XConstant__NameAssignment_2 ) ) ;
    public final void rule__XConstant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2540:1: ( ( ( rule__XConstant__NameAssignment_2 ) ) )
            // InternalXContext.g:2541:1: ( ( rule__XConstant__NameAssignment_2 ) )
            {
            // InternalXContext.g:2541:1: ( ( rule__XConstant__NameAssignment_2 ) )
            // InternalXContext.g:2542:2: ( rule__XConstant__NameAssignment_2 )
            {
             before(grammarAccess.getXConstantAccess().getNameAssignment_2()); 
            // InternalXContext.g:2543:2: ( rule__XConstant__NameAssignment_2 )
            // InternalXContext.g:2543:3: rule__XConstant__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XConstant__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getXConstantAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstant__Group__2__Impl"


    // $ANTLR start "rule__XIndividualConstant__Group__0"
    // InternalXContext.g:2552:1: rule__XIndividualConstant__Group__0 : rule__XIndividualConstant__Group__0__Impl rule__XIndividualConstant__Group__1 ;
    public final void rule__XIndividualConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2556:1: ( rule__XIndividualConstant__Group__0__Impl rule__XIndividualConstant__Group__1 )
            // InternalXContext.g:2557:2: rule__XIndividualConstant__Group__0__Impl rule__XIndividualConstant__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__XIndividualConstant__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualConstant__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group__0"


    // $ANTLR start "rule__XIndividualConstant__Group__0__Impl"
    // InternalXContext.g:2564:1: rule__XIndividualConstant__Group__0__Impl : ( () ) ;
    public final void rule__XIndividualConstant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2568:1: ( ( () ) )
            // InternalXContext.g:2569:1: ( () )
            {
            // InternalXContext.g:2569:1: ( () )
            // InternalXContext.g:2570:2: ()
            {
             before(grammarAccess.getXIndividualConstantAccess().getTypedConstantAction_0()); 
            // InternalXContext.g:2571:2: ()
            // InternalXContext.g:2571:3: 
            {
            }

             after(grammarAccess.getXIndividualConstantAccess().getTypedConstantAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group__0__Impl"


    // $ANTLR start "rule__XIndividualConstant__Group__1"
    // InternalXContext.g:2579:1: rule__XIndividualConstant__Group__1 : rule__XIndividualConstant__Group__1__Impl rule__XIndividualConstant__Group__2 ;
    public final void rule__XIndividualConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2583:1: ( rule__XIndividualConstant__Group__1__Impl rule__XIndividualConstant__Group__2 )
            // InternalXContext.g:2584:2: rule__XIndividualConstant__Group__1__Impl rule__XIndividualConstant__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__XIndividualConstant__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualConstant__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group__1"


    // $ANTLR start "rule__XIndividualConstant__Group__1__Impl"
    // InternalXContext.g:2591:1: rule__XIndividualConstant__Group__1__Impl : ( ( rule__XIndividualConstant__CommentAssignment_1 )? ) ;
    public final void rule__XIndividualConstant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2595:1: ( ( ( rule__XIndividualConstant__CommentAssignment_1 )? ) )
            // InternalXContext.g:2596:1: ( ( rule__XIndividualConstant__CommentAssignment_1 )? )
            {
            // InternalXContext.g:2596:1: ( ( rule__XIndividualConstant__CommentAssignment_1 )? )
            // InternalXContext.g:2597:2: ( rule__XIndividualConstant__CommentAssignment_1 )?
            {
             before(grammarAccess.getXIndividualConstantAccess().getCommentAssignment_1()); 
            // InternalXContext.g:2598:2: ( rule__XIndividualConstant__CommentAssignment_1 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_STRING) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalXContext.g:2598:3: rule__XIndividualConstant__CommentAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XIndividualConstant__CommentAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXIndividualConstantAccess().getCommentAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group__1__Impl"


    // $ANTLR start "rule__XIndividualConstant__Group__2"
    // InternalXContext.g:2606:1: rule__XIndividualConstant__Group__2 : rule__XIndividualConstant__Group__2__Impl rule__XIndividualConstant__Group__3 ;
    public final void rule__XIndividualConstant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2610:1: ( rule__XIndividualConstant__Group__2__Impl rule__XIndividualConstant__Group__3 )
            // InternalXContext.g:2611:2: rule__XIndividualConstant__Group__2__Impl rule__XIndividualConstant__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__XIndividualConstant__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualConstant__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group__2"


    // $ANTLR start "rule__XIndividualConstant__Group__2__Impl"
    // InternalXContext.g:2618:1: rule__XIndividualConstant__Group__2__Impl : ( ( rule__XIndividualConstant__Alternatives_2 ) ) ;
    public final void rule__XIndividualConstant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2622:1: ( ( ( rule__XIndividualConstant__Alternatives_2 ) ) )
            // InternalXContext.g:2623:1: ( ( rule__XIndividualConstant__Alternatives_2 ) )
            {
            // InternalXContext.g:2623:1: ( ( rule__XIndividualConstant__Alternatives_2 ) )
            // InternalXContext.g:2624:2: ( rule__XIndividualConstant__Alternatives_2 )
            {
             before(grammarAccess.getXIndividualConstantAccess().getAlternatives_2()); 
            // InternalXContext.g:2625:2: ( rule__XIndividualConstant__Alternatives_2 )
            // InternalXContext.g:2625:3: rule__XIndividualConstant__Alternatives_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualConstant__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getXIndividualConstantAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group__2__Impl"


    // $ANTLR start "rule__XIndividualConstant__Group__3"
    // InternalXContext.g:2633:1: rule__XIndividualConstant__Group__3 : rule__XIndividualConstant__Group__3__Impl rule__XIndividualConstant__Group__4 ;
    public final void rule__XIndividualConstant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2637:1: ( rule__XIndividualConstant__Group__3__Impl rule__XIndividualConstant__Group__4 )
            // InternalXContext.g:2638:2: rule__XIndividualConstant__Group__3__Impl rule__XIndividualConstant__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__XIndividualConstant__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualConstant__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group__3"


    // $ANTLR start "rule__XIndividualConstant__Group__3__Impl"
    // InternalXContext.g:2645:1: rule__XIndividualConstant__Group__3__Impl : ( ( rule__XIndividualConstant__NameAssignment_3 ) ) ;
    public final void rule__XIndividualConstant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2649:1: ( ( ( rule__XIndividualConstant__NameAssignment_3 ) ) )
            // InternalXContext.g:2650:1: ( ( rule__XIndividualConstant__NameAssignment_3 ) )
            {
            // InternalXContext.g:2650:1: ( ( rule__XIndividualConstant__NameAssignment_3 ) )
            // InternalXContext.g:2651:2: ( rule__XIndividualConstant__NameAssignment_3 )
            {
             before(grammarAccess.getXIndividualConstantAccess().getNameAssignment_3()); 
            // InternalXContext.g:2652:2: ( rule__XIndividualConstant__NameAssignment_3 )
            // InternalXContext.g:2652:3: rule__XIndividualConstant__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualConstant__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getXIndividualConstantAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group__3__Impl"


    // $ANTLR start "rule__XIndividualConstant__Group__4"
    // InternalXContext.g:2660:1: rule__XIndividualConstant__Group__4 : rule__XIndividualConstant__Group__4__Impl rule__XIndividualConstant__Group__5 ;
    public final void rule__XIndividualConstant__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2664:1: ( rule__XIndividualConstant__Group__4__Impl rule__XIndividualConstant__Group__5 )
            // InternalXContext.g:2665:2: rule__XIndividualConstant__Group__4__Impl rule__XIndividualConstant__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__XIndividualConstant__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualConstant__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group__4"


    // $ANTLR start "rule__XIndividualConstant__Group__4__Impl"
    // InternalXContext.g:2672:1: rule__XIndividualConstant__Group__4__Impl : ( ( rule__XIndividualConstant__Group_4__0 )? ) ;
    public final void rule__XIndividualConstant__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2676:1: ( ( ( rule__XIndividualConstant__Group_4__0 )? ) )
            // InternalXContext.g:2677:1: ( ( rule__XIndividualConstant__Group_4__0 )? )
            {
            // InternalXContext.g:2677:1: ( ( rule__XIndividualConstant__Group_4__0 )? )
            // InternalXContext.g:2678:2: ( rule__XIndividualConstant__Group_4__0 )?
            {
             before(grammarAccess.getXIndividualConstantAccess().getGroup_4()); 
            // InternalXContext.g:2679:2: ( rule__XIndividualConstant__Group_4__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==80) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalXContext.g:2679:3: rule__XIndividualConstant__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XIndividualConstant__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXIndividualConstantAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group__4__Impl"


    // $ANTLR start "rule__XIndividualConstant__Group__5"
    // InternalXContext.g:2687:1: rule__XIndividualConstant__Group__5 : rule__XIndividualConstant__Group__5__Impl ;
    public final void rule__XIndividualConstant__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2691:1: ( rule__XIndividualConstant__Group__5__Impl )
            // InternalXContext.g:2692:2: rule__XIndividualConstant__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualConstant__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group__5"


    // $ANTLR start "rule__XIndividualConstant__Group__5__Impl"
    // InternalXContext.g:2698:1: rule__XIndividualConstant__Group__5__Impl : ( ( rule__XIndividualConstant__Group_5__0 )? ) ;
    public final void rule__XIndividualConstant__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2702:1: ( ( ( rule__XIndividualConstant__Group_5__0 )? ) )
            // InternalXContext.g:2703:1: ( ( rule__XIndividualConstant__Group_5__0 )? )
            {
            // InternalXContext.g:2703:1: ( ( rule__XIndividualConstant__Group_5__0 )? )
            // InternalXContext.g:2704:2: ( rule__XIndividualConstant__Group_5__0 )?
            {
             before(grammarAccess.getXIndividualConstantAccess().getGroup_5()); 
            // InternalXContext.g:2705:2: ( rule__XIndividualConstant__Group_5__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==73) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalXContext.g:2705:3: rule__XIndividualConstant__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XIndividualConstant__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXIndividualConstantAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group__5__Impl"


    // $ANTLR start "rule__XIndividualConstant__Group_4__0"
    // InternalXContext.g:2714:1: rule__XIndividualConstant__Group_4__0 : rule__XIndividualConstant__Group_4__0__Impl rule__XIndividualConstant__Group_4__1 ;
    public final void rule__XIndividualConstant__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2718:1: ( rule__XIndividualConstant__Group_4__0__Impl rule__XIndividualConstant__Group_4__1 )
            // InternalXContext.g:2719:2: rule__XIndividualConstant__Group_4__0__Impl rule__XIndividualConstant__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__XIndividualConstant__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualConstant__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group_4__0"


    // $ANTLR start "rule__XIndividualConstant__Group_4__0__Impl"
    // InternalXContext.g:2726:1: rule__XIndividualConstant__Group_4__0__Impl : ( ':' ) ;
    public final void rule__XIndividualConstant__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2730:1: ( ( ':' ) )
            // InternalXContext.g:2731:1: ( ':' )
            {
            // InternalXContext.g:2731:1: ( ':' )
            // InternalXContext.g:2732:2: ':'
            {
             before(grammarAccess.getXIndividualConstantAccess().getColonKeyword_4_0()); 
            match(input,80,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXIndividualConstantAccess().getColonKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group_4__0__Impl"


    // $ANTLR start "rule__XIndividualConstant__Group_4__1"
    // InternalXContext.g:2741:1: rule__XIndividualConstant__Group_4__1 : rule__XIndividualConstant__Group_4__1__Impl ;
    public final void rule__XIndividualConstant__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2745:1: ( rule__XIndividualConstant__Group_4__1__Impl )
            // InternalXContext.g:2746:2: rule__XIndividualConstant__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualConstant__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group_4__1"


    // $ANTLR start "rule__XIndividualConstant__Group_4__1__Impl"
    // InternalXContext.g:2752:1: rule__XIndividualConstant__Group_4__1__Impl : ( ( rule__XIndividualConstant__TypeAssignment_4_1 ) ) ;
    public final void rule__XIndividualConstant__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2756:1: ( ( ( rule__XIndividualConstant__TypeAssignment_4_1 ) ) )
            // InternalXContext.g:2757:1: ( ( rule__XIndividualConstant__TypeAssignment_4_1 ) )
            {
            // InternalXContext.g:2757:1: ( ( rule__XIndividualConstant__TypeAssignment_4_1 ) )
            // InternalXContext.g:2758:2: ( rule__XIndividualConstant__TypeAssignment_4_1 )
            {
             before(grammarAccess.getXIndividualConstantAccess().getTypeAssignment_4_1()); 
            // InternalXContext.g:2759:2: ( rule__XIndividualConstant__TypeAssignment_4_1 )
            // InternalXContext.g:2759:3: rule__XIndividualConstant__TypeAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualConstant__TypeAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getXIndividualConstantAccess().getTypeAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group_4__1__Impl"


    // $ANTLR start "rule__XIndividualConstant__Group_5__0"
    // InternalXContext.g:2768:1: rule__XIndividualConstant__Group_5__0 : rule__XIndividualConstant__Group_5__0__Impl rule__XIndividualConstant__Group_5__1 ;
    public final void rule__XIndividualConstant__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2772:1: ( rule__XIndividualConstant__Group_5__0__Impl rule__XIndividualConstant__Group_5__1 )
            // InternalXContext.g:2773:2: rule__XIndividualConstant__Group_5__0__Impl rule__XIndividualConstant__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__XIndividualConstant__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualConstant__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group_5__0"


    // $ANTLR start "rule__XIndividualConstant__Group_5__0__Impl"
    // InternalXContext.g:2780:1: rule__XIndividualConstant__Group_5__0__Impl : ( '=' ) ;
    public final void rule__XIndividualConstant__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2784:1: ( ( '=' ) )
            // InternalXContext.g:2785:1: ( '=' )
            {
            // InternalXContext.g:2785:1: ( '=' )
            // InternalXContext.g:2786:2: '='
            {
             before(grammarAccess.getXIndividualConstantAccess().getEqualsSignKeyword_5_0()); 
            match(input,73,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXIndividualConstantAccess().getEqualsSignKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group_5__0__Impl"


    // $ANTLR start "rule__XIndividualConstant__Group_5__1"
    // InternalXContext.g:2795:1: rule__XIndividualConstant__Group_5__1 : rule__XIndividualConstant__Group_5__1__Impl ;
    public final void rule__XIndividualConstant__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2799:1: ( rule__XIndividualConstant__Group_5__1__Impl )
            // InternalXContext.g:2800:2: rule__XIndividualConstant__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualConstant__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group_5__1"


    // $ANTLR start "rule__XIndividualConstant__Group_5__1__Impl"
    // InternalXContext.g:2806:1: rule__XIndividualConstant__Group_5__1__Impl : ( ( rule__XIndividualConstant__ValueAssignment_5_1 ) ) ;
    public final void rule__XIndividualConstant__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2810:1: ( ( ( rule__XIndividualConstant__ValueAssignment_5_1 ) ) )
            // InternalXContext.g:2811:1: ( ( rule__XIndividualConstant__ValueAssignment_5_1 ) )
            {
            // InternalXContext.g:2811:1: ( ( rule__XIndividualConstant__ValueAssignment_5_1 ) )
            // InternalXContext.g:2812:2: ( rule__XIndividualConstant__ValueAssignment_5_1 )
            {
             before(grammarAccess.getXIndividualConstantAccess().getValueAssignment_5_1()); 
            // InternalXContext.g:2813:2: ( rule__XIndividualConstant__ValueAssignment_5_1 )
            // InternalXContext.g:2813:3: rule__XIndividualConstant__ValueAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualConstant__ValueAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getXIndividualConstantAccess().getValueAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__Group_5__1__Impl"


    // $ANTLR start "rule__XAxiom__Group__0"
    // InternalXContext.g:2822:1: rule__XAxiom__Group__0 : rule__XAxiom__Group__0__Impl rule__XAxiom__Group__1 ;
    public final void rule__XAxiom__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2826:1: ( rule__XAxiom__Group__0__Impl rule__XAxiom__Group__1 )
            // InternalXContext.g:2827:2: rule__XAxiom__Group__0__Impl rule__XAxiom__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__XAxiom__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XAxiom__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAxiom__Group__0"


    // $ANTLR start "rule__XAxiom__Group__0__Impl"
    // InternalXContext.g:2834:1: rule__XAxiom__Group__0__Impl : ( () ) ;
    public final void rule__XAxiom__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2838:1: ( ( () ) )
            // InternalXContext.g:2839:1: ( () )
            {
            // InternalXContext.g:2839:1: ( () )
            // InternalXContext.g:2840:2: ()
            {
             before(grammarAccess.getXAxiomAccess().getAxiomAction_0()); 
            // InternalXContext.g:2841:2: ()
            // InternalXContext.g:2841:3: 
            {
            }

             after(grammarAccess.getXAxiomAccess().getAxiomAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAxiom__Group__0__Impl"


    // $ANTLR start "rule__XAxiom__Group__1"
    // InternalXContext.g:2849:1: rule__XAxiom__Group__1 : rule__XAxiom__Group__1__Impl rule__XAxiom__Group__2 ;
    public final void rule__XAxiom__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2853:1: ( rule__XAxiom__Group__1__Impl rule__XAxiom__Group__2 )
            // InternalXContext.g:2854:2: rule__XAxiom__Group__1__Impl rule__XAxiom__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__XAxiom__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XAxiom__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAxiom__Group__1"


    // $ANTLR start "rule__XAxiom__Group__1__Impl"
    // InternalXContext.g:2861:1: rule__XAxiom__Group__1__Impl : ( ( rule__XAxiom__CommentAssignment_1 )? ) ;
    public final void rule__XAxiom__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2865:1: ( ( ( rule__XAxiom__CommentAssignment_1 )? ) )
            // InternalXContext.g:2866:1: ( ( rule__XAxiom__CommentAssignment_1 )? )
            {
            // InternalXContext.g:2866:1: ( ( rule__XAxiom__CommentAssignment_1 )? )
            // InternalXContext.g:2867:2: ( rule__XAxiom__CommentAssignment_1 )?
            {
             before(grammarAccess.getXAxiomAccess().getCommentAssignment_1()); 
            // InternalXContext.g:2868:2: ( rule__XAxiom__CommentAssignment_1 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_STRING) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalXContext.g:2868:3: rule__XAxiom__CommentAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XAxiom__CommentAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXAxiomAccess().getCommentAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAxiom__Group__1__Impl"


    // $ANTLR start "rule__XAxiom__Group__2"
    // InternalXContext.g:2876:1: rule__XAxiom__Group__2 : rule__XAxiom__Group__2__Impl rule__XAxiom__Group__3 ;
    public final void rule__XAxiom__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2880:1: ( rule__XAxiom__Group__2__Impl rule__XAxiom__Group__3 )
            // InternalXContext.g:2881:2: rule__XAxiom__Group__2__Impl rule__XAxiom__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__XAxiom__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XAxiom__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAxiom__Group__2"


    // $ANTLR start "rule__XAxiom__Group__2__Impl"
    // InternalXContext.g:2888:1: rule__XAxiom__Group__2__Impl : ( ( rule__XAxiom__NameAssignment_2 ) ) ;
    public final void rule__XAxiom__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2892:1: ( ( ( rule__XAxiom__NameAssignment_2 ) ) )
            // InternalXContext.g:2893:1: ( ( rule__XAxiom__NameAssignment_2 ) )
            {
            // InternalXContext.g:2893:1: ( ( rule__XAxiom__NameAssignment_2 ) )
            // InternalXContext.g:2894:2: ( rule__XAxiom__NameAssignment_2 )
            {
             before(grammarAccess.getXAxiomAccess().getNameAssignment_2()); 
            // InternalXContext.g:2895:2: ( rule__XAxiom__NameAssignment_2 )
            // InternalXContext.g:2895:3: rule__XAxiom__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XAxiom__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getXAxiomAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAxiom__Group__2__Impl"


    // $ANTLR start "rule__XAxiom__Group__3"
    // InternalXContext.g:2903:1: rule__XAxiom__Group__3 : rule__XAxiom__Group__3__Impl ;
    public final void rule__XAxiom__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2907:1: ( rule__XAxiom__Group__3__Impl )
            // InternalXContext.g:2908:2: rule__XAxiom__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XAxiom__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAxiom__Group__3"


    // $ANTLR start "rule__XAxiom__Group__3__Impl"
    // InternalXContext.g:2914:1: rule__XAxiom__Group__3__Impl : ( ( rule__XAxiom__PredicateAssignment_3 ) ) ;
    public final void rule__XAxiom__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2918:1: ( ( ( rule__XAxiom__PredicateAssignment_3 ) ) )
            // InternalXContext.g:2919:1: ( ( rule__XAxiom__PredicateAssignment_3 ) )
            {
            // InternalXContext.g:2919:1: ( ( rule__XAxiom__PredicateAssignment_3 ) )
            // InternalXContext.g:2920:2: ( rule__XAxiom__PredicateAssignment_3 )
            {
             before(grammarAccess.getXAxiomAccess().getPredicateAssignment_3()); 
            // InternalXContext.g:2921:2: ( rule__XAxiom__PredicateAssignment_3 )
            // InternalXContext.g:2921:3: rule__XAxiom__PredicateAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XAxiom__PredicateAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getXAxiomAccess().getPredicateAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAxiom__Group__3__Impl"


    // $ANTLR start "rule__XIndividualAxiom__Group__0"
    // InternalXContext.g:2930:1: rule__XIndividualAxiom__Group__0 : rule__XIndividualAxiom__Group__0__Impl rule__XIndividualAxiom__Group__1 ;
    public final void rule__XIndividualAxiom__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2934:1: ( rule__XIndividualAxiom__Group__0__Impl rule__XIndividualAxiom__Group__1 )
            // InternalXContext.g:2935:2: rule__XIndividualAxiom__Group__0__Impl rule__XIndividualAxiom__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__XIndividualAxiom__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualAxiom__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualAxiom__Group__0"


    // $ANTLR start "rule__XIndividualAxiom__Group__0__Impl"
    // InternalXContext.g:2942:1: rule__XIndividualAxiom__Group__0__Impl : ( () ) ;
    public final void rule__XIndividualAxiom__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2946:1: ( ( () ) )
            // InternalXContext.g:2947:1: ( () )
            {
            // InternalXContext.g:2947:1: ( () )
            // InternalXContext.g:2948:2: ()
            {
             before(grammarAccess.getXIndividualAxiomAccess().getAxiomAction_0()); 
            // InternalXContext.g:2949:2: ()
            // InternalXContext.g:2949:3: 
            {
            }

             after(grammarAccess.getXIndividualAxiomAccess().getAxiomAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualAxiom__Group__0__Impl"


    // $ANTLR start "rule__XIndividualAxiom__Group__1"
    // InternalXContext.g:2957:1: rule__XIndividualAxiom__Group__1 : rule__XIndividualAxiom__Group__1__Impl rule__XIndividualAxiom__Group__2 ;
    public final void rule__XIndividualAxiom__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2961:1: ( rule__XIndividualAxiom__Group__1__Impl rule__XIndividualAxiom__Group__2 )
            // InternalXContext.g:2962:2: rule__XIndividualAxiom__Group__1__Impl rule__XIndividualAxiom__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__XIndividualAxiom__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualAxiom__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualAxiom__Group__1"


    // $ANTLR start "rule__XIndividualAxiom__Group__1__Impl"
    // InternalXContext.g:2969:1: rule__XIndividualAxiom__Group__1__Impl : ( ( rule__XIndividualAxiom__CommentAssignment_1 )? ) ;
    public final void rule__XIndividualAxiom__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2973:1: ( ( ( rule__XIndividualAxiom__CommentAssignment_1 )? ) )
            // InternalXContext.g:2974:1: ( ( rule__XIndividualAxiom__CommentAssignment_1 )? )
            {
            // InternalXContext.g:2974:1: ( ( rule__XIndividualAxiom__CommentAssignment_1 )? )
            // InternalXContext.g:2975:2: ( rule__XIndividualAxiom__CommentAssignment_1 )?
            {
             before(grammarAccess.getXIndividualAxiomAccess().getCommentAssignment_1()); 
            // InternalXContext.g:2976:2: ( rule__XIndividualAxiom__CommentAssignment_1 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_STRING) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalXContext.g:2976:3: rule__XIndividualAxiom__CommentAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XIndividualAxiom__CommentAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXIndividualAxiomAccess().getCommentAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualAxiom__Group__1__Impl"


    // $ANTLR start "rule__XIndividualAxiom__Group__2"
    // InternalXContext.g:2984:1: rule__XIndividualAxiom__Group__2 : rule__XIndividualAxiom__Group__2__Impl rule__XIndividualAxiom__Group__3 ;
    public final void rule__XIndividualAxiom__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:2988:1: ( rule__XIndividualAxiom__Group__2__Impl rule__XIndividualAxiom__Group__3 )
            // InternalXContext.g:2989:2: rule__XIndividualAxiom__Group__2__Impl rule__XIndividualAxiom__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__XIndividualAxiom__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualAxiom__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualAxiom__Group__2"


    // $ANTLR start "rule__XIndividualAxiom__Group__2__Impl"
    // InternalXContext.g:2996:1: rule__XIndividualAxiom__Group__2__Impl : ( ( rule__XIndividualAxiom__Alternatives_2 ) ) ;
    public final void rule__XIndividualAxiom__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3000:1: ( ( ( rule__XIndividualAxiom__Alternatives_2 ) ) )
            // InternalXContext.g:3001:1: ( ( rule__XIndividualAxiom__Alternatives_2 ) )
            {
            // InternalXContext.g:3001:1: ( ( rule__XIndividualAxiom__Alternatives_2 ) )
            // InternalXContext.g:3002:2: ( rule__XIndividualAxiom__Alternatives_2 )
            {
             before(grammarAccess.getXIndividualAxiomAccess().getAlternatives_2()); 
            // InternalXContext.g:3003:2: ( rule__XIndividualAxiom__Alternatives_2 )
            // InternalXContext.g:3003:3: rule__XIndividualAxiom__Alternatives_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualAxiom__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getXIndividualAxiomAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualAxiom__Group__2__Impl"


    // $ANTLR start "rule__XIndividualAxiom__Group__3"
    // InternalXContext.g:3011:1: rule__XIndividualAxiom__Group__3 : rule__XIndividualAxiom__Group__3__Impl rule__XIndividualAxiom__Group__4 ;
    public final void rule__XIndividualAxiom__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3015:1: ( rule__XIndividualAxiom__Group__3__Impl rule__XIndividualAxiom__Group__4 )
            // InternalXContext.g:3016:2: rule__XIndividualAxiom__Group__3__Impl rule__XIndividualAxiom__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__XIndividualAxiom__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualAxiom__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualAxiom__Group__3"


    // $ANTLR start "rule__XIndividualAxiom__Group__3__Impl"
    // InternalXContext.g:3023:1: rule__XIndividualAxiom__Group__3__Impl : ( ( rule__XIndividualAxiom__NameAssignment_3 ) ) ;
    public final void rule__XIndividualAxiom__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3027:1: ( ( ( rule__XIndividualAxiom__NameAssignment_3 ) ) )
            // InternalXContext.g:3028:1: ( ( rule__XIndividualAxiom__NameAssignment_3 ) )
            {
            // InternalXContext.g:3028:1: ( ( rule__XIndividualAxiom__NameAssignment_3 ) )
            // InternalXContext.g:3029:2: ( rule__XIndividualAxiom__NameAssignment_3 )
            {
             before(grammarAccess.getXIndividualAxiomAccess().getNameAssignment_3()); 
            // InternalXContext.g:3030:2: ( rule__XIndividualAxiom__NameAssignment_3 )
            // InternalXContext.g:3030:3: rule__XIndividualAxiom__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualAxiom__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getXIndividualAxiomAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualAxiom__Group__3__Impl"


    // $ANTLR start "rule__XIndividualAxiom__Group__4"
    // InternalXContext.g:3038:1: rule__XIndividualAxiom__Group__4 : rule__XIndividualAxiom__Group__4__Impl ;
    public final void rule__XIndividualAxiom__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3042:1: ( rule__XIndividualAxiom__Group__4__Impl )
            // InternalXContext.g:3043:2: rule__XIndividualAxiom__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualAxiom__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualAxiom__Group__4"


    // $ANTLR start "rule__XIndividualAxiom__Group__4__Impl"
    // InternalXContext.g:3049:1: rule__XIndividualAxiom__Group__4__Impl : ( ( rule__XIndividualAxiom__PredicateAssignment_4 ) ) ;
    public final void rule__XIndividualAxiom__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3053:1: ( ( ( rule__XIndividualAxiom__PredicateAssignment_4 ) ) )
            // InternalXContext.g:3054:1: ( ( rule__XIndividualAxiom__PredicateAssignment_4 ) )
            {
            // InternalXContext.g:3054:1: ( ( rule__XIndividualAxiom__PredicateAssignment_4 ) )
            // InternalXContext.g:3055:2: ( rule__XIndividualAxiom__PredicateAssignment_4 )
            {
             before(grammarAccess.getXIndividualAxiomAccess().getPredicateAssignment_4()); 
            // InternalXContext.g:3056:2: ( rule__XIndividualAxiom__PredicateAssignment_4 )
            // InternalXContext.g:3056:3: rule__XIndividualAxiom__PredicateAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualAxiom__PredicateAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getXIndividualAxiomAccess().getPredicateAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualAxiom__Group__4__Impl"


    // $ANTLR start "rule__XIndividualTheorem__Group__0"
    // InternalXContext.g:3065:1: rule__XIndividualTheorem__Group__0 : rule__XIndividualTheorem__Group__0__Impl rule__XIndividualTheorem__Group__1 ;
    public final void rule__XIndividualTheorem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3069:1: ( rule__XIndividualTheorem__Group__0__Impl rule__XIndividualTheorem__Group__1 )
            // InternalXContext.g:3070:2: rule__XIndividualTheorem__Group__0__Impl rule__XIndividualTheorem__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__XIndividualTheorem__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualTheorem__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualTheorem__Group__0"


    // $ANTLR start "rule__XIndividualTheorem__Group__0__Impl"
    // InternalXContext.g:3077:1: rule__XIndividualTheorem__Group__0__Impl : ( () ) ;
    public final void rule__XIndividualTheorem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3081:1: ( ( () ) )
            // InternalXContext.g:3082:1: ( () )
            {
            // InternalXContext.g:3082:1: ( () )
            // InternalXContext.g:3083:2: ()
            {
             before(grammarAccess.getXIndividualTheoremAccess().getAxiomAction_0()); 
            // InternalXContext.g:3084:2: ()
            // InternalXContext.g:3084:3: 
            {
            }

             after(grammarAccess.getXIndividualTheoremAccess().getAxiomAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualTheorem__Group__0__Impl"


    // $ANTLR start "rule__XIndividualTheorem__Group__1"
    // InternalXContext.g:3092:1: rule__XIndividualTheorem__Group__1 : rule__XIndividualTheorem__Group__1__Impl rule__XIndividualTheorem__Group__2 ;
    public final void rule__XIndividualTheorem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3096:1: ( rule__XIndividualTheorem__Group__1__Impl rule__XIndividualTheorem__Group__2 )
            // InternalXContext.g:3097:2: rule__XIndividualTheorem__Group__1__Impl rule__XIndividualTheorem__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__XIndividualTheorem__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualTheorem__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualTheorem__Group__1"


    // $ANTLR start "rule__XIndividualTheorem__Group__1__Impl"
    // InternalXContext.g:3104:1: rule__XIndividualTheorem__Group__1__Impl : ( ( rule__XIndividualTheorem__CommentAssignment_1 )? ) ;
    public final void rule__XIndividualTheorem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3108:1: ( ( ( rule__XIndividualTheorem__CommentAssignment_1 )? ) )
            // InternalXContext.g:3109:1: ( ( rule__XIndividualTheorem__CommentAssignment_1 )? )
            {
            // InternalXContext.g:3109:1: ( ( rule__XIndividualTheorem__CommentAssignment_1 )? )
            // InternalXContext.g:3110:2: ( rule__XIndividualTheorem__CommentAssignment_1 )?
            {
             before(grammarAccess.getXIndividualTheoremAccess().getCommentAssignment_1()); 
            // InternalXContext.g:3111:2: ( rule__XIndividualTheorem__CommentAssignment_1 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_STRING) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalXContext.g:3111:3: rule__XIndividualTheorem__CommentAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XIndividualTheorem__CommentAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXIndividualTheoremAccess().getCommentAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualTheorem__Group__1__Impl"


    // $ANTLR start "rule__XIndividualTheorem__Group__2"
    // InternalXContext.g:3119:1: rule__XIndividualTheorem__Group__2 : rule__XIndividualTheorem__Group__2__Impl rule__XIndividualTheorem__Group__3 ;
    public final void rule__XIndividualTheorem__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3123:1: ( rule__XIndividualTheorem__Group__2__Impl rule__XIndividualTheorem__Group__3 )
            // InternalXContext.g:3124:2: rule__XIndividualTheorem__Group__2__Impl rule__XIndividualTheorem__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__XIndividualTheorem__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualTheorem__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualTheorem__Group__2"


    // $ANTLR start "rule__XIndividualTheorem__Group__2__Impl"
    // InternalXContext.g:3131:1: rule__XIndividualTheorem__Group__2__Impl : ( ( rule__XIndividualTheorem__TheoremAssignment_2 ) ) ;
    public final void rule__XIndividualTheorem__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3135:1: ( ( ( rule__XIndividualTheorem__TheoremAssignment_2 ) ) )
            // InternalXContext.g:3136:1: ( ( rule__XIndividualTheorem__TheoremAssignment_2 ) )
            {
            // InternalXContext.g:3136:1: ( ( rule__XIndividualTheorem__TheoremAssignment_2 ) )
            // InternalXContext.g:3137:2: ( rule__XIndividualTheorem__TheoremAssignment_2 )
            {
             before(grammarAccess.getXIndividualTheoremAccess().getTheoremAssignment_2()); 
            // InternalXContext.g:3138:2: ( rule__XIndividualTheorem__TheoremAssignment_2 )
            // InternalXContext.g:3138:3: rule__XIndividualTheorem__TheoremAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualTheorem__TheoremAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getXIndividualTheoremAccess().getTheoremAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualTheorem__Group__2__Impl"


    // $ANTLR start "rule__XIndividualTheorem__Group__3"
    // InternalXContext.g:3146:1: rule__XIndividualTheorem__Group__3 : rule__XIndividualTheorem__Group__3__Impl rule__XIndividualTheorem__Group__4 ;
    public final void rule__XIndividualTheorem__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3150:1: ( rule__XIndividualTheorem__Group__3__Impl rule__XIndividualTheorem__Group__4 )
            // InternalXContext.g:3151:2: rule__XIndividualTheorem__Group__3__Impl rule__XIndividualTheorem__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__XIndividualTheorem__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualTheorem__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualTheorem__Group__3"


    // $ANTLR start "rule__XIndividualTheorem__Group__3__Impl"
    // InternalXContext.g:3158:1: rule__XIndividualTheorem__Group__3__Impl : ( ( rule__XIndividualTheorem__NameAssignment_3 ) ) ;
    public final void rule__XIndividualTheorem__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3162:1: ( ( ( rule__XIndividualTheorem__NameAssignment_3 ) ) )
            // InternalXContext.g:3163:1: ( ( rule__XIndividualTheorem__NameAssignment_3 ) )
            {
            // InternalXContext.g:3163:1: ( ( rule__XIndividualTheorem__NameAssignment_3 ) )
            // InternalXContext.g:3164:2: ( rule__XIndividualTheorem__NameAssignment_3 )
            {
             before(grammarAccess.getXIndividualTheoremAccess().getNameAssignment_3()); 
            // InternalXContext.g:3165:2: ( rule__XIndividualTheorem__NameAssignment_3 )
            // InternalXContext.g:3165:3: rule__XIndividualTheorem__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualTheorem__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getXIndividualTheoremAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualTheorem__Group__3__Impl"


    // $ANTLR start "rule__XIndividualTheorem__Group__4"
    // InternalXContext.g:3173:1: rule__XIndividualTheorem__Group__4 : rule__XIndividualTheorem__Group__4__Impl ;
    public final void rule__XIndividualTheorem__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3177:1: ( rule__XIndividualTheorem__Group__4__Impl )
            // InternalXContext.g:3178:2: rule__XIndividualTheorem__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualTheorem__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualTheorem__Group__4"


    // $ANTLR start "rule__XIndividualTheorem__Group__4__Impl"
    // InternalXContext.g:3184:1: rule__XIndividualTheorem__Group__4__Impl : ( ( rule__XIndividualTheorem__PredicateAssignment_4 ) ) ;
    public final void rule__XIndividualTheorem__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3188:1: ( ( ( rule__XIndividualTheorem__PredicateAssignment_4 ) ) )
            // InternalXContext.g:3189:1: ( ( rule__XIndividualTheorem__PredicateAssignment_4 ) )
            {
            // InternalXContext.g:3189:1: ( ( rule__XIndividualTheorem__PredicateAssignment_4 ) )
            // InternalXContext.g:3190:2: ( rule__XIndividualTheorem__PredicateAssignment_4 )
            {
             before(grammarAccess.getXIndividualTheoremAccess().getPredicateAssignment_4()); 
            // InternalXContext.g:3191:2: ( rule__XIndividualTheorem__PredicateAssignment_4 )
            // InternalXContext.g:3191:3: rule__XIndividualTheorem__PredicateAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualTheorem__PredicateAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getXIndividualTheoremAccess().getPredicateAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualTheorem__Group__4__Impl"


    // $ANTLR start "rule__XType__Group__0"
    // InternalXContext.g:3200:1: rule__XType__Group__0 : rule__XType__Group__0__Impl rule__XType__Group__1 ;
    public final void rule__XType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3204:1: ( rule__XType__Group__0__Impl rule__XType__Group__1 )
            // InternalXContext.g:3205:2: rule__XType__Group__0__Impl rule__XType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__XType__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XType__Group__1();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3212:1: rule__XType__Group__0__Impl : ( ruleXTypePrimitive ) ;
    public final void rule__XType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3216:1: ( ( ruleXTypePrimitive ) )
            // InternalXContext.g:3217:1: ( ruleXTypePrimitive )
            {
            // InternalXContext.g:3217:1: ( ruleXTypePrimitive )
            // InternalXContext.g:3218:2: ruleXTypePrimitive
            {
             before(grammarAccess.getXTypeAccess().getXTypePrimitiveParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXTypePrimitive();

            state._fsp--;

             after(grammarAccess.getXTypeAccess().getXTypePrimitiveParserRuleCall_0()); 

            }


            }

        }
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
    // InternalXContext.g:3227:1: rule__XType__Group__1 : rule__XType__Group__1__Impl ;
    public final void rule__XType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3231:1: ( rule__XType__Group__1__Impl )
            // InternalXContext.g:3232:2: rule__XType__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XType__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3238:1: rule__XType__Group__1__Impl : ( ( rule__XType__Group_1__0 )* ) ;
    public final void rule__XType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3242:1: ( ( ( rule__XType__Group_1__0 )* ) )
            // InternalXContext.g:3243:1: ( ( rule__XType__Group_1__0 )* )
            {
            // InternalXContext.g:3243:1: ( ( rule__XType__Group_1__0 )* )
            // InternalXContext.g:3244:2: ( rule__XType__Group_1__0 )*
            {
             before(grammarAccess.getXTypeAccess().getGroup_1()); 
            // InternalXContext.g:3245:2: ( rule__XType__Group_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=21 && LA35_0<=32)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalXContext.g:3245:3: rule__XType__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_24);
            	    rule__XType__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getXTypeAccess().getGroup_1()); 

            }


            }

        }
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
    // InternalXContext.g:3254:1: rule__XType__Group_1__0 : rule__XType__Group_1__0__Impl rule__XType__Group_1__1 ;
    public final void rule__XType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3258:1: ( rule__XType__Group_1__0__Impl rule__XType__Group_1__1 )
            // InternalXContext.g:3259:2: rule__XType__Group_1__0__Impl rule__XType__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__XType__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XType__Group_1__1();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3266:1: rule__XType__Group_1__0__Impl : ( ruleXTYPEOPERATOR ) ;
    public final void rule__XType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3270:1: ( ( ruleXTYPEOPERATOR ) )
            // InternalXContext.g:3271:1: ( ruleXTYPEOPERATOR )
            {
            // InternalXContext.g:3271:1: ( ruleXTYPEOPERATOR )
            // InternalXContext.g:3272:2: ruleXTYPEOPERATOR
            {
             before(grammarAccess.getXTypeAccess().getXTYPEOPERATORParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXTYPEOPERATOR();

            state._fsp--;

             after(grammarAccess.getXTypeAccess().getXTYPEOPERATORParserRuleCall_1_0()); 

            }


            }

        }
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
    // InternalXContext.g:3281:1: rule__XType__Group_1__1 : rule__XType__Group_1__1__Impl ;
    public final void rule__XType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3285:1: ( rule__XType__Group_1__1__Impl )
            // InternalXContext.g:3286:2: rule__XType__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XType__Group_1__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3292:1: rule__XType__Group_1__1__Impl : ( ruleXTypePrimitive ) ;
    public final void rule__XType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3296:1: ( ( ruleXTypePrimitive ) )
            // InternalXContext.g:3297:1: ( ruleXTypePrimitive )
            {
            // InternalXContext.g:3297:1: ( ruleXTypePrimitive )
            // InternalXContext.g:3298:2: ruleXTypePrimitive
            {
             before(grammarAccess.getXTypeAccess().getXTypePrimitiveParserRuleCall_1_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXTypePrimitive();

            state._fsp--;

             after(grammarAccess.getXTypeAccess().getXTypePrimitiveParserRuleCall_1_1()); 

            }


            }

        }
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
    // InternalXContext.g:3308:1: rule__XTypePrimitive__Group_5__0 : rule__XTypePrimitive__Group_5__0__Impl rule__XTypePrimitive__Group_5__1 ;
    public final void rule__XTypePrimitive__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3312:1: ( rule__XTypePrimitive__Group_5__0__Impl rule__XTypePrimitive__Group_5__1 )
            // InternalXContext.g:3313:2: rule__XTypePrimitive__Group_5__0__Impl rule__XTypePrimitive__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__XTypePrimitive__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XTypePrimitive__Group_5__1();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3320:1: rule__XTypePrimitive__Group_5__0__Impl : ( '(' ) ;
    public final void rule__XTypePrimitive__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3324:1: ( ( '(' ) )
            // InternalXContext.g:3325:1: ( '(' )
            {
            // InternalXContext.g:3325:1: ( '(' )
            // InternalXContext.g:3326:2: '('
            {
             before(grammarAccess.getXTypePrimitiveAccess().getLeftParenthesisKeyword_5_0()); 
            match(input,56,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXTypePrimitiveAccess().getLeftParenthesisKeyword_5_0()); 

            }


            }

        }
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
    // InternalXContext.g:3335:1: rule__XTypePrimitive__Group_5__1 : rule__XTypePrimitive__Group_5__1__Impl rule__XTypePrimitive__Group_5__2 ;
    public final void rule__XTypePrimitive__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3339:1: ( rule__XTypePrimitive__Group_5__1__Impl rule__XTypePrimitive__Group_5__2 )
            // InternalXContext.g:3340:2: rule__XTypePrimitive__Group_5__1__Impl rule__XTypePrimitive__Group_5__2
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__XTypePrimitive__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XTypePrimitive__Group_5__2();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3347:1: rule__XTypePrimitive__Group_5__1__Impl : ( ruleXType ) ;
    public final void rule__XTypePrimitive__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3351:1: ( ( ruleXType ) )
            // InternalXContext.g:3352:1: ( ruleXType )
            {
            // InternalXContext.g:3352:1: ( ruleXType )
            // InternalXContext.g:3353:2: ruleXType
            {
             before(grammarAccess.getXTypePrimitiveAccess().getXTypeParserRuleCall_5_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXType();

            state._fsp--;

             after(grammarAccess.getXTypePrimitiveAccess().getXTypeParserRuleCall_5_1()); 

            }


            }

        }
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
    // InternalXContext.g:3362:1: rule__XTypePrimitive__Group_5__2 : rule__XTypePrimitive__Group_5__2__Impl ;
    public final void rule__XTypePrimitive__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3366:1: ( rule__XTypePrimitive__Group_5__2__Impl )
            // InternalXContext.g:3367:2: rule__XTypePrimitive__Group_5__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XTypePrimitive__Group_5__2__Impl();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3373:1: rule__XTypePrimitive__Group_5__2__Impl : ( ')' ) ;
    public final void rule__XTypePrimitive__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3377:1: ( ( ')' ) )
            // InternalXContext.g:3378:1: ( ')' )
            {
            // InternalXContext.g:3378:1: ( ')' )
            // InternalXContext.g:3379:2: ')'
            {
             before(grammarAccess.getXTypePrimitiveAccess().getRightParenthesisKeyword_5_2()); 
            match(input,57,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXTypePrimitiveAccess().getRightParenthesisKeyword_5_2()); 

            }


            }

        }
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
    // InternalXContext.g:3389:1: rule__XTypePrimitive__Group_6__0 : rule__XTypePrimitive__Group_6__0__Impl rule__XTypePrimitive__Group_6__1 ;
    public final void rule__XTypePrimitive__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3393:1: ( rule__XTypePrimitive__Group_6__0__Impl rule__XTypePrimitive__Group_6__1 )
            // InternalXContext.g:3394:2: rule__XTypePrimitive__Group_6__0__Impl rule__XTypePrimitive__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_26);
            rule__XTypePrimitive__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XTypePrimitive__Group_6__1();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3401:1: rule__XTypePrimitive__Group_6__0__Impl : ( '\\u2119' ) ;
    public final void rule__XTypePrimitive__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3405:1: ( ( '\\u2119' ) )
            // InternalXContext.g:3406:1: ( '\\u2119' )
            {
            // InternalXContext.g:3406:1: ( '\\u2119' )
            // InternalXContext.g:3407:2: '\\u2119'
            {
             before(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalPKeyword_6_0()); 
            match(input,55,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalPKeyword_6_0()); 

            }


            }

        }
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
    // InternalXContext.g:3416:1: rule__XTypePrimitive__Group_6__1 : rule__XTypePrimitive__Group_6__1__Impl rule__XTypePrimitive__Group_6__2 ;
    public final void rule__XTypePrimitive__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3420:1: ( rule__XTypePrimitive__Group_6__1__Impl rule__XTypePrimitive__Group_6__2 )
            // InternalXContext.g:3421:2: rule__XTypePrimitive__Group_6__1__Impl rule__XTypePrimitive__Group_6__2
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__XTypePrimitive__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XTypePrimitive__Group_6__2();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3428:1: rule__XTypePrimitive__Group_6__1__Impl : ( '(' ) ;
    public final void rule__XTypePrimitive__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3432:1: ( ( '(' ) )
            // InternalXContext.g:3433:1: ( '(' )
            {
            // InternalXContext.g:3433:1: ( '(' )
            // InternalXContext.g:3434:2: '('
            {
             before(grammarAccess.getXTypePrimitiveAccess().getLeftParenthesisKeyword_6_1()); 
            match(input,56,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXTypePrimitiveAccess().getLeftParenthesisKeyword_6_1()); 

            }


            }

        }
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
    // InternalXContext.g:3443:1: rule__XTypePrimitive__Group_6__2 : rule__XTypePrimitive__Group_6__2__Impl rule__XTypePrimitive__Group_6__3 ;
    public final void rule__XTypePrimitive__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3447:1: ( rule__XTypePrimitive__Group_6__2__Impl rule__XTypePrimitive__Group_6__3 )
            // InternalXContext.g:3448:2: rule__XTypePrimitive__Group_6__2__Impl rule__XTypePrimitive__Group_6__3
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__XTypePrimitive__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XTypePrimitive__Group_6__3();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3455:1: rule__XTypePrimitive__Group_6__2__Impl : ( ruleXType ) ;
    public final void rule__XTypePrimitive__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3459:1: ( ( ruleXType ) )
            // InternalXContext.g:3460:1: ( ruleXType )
            {
            // InternalXContext.g:3460:1: ( ruleXType )
            // InternalXContext.g:3461:2: ruleXType
            {
             before(grammarAccess.getXTypePrimitiveAccess().getXTypeParserRuleCall_6_2()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXType();

            state._fsp--;

             after(grammarAccess.getXTypePrimitiveAccess().getXTypeParserRuleCall_6_2()); 

            }


            }

        }
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
    // InternalXContext.g:3470:1: rule__XTypePrimitive__Group_6__3 : rule__XTypePrimitive__Group_6__3__Impl ;
    public final void rule__XTypePrimitive__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3474:1: ( rule__XTypePrimitive__Group_6__3__Impl )
            // InternalXContext.g:3475:2: rule__XTypePrimitive__Group_6__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XTypePrimitive__Group_6__3__Impl();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3481:1: rule__XTypePrimitive__Group_6__3__Impl : ( ')' ) ;
    public final void rule__XTypePrimitive__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3485:1: ( ( ')' ) )
            // InternalXContext.g:3486:1: ( ')' )
            {
            // InternalXContext.g:3486:1: ( ')' )
            // InternalXContext.g:3487:2: ')'
            {
             before(grammarAccess.getXTypePrimitiveAccess().getRightParenthesisKeyword_6_3()); 
            match(input,57,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXTypePrimitiveAccess().getRightParenthesisKeyword_6_3()); 

            }


            }

        }
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
    // InternalXContext.g:3497:1: rule__XTypePrimitive__Group_7__0 : rule__XTypePrimitive__Group_7__0__Impl rule__XTypePrimitive__Group_7__1 ;
    public final void rule__XTypePrimitive__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3501:1: ( rule__XTypePrimitive__Group_7__0__Impl rule__XTypePrimitive__Group_7__1 )
            // InternalXContext.g:3502:2: rule__XTypePrimitive__Group_7__0__Impl rule__XTypePrimitive__Group_7__1
            {
            pushFollow(FollowSets000.FOLLOW_26);
            rule__XTypePrimitive__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XTypePrimitive__Group_7__1();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3509:1: rule__XTypePrimitive__Group_7__0__Impl : ( '\\u21191' ) ;
    public final void rule__XTypePrimitive__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3513:1: ( ( '\\u21191' ) )
            // InternalXContext.g:3514:1: ( '\\u21191' )
            {
            // InternalXContext.g:3514:1: ( '\\u21191' )
            // InternalXContext.g:3515:2: '\\u21191'
            {
             before(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalPDigitOneKeyword_7_0()); 
            match(input,54,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalPDigitOneKeyword_7_0()); 

            }


            }

        }
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
    // InternalXContext.g:3524:1: rule__XTypePrimitive__Group_7__1 : rule__XTypePrimitive__Group_7__1__Impl rule__XTypePrimitive__Group_7__2 ;
    public final void rule__XTypePrimitive__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3528:1: ( rule__XTypePrimitive__Group_7__1__Impl rule__XTypePrimitive__Group_7__2 )
            // InternalXContext.g:3529:2: rule__XTypePrimitive__Group_7__1__Impl rule__XTypePrimitive__Group_7__2
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__XTypePrimitive__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XTypePrimitive__Group_7__2();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3536:1: rule__XTypePrimitive__Group_7__1__Impl : ( '(' ) ;
    public final void rule__XTypePrimitive__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3540:1: ( ( '(' ) )
            // InternalXContext.g:3541:1: ( '(' )
            {
            // InternalXContext.g:3541:1: ( '(' )
            // InternalXContext.g:3542:2: '('
            {
             before(grammarAccess.getXTypePrimitiveAccess().getLeftParenthesisKeyword_7_1()); 
            match(input,56,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXTypePrimitiveAccess().getLeftParenthesisKeyword_7_1()); 

            }


            }

        }
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
    // InternalXContext.g:3551:1: rule__XTypePrimitive__Group_7__2 : rule__XTypePrimitive__Group_7__2__Impl rule__XTypePrimitive__Group_7__3 ;
    public final void rule__XTypePrimitive__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3555:1: ( rule__XTypePrimitive__Group_7__2__Impl rule__XTypePrimitive__Group_7__3 )
            // InternalXContext.g:3556:2: rule__XTypePrimitive__Group_7__2__Impl rule__XTypePrimitive__Group_7__3
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__XTypePrimitive__Group_7__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XTypePrimitive__Group_7__3();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3563:1: rule__XTypePrimitive__Group_7__2__Impl : ( ruleXType ) ;
    public final void rule__XTypePrimitive__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3567:1: ( ( ruleXType ) )
            // InternalXContext.g:3568:1: ( ruleXType )
            {
            // InternalXContext.g:3568:1: ( ruleXType )
            // InternalXContext.g:3569:2: ruleXType
            {
             before(grammarAccess.getXTypePrimitiveAccess().getXTypeParserRuleCall_7_2()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXType();

            state._fsp--;

             after(grammarAccess.getXTypePrimitiveAccess().getXTypeParserRuleCall_7_2()); 

            }


            }

        }
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
    // InternalXContext.g:3578:1: rule__XTypePrimitive__Group_7__3 : rule__XTypePrimitive__Group_7__3__Impl ;
    public final void rule__XTypePrimitive__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3582:1: ( rule__XTypePrimitive__Group_7__3__Impl )
            // InternalXContext.g:3583:2: rule__XTypePrimitive__Group_7__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XTypePrimitive__Group_7__3__Impl();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3589:1: rule__XTypePrimitive__Group_7__3__Impl : ( ')' ) ;
    public final void rule__XTypePrimitive__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3593:1: ( ( ')' ) )
            // InternalXContext.g:3594:1: ( ')' )
            {
            // InternalXContext.g:3594:1: ( ')' )
            // InternalXContext.g:3595:2: ')'
            {
             before(grammarAccess.getXTypePrimitiveAccess().getRightParenthesisKeyword_7_3()); 
            match(input,57,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXTypePrimitiveAccess().getRightParenthesisKeyword_7_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0"
    // InternalXContext.g:3605:1: rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0 : rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0__Impl rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1 ;
    public final void rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3609:1: ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0__Impl rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1 )
            // InternalXContext.g:3610:2: rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0__Impl rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0"


    // $ANTLR start "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0__Impl"
    // InternalXContext.g:3617:1: rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0__Impl : ( '%' ) ;
    public final void rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3621:1: ( ( '%' ) )
            // InternalXContext.g:3622:1: ( '%' )
            {
            // InternalXContext.g:3622:1: ( '%' )
            // InternalXContext.g:3623:2: '%'
            {
             before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPercentSignKeyword_32_0()); 
            match(input,130,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPercentSignKeyword_32_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__0__Impl"


    // $ANTLR start "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1"
    // InternalXContext.g:3632:1: rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1 : rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1__Impl ;
    public final void rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3636:1: ( rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1__Impl )
            // InternalXContext.g:3637:2: rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1"


    // $ANTLR start "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1__Impl"
    // InternalXContext.g:3643:1: rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1__Impl : ( '\\u22C2' ) ;
    public final void rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3647:1: ( ( '\\u22C2' ) )
            // InternalXContext.g:3648:1: ( '\\u22C2' )
            {
            // InternalXContext.g:3648:1: ( '\\u22C2' )
            // InternalXContext.g:3649:2: '\\u22C2'
            {
             before(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryIntersectionKeyword_32_1()); 
            match(input,131,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryIntersectionKeyword_32_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EVENTB_EXPRESSION_SYMBOLS__Group_32__1__Impl"


    // $ANTLR start "rule__XRecord__Group__0"
    // InternalXContext.g:3659:1: rule__XRecord__Group__0 : rule__XRecord__Group__0__Impl rule__XRecord__Group__1 ;
    public final void rule__XRecord__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3663:1: ( rule__XRecord__Group__0__Impl rule__XRecord__Group__1 )
            // InternalXContext.g:3664:2: rule__XRecord__Group__0__Impl rule__XRecord__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_28);
            rule__XRecord__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__Group__1();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3671:1: rule__XRecord__Group__0__Impl : ( () ) ;
    public final void rule__XRecord__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3675:1: ( ( () ) )
            // InternalXContext.g:3676:1: ( () )
            {
            // InternalXContext.g:3676:1: ( () )
            // InternalXContext.g:3677:2: ()
            {
             before(grammarAccess.getXRecordAccess().getRecordAction_0()); 
            // InternalXContext.g:3678:2: ()
            // InternalXContext.g:3678:3: 
            {
            }

             after(grammarAccess.getXRecordAccess().getRecordAction_0()); 

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
    // InternalXContext.g:3686:1: rule__XRecord__Group__1 : rule__XRecord__Group__1__Impl rule__XRecord__Group__2 ;
    public final void rule__XRecord__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3690:1: ( rule__XRecord__Group__1__Impl rule__XRecord__Group__2 )
            // InternalXContext.g:3691:2: rule__XRecord__Group__1__Impl rule__XRecord__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_28);
            rule__XRecord__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__Group__2();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3698:1: rule__XRecord__Group__1__Impl : ( ( rule__XRecord__ExtendedAssignment_1 )? ) ;
    public final void rule__XRecord__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3702:1: ( ( ( rule__XRecord__ExtendedAssignment_1 )? ) )
            // InternalXContext.g:3703:1: ( ( rule__XRecord__ExtendedAssignment_1 )? )
            {
            // InternalXContext.g:3703:1: ( ( rule__XRecord__ExtendedAssignment_1 )? )
            // InternalXContext.g:3704:2: ( rule__XRecord__ExtendedAssignment_1 )?
            {
             before(grammarAccess.getXRecordAccess().getExtendedAssignment_1()); 
            // InternalXContext.g:3705:2: ( rule__XRecord__ExtendedAssignment_1 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==136) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalXContext.g:3705:3: rule__XRecord__ExtendedAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XRecord__ExtendedAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXRecordAccess().getExtendedAssignment_1()); 

            }


            }

        }
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
    // InternalXContext.g:3713:1: rule__XRecord__Group__2 : rule__XRecord__Group__2__Impl rule__XRecord__Group__3 ;
    public final void rule__XRecord__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3717:1: ( rule__XRecord__Group__2__Impl rule__XRecord__Group__3 )
            // InternalXContext.g:3718:2: rule__XRecord__Group__2__Impl rule__XRecord__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__XRecord__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__Group__3();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3725:1: rule__XRecord__Group__2__Impl : ( 'record' ) ;
    public final void rule__XRecord__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3729:1: ( ( 'record' ) )
            // InternalXContext.g:3730:1: ( 'record' )
            {
            // InternalXContext.g:3730:1: ( 'record' )
            // InternalXContext.g:3731:2: 'record'
            {
             before(grammarAccess.getXRecordAccess().getRecordKeyword_2()); 
            match(input,132,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXRecordAccess().getRecordKeyword_2()); 

            }


            }

        }
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
    // InternalXContext.g:3740:1: rule__XRecord__Group__3 : rule__XRecord__Group__3__Impl rule__XRecord__Group__4 ;
    public final void rule__XRecord__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3744:1: ( rule__XRecord__Group__3__Impl rule__XRecord__Group__4 )
            // InternalXContext.g:3745:2: rule__XRecord__Group__3__Impl rule__XRecord__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__XRecord__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__Group__4();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3752:1: rule__XRecord__Group__3__Impl : ( ( rule__XRecord__NameAssignment_3 ) ) ;
    public final void rule__XRecord__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3756:1: ( ( ( rule__XRecord__NameAssignment_3 ) ) )
            // InternalXContext.g:3757:1: ( ( rule__XRecord__NameAssignment_3 ) )
            {
            // InternalXContext.g:3757:1: ( ( rule__XRecord__NameAssignment_3 ) )
            // InternalXContext.g:3758:2: ( rule__XRecord__NameAssignment_3 )
            {
             before(grammarAccess.getXRecordAccess().getNameAssignment_3()); 
            // InternalXContext.g:3759:2: ( rule__XRecord__NameAssignment_3 )
            // InternalXContext.g:3759:3: rule__XRecord__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getXRecordAccess().getNameAssignment_3()); 

            }


            }

        }
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
    // InternalXContext.g:3767:1: rule__XRecord__Group__4 : rule__XRecord__Group__4__Impl rule__XRecord__Group__5 ;
    public final void rule__XRecord__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3771:1: ( rule__XRecord__Group__4__Impl rule__XRecord__Group__5 )
            // InternalXContext.g:3772:2: rule__XRecord__Group__4__Impl rule__XRecord__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__XRecord__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__Group__5();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3779:1: rule__XRecord__Group__4__Impl : ( ( rule__XRecord__Group_4__0 )? ) ;
    public final void rule__XRecord__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3783:1: ( ( ( rule__XRecord__Group_4__0 )? ) )
            // InternalXContext.g:3784:1: ( ( rule__XRecord__Group_4__0 )? )
            {
            // InternalXContext.g:3784:1: ( ( rule__XRecord__Group_4__0 )? )
            // InternalXContext.g:3785:2: ( rule__XRecord__Group_4__0 )?
            {
             before(grammarAccess.getXRecordAccess().getGroup_4()); 
            // InternalXContext.g:3786:2: ( rule__XRecord__Group_4__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==133) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalXContext.g:3786:3: rule__XRecord__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XRecord__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXRecordAccess().getGroup_4()); 

            }


            }

        }
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
    // InternalXContext.g:3794:1: rule__XRecord__Group__5 : rule__XRecord__Group__5__Impl rule__XRecord__Group__6 ;
    public final void rule__XRecord__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3798:1: ( rule__XRecord__Group__5__Impl rule__XRecord__Group__6 )
            // InternalXContext.g:3799:2: rule__XRecord__Group__5__Impl rule__XRecord__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__XRecord__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__Group__6();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3806:1: rule__XRecord__Group__5__Impl : ( ( rule__XRecord__Alternatives_5 )* ) ;
    public final void rule__XRecord__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3810:1: ( ( ( rule__XRecord__Alternatives_5 )* ) )
            // InternalXContext.g:3811:1: ( ( rule__XRecord__Alternatives_5 )* )
            {
            // InternalXContext.g:3811:1: ( ( rule__XRecord__Alternatives_5 )* )
            // InternalXContext.g:3812:2: ( rule__XRecord__Alternatives_5 )*
            {
             before(grammarAccess.getXRecordAccess().getAlternatives_5()); 
            // InternalXContext.g:3813:2: ( rule__XRecord__Alternatives_5 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=134 && LA38_0<=135)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalXContext.g:3813:3: rule__XRecord__Alternatives_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_30);
            	    rule__XRecord__Alternatives_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getXRecordAccess().getAlternatives_5()); 

            }


            }

        }
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
    // InternalXContext.g:3821:1: rule__XRecord__Group__6 : rule__XRecord__Group__6__Impl ;
    public final void rule__XRecord__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3825:1: ( rule__XRecord__Group__6__Impl )
            // InternalXContext.g:3826:2: rule__XRecord__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__Group__6__Impl();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:3832:1: rule__XRecord__Group__6__Impl : ( 'end' ) ;
    public final void rule__XRecord__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3836:1: ( ( 'end' ) )
            // InternalXContext.g:3837:1: ( 'end' )
            {
            // InternalXContext.g:3837:1: ( 'end' )
            // InternalXContext.g:3838:2: 'end'
            {
             before(grammarAccess.getXRecordAccess().getEndKeyword_6()); 
            match(input,123,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXRecordAccess().getEndKeyword_6()); 

            }


            }

        }
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


    // $ANTLR start "rule__XRecord__Group_4__0"
    // InternalXContext.g:3848:1: rule__XRecord__Group_4__0 : rule__XRecord__Group_4__0__Impl rule__XRecord__Group_4__1 ;
    public final void rule__XRecord__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3852:1: ( rule__XRecord__Group_4__0__Impl rule__XRecord__Group_4__1 )
            // InternalXContext.g:3853:2: rule__XRecord__Group_4__0__Impl rule__XRecord__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__XRecord__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_4__0"


    // $ANTLR start "rule__XRecord__Group_4__0__Impl"
    // InternalXContext.g:3860:1: rule__XRecord__Group_4__0__Impl : ( 'inherits' ) ;
    public final void rule__XRecord__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3864:1: ( ( 'inherits' ) )
            // InternalXContext.g:3865:1: ( 'inherits' )
            {
            // InternalXContext.g:3865:1: ( 'inherits' )
            // InternalXContext.g:3866:2: 'inherits'
            {
             before(grammarAccess.getXRecordAccess().getInheritsKeyword_4_0()); 
            match(input,133,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXRecordAccess().getInheritsKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_4__0__Impl"


    // $ANTLR start "rule__XRecord__Group_4__1"
    // InternalXContext.g:3875:1: rule__XRecord__Group_4__1 : rule__XRecord__Group_4__1__Impl ;
    public final void rule__XRecord__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3879:1: ( rule__XRecord__Group_4__1__Impl )
            // InternalXContext.g:3880:2: rule__XRecord__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_4__1"


    // $ANTLR start "rule__XRecord__Group_4__1__Impl"
    // InternalXContext.g:3886:1: rule__XRecord__Group_4__1__Impl : ( ( rule__XRecord__InheritsNamesAssignment_4_1 ) ) ;
    public final void rule__XRecord__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3890:1: ( ( ( rule__XRecord__InheritsNamesAssignment_4_1 ) ) )
            // InternalXContext.g:3891:1: ( ( rule__XRecord__InheritsNamesAssignment_4_1 ) )
            {
            // InternalXContext.g:3891:1: ( ( rule__XRecord__InheritsNamesAssignment_4_1 ) )
            // InternalXContext.g:3892:2: ( rule__XRecord__InheritsNamesAssignment_4_1 )
            {
             before(grammarAccess.getXRecordAccess().getInheritsNamesAssignment_4_1()); 
            // InternalXContext.g:3893:2: ( rule__XRecord__InheritsNamesAssignment_4_1 )
            // InternalXContext.g:3893:3: rule__XRecord__InheritsNamesAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__InheritsNamesAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getXRecordAccess().getInheritsNamesAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_4__1__Impl"


    // $ANTLR start "rule__XRecord__Group_5_0__0"
    // InternalXContext.g:3902:1: rule__XRecord__Group_5_0__0 : rule__XRecord__Group_5_0__0__Impl rule__XRecord__Group_5_0__1 ;
    public final void rule__XRecord__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3906:1: ( rule__XRecord__Group_5_0__0__Impl rule__XRecord__Group_5_0__1 )
            // InternalXContext.g:3907:2: rule__XRecord__Group_5_0__0__Impl rule__XRecord__Group_5_0__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__XRecord__Group_5_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__Group_5_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_5_0__0"


    // $ANTLR start "rule__XRecord__Group_5_0__0__Impl"
    // InternalXContext.g:3914:1: rule__XRecord__Group_5_0__0__Impl : ( 'field' ) ;
    public final void rule__XRecord__Group_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3918:1: ( ( 'field' ) )
            // InternalXContext.g:3919:1: ( 'field' )
            {
            // InternalXContext.g:3919:1: ( 'field' )
            // InternalXContext.g:3920:2: 'field'
            {
             before(grammarAccess.getXRecordAccess().getFieldKeyword_5_0_0()); 
            match(input,134,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXRecordAccess().getFieldKeyword_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_5_0__0__Impl"


    // $ANTLR start "rule__XRecord__Group_5_0__1"
    // InternalXContext.g:3929:1: rule__XRecord__Group_5_0__1 : rule__XRecord__Group_5_0__1__Impl ;
    public final void rule__XRecord__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3933:1: ( rule__XRecord__Group_5_0__1__Impl )
            // InternalXContext.g:3934:2: rule__XRecord__Group_5_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__Group_5_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_5_0__1"


    // $ANTLR start "rule__XRecord__Group_5_0__1__Impl"
    // InternalXContext.g:3940:1: rule__XRecord__Group_5_0__1__Impl : ( ( rule__XRecord__FieldsAssignment_5_0_1 ) ) ;
    public final void rule__XRecord__Group_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3944:1: ( ( ( rule__XRecord__FieldsAssignment_5_0_1 ) ) )
            // InternalXContext.g:3945:1: ( ( rule__XRecord__FieldsAssignment_5_0_1 ) )
            {
            // InternalXContext.g:3945:1: ( ( rule__XRecord__FieldsAssignment_5_0_1 ) )
            // InternalXContext.g:3946:2: ( rule__XRecord__FieldsAssignment_5_0_1 )
            {
             before(grammarAccess.getXRecordAccess().getFieldsAssignment_5_0_1()); 
            // InternalXContext.g:3947:2: ( rule__XRecord__FieldsAssignment_5_0_1 )
            // InternalXContext.g:3947:3: rule__XRecord__FieldsAssignment_5_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__FieldsAssignment_5_0_1();

            state._fsp--;


            }

             after(grammarAccess.getXRecordAccess().getFieldsAssignment_5_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_5_0__1__Impl"


    // $ANTLR start "rule__XRecord__Group_5_1__0"
    // InternalXContext.g:3956:1: rule__XRecord__Group_5_1__0 : rule__XRecord__Group_5_1__0__Impl rule__XRecord__Group_5_1__1 ;
    public final void rule__XRecord__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3960:1: ( rule__XRecord__Group_5_1__0__Impl rule__XRecord__Group_5_1__1 )
            // InternalXContext.g:3961:2: rule__XRecord__Group_5_1__0__Impl rule__XRecord__Group_5_1__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__XRecord__Group_5_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__Group_5_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_5_1__0"


    // $ANTLR start "rule__XRecord__Group_5_1__0__Impl"
    // InternalXContext.g:3968:1: rule__XRecord__Group_5_1__0__Impl : ( 'constraint' ) ;
    public final void rule__XRecord__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3972:1: ( ( 'constraint' ) )
            // InternalXContext.g:3973:1: ( 'constraint' )
            {
            // InternalXContext.g:3973:1: ( 'constraint' )
            // InternalXContext.g:3974:2: 'constraint'
            {
             before(grammarAccess.getXRecordAccess().getConstraintKeyword_5_1_0()); 
            match(input,135,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXRecordAccess().getConstraintKeyword_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_5_1__0__Impl"


    // $ANTLR start "rule__XRecord__Group_5_1__1"
    // InternalXContext.g:3983:1: rule__XRecord__Group_5_1__1 : rule__XRecord__Group_5_1__1__Impl ;
    public final void rule__XRecord__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3987:1: ( rule__XRecord__Group_5_1__1__Impl )
            // InternalXContext.g:3988:2: rule__XRecord__Group_5_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__Group_5_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_5_1__1"


    // $ANTLR start "rule__XRecord__Group_5_1__1__Impl"
    // InternalXContext.g:3994:1: rule__XRecord__Group_5_1__1__Impl : ( ( rule__XRecord__ConstraintsAssignment_5_1_1 ) ) ;
    public final void rule__XRecord__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:3998:1: ( ( ( rule__XRecord__ConstraintsAssignment_5_1_1 ) ) )
            // InternalXContext.g:3999:1: ( ( rule__XRecord__ConstraintsAssignment_5_1_1 ) )
            {
            // InternalXContext.g:3999:1: ( ( rule__XRecord__ConstraintsAssignment_5_1_1 ) )
            // InternalXContext.g:4000:2: ( rule__XRecord__ConstraintsAssignment_5_1_1 )
            {
             before(grammarAccess.getXRecordAccess().getConstraintsAssignment_5_1_1()); 
            // InternalXContext.g:4001:2: ( rule__XRecord__ConstraintsAssignment_5_1_1 )
            // InternalXContext.g:4001:3: rule__XRecord__ConstraintsAssignment_5_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XRecord__ConstraintsAssignment_5_1_1();

            state._fsp--;


            }

             after(grammarAccess.getXRecordAccess().getConstraintsAssignment_5_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__Group_5_1__1__Impl"


    // $ANTLR start "rule__Field__Group__0"
    // InternalXContext.g:4010:1: rule__Field__Group__0 : rule__Field__Group__0__Impl rule__Field__Group__1 ;
    public final void rule__Field__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4014:1: ( rule__Field__Group__0__Impl rule__Field__Group__1 )
            // InternalXContext.g:4015:2: rule__Field__Group__0__Impl rule__Field__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Field__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Field__Group__1();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:4022:1: rule__Field__Group__0__Impl : ( () ) ;
    public final void rule__Field__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4026:1: ( ( () ) )
            // InternalXContext.g:4027:1: ( () )
            {
            // InternalXContext.g:4027:1: ( () )
            // InternalXContext.g:4028:2: ()
            {
             before(grammarAccess.getFieldAccess().getFieldAction_0()); 
            // InternalXContext.g:4029:2: ()
            // InternalXContext.g:4029:3: 
            {
            }

             after(grammarAccess.getFieldAccess().getFieldAction_0()); 

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
    // InternalXContext.g:4037:1: rule__Field__Group__1 : rule__Field__Group__1__Impl rule__Field__Group__2 ;
    public final void rule__Field__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4041:1: ( rule__Field__Group__1__Impl rule__Field__Group__2 )
            // InternalXContext.g:4042:2: rule__Field__Group__1__Impl rule__Field__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Field__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Field__Group__2();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:4049:1: rule__Field__Group__1__Impl : ( ( rule__Field__CommentAssignment_1 )? ) ;
    public final void rule__Field__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4053:1: ( ( ( rule__Field__CommentAssignment_1 )? ) )
            // InternalXContext.g:4054:1: ( ( rule__Field__CommentAssignment_1 )? )
            {
            // InternalXContext.g:4054:1: ( ( rule__Field__CommentAssignment_1 )? )
            // InternalXContext.g:4055:2: ( rule__Field__CommentAssignment_1 )?
            {
             before(grammarAccess.getFieldAccess().getCommentAssignment_1()); 
            // InternalXContext.g:4056:2: ( rule__Field__CommentAssignment_1 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_STRING) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalXContext.g:4056:3: rule__Field__CommentAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Field__CommentAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFieldAccess().getCommentAssignment_1()); 

            }


            }

        }
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
    // InternalXContext.g:4064:1: rule__Field__Group__2 : rule__Field__Group__2__Impl rule__Field__Group__3 ;
    public final void rule__Field__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4068:1: ( rule__Field__Group__2__Impl rule__Field__Group__3 )
            // InternalXContext.g:4069:2: rule__Field__Group__2__Impl rule__Field__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__Field__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Field__Group__3();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:4076:1: rule__Field__Group__2__Impl : ( ( rule__Field__NameAssignment_2 ) ) ;
    public final void rule__Field__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4080:1: ( ( ( rule__Field__NameAssignment_2 ) ) )
            // InternalXContext.g:4081:1: ( ( rule__Field__NameAssignment_2 ) )
            {
            // InternalXContext.g:4081:1: ( ( rule__Field__NameAssignment_2 ) )
            // InternalXContext.g:4082:2: ( rule__Field__NameAssignment_2 )
            {
             before(grammarAccess.getFieldAccess().getNameAssignment_2()); 
            // InternalXContext.g:4083:2: ( rule__Field__NameAssignment_2 )
            // InternalXContext.g:4083:3: rule__Field__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Field__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFieldAccess().getNameAssignment_2()); 

            }


            }

        }
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
    // InternalXContext.g:4091:1: rule__Field__Group__3 : rule__Field__Group__3__Impl rule__Field__Group__4 ;
    public final void rule__Field__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4095:1: ( rule__Field__Group__3__Impl rule__Field__Group__4 )
            // InternalXContext.g:4096:2: rule__Field__Group__3__Impl rule__Field__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_32);
            rule__Field__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Field__Group__4();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:4103:1: rule__Field__Group__3__Impl : ( ':' ) ;
    public final void rule__Field__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4107:1: ( ( ':' ) )
            // InternalXContext.g:4108:1: ( ':' )
            {
            // InternalXContext.g:4108:1: ( ':' )
            // InternalXContext.g:4109:2: ':'
            {
             before(grammarAccess.getFieldAccess().getColonKeyword_3()); 
            match(input,80,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFieldAccess().getColonKeyword_3()); 

            }


            }

        }
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
    // InternalXContext.g:4118:1: rule__Field__Group__4 : rule__Field__Group__4__Impl rule__Field__Group__5 ;
    public final void rule__Field__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4122:1: ( rule__Field__Group__4__Impl rule__Field__Group__5 )
            // InternalXContext.g:4123:2: rule__Field__Group__4__Impl rule__Field__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_32);
            rule__Field__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Field__Group__5();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:4130:1: rule__Field__Group__4__Impl : ( ( rule__Field__MultiplicityAssignment_4 )? ) ;
    public final void rule__Field__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4134:1: ( ( ( rule__Field__MultiplicityAssignment_4 )? ) )
            // InternalXContext.g:4135:1: ( ( rule__Field__MultiplicityAssignment_4 )? )
            {
            // InternalXContext.g:4135:1: ( ( rule__Field__MultiplicityAssignment_4 )? )
            // InternalXContext.g:4136:2: ( rule__Field__MultiplicityAssignment_4 )?
            {
             before(grammarAccess.getFieldAccess().getMultiplicityAssignment_4()); 
            // InternalXContext.g:4137:2: ( rule__Field__MultiplicityAssignment_4 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=119 && LA40_0<=121)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalXContext.g:4137:3: rule__Field__MultiplicityAssignment_4
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Field__MultiplicityAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFieldAccess().getMultiplicityAssignment_4()); 

            }


            }

        }
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
    // InternalXContext.g:4145:1: rule__Field__Group__5 : rule__Field__Group__5__Impl ;
    public final void rule__Field__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4149:1: ( rule__Field__Group__5__Impl )
            // InternalXContext.g:4150:2: rule__Field__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Field__Group__5__Impl();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:4156:1: rule__Field__Group__5__Impl : ( ( rule__Field__TypeAssignment_5 ) ) ;
    public final void rule__Field__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4160:1: ( ( ( rule__Field__TypeAssignment_5 ) ) )
            // InternalXContext.g:4161:1: ( ( rule__Field__TypeAssignment_5 ) )
            {
            // InternalXContext.g:4161:1: ( ( rule__Field__TypeAssignment_5 ) )
            // InternalXContext.g:4162:2: ( rule__Field__TypeAssignment_5 )
            {
             before(grammarAccess.getFieldAccess().getTypeAssignment_5()); 
            // InternalXContext.g:4163:2: ( rule__Field__TypeAssignment_5 )
            // InternalXContext.g:4163:3: rule__Field__TypeAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Field__TypeAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getFieldAccess().getTypeAssignment_5()); 

            }


            }

        }
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
    // InternalXContext.g:4172:1: rule__XConstraint__Group__0 : rule__XConstraint__Group__0__Impl rule__XConstraint__Group__1 ;
    public final void rule__XConstraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4176:1: ( rule__XConstraint__Group__0__Impl rule__XConstraint__Group__1 )
            // InternalXContext.g:4177:2: rule__XConstraint__Group__0__Impl rule__XConstraint__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__XConstraint__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XConstraint__Group__1();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:4184:1: rule__XConstraint__Group__0__Impl : ( () ) ;
    public final void rule__XConstraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4188:1: ( ( () ) )
            // InternalXContext.g:4189:1: ( () )
            {
            // InternalXContext.g:4189:1: ( () )
            // InternalXContext.g:4190:2: ()
            {
             before(grammarAccess.getXConstraintAccess().getConstraintAction_0()); 
            // InternalXContext.g:4191:2: ()
            // InternalXContext.g:4191:3: 
            {
            }

             after(grammarAccess.getXConstraintAccess().getConstraintAction_0()); 

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
    // InternalXContext.g:4199:1: rule__XConstraint__Group__1 : rule__XConstraint__Group__1__Impl rule__XConstraint__Group__2 ;
    public final void rule__XConstraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4203:1: ( rule__XConstraint__Group__1__Impl rule__XConstraint__Group__2 )
            // InternalXContext.g:4204:2: rule__XConstraint__Group__1__Impl rule__XConstraint__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__XConstraint__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XConstraint__Group__2();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:4211:1: rule__XConstraint__Group__1__Impl : ( ( rule__XConstraint__CommentAssignment_1 )? ) ;
    public final void rule__XConstraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4215:1: ( ( ( rule__XConstraint__CommentAssignment_1 )? ) )
            // InternalXContext.g:4216:1: ( ( rule__XConstraint__CommentAssignment_1 )? )
            {
            // InternalXContext.g:4216:1: ( ( rule__XConstraint__CommentAssignment_1 )? )
            // InternalXContext.g:4217:2: ( rule__XConstraint__CommentAssignment_1 )?
            {
             before(grammarAccess.getXConstraintAccess().getCommentAssignment_1()); 
            // InternalXContext.g:4218:2: ( rule__XConstraint__CommentAssignment_1 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_STRING) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalXContext.g:4218:3: rule__XConstraint__CommentAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__XConstraint__CommentAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXConstraintAccess().getCommentAssignment_1()); 

            }


            }

        }
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
    // InternalXContext.g:4226:1: rule__XConstraint__Group__2 : rule__XConstraint__Group__2__Impl rule__XConstraint__Group__3 ;
    public final void rule__XConstraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4230:1: ( rule__XConstraint__Group__2__Impl rule__XConstraint__Group__3 )
            // InternalXContext.g:4231:2: rule__XConstraint__Group__2__Impl rule__XConstraint__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__XConstraint__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__XConstraint__Group__3();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:4238:1: rule__XConstraint__Group__2__Impl : ( ( rule__XConstraint__NameAssignment_2 ) ) ;
    public final void rule__XConstraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4242:1: ( ( ( rule__XConstraint__NameAssignment_2 ) ) )
            // InternalXContext.g:4243:1: ( ( rule__XConstraint__NameAssignment_2 ) )
            {
            // InternalXContext.g:4243:1: ( ( rule__XConstraint__NameAssignment_2 ) )
            // InternalXContext.g:4244:2: ( rule__XConstraint__NameAssignment_2 )
            {
             before(grammarAccess.getXConstraintAccess().getNameAssignment_2()); 
            // InternalXContext.g:4245:2: ( rule__XConstraint__NameAssignment_2 )
            // InternalXContext.g:4245:3: rule__XConstraint__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XConstraint__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getXConstraintAccess().getNameAssignment_2()); 

            }


            }

        }
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
    // InternalXContext.g:4253:1: rule__XConstraint__Group__3 : rule__XConstraint__Group__3__Impl ;
    public final void rule__XConstraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4257:1: ( rule__XConstraint__Group__3__Impl )
            // InternalXContext.g:4258:2: rule__XConstraint__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XConstraint__Group__3__Impl();

            state._fsp--;


            }

        }
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
    // InternalXContext.g:4264:1: rule__XConstraint__Group__3__Impl : ( ( rule__XConstraint__PredicateAssignment_3 ) ) ;
    public final void rule__XConstraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4268:1: ( ( ( rule__XConstraint__PredicateAssignment_3 ) ) )
            // InternalXContext.g:4269:1: ( ( rule__XConstraint__PredicateAssignment_3 ) )
            {
            // InternalXContext.g:4269:1: ( ( rule__XConstraint__PredicateAssignment_3 ) )
            // InternalXContext.g:4270:2: ( rule__XConstraint__PredicateAssignment_3 )
            {
             before(grammarAccess.getXConstraintAccess().getPredicateAssignment_3()); 
            // InternalXContext.g:4271:2: ( rule__XConstraint__PredicateAssignment_3 )
            // InternalXContext.g:4271:3: rule__XConstraint__PredicateAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XConstraint__PredicateAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getXConstraintAccess().getPredicateAssignment_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__XContext__CommentAssignment_1"
    // InternalXContext.g:4280:1: rule__XContext__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XContext__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4284:1: ( ( RULE_STRING ) )
            // InternalXContext.g:4285:2: ( RULE_STRING )
            {
            // InternalXContext.g:4285:2: ( RULE_STRING )
            // InternalXContext.g:4286:3: RULE_STRING
            {
             before(grammarAccess.getXContextAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXContextAccess().getCommentSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__CommentAssignment_1"


    // $ANTLR start "rule__XContext__NameAssignment_3"
    // InternalXContext.g:4295:1: rule__XContext__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__XContext__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4299:1: ( ( RULE_ID ) )
            // InternalXContext.g:4300:2: ( RULE_ID )
            {
            // InternalXContext.g:4300:2: ( RULE_ID )
            // InternalXContext.g:4301:3: RULE_ID
            {
             before(grammarAccess.getXContextAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXContextAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__NameAssignment_3"


    // $ANTLR start "rule__XContext__OrderedChildrenAssignment_4_1"
    // InternalXContext.g:4310:1: rule__XContext__OrderedChildrenAssignment_4_1 : ( ruleXAgent ) ;
    public final void rule__XContext__OrderedChildrenAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4314:1: ( ( ruleXAgent ) )
            // InternalXContext.g:4315:2: ( ruleXAgent )
            {
            // InternalXContext.g:4315:2: ( ruleXAgent )
            // InternalXContext.g:4316:3: ruleXAgent
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenXAgentParserRuleCall_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXAgent();

            state._fsp--;

             after(grammarAccess.getXContextAccess().getOrderedChildrenXAgentParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__OrderedChildrenAssignment_4_1"


    // $ANTLR start "rule__XContext__ExtendsAssignment_5_0_1"
    // InternalXContext.g:4325:1: rule__XContext__ExtendsAssignment_5_0_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__XContext__ExtendsAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4329:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXContext.g:4330:2: ( ( ruleQualifiedName ) )
            {
            // InternalXContext.g:4330:2: ( ( ruleQualifiedName ) )
            // InternalXContext.g:4331:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getXContextAccess().getExtendsContextCrossReference_5_0_1_0()); 
            // InternalXContext.g:4332:3: ( ruleQualifiedName )
            // InternalXContext.g:4333:4: ruleQualifiedName
            {
             before(grammarAccess.getXContextAccess().getExtendsContextQualifiedNameParserRuleCall_5_0_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getXContextAccess().getExtendsContextQualifiedNameParserRuleCall_5_0_1_0_1()); 

            }

             after(grammarAccess.getXContextAccess().getExtendsContextCrossReference_5_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__ExtendsAssignment_5_0_1"


    // $ANTLR start "rule__XContext__ExtendsAssignment_5_1_1"
    // InternalXContext.g:4344:1: rule__XContext__ExtendsAssignment_5_1_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__XContext__ExtendsAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4348:1: ( ( ( ruleQualifiedName ) ) )
            // InternalXContext.g:4349:2: ( ( ruleQualifiedName ) )
            {
            // InternalXContext.g:4349:2: ( ( ruleQualifiedName ) )
            // InternalXContext.g:4350:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getXContextAccess().getExtendsContextCrossReference_5_1_1_0()); 
            // InternalXContext.g:4351:3: ( ruleQualifiedName )
            // InternalXContext.g:4352:4: ruleQualifiedName
            {
             before(grammarAccess.getXContextAccess().getExtendsContextQualifiedNameParserRuleCall_5_1_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getXContextAccess().getExtendsContextQualifiedNameParserRuleCall_5_1_1_0_1()); 

            }

             after(grammarAccess.getXContextAccess().getExtendsContextCrossReference_5_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__ExtendsAssignment_5_1_1"


    // $ANTLR start "rule__XContext__OrderedChildrenAssignment_5_2_1"
    // InternalXContext.g:4363:1: rule__XContext__OrderedChildrenAssignment_5_2_1 : ( ruleXCarrierSet ) ;
    public final void rule__XContext__OrderedChildrenAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4367:1: ( ( ruleXCarrierSet ) )
            // InternalXContext.g:4368:2: ( ruleXCarrierSet )
            {
            // InternalXContext.g:4368:2: ( ruleXCarrierSet )
            // InternalXContext.g:4369:3: ruleXCarrierSet
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenXCarrierSetParserRuleCall_5_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXCarrierSet();

            state._fsp--;

             after(grammarAccess.getXContextAccess().getOrderedChildrenXCarrierSetParserRuleCall_5_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__OrderedChildrenAssignment_5_2_1"


    // $ANTLR start "rule__XContext__OrderedChildrenAssignment_5_3"
    // InternalXContext.g:4378:1: rule__XContext__OrderedChildrenAssignment_5_3 : ( ruleXIndividualCarrierSet ) ;
    public final void rule__XContext__OrderedChildrenAssignment_5_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4382:1: ( ( ruleXIndividualCarrierSet ) )
            // InternalXContext.g:4383:2: ( ruleXIndividualCarrierSet )
            {
            // InternalXContext.g:4383:2: ( ruleXIndividualCarrierSet )
            // InternalXContext.g:4384:3: ruleXIndividualCarrierSet
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenXIndividualCarrierSetParserRuleCall_5_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXIndividualCarrierSet();

            state._fsp--;

             after(grammarAccess.getXContextAccess().getOrderedChildrenXIndividualCarrierSetParserRuleCall_5_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__OrderedChildrenAssignment_5_3"


    // $ANTLR start "rule__XContext__OrderedChildrenAssignment_5_4_1"
    // InternalXContext.g:4393:1: rule__XContext__OrderedChildrenAssignment_5_4_1 : ( ruleXConstant ) ;
    public final void rule__XContext__OrderedChildrenAssignment_5_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4397:1: ( ( ruleXConstant ) )
            // InternalXContext.g:4398:2: ( ruleXConstant )
            {
            // InternalXContext.g:4398:2: ( ruleXConstant )
            // InternalXContext.g:4399:3: ruleXConstant
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenXConstantParserRuleCall_5_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXConstant();

            state._fsp--;

             after(grammarAccess.getXContextAccess().getOrderedChildrenXConstantParserRuleCall_5_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__OrderedChildrenAssignment_5_4_1"


    // $ANTLR start "rule__XContext__OrderedChildrenAssignment_5_5"
    // InternalXContext.g:4408:1: rule__XContext__OrderedChildrenAssignment_5_5 : ( ruleXIndividualConstant ) ;
    public final void rule__XContext__OrderedChildrenAssignment_5_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4412:1: ( ( ruleXIndividualConstant ) )
            // InternalXContext.g:4413:2: ( ruleXIndividualConstant )
            {
            // InternalXContext.g:4413:2: ( ruleXIndividualConstant )
            // InternalXContext.g:4414:3: ruleXIndividualConstant
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenXIndividualConstantParserRuleCall_5_5_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXIndividualConstant();

            state._fsp--;

             after(grammarAccess.getXContextAccess().getOrderedChildrenXIndividualConstantParserRuleCall_5_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__OrderedChildrenAssignment_5_5"


    // $ANTLR start "rule__XContext__OrderedChildrenAssignment_5_6"
    // InternalXContext.g:4423:1: rule__XContext__OrderedChildrenAssignment_5_6 : ( ruleXRecord ) ;
    public final void rule__XContext__OrderedChildrenAssignment_5_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4427:1: ( ( ruleXRecord ) )
            // InternalXContext.g:4428:2: ( ruleXRecord )
            {
            // InternalXContext.g:4428:2: ( ruleXRecord )
            // InternalXContext.g:4429:3: ruleXRecord
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenXRecordParserRuleCall_5_6_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXRecord();

            state._fsp--;

             after(grammarAccess.getXContextAccess().getOrderedChildrenXRecordParserRuleCall_5_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__OrderedChildrenAssignment_5_6"


    // $ANTLR start "rule__XContext__OrderedChildrenAssignment_5_7_1"
    // InternalXContext.g:4438:1: rule__XContext__OrderedChildrenAssignment_5_7_1 : ( ruleXAxiom ) ;
    public final void rule__XContext__OrderedChildrenAssignment_5_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4442:1: ( ( ruleXAxiom ) )
            // InternalXContext.g:4443:2: ( ruleXAxiom )
            {
            // InternalXContext.g:4443:2: ( ruleXAxiom )
            // InternalXContext.g:4444:3: ruleXAxiom
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenXAxiomParserRuleCall_5_7_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXAxiom();

            state._fsp--;

             after(grammarAccess.getXContextAccess().getOrderedChildrenXAxiomParserRuleCall_5_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__OrderedChildrenAssignment_5_7_1"


    // $ANTLR start "rule__XContext__OrderedChildrenAssignment_5_8"
    // InternalXContext.g:4453:1: rule__XContext__OrderedChildrenAssignment_5_8 : ( ruleXIndividualAxiom ) ;
    public final void rule__XContext__OrderedChildrenAssignment_5_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4457:1: ( ( ruleXIndividualAxiom ) )
            // InternalXContext.g:4458:2: ( ruleXIndividualAxiom )
            {
            // InternalXContext.g:4458:2: ( ruleXIndividualAxiom )
            // InternalXContext.g:4459:3: ruleXIndividualAxiom
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenXIndividualAxiomParserRuleCall_5_8_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXIndividualAxiom();

            state._fsp--;

             after(grammarAccess.getXContextAccess().getOrderedChildrenXIndividualAxiomParserRuleCall_5_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__OrderedChildrenAssignment_5_8"


    // $ANTLR start "rule__XContext__OrderedChildrenAssignment_5_9"
    // InternalXContext.g:4468:1: rule__XContext__OrderedChildrenAssignment_5_9 : ( ruleXIndividualTheorem ) ;
    public final void rule__XContext__OrderedChildrenAssignment_5_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4472:1: ( ( ruleXIndividualTheorem ) )
            // InternalXContext.g:4473:2: ( ruleXIndividualTheorem )
            {
            // InternalXContext.g:4473:2: ( ruleXIndividualTheorem )
            // InternalXContext.g:4474:3: ruleXIndividualTheorem
            {
             before(grammarAccess.getXContextAccess().getOrderedChildrenXIndividualTheoremParserRuleCall_5_9_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXIndividualTheorem();

            state._fsp--;

             after(grammarAccess.getXContextAccess().getOrderedChildrenXIndividualTheoremParserRuleCall_5_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XContext__OrderedChildrenAssignment_5_9"


    // $ANTLR start "rule__XAgent__NameAssignment"
    // InternalXContext.g:4483:1: rule__XAgent__NameAssignment : ( RULE_ID ) ;
    public final void rule__XAgent__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4487:1: ( ( RULE_ID ) )
            // InternalXContext.g:4488:2: ( RULE_ID )
            {
            // InternalXContext.g:4488:2: ( RULE_ID )
            // InternalXContext.g:4489:3: RULE_ID
            {
             before(grammarAccess.getXAgentAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXAgentAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAgent__NameAssignment"


    // $ANTLR start "rule__XCarrierSet__CommentAssignment_1"
    // InternalXContext.g:4498:1: rule__XCarrierSet__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XCarrierSet__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4502:1: ( ( RULE_STRING ) )
            // InternalXContext.g:4503:2: ( RULE_STRING )
            {
            // InternalXContext.g:4503:2: ( RULE_STRING )
            // InternalXContext.g:4504:3: RULE_STRING
            {
             before(grammarAccess.getXCarrierSetAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXCarrierSetAccess().getCommentSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XCarrierSet__CommentAssignment_1"


    // $ANTLR start "rule__XCarrierSet__NameAssignment_2"
    // InternalXContext.g:4513:1: rule__XCarrierSet__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__XCarrierSet__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4517:1: ( ( RULE_ID ) )
            // InternalXContext.g:4518:2: ( RULE_ID )
            {
            // InternalXContext.g:4518:2: ( RULE_ID )
            // InternalXContext.g:4519:3: RULE_ID
            {
             before(grammarAccess.getXCarrierSetAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXCarrierSetAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XCarrierSet__NameAssignment_2"


    // $ANTLR start "rule__XIndividualCarrierSet__CommentAssignment_1"
    // InternalXContext.g:4528:1: rule__XIndividualCarrierSet__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XIndividualCarrierSet__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4532:1: ( ( RULE_STRING ) )
            // InternalXContext.g:4533:2: ( RULE_STRING )
            {
            // InternalXContext.g:4533:2: ( RULE_STRING )
            // InternalXContext.g:4534:3: RULE_STRING
            {
             before(grammarAccess.getXIndividualCarrierSetAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXIndividualCarrierSetAccess().getCommentSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualCarrierSet__CommentAssignment_1"


    // $ANTLR start "rule__XIndividualCarrierSet__NameAssignment_3"
    // InternalXContext.g:4543:1: rule__XIndividualCarrierSet__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__XIndividualCarrierSet__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4547:1: ( ( RULE_ID ) )
            // InternalXContext.g:4548:2: ( RULE_ID )
            {
            // InternalXContext.g:4548:2: ( RULE_ID )
            // InternalXContext.g:4549:3: RULE_ID
            {
             before(grammarAccess.getXIndividualCarrierSetAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXIndividualCarrierSetAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualCarrierSet__NameAssignment_3"


    // $ANTLR start "rule__XConstant__CommentAssignment_1"
    // InternalXContext.g:4558:1: rule__XConstant__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XConstant__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4562:1: ( ( RULE_STRING ) )
            // InternalXContext.g:4563:2: ( RULE_STRING )
            {
            // InternalXContext.g:4563:2: ( RULE_STRING )
            // InternalXContext.g:4564:3: RULE_STRING
            {
             before(grammarAccess.getXConstantAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXConstantAccess().getCommentSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstant__CommentAssignment_1"


    // $ANTLR start "rule__XConstant__NameAssignment_2"
    // InternalXContext.g:4573:1: rule__XConstant__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__XConstant__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4577:1: ( ( RULE_ID ) )
            // InternalXContext.g:4578:2: ( RULE_ID )
            {
            // InternalXContext.g:4578:2: ( RULE_ID )
            // InternalXContext.g:4579:3: RULE_ID
            {
             before(grammarAccess.getXConstantAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXConstantAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XConstant__NameAssignment_2"


    // $ANTLR start "rule__XIndividualConstant__CommentAssignment_1"
    // InternalXContext.g:4588:1: rule__XIndividualConstant__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XIndividualConstant__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4592:1: ( ( RULE_STRING ) )
            // InternalXContext.g:4593:2: ( RULE_STRING )
            {
            // InternalXContext.g:4593:2: ( RULE_STRING )
            // InternalXContext.g:4594:3: RULE_STRING
            {
             before(grammarAccess.getXIndividualConstantAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXIndividualConstantAccess().getCommentSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__CommentAssignment_1"


    // $ANTLR start "rule__XIndividualConstant__NameAssignment_3"
    // InternalXContext.g:4603:1: rule__XIndividualConstant__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__XIndividualConstant__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4607:1: ( ( RULE_ID ) )
            // InternalXContext.g:4608:2: ( RULE_ID )
            {
            // InternalXContext.g:4608:2: ( RULE_ID )
            // InternalXContext.g:4609:3: RULE_ID
            {
             before(grammarAccess.getXIndividualConstantAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXIndividualConstantAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__NameAssignment_3"


    // $ANTLR start "rule__XIndividualConstant__TypeAssignment_4_1"
    // InternalXContext.g:4618:1: rule__XIndividualConstant__TypeAssignment_4_1 : ( ruleXType ) ;
    public final void rule__XIndividualConstant__TypeAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4622:1: ( ( ruleXType ) )
            // InternalXContext.g:4623:2: ( ruleXType )
            {
            // InternalXContext.g:4623:2: ( ruleXType )
            // InternalXContext.g:4624:3: ruleXType
            {
             before(grammarAccess.getXIndividualConstantAccess().getTypeXTypeParserRuleCall_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXType();

            state._fsp--;

             after(grammarAccess.getXIndividualConstantAccess().getTypeXTypeParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__TypeAssignment_4_1"


    // $ANTLR start "rule__XIndividualConstant__ValueAssignment_5_1"
    // InternalXContext.g:4633:1: rule__XIndividualConstant__ValueAssignment_5_1 : ( ruleXFormula ) ;
    public final void rule__XIndividualConstant__ValueAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4637:1: ( ( ruleXFormula ) )
            // InternalXContext.g:4638:2: ( ruleXFormula )
            {
            // InternalXContext.g:4638:2: ( ruleXFormula )
            // InternalXContext.g:4639:3: ruleXFormula
            {
             before(grammarAccess.getXIndividualConstantAccess().getValueXFormulaParserRuleCall_5_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXFormula();

            state._fsp--;

             after(grammarAccess.getXIndividualConstantAccess().getValueXFormulaParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualConstant__ValueAssignment_5_1"


    // $ANTLR start "rule__XAxiom__CommentAssignment_1"
    // InternalXContext.g:4648:1: rule__XAxiom__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XAxiom__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4652:1: ( ( RULE_STRING ) )
            // InternalXContext.g:4653:2: ( RULE_STRING )
            {
            // InternalXContext.g:4653:2: ( RULE_STRING )
            // InternalXContext.g:4654:3: RULE_STRING
            {
             before(grammarAccess.getXAxiomAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXAxiomAccess().getCommentSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAxiom__CommentAssignment_1"


    // $ANTLR start "rule__XAxiom__NameAssignment_2"
    // InternalXContext.g:4663:1: rule__XAxiom__NameAssignment_2 : ( RULE_XLABEL ) ;
    public final void rule__XAxiom__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4667:1: ( ( RULE_XLABEL ) )
            // InternalXContext.g:4668:2: ( RULE_XLABEL )
            {
            // InternalXContext.g:4668:2: ( RULE_XLABEL )
            // InternalXContext.g:4669:3: RULE_XLABEL
            {
             before(grammarAccess.getXAxiomAccess().getNameXLABELTerminalRuleCall_2_0()); 
            match(input,RULE_XLABEL,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXAxiomAccess().getNameXLABELTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAxiom__NameAssignment_2"


    // $ANTLR start "rule__XAxiom__PredicateAssignment_3"
    // InternalXContext.g:4678:1: rule__XAxiom__PredicateAssignment_3 : ( ruleXFormula ) ;
    public final void rule__XAxiom__PredicateAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4682:1: ( ( ruleXFormula ) )
            // InternalXContext.g:4683:2: ( ruleXFormula )
            {
            // InternalXContext.g:4683:2: ( ruleXFormula )
            // InternalXContext.g:4684:3: ruleXFormula
            {
             before(grammarAccess.getXAxiomAccess().getPredicateXFormulaParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXFormula();

            state._fsp--;

             after(grammarAccess.getXAxiomAccess().getPredicateXFormulaParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAxiom__PredicateAssignment_3"


    // $ANTLR start "rule__XIndividualAxiom__CommentAssignment_1"
    // InternalXContext.g:4693:1: rule__XIndividualAxiom__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XIndividualAxiom__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4697:1: ( ( RULE_STRING ) )
            // InternalXContext.g:4698:2: ( RULE_STRING )
            {
            // InternalXContext.g:4698:2: ( RULE_STRING )
            // InternalXContext.g:4699:3: RULE_STRING
            {
             before(grammarAccess.getXIndividualAxiomAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXIndividualAxiomAccess().getCommentSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualAxiom__CommentAssignment_1"


    // $ANTLR start "rule__XIndividualAxiom__NameAssignment_3"
    // InternalXContext.g:4708:1: rule__XIndividualAxiom__NameAssignment_3 : ( RULE_XLABEL ) ;
    public final void rule__XIndividualAxiom__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4712:1: ( ( RULE_XLABEL ) )
            // InternalXContext.g:4713:2: ( RULE_XLABEL )
            {
            // InternalXContext.g:4713:2: ( RULE_XLABEL )
            // InternalXContext.g:4714:3: RULE_XLABEL
            {
             before(grammarAccess.getXIndividualAxiomAccess().getNameXLABELTerminalRuleCall_3_0()); 
            match(input,RULE_XLABEL,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXIndividualAxiomAccess().getNameXLABELTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualAxiom__NameAssignment_3"


    // $ANTLR start "rule__XIndividualAxiom__PredicateAssignment_4"
    // InternalXContext.g:4723:1: rule__XIndividualAxiom__PredicateAssignment_4 : ( ruleXFormula ) ;
    public final void rule__XIndividualAxiom__PredicateAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4727:1: ( ( ruleXFormula ) )
            // InternalXContext.g:4728:2: ( ruleXFormula )
            {
            // InternalXContext.g:4728:2: ( ruleXFormula )
            // InternalXContext.g:4729:3: ruleXFormula
            {
             before(grammarAccess.getXIndividualAxiomAccess().getPredicateXFormulaParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXFormula();

            state._fsp--;

             after(grammarAccess.getXIndividualAxiomAccess().getPredicateXFormulaParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualAxiom__PredicateAssignment_4"


    // $ANTLR start "rule__XIndividualTheorem__CommentAssignment_1"
    // InternalXContext.g:4738:1: rule__XIndividualTheorem__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XIndividualTheorem__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4742:1: ( ( RULE_STRING ) )
            // InternalXContext.g:4743:2: ( RULE_STRING )
            {
            // InternalXContext.g:4743:2: ( RULE_STRING )
            // InternalXContext.g:4744:3: RULE_STRING
            {
             before(grammarAccess.getXIndividualTheoremAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXIndividualTheoremAccess().getCommentSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualTheorem__CommentAssignment_1"


    // $ANTLR start "rule__XIndividualTheorem__TheoremAssignment_2"
    // InternalXContext.g:4753:1: rule__XIndividualTheorem__TheoremAssignment_2 : ( ( rule__XIndividualTheorem__TheoremAlternatives_2_0 ) ) ;
    public final void rule__XIndividualTheorem__TheoremAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4757:1: ( ( ( rule__XIndividualTheorem__TheoremAlternatives_2_0 ) ) )
            // InternalXContext.g:4758:2: ( ( rule__XIndividualTheorem__TheoremAlternatives_2_0 ) )
            {
            // InternalXContext.g:4758:2: ( ( rule__XIndividualTheorem__TheoremAlternatives_2_0 ) )
            // InternalXContext.g:4759:3: ( rule__XIndividualTheorem__TheoremAlternatives_2_0 )
            {
             before(grammarAccess.getXIndividualTheoremAccess().getTheoremAlternatives_2_0()); 
            // InternalXContext.g:4760:3: ( rule__XIndividualTheorem__TheoremAlternatives_2_0 )
            // InternalXContext.g:4760:4: rule__XIndividualTheorem__TheoremAlternatives_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__XIndividualTheorem__TheoremAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getXIndividualTheoremAccess().getTheoremAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualTheorem__TheoremAssignment_2"


    // $ANTLR start "rule__XIndividualTheorem__NameAssignment_3"
    // InternalXContext.g:4768:1: rule__XIndividualTheorem__NameAssignment_3 : ( RULE_XLABEL ) ;
    public final void rule__XIndividualTheorem__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4772:1: ( ( RULE_XLABEL ) )
            // InternalXContext.g:4773:2: ( RULE_XLABEL )
            {
            // InternalXContext.g:4773:2: ( RULE_XLABEL )
            // InternalXContext.g:4774:3: RULE_XLABEL
            {
             before(grammarAccess.getXIndividualTheoremAccess().getNameXLABELTerminalRuleCall_3_0()); 
            match(input,RULE_XLABEL,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXIndividualTheoremAccess().getNameXLABELTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualTheorem__NameAssignment_3"


    // $ANTLR start "rule__XIndividualTheorem__PredicateAssignment_4"
    // InternalXContext.g:4783:1: rule__XIndividualTheorem__PredicateAssignment_4 : ( ruleXFormula ) ;
    public final void rule__XIndividualTheorem__PredicateAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4787:1: ( ( ruleXFormula ) )
            // InternalXContext.g:4788:2: ( ruleXFormula )
            {
            // InternalXContext.g:4788:2: ( ruleXFormula )
            // InternalXContext.g:4789:3: ruleXFormula
            {
             before(grammarAccess.getXIndividualTheoremAccess().getPredicateXFormulaParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXFormula();

            state._fsp--;

             after(grammarAccess.getXIndividualTheoremAccess().getPredicateXFormulaParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XIndividualTheorem__PredicateAssignment_4"


    // $ANTLR start "rule__XRecord__ExtendedAssignment_1"
    // InternalXContext.g:4798:1: rule__XRecord__ExtendedAssignment_1 : ( ( 'extended' ) ) ;
    public final void rule__XRecord__ExtendedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4802:1: ( ( ( 'extended' ) ) )
            // InternalXContext.g:4803:2: ( ( 'extended' ) )
            {
            // InternalXContext.g:4803:2: ( ( 'extended' ) )
            // InternalXContext.g:4804:3: ( 'extended' )
            {
             before(grammarAccess.getXRecordAccess().getExtendedExtendedKeyword_1_0()); 
            // InternalXContext.g:4805:3: ( 'extended' )
            // InternalXContext.g:4806:4: 'extended'
            {
             before(grammarAccess.getXRecordAccess().getExtendedExtendedKeyword_1_0()); 
            match(input,136,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXRecordAccess().getExtendedExtendedKeyword_1_0()); 

            }

             after(grammarAccess.getXRecordAccess().getExtendedExtendedKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__ExtendedAssignment_1"


    // $ANTLR start "rule__XRecord__NameAssignment_3"
    // InternalXContext.g:4817:1: rule__XRecord__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__XRecord__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4821:1: ( ( RULE_ID ) )
            // InternalXContext.g:4822:2: ( RULE_ID )
            {
            // InternalXContext.g:4822:2: ( RULE_ID )
            // InternalXContext.g:4823:3: RULE_ID
            {
             before(grammarAccess.getXRecordAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXRecordAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__NameAssignment_3"


    // $ANTLR start "rule__XRecord__InheritsNamesAssignment_4_1"
    // InternalXContext.g:4832:1: rule__XRecord__InheritsNamesAssignment_4_1 : ( RULE_ID ) ;
    public final void rule__XRecord__InheritsNamesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4836:1: ( ( RULE_ID ) )
            // InternalXContext.g:4837:2: ( RULE_ID )
            {
            // InternalXContext.g:4837:2: ( RULE_ID )
            // InternalXContext.g:4838:3: RULE_ID
            {
             before(grammarAccess.getXRecordAccess().getInheritsNamesIDTerminalRuleCall_4_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXRecordAccess().getInheritsNamesIDTerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__InheritsNamesAssignment_4_1"


    // $ANTLR start "rule__XRecord__FieldsAssignment_5_0_1"
    // InternalXContext.g:4847:1: rule__XRecord__FieldsAssignment_5_0_1 : ( ruleField ) ;
    public final void rule__XRecord__FieldsAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4851:1: ( ( ruleField ) )
            // InternalXContext.g:4852:2: ( ruleField )
            {
            // InternalXContext.g:4852:2: ( ruleField )
            // InternalXContext.g:4853:3: ruleField
            {
             before(grammarAccess.getXRecordAccess().getFieldsFieldParserRuleCall_5_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleField();

            state._fsp--;

             after(grammarAccess.getXRecordAccess().getFieldsFieldParserRuleCall_5_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__FieldsAssignment_5_0_1"


    // $ANTLR start "rule__XRecord__ConstraintsAssignment_5_1_1"
    // InternalXContext.g:4862:1: rule__XRecord__ConstraintsAssignment_5_1_1 : ( ruleXConstraint ) ;
    public final void rule__XRecord__ConstraintsAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4866:1: ( ( ruleXConstraint ) )
            // InternalXContext.g:4867:2: ( ruleXConstraint )
            {
            // InternalXContext.g:4867:2: ( ruleXConstraint )
            // InternalXContext.g:4868:3: ruleXConstraint
            {
             before(grammarAccess.getXRecordAccess().getConstraintsXConstraintParserRuleCall_5_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXConstraint();

            state._fsp--;

             after(grammarAccess.getXRecordAccess().getConstraintsXConstraintParserRuleCall_5_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRecord__ConstraintsAssignment_5_1_1"


    // $ANTLR start "rule__Field__CommentAssignment_1"
    // InternalXContext.g:4877:1: rule__Field__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Field__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4881:1: ( ( RULE_STRING ) )
            // InternalXContext.g:4882:2: ( RULE_STRING )
            {
            // InternalXContext.g:4882:2: ( RULE_STRING )
            // InternalXContext.g:4883:3: RULE_STRING
            {
             before(grammarAccess.getFieldAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFieldAccess().getCommentSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
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
    // InternalXContext.g:4892:1: rule__Field__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Field__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4896:1: ( ( RULE_ID ) )
            // InternalXContext.g:4897:2: ( RULE_ID )
            {
            // InternalXContext.g:4897:2: ( RULE_ID )
            // InternalXContext.g:4898:3: RULE_ID
            {
             before(grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
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
    // InternalXContext.g:4907:1: rule__Field__MultiplicityAssignment_4 : ( ruleMultiplicity ) ;
    public final void rule__Field__MultiplicityAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4911:1: ( ( ruleMultiplicity ) )
            // InternalXContext.g:4912:2: ( ruleMultiplicity )
            {
            // InternalXContext.g:4912:2: ( ruleMultiplicity )
            // InternalXContext.g:4913:3: ruleMultiplicity
            {
             before(grammarAccess.getFieldAccess().getMultiplicityMultiplicityEnumRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleMultiplicity();

            state._fsp--;

             after(grammarAccess.getFieldAccess().getMultiplicityMultiplicityEnumRuleCall_4_0()); 

            }


            }

        }
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
    // InternalXContext.g:4922:1: rule__Field__TypeAssignment_5 : ( ruleFieldType ) ;
    public final void rule__Field__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4926:1: ( ( ruleFieldType ) )
            // InternalXContext.g:4927:2: ( ruleFieldType )
            {
            // InternalXContext.g:4927:2: ( ruleFieldType )
            // InternalXContext.g:4928:3: ruleFieldType
            {
             before(grammarAccess.getFieldAccess().getTypeFieldTypeParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFieldType();

            state._fsp--;

             after(grammarAccess.getFieldAccess().getTypeFieldTypeParserRuleCall_5_0()); 

            }


            }

        }
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
    // InternalXContext.g:4937:1: rule__XConstraint__CommentAssignment_1 : ( RULE_STRING ) ;
    public final void rule__XConstraint__CommentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4941:1: ( ( RULE_STRING ) )
            // InternalXContext.g:4942:2: ( RULE_STRING )
            {
            // InternalXContext.g:4942:2: ( RULE_STRING )
            // InternalXContext.g:4943:3: RULE_STRING
            {
             before(grammarAccess.getXConstraintAccess().getCommentSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXConstraintAccess().getCommentSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
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
    // InternalXContext.g:4952:1: rule__XConstraint__NameAssignment_2 : ( RULE_XLABEL ) ;
    public final void rule__XConstraint__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4956:1: ( ( RULE_XLABEL ) )
            // InternalXContext.g:4957:2: ( RULE_XLABEL )
            {
            // InternalXContext.g:4957:2: ( RULE_XLABEL )
            // InternalXContext.g:4958:3: RULE_XLABEL
            {
             before(grammarAccess.getXConstraintAccess().getNameXLABELTerminalRuleCall_2_0()); 
            match(input,RULE_XLABEL,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getXConstraintAccess().getNameXLABELTerminalRuleCall_2_0()); 

            }


            }

        }
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
    // InternalXContext.g:4967:1: rule__XConstraint__PredicateAssignment_3 : ( ruleXFormula ) ;
    public final void rule__XConstraint__PredicateAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXContext.g:4971:1: ( ( ruleXFormula ) )
            // InternalXContext.g:4972:2: ( ruleXFormula )
            {
            // InternalXContext.g:4972:2: ( ruleXFormula )
            // InternalXContext.g:4973:3: ruleXFormula
            {
             before(grammarAccess.getXConstraintAccess().getPredicateXFormulaParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleXFormula();

            state._fsp--;

             after(grammarAccess.getXConstraintAccess().getPredicateXFormulaParserRuleCall_3_0()); 

            }


            }

        }
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

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\7\3\uffff\1\17\7\uffff";
    static final String dfa_3s = "\1\u0088\3\uffff\1\u0081\7\uffff";
    static final String dfa_4s = "\1\uffff\1\1\1\2\1\3\1\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12";
    static final String dfa_5s = "\14\uffff}>";
    static final String[] dfa_6s = {
            "\1\4\5\uffff\2\2\2\7\2\12\2\13\150\uffff\1\1\1\3\1\6\1\11\1\5\2\uffff\1\10\3\uffff\1\10",
            "",
            "",
            "",
            "\2\7\2\12\2\13\154\uffff\1\5",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "600:1: rule__XContext__Alternatives_5 : ( ( ( rule__XContext__Group_5_0__0 ) ) | ( ( rule__XContext__Group_5_1__0 ) ) | ( ( rule__XContext__Group_5_2__0 ) ) | ( ( rule__XContext__OrderedChildrenAssignment_5_3 ) ) | ( ( rule__XContext__Group_5_4__0 ) ) | ( ( rule__XContext__OrderedChildrenAssignment_5_5 ) ) | ( ( rule__XContext__OrderedChildrenAssignment_5_6 ) ) | ( ( rule__XContext__Group_5_7__0 ) ) | ( ( rule__XContext__OrderedChildrenAssignment_5_8 ) ) | ( ( rule__XContext__OrderedChildrenAssignment_5_9 ) ) );";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xFFFFFFFFFFE00072L,0x007FFFFFFFFFFFFFL,0x0000000000000004L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000080L,0x0400000000000000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000001FE080L,0xF800000000000000L,0x0000000000000113L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000001FE082L,0xE000000000000000L,0x0000000000000113L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000090L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000092L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000180L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000182L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000080L,0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000018080L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010200L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x01C0001E00000010L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0xFFFFFFFFFFE00070L,0x007FFFFFFFFFFFFFL,0x0000000000000004L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000060080L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000000001FE080L,0xE000000000000000L,0x0000000000000113L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000001FFE00000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00000001FFE00002L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000110L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L,0x00000000000000E0L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x00000000000000C0L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00FFFFFE00000010L,0x0380000000000000L});
    }


}