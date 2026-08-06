package ac.soton.xeventb.xcontext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import ac.soton.xeventb.xcontext.services.XContextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXContextParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_XLABEL", "RULE_INT", "RULE_UNTRANSLATED_TOKEN", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'context'", "'agents'", "'extends'", "'extend'", "'ext'", "'sets'", "'constants'", "'axioms'", "'end'", "'.'", "'set'", "'constant'", "'cst'", "':'", "'='", "'axiom'", "'axm'", "'theorem'", "'thm'", "'\\u2194'", "'\\uE100'", "'\\uE101'", "'\\uE102'", "'\\u21F8'", "'\\u2192'", "'\\u2914'", "'\\u21A3'", "'\\u2900'", "'\\u21A0'", "'\\u2916'", "'\\u00D7'", "'BOOL'", "'\\u21151'", "'\\u2115'", "'\\u2124'", "'('", "')'", "'\\u2119'", "'\\u21191'", "'FALSE'", "'TRUE'", "'bool'", "'card'", "'dom'", "'finite'", "'id'", "'inter'", "'max'", "'min'", "'mod'", "'pred'", "'prj1'", "'prj2'", "'ran'", "'succ'", "'union'", "'\\u21D4'", "'\\u21D2'", "'\\u2227'", "'&'", "'\\u2228'", "'\\u00AC'", "'\\u22A4'", "'\\u22A5'", "'\\u2200'", "'!'", "'\\u2203'", "'#'", "','", "'\\u00B7'", "'\\u2260'", "'\\u2264'", "'<'", "'\\u2265'", "'>'", "'\\u2208'", "'\\u2209'", "'\\u2282'", "'\\u2284'", "'\\u2286'", "'\\u2288'", "'partition'", "'{'", "'}'", "'\\u21A6'", "'\\u2205'", "'\\u2229'", "'\\u222A'", "'\\u2216'", "'['", "']'", "'\\uE103'", "'\\u2218'", "';'", "'\\u2297'", "'\\u2225'", "'\\u223C'", "'\\u25C1'", "'\\u2A64'", "'\\u25B7'", "'\\u2A65'", "'\\u03BB'", "'%'", "'\\u22C2'", "'\\u22C3'", "'\\u2223'", "'\\u2025'", "'+'", "'\\u2212'", "'-'", "'\\u2217'", "'*'", "'\\u00F7'", "'/'", "'^'", "'\\\\'", "'extended'", "'record'", "'inherits'", "'field'", "'constraint'", "'one'", "'many'", "'opt'"
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
    public static final int RULE_ID=5;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=7;
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
    public static final int RULE_XLABEL=6;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int RULE_UNTRANSLATED_TOKEN=8;
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
    public static final int RULE_STRING=4;
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

        public InternalXContextParser(TokenStream input, XContextGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "XContext";
       	}

       	@Override
       	protected XContextGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleXContext"
    // InternalXContext.g:65:1: entryRuleXContext returns [EObject current=null] : iv_ruleXContext= ruleXContext EOF ;
    public final EObject entryRuleXContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXContext = null;


        try {
            // InternalXContext.g:65:49: (iv_ruleXContext= ruleXContext EOF )
            // InternalXContext.g:66:2: iv_ruleXContext= ruleXContext EOF
            {
             newCompositeNode(grammarAccess.getXContextRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXContext=ruleXContext();

            state._fsp--;

             current =iv_ruleXContext; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXContext"


    // $ANTLR start "ruleXContext"
    // InternalXContext.g:72:1: ruleXContext returns [EObject current=null] : ( () ( (lv_comment_1_0= RULE_STRING ) )? otherlv_2= 'context' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'agents' ( (lv_orderedChildren_5_0= ruleXAgent ) )+ )? ( (otherlv_6= 'extends' ( ( ruleQualifiedName ) )+ ) | ( (otherlv_8= 'extend' | otherlv_9= 'ext' ) ( ( ruleQualifiedName ) ) ) | (otherlv_11= 'sets' ( (lv_orderedChildren_12_0= ruleXCarrierSet ) )+ ) | ( (lv_orderedChildren_13_0= ruleXIndividualCarrierSet ) ) | (otherlv_14= 'constants' ( (lv_orderedChildren_15_0= ruleXConstant ) )+ ) | ( (lv_orderedChildren_16_0= ruleXIndividualConstant ) ) | ( (lv_orderedChildren_17_0= ruleXRecord ) ) | (otherlv_18= 'axioms' ( (lv_orderedChildren_19_0= ruleXAxiom ) )+ ) | ( (lv_orderedChildren_20_0= ruleXIndividualAxiom ) ) | ( (lv_orderedChildren_21_0= ruleXIndividualTheorem ) ) )* (otherlv_22= 'end' )? ) ;
    public final EObject ruleXContext() throws RecognitionException {
        EObject current = null;

        Token lv_comment_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_18=null;
        Token otherlv_22=null;
        EObject lv_orderedChildren_5_0 = null;

        EObject lv_orderedChildren_12_0 = null;

        EObject lv_orderedChildren_13_0 = null;

        EObject lv_orderedChildren_15_0 = null;

        EObject lv_orderedChildren_16_0 = null;

        EObject lv_orderedChildren_17_0 = null;

        EObject lv_orderedChildren_19_0 = null;

        EObject lv_orderedChildren_20_0 = null;

        EObject lv_orderedChildren_21_0 = null;



        	enterRule();

        try {
            // InternalXContext.g:78:2: ( ( () ( (lv_comment_1_0= RULE_STRING ) )? otherlv_2= 'context' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'agents' ( (lv_orderedChildren_5_0= ruleXAgent ) )+ )? ( (otherlv_6= 'extends' ( ( ruleQualifiedName ) )+ ) | ( (otherlv_8= 'extend' | otherlv_9= 'ext' ) ( ( ruleQualifiedName ) ) ) | (otherlv_11= 'sets' ( (lv_orderedChildren_12_0= ruleXCarrierSet ) )+ ) | ( (lv_orderedChildren_13_0= ruleXIndividualCarrierSet ) ) | (otherlv_14= 'constants' ( (lv_orderedChildren_15_0= ruleXConstant ) )+ ) | ( (lv_orderedChildren_16_0= ruleXIndividualConstant ) ) | ( (lv_orderedChildren_17_0= ruleXRecord ) ) | (otherlv_18= 'axioms' ( (lv_orderedChildren_19_0= ruleXAxiom ) )+ ) | ( (lv_orderedChildren_20_0= ruleXIndividualAxiom ) ) | ( (lv_orderedChildren_21_0= ruleXIndividualTheorem ) ) )* (otherlv_22= 'end' )? ) )
            // InternalXContext.g:79:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? otherlv_2= 'context' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'agents' ( (lv_orderedChildren_5_0= ruleXAgent ) )+ )? ( (otherlv_6= 'extends' ( ( ruleQualifiedName ) )+ ) | ( (otherlv_8= 'extend' | otherlv_9= 'ext' ) ( ( ruleQualifiedName ) ) ) | (otherlv_11= 'sets' ( (lv_orderedChildren_12_0= ruleXCarrierSet ) )+ ) | ( (lv_orderedChildren_13_0= ruleXIndividualCarrierSet ) ) | (otherlv_14= 'constants' ( (lv_orderedChildren_15_0= ruleXConstant ) )+ ) | ( (lv_orderedChildren_16_0= ruleXIndividualConstant ) ) | ( (lv_orderedChildren_17_0= ruleXRecord ) ) | (otherlv_18= 'axioms' ( (lv_orderedChildren_19_0= ruleXAxiom ) )+ ) | ( (lv_orderedChildren_20_0= ruleXIndividualAxiom ) ) | ( (lv_orderedChildren_21_0= ruleXIndividualTheorem ) ) )* (otherlv_22= 'end' )? )
            {
            // InternalXContext.g:79:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? otherlv_2= 'context' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'agents' ( (lv_orderedChildren_5_0= ruleXAgent ) )+ )? ( (otherlv_6= 'extends' ( ( ruleQualifiedName ) )+ ) | ( (otherlv_8= 'extend' | otherlv_9= 'ext' ) ( ( ruleQualifiedName ) ) ) | (otherlv_11= 'sets' ( (lv_orderedChildren_12_0= ruleXCarrierSet ) )+ ) | ( (lv_orderedChildren_13_0= ruleXIndividualCarrierSet ) ) | (otherlv_14= 'constants' ( (lv_orderedChildren_15_0= ruleXConstant ) )+ ) | ( (lv_orderedChildren_16_0= ruleXIndividualConstant ) ) | ( (lv_orderedChildren_17_0= ruleXRecord ) ) | (otherlv_18= 'axioms' ( (lv_orderedChildren_19_0= ruleXAxiom ) )+ ) | ( (lv_orderedChildren_20_0= ruleXIndividualAxiom ) ) | ( (lv_orderedChildren_21_0= ruleXIndividualTheorem ) ) )* (otherlv_22= 'end' )? )
            // InternalXContext.g:80:3: () ( (lv_comment_1_0= RULE_STRING ) )? otherlv_2= 'context' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'agents' ( (lv_orderedChildren_5_0= ruleXAgent ) )+ )? ( (otherlv_6= 'extends' ( ( ruleQualifiedName ) )+ ) | ( (otherlv_8= 'extend' | otherlv_9= 'ext' ) ( ( ruleQualifiedName ) ) ) | (otherlv_11= 'sets' ( (lv_orderedChildren_12_0= ruleXCarrierSet ) )+ ) | ( (lv_orderedChildren_13_0= ruleXIndividualCarrierSet ) ) | (otherlv_14= 'constants' ( (lv_orderedChildren_15_0= ruleXConstant ) )+ ) | ( (lv_orderedChildren_16_0= ruleXIndividualConstant ) ) | ( (lv_orderedChildren_17_0= ruleXRecord ) ) | (otherlv_18= 'axioms' ( (lv_orderedChildren_19_0= ruleXAxiom ) )+ ) | ( (lv_orderedChildren_20_0= ruleXIndividualAxiom ) ) | ( (lv_orderedChildren_21_0= ruleXIndividualTheorem ) ) )* (otherlv_22= 'end' )?
            {
            // InternalXContext.g:80:3: ()
            // InternalXContext.g:81:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXContextAccess().getContextAction_0(),
            					current);
            			

            }

            // InternalXContext.g:87:3: ( (lv_comment_1_0= RULE_STRING ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_STRING) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalXContext.g:88:4: (lv_comment_1_0= RULE_STRING )
                    {
                    // InternalXContext.g:88:4: (lv_comment_1_0= RULE_STRING )
                    // InternalXContext.g:89:5: lv_comment_1_0= RULE_STRING
                    {
                    lv_comment_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_3); 

                    					newLeafNode(lv_comment_1_0, grammarAccess.getXContextAccess().getCommentSTRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getXContextRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"comment",
                    						lv_comment_1_0,
                    						"ac.soton.xeventb.xcontext.XContext.STRING");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getXContextAccess().getContextKeyword_2());
            		
            // InternalXContext.g:109:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalXContext.g:110:4: (lv_name_3_0= RULE_ID )
            {
            // InternalXContext.g:110:4: (lv_name_3_0= RULE_ID )
            // InternalXContext.g:111:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					newLeafNode(lv_name_3_0, grammarAccess.getXContextAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXContextRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"ac.soton.xeventb.xcontext.XContext.ID");
            				

            }


            }

            // InternalXContext.g:127:3: (otherlv_4= 'agents' ( (lv_orderedChildren_5_0= ruleXAgent ) )+ )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalXContext.g:128:4: otherlv_4= 'agents' ( (lv_orderedChildren_5_0= ruleXAgent ) )+
                    {
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_4, grammarAccess.getXContextAccess().getAgentsKeyword_4_0());
                    			
                    // InternalXContext.g:132:4: ( (lv_orderedChildren_5_0= ruleXAgent ) )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalXContext.g:133:5: (lv_orderedChildren_5_0= ruleXAgent )
                    	    {
                    	    // InternalXContext.g:133:5: (lv_orderedChildren_5_0= ruleXAgent )
                    	    // InternalXContext.g:134:6: lv_orderedChildren_5_0= ruleXAgent
                    	    {

                    	    						newCompositeNode(grammarAccess.getXContextAccess().getOrderedChildrenXAgentParserRuleCall_4_1_0());
                    	    					
                    	    pushFollow(FollowSets000.FOLLOW_6);
                    	    lv_orderedChildren_5_0=ruleXAgent();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getXContextRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"orderedChildren",
                    	    							lv_orderedChildren_5_0,
                    	    							"ac.soton.xeventb.xcontext.XContext.XAgent");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    }
                    break;

            }

            // InternalXContext.g:152:3: ( (otherlv_6= 'extends' ( ( ruleQualifiedName ) )+ ) | ( (otherlv_8= 'extend' | otherlv_9= 'ext' ) ( ( ruleQualifiedName ) ) ) | (otherlv_11= 'sets' ( (lv_orderedChildren_12_0= ruleXCarrierSet ) )+ ) | ( (lv_orderedChildren_13_0= ruleXIndividualCarrierSet ) ) | (otherlv_14= 'constants' ( (lv_orderedChildren_15_0= ruleXConstant ) )+ ) | ( (lv_orderedChildren_16_0= ruleXIndividualConstant ) ) | ( (lv_orderedChildren_17_0= ruleXRecord ) ) | (otherlv_18= 'axioms' ( (lv_orderedChildren_19_0= ruleXAxiom ) )+ ) | ( (lv_orderedChildren_20_0= ruleXIndividualAxiom ) ) | ( (lv_orderedChildren_21_0= ruleXIndividualTheorem ) ) )*
            loop9:
            do {
                int alt9=11;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // InternalXContext.g:153:4: (otherlv_6= 'extends' ( ( ruleQualifiedName ) )+ )
            	    {
            	    // InternalXContext.g:153:4: (otherlv_6= 'extends' ( ( ruleQualifiedName ) )+ )
            	    // InternalXContext.g:154:5: otherlv_6= 'extends' ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_4); 

            	    					newLeafNode(otherlv_6, grammarAccess.getXContextAccess().getExtendsKeyword_5_0_0());
            	    				
            	    // InternalXContext.g:158:5: ( ( ruleQualifiedName ) )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==RULE_ID) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalXContext.g:159:6: ( ruleQualifiedName )
            	    	    {
            	    	    // InternalXContext.g:159:6: ( ruleQualifiedName )
            	    	    // InternalXContext.g:160:7: ruleQualifiedName
            	    	    {

            	    	    							if (current==null) {
            	    	    								current = createModelElement(grammarAccess.getXContextRule());
            	    	    							}
            	    	    						

            	    	    							newCompositeNode(grammarAccess.getXContextAccess().getExtendsContextCrossReference_5_0_1_0());
            	    	    						
            	    	    pushFollow(FollowSets000.FOLLOW_6);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;


            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt4 >= 1 ) break loop4;
            	                EarlyExitException eee =
            	                    new EarlyExitException(4, input);
            	                throw eee;
            	        }
            	        cnt4++;
            	    } while (true);


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalXContext.g:176:4: ( (otherlv_8= 'extend' | otherlv_9= 'ext' ) ( ( ruleQualifiedName ) ) )
            	    {
            	    // InternalXContext.g:176:4: ( (otherlv_8= 'extend' | otherlv_9= 'ext' ) ( ( ruleQualifiedName ) ) )
            	    // InternalXContext.g:177:5: (otherlv_8= 'extend' | otherlv_9= 'ext' ) ( ( ruleQualifiedName ) )
            	    {
            	    // InternalXContext.g:177:5: (otherlv_8= 'extend' | otherlv_9= 'ext' )
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==16) ) {
            	        alt5=1;
            	    }
            	    else if ( (LA5_0==17) ) {
            	        alt5=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // InternalXContext.g:178:6: otherlv_8= 'extend'
            	            {
            	            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_4); 

            	            						newLeafNode(otherlv_8, grammarAccess.getXContextAccess().getExtendKeyword_5_1_0_0());
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // InternalXContext.g:183:6: otherlv_9= 'ext'
            	            {
            	            otherlv_9=(Token)match(input,17,FollowSets000.FOLLOW_4); 

            	            						newLeafNode(otherlv_9, grammarAccess.getXContextAccess().getExtKeyword_5_1_0_1());
            	            					

            	            }
            	            break;

            	    }

            	    // InternalXContext.g:188:5: ( ( ruleQualifiedName ) )
            	    // InternalXContext.g:189:6: ( ruleQualifiedName )
            	    {
            	    // InternalXContext.g:189:6: ( ruleQualifiedName )
            	    // InternalXContext.g:190:7: ruleQualifiedName
            	    {

            	    							if (current==null) {
            	    								current = createModelElement(grammarAccess.getXContextRule());
            	    							}
            	    						

            	    							newCompositeNode(grammarAccess.getXContextAccess().getExtendsContextCrossReference_5_1_1_0());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    ruleQualifiedName();

            	    state._fsp--;


            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalXContext.g:206:4: (otherlv_11= 'sets' ( (lv_orderedChildren_12_0= ruleXCarrierSet ) )+ )
            	    {
            	    // InternalXContext.g:206:4: (otherlv_11= 'sets' ( (lv_orderedChildren_12_0= ruleXCarrierSet ) )+ )
            	    // InternalXContext.g:207:5: otherlv_11= 'sets' ( (lv_orderedChildren_12_0= ruleXCarrierSet ) )+
            	    {
            	    otherlv_11=(Token)match(input,18,FollowSets000.FOLLOW_8); 

            	    					newLeafNode(otherlv_11, grammarAccess.getXContextAccess().getSetsKeyword_5_2_0());
            	    				
            	    // InternalXContext.g:211:5: ( (lv_orderedChildren_12_0= ruleXCarrierSet ) )+
            	    int cnt6=0;
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==RULE_STRING) ) {
            	            int LA6_2 = input.LA(2);

            	            if ( (LA6_2==RULE_ID) ) {
            	                alt6=1;
            	            }


            	        }
            	        else if ( (LA6_0==RULE_ID) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalXContext.g:212:6: (lv_orderedChildren_12_0= ruleXCarrierSet )
            	    	    {
            	    	    // InternalXContext.g:212:6: (lv_orderedChildren_12_0= ruleXCarrierSet )
            	    	    // InternalXContext.g:213:7: lv_orderedChildren_12_0= ruleXCarrierSet
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getXContextAccess().getOrderedChildrenXCarrierSetParserRuleCall_5_2_1_0());
            	    	    						
            	    	    pushFollow(FollowSets000.FOLLOW_6);
            	    	    lv_orderedChildren_12_0=ruleXCarrierSet();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getXContextRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"orderedChildren",
            	    	    								lv_orderedChildren_12_0,
            	    	    								"ac.soton.xeventb.xcontext.XContext.XCarrierSet");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt6 >= 1 ) break loop6;
            	                EarlyExitException eee =
            	                    new EarlyExitException(6, input);
            	                throw eee;
            	        }
            	        cnt6++;
            	    } while (true);


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalXContext.g:232:4: ( (lv_orderedChildren_13_0= ruleXIndividualCarrierSet ) )
            	    {
            	    // InternalXContext.g:232:4: ( (lv_orderedChildren_13_0= ruleXIndividualCarrierSet ) )
            	    // InternalXContext.g:233:5: (lv_orderedChildren_13_0= ruleXIndividualCarrierSet )
            	    {
            	    // InternalXContext.g:233:5: (lv_orderedChildren_13_0= ruleXIndividualCarrierSet )
            	    // InternalXContext.g:234:6: lv_orderedChildren_13_0= ruleXIndividualCarrierSet
            	    {

            	    						newCompositeNode(grammarAccess.getXContextAccess().getOrderedChildrenXIndividualCarrierSetParserRuleCall_5_3_0());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_orderedChildren_13_0=ruleXIndividualCarrierSet();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getXContextRule());
            	    						}
            	    						add(
            	    							current,
            	    							"orderedChildren",
            	    							lv_orderedChildren_13_0,
            	    							"ac.soton.xeventb.xcontext.XContext.XIndividualCarrierSet");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalXContext.g:252:4: (otherlv_14= 'constants' ( (lv_orderedChildren_15_0= ruleXConstant ) )+ )
            	    {
            	    // InternalXContext.g:252:4: (otherlv_14= 'constants' ( (lv_orderedChildren_15_0= ruleXConstant ) )+ )
            	    // InternalXContext.g:253:5: otherlv_14= 'constants' ( (lv_orderedChildren_15_0= ruleXConstant ) )+
            	    {
            	    otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_8); 

            	    					newLeafNode(otherlv_14, grammarAccess.getXContextAccess().getConstantsKeyword_5_4_0());
            	    				
            	    // InternalXContext.g:257:5: ( (lv_orderedChildren_15_0= ruleXConstant ) )+
            	    int cnt7=0;
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==RULE_STRING) ) {
            	            int LA7_2 = input.LA(2);

            	            if ( (LA7_2==RULE_ID) ) {
            	                alt7=1;
            	            }


            	        }
            	        else if ( (LA7_0==RULE_ID) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // InternalXContext.g:258:6: (lv_orderedChildren_15_0= ruleXConstant )
            	    	    {
            	    	    // InternalXContext.g:258:6: (lv_orderedChildren_15_0= ruleXConstant )
            	    	    // InternalXContext.g:259:7: lv_orderedChildren_15_0= ruleXConstant
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getXContextAccess().getOrderedChildrenXConstantParserRuleCall_5_4_1_0());
            	    	    						
            	    	    pushFollow(FollowSets000.FOLLOW_6);
            	    	    lv_orderedChildren_15_0=ruleXConstant();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getXContextRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"orderedChildren",
            	    	    								lv_orderedChildren_15_0,
            	    	    								"ac.soton.xeventb.xcontext.XContext.XConstant");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt7 >= 1 ) break loop7;
            	                EarlyExitException eee =
            	                    new EarlyExitException(7, input);
            	                throw eee;
            	        }
            	        cnt7++;
            	    } while (true);


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalXContext.g:278:4: ( (lv_orderedChildren_16_0= ruleXIndividualConstant ) )
            	    {
            	    // InternalXContext.g:278:4: ( (lv_orderedChildren_16_0= ruleXIndividualConstant ) )
            	    // InternalXContext.g:279:5: (lv_orderedChildren_16_0= ruleXIndividualConstant )
            	    {
            	    // InternalXContext.g:279:5: (lv_orderedChildren_16_0= ruleXIndividualConstant )
            	    // InternalXContext.g:280:6: lv_orderedChildren_16_0= ruleXIndividualConstant
            	    {

            	    						newCompositeNode(grammarAccess.getXContextAccess().getOrderedChildrenXIndividualConstantParserRuleCall_5_5_0());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_orderedChildren_16_0=ruleXIndividualConstant();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getXContextRule());
            	    						}
            	    						add(
            	    							current,
            	    							"orderedChildren",
            	    							lv_orderedChildren_16_0,
            	    							"ac.soton.xeventb.xcontext.XContext.XIndividualConstant");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalXContext.g:298:4: ( (lv_orderedChildren_17_0= ruleXRecord ) )
            	    {
            	    // InternalXContext.g:298:4: ( (lv_orderedChildren_17_0= ruleXRecord ) )
            	    // InternalXContext.g:299:5: (lv_orderedChildren_17_0= ruleXRecord )
            	    {
            	    // InternalXContext.g:299:5: (lv_orderedChildren_17_0= ruleXRecord )
            	    // InternalXContext.g:300:6: lv_orderedChildren_17_0= ruleXRecord
            	    {

            	    						newCompositeNode(grammarAccess.getXContextAccess().getOrderedChildrenXRecordParserRuleCall_5_6_0());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_orderedChildren_17_0=ruleXRecord();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getXContextRule());
            	    						}
            	    						add(
            	    							current,
            	    							"orderedChildren",
            	    							lv_orderedChildren_17_0,
            	    							"ac.soton.xeventb.xcontext.XContext.XRecord");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalXContext.g:318:4: (otherlv_18= 'axioms' ( (lv_orderedChildren_19_0= ruleXAxiom ) )+ )
            	    {
            	    // InternalXContext.g:318:4: (otherlv_18= 'axioms' ( (lv_orderedChildren_19_0= ruleXAxiom ) )+ )
            	    // InternalXContext.g:319:5: otherlv_18= 'axioms' ( (lv_orderedChildren_19_0= ruleXAxiom ) )+
            	    {
            	    otherlv_18=(Token)match(input,20,FollowSets000.FOLLOW_9); 

            	    					newLeafNode(otherlv_18, grammarAccess.getXContextAccess().getAxiomsKeyword_5_7_0());
            	    				
            	    // InternalXContext.g:323:5: ( (lv_orderedChildren_19_0= ruleXAxiom ) )+
            	    int cnt8=0;
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==RULE_STRING) ) {
            	            int LA8_2 = input.LA(2);

            	            if ( (LA8_2==RULE_XLABEL) ) {
            	                alt8=1;
            	            }


            	        }
            	        else if ( (LA8_0==RULE_XLABEL) ) {
            	            alt8=1;
            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // InternalXContext.g:324:6: (lv_orderedChildren_19_0= ruleXAxiom )
            	    	    {
            	    	    // InternalXContext.g:324:6: (lv_orderedChildren_19_0= ruleXAxiom )
            	    	    // InternalXContext.g:325:7: lv_orderedChildren_19_0= ruleXAxiom
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getXContextAccess().getOrderedChildrenXAxiomParserRuleCall_5_7_1_0());
            	    	    						
            	    	    pushFollow(FollowSets000.FOLLOW_10);
            	    	    lv_orderedChildren_19_0=ruleXAxiom();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getXContextRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"orderedChildren",
            	    	    								lv_orderedChildren_19_0,
            	    	    								"ac.soton.xeventb.xcontext.XContext.XAxiom");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt8 >= 1 ) break loop8;
            	                EarlyExitException eee =
            	                    new EarlyExitException(8, input);
            	                throw eee;
            	        }
            	        cnt8++;
            	    } while (true);


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalXContext.g:344:4: ( (lv_orderedChildren_20_0= ruleXIndividualAxiom ) )
            	    {
            	    // InternalXContext.g:344:4: ( (lv_orderedChildren_20_0= ruleXIndividualAxiom ) )
            	    // InternalXContext.g:345:5: (lv_orderedChildren_20_0= ruleXIndividualAxiom )
            	    {
            	    // InternalXContext.g:345:5: (lv_orderedChildren_20_0= ruleXIndividualAxiom )
            	    // InternalXContext.g:346:6: lv_orderedChildren_20_0= ruleXIndividualAxiom
            	    {

            	    						newCompositeNode(grammarAccess.getXContextAccess().getOrderedChildrenXIndividualAxiomParserRuleCall_5_8_0());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_orderedChildren_20_0=ruleXIndividualAxiom();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getXContextRule());
            	    						}
            	    						add(
            	    							current,
            	    							"orderedChildren",
            	    							lv_orderedChildren_20_0,
            	    							"ac.soton.xeventb.xcontext.XContext.XIndividualAxiom");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // InternalXContext.g:364:4: ( (lv_orderedChildren_21_0= ruleXIndividualTheorem ) )
            	    {
            	    // InternalXContext.g:364:4: ( (lv_orderedChildren_21_0= ruleXIndividualTheorem ) )
            	    // InternalXContext.g:365:5: (lv_orderedChildren_21_0= ruleXIndividualTheorem )
            	    {
            	    // InternalXContext.g:365:5: (lv_orderedChildren_21_0= ruleXIndividualTheorem )
            	    // InternalXContext.g:366:6: lv_orderedChildren_21_0= ruleXIndividualTheorem
            	    {

            	    						newCompositeNode(grammarAccess.getXContextAccess().getOrderedChildrenXIndividualTheoremParserRuleCall_5_9_0());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_orderedChildren_21_0=ruleXIndividualTheorem();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getXContextRule());
            	    						}
            	    						add(
            	    							current,
            	    							"orderedChildren",
            	    							lv_orderedChildren_21_0,
            	    							"ac.soton.xeventb.xcontext.XContext.XIndividualTheorem");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // InternalXContext.g:384:3: (otherlv_22= 'end' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalXContext.g:385:4: otherlv_22= 'end'
                    {
                    otherlv_22=(Token)match(input,21,FollowSets000.FOLLOW_2); 

                    				newLeafNode(otherlv_22, grammarAccess.getXContextAccess().getEndKeyword_6());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXContext"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalXContext.g:394:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalXContext.g:394:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalXContext.g:395:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalXContext.g:401:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalXContext.g:407:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalXContext.g:408:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalXContext.g:408:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalXContext.g:409:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalXContext.g:416:3: (kw= '.' this_ID_2= RULE_ID )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==22) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalXContext.g:417:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,22,FollowSets000.FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleXAgent"
    // InternalXContext.g:434:1: entryRuleXAgent returns [EObject current=null] : iv_ruleXAgent= ruleXAgent EOF ;
    public final EObject entryRuleXAgent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAgent = null;


        try {
            // InternalXContext.g:434:47: (iv_ruleXAgent= ruleXAgent EOF )
            // InternalXContext.g:435:2: iv_ruleXAgent= ruleXAgent EOF
            {
             newCompositeNode(grammarAccess.getXAgentRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXAgent=ruleXAgent();

            state._fsp--;

             current =iv_ruleXAgent; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAgent"


    // $ANTLR start "ruleXAgent"
    // InternalXContext.g:441:1: ruleXAgent returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleXAgent() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalXContext.g:447:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalXContext.g:448:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalXContext.g:448:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalXContext.g:449:3: (lv_name_0_0= RULE_ID )
            {
            // InternalXContext.g:449:3: (lv_name_0_0= RULE_ID )
            // InternalXContext.g:450:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getXAgentAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getXAgentRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"ac.soton.xeventb.xcontext.XContext.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXAgent"


    // $ANTLR start "entryRuleXCarrierSet"
    // InternalXContext.g:469:1: entryRuleXCarrierSet returns [EObject current=null] : iv_ruleXCarrierSet= ruleXCarrierSet EOF ;
    public final EObject entryRuleXCarrierSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCarrierSet = null;


        try {
            // InternalXContext.g:469:52: (iv_ruleXCarrierSet= ruleXCarrierSet EOF )
            // InternalXContext.g:470:2: iv_ruleXCarrierSet= ruleXCarrierSet EOF
            {
             newCompositeNode(grammarAccess.getXCarrierSetRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXCarrierSet=ruleXCarrierSet();

            state._fsp--;

             current =iv_ruleXCarrierSet; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXCarrierSet"


    // $ANTLR start "ruleXCarrierSet"
    // InternalXContext.g:476:1: ruleXCarrierSet returns [EObject current=null] : ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleXCarrierSet() throws RecognitionException {
        EObject current = null;

        Token lv_comment_1_0=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalXContext.g:482:2: ( ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalXContext.g:483:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalXContext.g:483:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_ID ) ) )
            // InternalXContext.g:484:3: () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalXContext.g:484:3: ()
            // InternalXContext.g:485:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXCarrierSetAccess().getCarrierSetAction_0(),
            					current);
            			

            }

            // InternalXContext.g:491:3: ( (lv_comment_1_0= RULE_STRING ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_STRING) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalXContext.g:492:4: (lv_comment_1_0= RULE_STRING )
                    {
                    // InternalXContext.g:492:4: (lv_comment_1_0= RULE_STRING )
                    // InternalXContext.g:493:5: lv_comment_1_0= RULE_STRING
                    {
                    lv_comment_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_4); 

                    					newLeafNode(lv_comment_1_0, grammarAccess.getXCarrierSetAccess().getCommentSTRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getXCarrierSetRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"comment",
                    						lv_comment_1_0,
                    						"ac.soton.xeventb.xcontext.XContext.STRING");
                    				

                    }


                    }
                    break;

            }

            // InternalXContext.g:509:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalXContext.g:510:4: (lv_name_2_0= RULE_ID )
            {
            // InternalXContext.g:510:4: (lv_name_2_0= RULE_ID )
            // InternalXContext.g:511:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getXCarrierSetAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXCarrierSetRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"ac.soton.xeventb.xcontext.XContext.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXCarrierSet"


    // $ANTLR start "entryRuleXIndividualCarrierSet"
    // InternalXContext.g:531:1: entryRuleXIndividualCarrierSet returns [EObject current=null] : iv_ruleXIndividualCarrierSet= ruleXIndividualCarrierSet EOF ;
    public final EObject entryRuleXIndividualCarrierSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIndividualCarrierSet = null;


        try {
            // InternalXContext.g:531:62: (iv_ruleXIndividualCarrierSet= ruleXIndividualCarrierSet EOF )
            // InternalXContext.g:532:2: iv_ruleXIndividualCarrierSet= ruleXIndividualCarrierSet EOF
            {
             newCompositeNode(grammarAccess.getXIndividualCarrierSetRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXIndividualCarrierSet=ruleXIndividualCarrierSet();

            state._fsp--;

             current =iv_ruleXIndividualCarrierSet; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXIndividualCarrierSet"


    // $ANTLR start "ruleXIndividualCarrierSet"
    // InternalXContext.g:538:1: ruleXIndividualCarrierSet returns [EObject current=null] : ( () ( (lv_comment_1_0= RULE_STRING ) )? otherlv_2= 'set' ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleXIndividualCarrierSet() throws RecognitionException {
        EObject current = null;

        Token lv_comment_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;


        	enterRule();

        try {
            // InternalXContext.g:544:2: ( ( () ( (lv_comment_1_0= RULE_STRING ) )? otherlv_2= 'set' ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalXContext.g:545:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? otherlv_2= 'set' ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalXContext.g:545:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? otherlv_2= 'set' ( (lv_name_3_0= RULE_ID ) ) )
            // InternalXContext.g:546:3: () ( (lv_comment_1_0= RULE_STRING ) )? otherlv_2= 'set' ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalXContext.g:546:3: ()
            // InternalXContext.g:547:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXIndividualCarrierSetAccess().getCarrierSetAction_0(),
            					current);
            			

            }

            // InternalXContext.g:553:3: ( (lv_comment_1_0= RULE_STRING ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_STRING) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalXContext.g:554:4: (lv_comment_1_0= RULE_STRING )
                    {
                    // InternalXContext.g:554:4: (lv_comment_1_0= RULE_STRING )
                    // InternalXContext.g:555:5: lv_comment_1_0= RULE_STRING
                    {
                    lv_comment_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_12); 

                    					newLeafNode(lv_comment_1_0, grammarAccess.getXIndividualCarrierSetAccess().getCommentSTRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getXIndividualCarrierSetRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"comment",
                    						lv_comment_1_0,
                    						"ac.soton.xeventb.xcontext.XContext.STRING");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getXIndividualCarrierSetAccess().getSetKeyword_2());
            		
            // InternalXContext.g:575:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalXContext.g:576:4: (lv_name_3_0= RULE_ID )
            {
            // InternalXContext.g:576:4: (lv_name_3_0= RULE_ID )
            // InternalXContext.g:577:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_name_3_0, grammarAccess.getXIndividualCarrierSetAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXIndividualCarrierSetRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"ac.soton.xeventb.xcontext.XContext.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXIndividualCarrierSet"


    // $ANTLR start "entryRuleXConstant"
    // InternalXContext.g:597:1: entryRuleXConstant returns [EObject current=null] : iv_ruleXConstant= ruleXConstant EOF ;
    public final EObject entryRuleXConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstant = null;


        try {
            // InternalXContext.g:597:50: (iv_ruleXConstant= ruleXConstant EOF )
            // InternalXContext.g:598:2: iv_ruleXConstant= ruleXConstant EOF
            {
             newCompositeNode(grammarAccess.getXConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXConstant=ruleXConstant();

            state._fsp--;

             current =iv_ruleXConstant; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXConstant"


    // $ANTLR start "ruleXConstant"
    // InternalXContext.g:604:1: ruleXConstant returns [EObject current=null] : ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleXConstant() throws RecognitionException {
        EObject current = null;

        Token lv_comment_1_0=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalXContext.g:610:2: ( ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalXContext.g:611:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalXContext.g:611:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_ID ) ) )
            // InternalXContext.g:612:3: () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalXContext.g:612:3: ()
            // InternalXContext.g:613:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXConstantAccess().getConstantAction_0(),
            					current);
            			

            }

            // InternalXContext.g:619:3: ( (lv_comment_1_0= RULE_STRING ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_STRING) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalXContext.g:620:4: (lv_comment_1_0= RULE_STRING )
                    {
                    // InternalXContext.g:620:4: (lv_comment_1_0= RULE_STRING )
                    // InternalXContext.g:621:5: lv_comment_1_0= RULE_STRING
                    {
                    lv_comment_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_4); 

                    					newLeafNode(lv_comment_1_0, grammarAccess.getXConstantAccess().getCommentSTRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getXConstantRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"comment",
                    						lv_comment_1_0,
                    						"ac.soton.xeventb.xcontext.XContext.STRING");
                    				

                    }


                    }
                    break;

            }

            // InternalXContext.g:637:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalXContext.g:638:4: (lv_name_2_0= RULE_ID )
            {
            // InternalXContext.g:638:4: (lv_name_2_0= RULE_ID )
            // InternalXContext.g:639:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getXConstantAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXConstantRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"ac.soton.xeventb.xcontext.XContext.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXConstant"


    // $ANTLR start "entryRuleXIndividualConstant"
    // InternalXContext.g:659:1: entryRuleXIndividualConstant returns [EObject current=null] : iv_ruleXIndividualConstant= ruleXIndividualConstant EOF ;
    public final EObject entryRuleXIndividualConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIndividualConstant = null;


        try {
            // InternalXContext.g:659:60: (iv_ruleXIndividualConstant= ruleXIndividualConstant EOF )
            // InternalXContext.g:660:2: iv_ruleXIndividualConstant= ruleXIndividualConstant EOF
            {
             newCompositeNode(grammarAccess.getXIndividualConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXIndividualConstant=ruleXIndividualConstant();

            state._fsp--;

             current =iv_ruleXIndividualConstant; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXIndividualConstant"


    // $ANTLR start "ruleXIndividualConstant"
    // InternalXContext.g:666:1: ruleXIndividualConstant returns [EObject current=null] : ( () ( (lv_comment_1_0= RULE_STRING ) )? (otherlv_2= 'constant' | otherlv_3= 'cst' ) ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= ':' ( (lv_type_6_0= ruleXType ) ) )? (otherlv_7= '=' ( (lv_value_8_0= ruleXFormula ) ) )? ) ;
    public final EObject ruleXIndividualConstant() throws RecognitionException {
        EObject current = null;

        Token lv_comment_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_type_6_0 = null;

        AntlrDatatypeRuleToken lv_value_8_0 = null;



        	enterRule();

        try {
            // InternalXContext.g:672:2: ( ( () ( (lv_comment_1_0= RULE_STRING ) )? (otherlv_2= 'constant' | otherlv_3= 'cst' ) ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= ':' ( (lv_type_6_0= ruleXType ) ) )? (otherlv_7= '=' ( (lv_value_8_0= ruleXFormula ) ) )? ) )
            // InternalXContext.g:673:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? (otherlv_2= 'constant' | otherlv_3= 'cst' ) ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= ':' ( (lv_type_6_0= ruleXType ) ) )? (otherlv_7= '=' ( (lv_value_8_0= ruleXFormula ) ) )? )
            {
            // InternalXContext.g:673:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? (otherlv_2= 'constant' | otherlv_3= 'cst' ) ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= ':' ( (lv_type_6_0= ruleXType ) ) )? (otherlv_7= '=' ( (lv_value_8_0= ruleXFormula ) ) )? )
            // InternalXContext.g:674:3: () ( (lv_comment_1_0= RULE_STRING ) )? (otherlv_2= 'constant' | otherlv_3= 'cst' ) ( (lv_name_4_0= RULE_ID ) ) (otherlv_5= ':' ( (lv_type_6_0= ruleXType ) ) )? (otherlv_7= '=' ( (lv_value_8_0= ruleXFormula ) ) )?
            {
            // InternalXContext.g:674:3: ()
            // InternalXContext.g:675:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXIndividualConstantAccess().getTypedConstantAction_0(),
            					current);
            			

            }

            // InternalXContext.g:681:3: ( (lv_comment_1_0= RULE_STRING ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_STRING) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalXContext.g:682:4: (lv_comment_1_0= RULE_STRING )
                    {
                    // InternalXContext.g:682:4: (lv_comment_1_0= RULE_STRING )
                    // InternalXContext.g:683:5: lv_comment_1_0= RULE_STRING
                    {
                    lv_comment_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_13); 

                    					newLeafNode(lv_comment_1_0, grammarAccess.getXIndividualConstantAccess().getCommentSTRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getXIndividualConstantRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"comment",
                    						lv_comment_1_0,
                    						"ac.soton.xeventb.xcontext.XContext.STRING");
                    				

                    }


                    }
                    break;

            }

            // InternalXContext.g:699:3: (otherlv_2= 'constant' | otherlv_3= 'cst' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            else if ( (LA16_0==25) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalXContext.g:700:4: otherlv_2= 'constant'
                    {
                    otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getXIndividualConstantAccess().getConstantKeyword_2_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalXContext.g:705:4: otherlv_3= 'cst'
                    {
                    otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_3, grammarAccess.getXIndividualConstantAccess().getCstKeyword_2_1());
                    			

                    }
                    break;

            }

            // InternalXContext.g:710:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalXContext.g:711:4: (lv_name_4_0= RULE_ID )
            {
            // InternalXContext.g:711:4: (lv_name_4_0= RULE_ID )
            // InternalXContext.g:712:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); 

            					newLeafNode(lv_name_4_0, grammarAccess.getXIndividualConstantAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXIndividualConstantRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_4_0,
            						"ac.soton.xeventb.xcontext.XContext.ID");
            				

            }


            }

            // InternalXContext.g:728:3: (otherlv_5= ':' ( (lv_type_6_0= ruleXType ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalXContext.g:729:4: otherlv_5= ':' ( (lv_type_6_0= ruleXType ) )
                    {
                    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_15); 

                    				newLeafNode(otherlv_5, grammarAccess.getXIndividualConstantAccess().getColonKeyword_4_0());
                    			
                    // InternalXContext.g:733:4: ( (lv_type_6_0= ruleXType ) )
                    // InternalXContext.g:734:5: (lv_type_6_0= ruleXType )
                    {
                    // InternalXContext.g:734:5: (lv_type_6_0= ruleXType )
                    // InternalXContext.g:735:6: lv_type_6_0= ruleXType
                    {

                    						newCompositeNode(grammarAccess.getXIndividualConstantAccess().getTypeXTypeParserRuleCall_4_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_16);
                    lv_type_6_0=ruleXType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getXIndividualConstantRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_6_0,
                    							"ac.soton.xeventb.xcontext.XContext.XType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXContext.g:753:3: (otherlv_7= '=' ( (lv_value_8_0= ruleXFormula ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalXContext.g:754:4: otherlv_7= '=' ( (lv_value_8_0= ruleXFormula ) )
                    {
                    otherlv_7=(Token)match(input,27,FollowSets000.FOLLOW_17); 

                    				newLeafNode(otherlv_7, grammarAccess.getXIndividualConstantAccess().getEqualsSignKeyword_5_0());
                    			
                    // InternalXContext.g:758:4: ( (lv_value_8_0= ruleXFormula ) )
                    // InternalXContext.g:759:5: (lv_value_8_0= ruleXFormula )
                    {
                    // InternalXContext.g:759:5: (lv_value_8_0= ruleXFormula )
                    // InternalXContext.g:760:6: lv_value_8_0= ruleXFormula
                    {

                    						newCompositeNode(grammarAccess.getXIndividualConstantAccess().getValueXFormulaParserRuleCall_5_1_0());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_value_8_0=ruleXFormula();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getXIndividualConstantRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_8_0,
                    							"ac.soton.xeventb.xcontext.XContext.XFormula");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXIndividualConstant"


    // $ANTLR start "entryRuleXAxiom"
    // InternalXContext.g:782:1: entryRuleXAxiom returns [EObject current=null] : iv_ruleXAxiom= ruleXAxiom EOF ;
    public final EObject entryRuleXAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAxiom = null;


        try {
            // InternalXContext.g:782:47: (iv_ruleXAxiom= ruleXAxiom EOF )
            // InternalXContext.g:783:2: iv_ruleXAxiom= ruleXAxiom EOF
            {
             newCompositeNode(grammarAccess.getXAxiomRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXAxiom=ruleXAxiom();

            state._fsp--;

             current =iv_ruleXAxiom; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAxiom"


    // $ANTLR start "ruleXAxiom"
    // InternalXContext.g:789:1: ruleXAxiom returns [EObject current=null] : ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_XLABEL ) ) ( (lv_predicate_3_0= ruleXFormula ) ) ) ;
    public final EObject ruleXAxiom() throws RecognitionException {
        EObject current = null;

        Token lv_comment_1_0=null;
        Token lv_name_2_0=null;
        AntlrDatatypeRuleToken lv_predicate_3_0 = null;



        	enterRule();

        try {
            // InternalXContext.g:795:2: ( ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_XLABEL ) ) ( (lv_predicate_3_0= ruleXFormula ) ) ) )
            // InternalXContext.g:796:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_XLABEL ) ) ( (lv_predicate_3_0= ruleXFormula ) ) )
            {
            // InternalXContext.g:796:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_XLABEL ) ) ( (lv_predicate_3_0= ruleXFormula ) ) )
            // InternalXContext.g:797:3: () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_XLABEL ) ) ( (lv_predicate_3_0= ruleXFormula ) )
            {
            // InternalXContext.g:797:3: ()
            // InternalXContext.g:798:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXAxiomAccess().getAxiomAction_0(),
            					current);
            			

            }

            // InternalXContext.g:804:3: ( (lv_comment_1_0= RULE_STRING ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_STRING) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalXContext.g:805:4: (lv_comment_1_0= RULE_STRING )
                    {
                    // InternalXContext.g:805:4: (lv_comment_1_0= RULE_STRING )
                    // InternalXContext.g:806:5: lv_comment_1_0= RULE_STRING
                    {
                    lv_comment_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_18); 

                    					newLeafNode(lv_comment_1_0, grammarAccess.getXAxiomAccess().getCommentSTRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getXAxiomRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"comment",
                    						lv_comment_1_0,
                    						"ac.soton.xeventb.xcontext.XContext.STRING");
                    				

                    }


                    }
                    break;

            }

            // InternalXContext.g:822:3: ( (lv_name_2_0= RULE_XLABEL ) )
            // InternalXContext.g:823:4: (lv_name_2_0= RULE_XLABEL )
            {
            // InternalXContext.g:823:4: (lv_name_2_0= RULE_XLABEL )
            // InternalXContext.g:824:5: lv_name_2_0= RULE_XLABEL
            {
            lv_name_2_0=(Token)match(input,RULE_XLABEL,FollowSets000.FOLLOW_17); 

            					newLeafNode(lv_name_2_0, grammarAccess.getXAxiomAccess().getNameXLABELTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXAxiomRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"ac.soton.xeventb.xcontext.XContext.XLABEL");
            				

            }


            }

            // InternalXContext.g:840:3: ( (lv_predicate_3_0= ruleXFormula ) )
            // InternalXContext.g:841:4: (lv_predicate_3_0= ruleXFormula )
            {
            // InternalXContext.g:841:4: (lv_predicate_3_0= ruleXFormula )
            // InternalXContext.g:842:5: lv_predicate_3_0= ruleXFormula
            {

            					newCompositeNode(grammarAccess.getXAxiomAccess().getPredicateXFormulaParserRuleCall_3_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_predicate_3_0=ruleXFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getXAxiomRule());
            					}
            					set(
            						current,
            						"predicate",
            						lv_predicate_3_0,
            						"ac.soton.xeventb.xcontext.XContext.XFormula");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXAxiom"


    // $ANTLR start "entryRuleXIndividualAxiom"
    // InternalXContext.g:863:1: entryRuleXIndividualAxiom returns [EObject current=null] : iv_ruleXIndividualAxiom= ruleXIndividualAxiom EOF ;
    public final EObject entryRuleXIndividualAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIndividualAxiom = null;


        try {
            // InternalXContext.g:863:57: (iv_ruleXIndividualAxiom= ruleXIndividualAxiom EOF )
            // InternalXContext.g:864:2: iv_ruleXIndividualAxiom= ruleXIndividualAxiom EOF
            {
             newCompositeNode(grammarAccess.getXIndividualAxiomRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXIndividualAxiom=ruleXIndividualAxiom();

            state._fsp--;

             current =iv_ruleXIndividualAxiom; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXIndividualAxiom"


    // $ANTLR start "ruleXIndividualAxiom"
    // InternalXContext.g:870:1: ruleXIndividualAxiom returns [EObject current=null] : ( () ( (lv_comment_1_0= RULE_STRING ) )? (otherlv_2= 'axiom' | otherlv_3= 'axm' ) ( (lv_name_4_0= RULE_XLABEL ) ) ( (lv_predicate_5_0= ruleXFormula ) ) ) ;
    public final EObject ruleXIndividualAxiom() throws RecognitionException {
        EObject current = null;

        Token lv_comment_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        AntlrDatatypeRuleToken lv_predicate_5_0 = null;



        	enterRule();

        try {
            // InternalXContext.g:876:2: ( ( () ( (lv_comment_1_0= RULE_STRING ) )? (otherlv_2= 'axiom' | otherlv_3= 'axm' ) ( (lv_name_4_0= RULE_XLABEL ) ) ( (lv_predicate_5_0= ruleXFormula ) ) ) )
            // InternalXContext.g:877:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? (otherlv_2= 'axiom' | otherlv_3= 'axm' ) ( (lv_name_4_0= RULE_XLABEL ) ) ( (lv_predicate_5_0= ruleXFormula ) ) )
            {
            // InternalXContext.g:877:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? (otherlv_2= 'axiom' | otherlv_3= 'axm' ) ( (lv_name_4_0= RULE_XLABEL ) ) ( (lv_predicate_5_0= ruleXFormula ) ) )
            // InternalXContext.g:878:3: () ( (lv_comment_1_0= RULE_STRING ) )? (otherlv_2= 'axiom' | otherlv_3= 'axm' ) ( (lv_name_4_0= RULE_XLABEL ) ) ( (lv_predicate_5_0= ruleXFormula ) )
            {
            // InternalXContext.g:878:3: ()
            // InternalXContext.g:879:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXIndividualAxiomAccess().getAxiomAction_0(),
            					current);
            			

            }

            // InternalXContext.g:885:3: ( (lv_comment_1_0= RULE_STRING ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_STRING) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalXContext.g:886:4: (lv_comment_1_0= RULE_STRING )
                    {
                    // InternalXContext.g:886:4: (lv_comment_1_0= RULE_STRING )
                    // InternalXContext.g:887:5: lv_comment_1_0= RULE_STRING
                    {
                    lv_comment_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_19); 

                    					newLeafNode(lv_comment_1_0, grammarAccess.getXIndividualAxiomAccess().getCommentSTRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getXIndividualAxiomRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"comment",
                    						lv_comment_1_0,
                    						"ac.soton.xeventb.xcontext.XContext.STRING");
                    				

                    }


                    }
                    break;

            }

            // InternalXContext.g:903:3: (otherlv_2= 'axiom' | otherlv_3= 'axm' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            else if ( (LA21_0==29) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalXContext.g:904:4: otherlv_2= 'axiom'
                    {
                    otherlv_2=(Token)match(input,28,FollowSets000.FOLLOW_18); 

                    				newLeafNode(otherlv_2, grammarAccess.getXIndividualAxiomAccess().getAxiomKeyword_2_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalXContext.g:909:4: otherlv_3= 'axm'
                    {
                    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_18); 

                    				newLeafNode(otherlv_3, grammarAccess.getXIndividualAxiomAccess().getAxmKeyword_2_1());
                    			

                    }
                    break;

            }

            // InternalXContext.g:914:3: ( (lv_name_4_0= RULE_XLABEL ) )
            // InternalXContext.g:915:4: (lv_name_4_0= RULE_XLABEL )
            {
            // InternalXContext.g:915:4: (lv_name_4_0= RULE_XLABEL )
            // InternalXContext.g:916:5: lv_name_4_0= RULE_XLABEL
            {
            lv_name_4_0=(Token)match(input,RULE_XLABEL,FollowSets000.FOLLOW_17); 

            					newLeafNode(lv_name_4_0, grammarAccess.getXIndividualAxiomAccess().getNameXLABELTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXIndividualAxiomRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_4_0,
            						"ac.soton.xeventb.xcontext.XContext.XLABEL");
            				

            }


            }

            // InternalXContext.g:932:3: ( (lv_predicate_5_0= ruleXFormula ) )
            // InternalXContext.g:933:4: (lv_predicate_5_0= ruleXFormula )
            {
            // InternalXContext.g:933:4: (lv_predicate_5_0= ruleXFormula )
            // InternalXContext.g:934:5: lv_predicate_5_0= ruleXFormula
            {

            					newCompositeNode(grammarAccess.getXIndividualAxiomAccess().getPredicateXFormulaParserRuleCall_4_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_predicate_5_0=ruleXFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getXIndividualAxiomRule());
            					}
            					set(
            						current,
            						"predicate",
            						lv_predicate_5_0,
            						"ac.soton.xeventb.xcontext.XContext.XFormula");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXIndividualAxiom"


    // $ANTLR start "entryRuleXIndividualTheorem"
    // InternalXContext.g:955:1: entryRuleXIndividualTheorem returns [EObject current=null] : iv_ruleXIndividualTheorem= ruleXIndividualTheorem EOF ;
    public final EObject entryRuleXIndividualTheorem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIndividualTheorem = null;


        try {
            // InternalXContext.g:955:59: (iv_ruleXIndividualTheorem= ruleXIndividualTheorem EOF )
            // InternalXContext.g:956:2: iv_ruleXIndividualTheorem= ruleXIndividualTheorem EOF
            {
             newCompositeNode(grammarAccess.getXIndividualTheoremRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXIndividualTheorem=ruleXIndividualTheorem();

            state._fsp--;

             current =iv_ruleXIndividualTheorem; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXIndividualTheorem"


    // $ANTLR start "ruleXIndividualTheorem"
    // InternalXContext.g:962:1: ruleXIndividualTheorem returns [EObject current=null] : ( () ( (lv_comment_1_0= RULE_STRING ) )? ( ( (lv_theorem_2_1= 'theorem' | lv_theorem_2_2= 'thm' ) ) ) ( (lv_name_3_0= RULE_XLABEL ) ) ( (lv_predicate_4_0= ruleXFormula ) ) ) ;
    public final EObject ruleXIndividualTheorem() throws RecognitionException {
        EObject current = null;

        Token lv_comment_1_0=null;
        Token lv_theorem_2_1=null;
        Token lv_theorem_2_2=null;
        Token lv_name_3_0=null;
        AntlrDatatypeRuleToken lv_predicate_4_0 = null;



        	enterRule();

        try {
            // InternalXContext.g:968:2: ( ( () ( (lv_comment_1_0= RULE_STRING ) )? ( ( (lv_theorem_2_1= 'theorem' | lv_theorem_2_2= 'thm' ) ) ) ( (lv_name_3_0= RULE_XLABEL ) ) ( (lv_predicate_4_0= ruleXFormula ) ) ) )
            // InternalXContext.g:969:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? ( ( (lv_theorem_2_1= 'theorem' | lv_theorem_2_2= 'thm' ) ) ) ( (lv_name_3_0= RULE_XLABEL ) ) ( (lv_predicate_4_0= ruleXFormula ) ) )
            {
            // InternalXContext.g:969:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? ( ( (lv_theorem_2_1= 'theorem' | lv_theorem_2_2= 'thm' ) ) ) ( (lv_name_3_0= RULE_XLABEL ) ) ( (lv_predicate_4_0= ruleXFormula ) ) )
            // InternalXContext.g:970:3: () ( (lv_comment_1_0= RULE_STRING ) )? ( ( (lv_theorem_2_1= 'theorem' | lv_theorem_2_2= 'thm' ) ) ) ( (lv_name_3_0= RULE_XLABEL ) ) ( (lv_predicate_4_0= ruleXFormula ) )
            {
            // InternalXContext.g:970:3: ()
            // InternalXContext.g:971:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXIndividualTheoremAccess().getAxiomAction_0(),
            					current);
            			

            }

            // InternalXContext.g:977:3: ( (lv_comment_1_0= RULE_STRING ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_STRING) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalXContext.g:978:4: (lv_comment_1_0= RULE_STRING )
                    {
                    // InternalXContext.g:978:4: (lv_comment_1_0= RULE_STRING )
                    // InternalXContext.g:979:5: lv_comment_1_0= RULE_STRING
                    {
                    lv_comment_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_20); 

                    					newLeafNode(lv_comment_1_0, grammarAccess.getXIndividualTheoremAccess().getCommentSTRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getXIndividualTheoremRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"comment",
                    						lv_comment_1_0,
                    						"ac.soton.xeventb.xcontext.XContext.STRING");
                    				

                    }


                    }
                    break;

            }

            // InternalXContext.g:995:3: ( ( (lv_theorem_2_1= 'theorem' | lv_theorem_2_2= 'thm' ) ) )
            // InternalXContext.g:996:4: ( (lv_theorem_2_1= 'theorem' | lv_theorem_2_2= 'thm' ) )
            {
            // InternalXContext.g:996:4: ( (lv_theorem_2_1= 'theorem' | lv_theorem_2_2= 'thm' ) )
            // InternalXContext.g:997:5: (lv_theorem_2_1= 'theorem' | lv_theorem_2_2= 'thm' )
            {
            // InternalXContext.g:997:5: (lv_theorem_2_1= 'theorem' | lv_theorem_2_2= 'thm' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==30) ) {
                alt23=1;
            }
            else if ( (LA23_0==31) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalXContext.g:998:6: lv_theorem_2_1= 'theorem'
                    {
                    lv_theorem_2_1=(Token)match(input,30,FollowSets000.FOLLOW_18); 

                    						newLeafNode(lv_theorem_2_1, grammarAccess.getXIndividualTheoremAccess().getTheoremTheoremKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getXIndividualTheoremRule());
                    						}
                    						setWithLastConsumed(current, "theorem", lv_theorem_2_1 != null, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalXContext.g:1009:6: lv_theorem_2_2= 'thm'
                    {
                    lv_theorem_2_2=(Token)match(input,31,FollowSets000.FOLLOW_18); 

                    						newLeafNode(lv_theorem_2_2, grammarAccess.getXIndividualTheoremAccess().getTheoremThmKeyword_2_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getXIndividualTheoremRule());
                    						}
                    						setWithLastConsumed(current, "theorem", lv_theorem_2_2 != null, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalXContext.g:1022:3: ( (lv_name_3_0= RULE_XLABEL ) )
            // InternalXContext.g:1023:4: (lv_name_3_0= RULE_XLABEL )
            {
            // InternalXContext.g:1023:4: (lv_name_3_0= RULE_XLABEL )
            // InternalXContext.g:1024:5: lv_name_3_0= RULE_XLABEL
            {
            lv_name_3_0=(Token)match(input,RULE_XLABEL,FollowSets000.FOLLOW_17); 

            					newLeafNode(lv_name_3_0, grammarAccess.getXIndividualTheoremAccess().getNameXLABELTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXIndividualTheoremRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"ac.soton.xeventb.xcontext.XContext.XLABEL");
            				

            }


            }

            // InternalXContext.g:1040:3: ( (lv_predicate_4_0= ruleXFormula ) )
            // InternalXContext.g:1041:4: (lv_predicate_4_0= ruleXFormula )
            {
            // InternalXContext.g:1041:4: (lv_predicate_4_0= ruleXFormula )
            // InternalXContext.g:1042:5: lv_predicate_4_0= ruleXFormula
            {

            					newCompositeNode(grammarAccess.getXIndividualTheoremAccess().getPredicateXFormulaParserRuleCall_4_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_predicate_4_0=ruleXFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getXIndividualTheoremRule());
            					}
            					set(
            						current,
            						"predicate",
            						lv_predicate_4_0,
            						"ac.soton.xeventb.xcontext.XContext.XFormula");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXIndividualTheorem"


    // $ANTLR start "entryRuleXFormula"
    // InternalXContext.g:1063:1: entryRuleXFormula returns [String current=null] : iv_ruleXFormula= ruleXFormula EOF ;
    public final String entryRuleXFormula() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXFormula = null;


        try {
            // InternalXContext.g:1063:48: (iv_ruleXFormula= ruleXFormula EOF )
            // InternalXContext.g:1064:2: iv_ruleXFormula= ruleXFormula EOF
            {
             newCompositeNode(grammarAccess.getXFormulaRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXFormula=ruleXFormula();

            state._fsp--;

             current =iv_ruleXFormula.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXFormula"


    // $ANTLR start "ruleXFormula"
    // InternalXContext.g:1070:1: ruleXFormula returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD | this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS | this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS | this_ID_3= RULE_ID | this_INT_4= RULE_INT | this_UNTRANSLATED_TOKEN_5= RULE_UNTRANSLATED_TOKEN )+ ;
    public final AntlrDatatypeRuleToken ruleXFormula() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_3=null;
        Token this_INT_4=null;
        Token this_UNTRANSLATED_TOKEN_5=null;
        AntlrDatatypeRuleToken this_EVENTB_IDENTIFIER_KEYWORD_0 = null;

        AntlrDatatypeRuleToken this_EVENTB_PREDICATE_SYMBOLS_1 = null;

        AntlrDatatypeRuleToken this_EVENTB_EXPRESSION_SYMBOLS_2 = null;



        	enterRule();

        try {
            // InternalXContext.g:1076:2: ( (this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD | this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS | this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS | this_ID_3= RULE_ID | this_INT_4= RULE_INT | this_UNTRANSLATED_TOKEN_5= RULE_UNTRANSLATED_TOKEN )+ )
            // InternalXContext.g:1077:2: (this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD | this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS | this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS | this_ID_3= RULE_ID | this_INT_4= RULE_INT | this_UNTRANSLATED_TOKEN_5= RULE_UNTRANSLATED_TOKEN )+
            {
            // InternalXContext.g:1077:2: (this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD | this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS | this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS | this_ID_3= RULE_ID | this_INT_4= RULE_INT | this_UNTRANSLATED_TOKEN_5= RULE_UNTRANSLATED_TOKEN )+
            int cnt24=0;
            loop24:
            do {
                int alt24=7;
                switch ( input.LA(1) ) {
                case 44:
                case 45:
                case 46:
                case 47:
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
                    {
                    alt24=1;
                    }
                    break;
                case 22:
                case 26:
                case 27:
                case 48:
                case 49:
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
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                    {
                    alt24=2;
                    }
                    break;
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
                case 42:
                case 43:
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
                case 117:
                case 118:
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
                    {
                    alt24=3;
                    }
                    break;
                case RULE_ID:
                    {
                    alt24=4;
                    }
                    break;
                case RULE_INT:
                    {
                    alt24=5;
                    }
                    break;
                case RULE_UNTRANSLATED_TOKEN:
                    {
                    alt24=6;
                    }
                    break;

                }

                switch (alt24) {
            	case 1 :
            	    // InternalXContext.g:1078:3: this_EVENTB_IDENTIFIER_KEYWORD_0= ruleEVENTB_IDENTIFIER_KEYWORD
            	    {

            	    			newCompositeNode(grammarAccess.getXFormulaAccess().getEVENTB_IDENTIFIER_KEYWORDParserRuleCall_0());
            	    		
            	    pushFollow(FollowSets000.FOLLOW_21);
            	    this_EVENTB_IDENTIFIER_KEYWORD_0=ruleEVENTB_IDENTIFIER_KEYWORD();

            	    state._fsp--;


            	    			current.merge(this_EVENTB_IDENTIFIER_KEYWORD_0);
            	    		

            	    			afterParserOrEnumRuleCall();
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalXContext.g:1089:3: this_EVENTB_PREDICATE_SYMBOLS_1= ruleEVENTB_PREDICATE_SYMBOLS
            	    {

            	    			newCompositeNode(grammarAccess.getXFormulaAccess().getEVENTB_PREDICATE_SYMBOLSParserRuleCall_1());
            	    		
            	    pushFollow(FollowSets000.FOLLOW_21);
            	    this_EVENTB_PREDICATE_SYMBOLS_1=ruleEVENTB_PREDICATE_SYMBOLS();

            	    state._fsp--;


            	    			current.merge(this_EVENTB_PREDICATE_SYMBOLS_1);
            	    		

            	    			afterParserOrEnumRuleCall();
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalXContext.g:1100:3: this_EVENTB_EXPRESSION_SYMBOLS_2= ruleEVENTB_EXPRESSION_SYMBOLS
            	    {

            	    			newCompositeNode(grammarAccess.getXFormulaAccess().getEVENTB_EXPRESSION_SYMBOLSParserRuleCall_2());
            	    		
            	    pushFollow(FollowSets000.FOLLOW_21);
            	    this_EVENTB_EXPRESSION_SYMBOLS_2=ruleEVENTB_EXPRESSION_SYMBOLS();

            	    state._fsp--;


            	    			current.merge(this_EVENTB_EXPRESSION_SYMBOLS_2);
            	    		

            	    			afterParserOrEnumRuleCall();
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalXContext.g:1111:3: this_ID_3= RULE_ID
            	    {
            	    this_ID_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

            	    			current.merge(this_ID_3);
            	    		

            	    			newLeafNode(this_ID_3, grammarAccess.getXFormulaAccess().getIDTerminalRuleCall_3());
            	    		

            	    }
            	    break;
            	case 5 :
            	    // InternalXContext.g:1119:3: this_INT_4= RULE_INT
            	    {
            	    this_INT_4=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_21); 

            	    			current.merge(this_INT_4);
            	    		

            	    			newLeafNode(this_INT_4, grammarAccess.getXFormulaAccess().getINTTerminalRuleCall_4());
            	    		

            	    }
            	    break;
            	case 6 :
            	    // InternalXContext.g:1127:3: this_UNTRANSLATED_TOKEN_5= RULE_UNTRANSLATED_TOKEN
            	    {
            	    this_UNTRANSLATED_TOKEN_5=(Token)match(input,RULE_UNTRANSLATED_TOKEN,FollowSets000.FOLLOW_21); 

            	    			current.merge(this_UNTRANSLATED_TOKEN_5);
            	    		

            	    			newLeafNode(this_UNTRANSLATED_TOKEN_5, grammarAccess.getXFormulaAccess().getUNTRANSLATED_TOKENTerminalRuleCall_5());
            	    		

            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXFormula"


    // $ANTLR start "entryRuleXType"
    // InternalXContext.g:1138:1: entryRuleXType returns [String current=null] : iv_ruleXType= ruleXType EOF ;
    public final String entryRuleXType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXType = null;


        try {
            // InternalXContext.g:1138:45: (iv_ruleXType= ruleXType EOF )
            // InternalXContext.g:1139:2: iv_ruleXType= ruleXType EOF
            {
             newCompositeNode(grammarAccess.getXTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXType=ruleXType();

            state._fsp--;

             current =iv_ruleXType.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXType"


    // $ANTLR start "ruleXType"
    // InternalXContext.g:1145:1: ruleXType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_XTypePrimitive_0= ruleXTypePrimitive (this_XTYPEOPERATOR_1= ruleXTYPEOPERATOR this_XTypePrimitive_2= ruleXTypePrimitive )* ) ;
    public final AntlrDatatypeRuleToken ruleXType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_XTypePrimitive_0 = null;

        AntlrDatatypeRuleToken this_XTYPEOPERATOR_1 = null;

        AntlrDatatypeRuleToken this_XTypePrimitive_2 = null;



        	enterRule();

        try {
            // InternalXContext.g:1151:2: ( (this_XTypePrimitive_0= ruleXTypePrimitive (this_XTYPEOPERATOR_1= ruleXTYPEOPERATOR this_XTypePrimitive_2= ruleXTypePrimitive )* ) )
            // InternalXContext.g:1152:2: (this_XTypePrimitive_0= ruleXTypePrimitive (this_XTYPEOPERATOR_1= ruleXTYPEOPERATOR this_XTypePrimitive_2= ruleXTypePrimitive )* )
            {
            // InternalXContext.g:1152:2: (this_XTypePrimitive_0= ruleXTypePrimitive (this_XTYPEOPERATOR_1= ruleXTYPEOPERATOR this_XTypePrimitive_2= ruleXTypePrimitive )* )
            // InternalXContext.g:1153:3: this_XTypePrimitive_0= ruleXTypePrimitive (this_XTYPEOPERATOR_1= ruleXTYPEOPERATOR this_XTypePrimitive_2= ruleXTypePrimitive )*
            {

            			newCompositeNode(grammarAccess.getXTypeAccess().getXTypePrimitiveParserRuleCall_0());
            		
            pushFollow(FollowSets000.FOLLOW_22);
            this_XTypePrimitive_0=ruleXTypePrimitive();

            state._fsp--;


            			current.merge(this_XTypePrimitive_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalXContext.g:1163:3: (this_XTYPEOPERATOR_1= ruleXTYPEOPERATOR this_XTypePrimitive_2= ruleXTypePrimitive )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=32 && LA25_0<=43)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalXContext.g:1164:4: this_XTYPEOPERATOR_1= ruleXTYPEOPERATOR this_XTypePrimitive_2= ruleXTypePrimitive
            	    {

            	    				newCompositeNode(grammarAccess.getXTypeAccess().getXTYPEOPERATORParserRuleCall_1_0());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_15);
            	    this_XTYPEOPERATOR_1=ruleXTYPEOPERATOR();

            	    state._fsp--;


            	    				current.merge(this_XTYPEOPERATOR_1);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

            	    				newCompositeNode(grammarAccess.getXTypeAccess().getXTypePrimitiveParserRuleCall_1_1());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_22);
            	    this_XTypePrimitive_2=ruleXTypePrimitive();

            	    state._fsp--;


            	    				current.merge(this_XTypePrimitive_2);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXType"


    // $ANTLR start "entryRuleXTYPEOPERATOR"
    // InternalXContext.g:1189:1: entryRuleXTYPEOPERATOR returns [String current=null] : iv_ruleXTYPEOPERATOR= ruleXTYPEOPERATOR EOF ;
    public final String entryRuleXTYPEOPERATOR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXTYPEOPERATOR = null;


        try {
            // InternalXContext.g:1189:53: (iv_ruleXTYPEOPERATOR= ruleXTYPEOPERATOR EOF )
            // InternalXContext.g:1190:2: iv_ruleXTYPEOPERATOR= ruleXTYPEOPERATOR EOF
            {
             newCompositeNode(grammarAccess.getXTYPEOPERATORRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXTYPEOPERATOR=ruleXTYPEOPERATOR();

            state._fsp--;

             current =iv_ruleXTYPEOPERATOR.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXTYPEOPERATOR"


    // $ANTLR start "ruleXTYPEOPERATOR"
    // InternalXContext.g:1196:1: ruleXTYPEOPERATOR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '\\u00D7' ) ;
    public final AntlrDatatypeRuleToken ruleXTYPEOPERATOR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalXContext.g:1202:2: ( (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '\\u00D7' ) )
            // InternalXContext.g:1203:2: (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '\\u00D7' )
            {
            // InternalXContext.g:1203:2: (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '\\u00D7' )
            int alt26=12;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt26=1;
                }
                break;
            case 33:
                {
                alt26=2;
                }
                break;
            case 34:
                {
                alt26=3;
                }
                break;
            case 35:
                {
                alt26=4;
                }
                break;
            case 36:
                {
                alt26=5;
                }
                break;
            case 37:
                {
                alt26=6;
                }
                break;
            case 38:
                {
                alt26=7;
                }
                break;
            case 39:
                {
                alt26=8;
                }
                break;
            case 40:
                {
                alt26=9;
                }
                break;
            case 41:
                {
                alt26=10;
                }
                break;
            case 42:
                {
                alt26=11;
                }
                break;
            case 43:
                {
                alt26=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalXContext.g:1204:3: kw= '\\u2194'
                    {
                    kw=(Token)match(input,32,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getXTYPEOPERATORAccess().getLeftRightArrowKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalXContext.g:1210:3: kw= '\\uE100'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getXTYPEOPERATORAccess().getPrivateUseAreaE100Keyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalXContext.g:1216:3: kw= '\\uE101'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getXTYPEOPERATORAccess().getPrivateUseAreaE101Keyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalXContext.g:1222:3: kw= '\\uE102'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getXTYPEOPERATORAccess().getPrivateUseAreaE102Keyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalXContext.g:1228:3: kw= '\\u21F8'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowWithVerticalStrokeKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalXContext.g:1234:3: kw= '\\u2192'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalXContext.g:1240:3: kw= '\\u2914'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowWithTailWithVerticalStrokeKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalXContext.g:1246:3: kw= '\\u21A3'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getXTYPEOPERATORAccess().getRightwardsArrowWithTailKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalXContext.g:1252:3: kw= '\\u2900'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getXTYPEOPERATORAccess().getRightwardsTwoHeadedArrowWithVerticalStrokeKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalXContext.g:1258:3: kw= '\\u21A0'
                    {
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getXTYPEOPERATORAccess().getRightwardsTwoHeadedArrowKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalXContext.g:1264:3: kw= '\\u2916'
                    {
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getXTYPEOPERATORAccess().getRightwardsTwoHeadedArrowWithTailKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalXContext.g:1270:3: kw= '\\u00D7'
                    {
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getXTYPEOPERATORAccess().getMultiplicationSignKeyword_11());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXTYPEOPERATOR"


    // $ANTLR start "entryRuleXTypePrimitive"
    // InternalXContext.g:1279:1: entryRuleXTypePrimitive returns [String current=null] : iv_ruleXTypePrimitive= ruleXTypePrimitive EOF ;
    public final String entryRuleXTypePrimitive() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXTypePrimitive = null;


        try {
            // InternalXContext.g:1279:54: (iv_ruleXTypePrimitive= ruleXTypePrimitive EOF )
            // InternalXContext.g:1280:2: iv_ruleXTypePrimitive= ruleXTypePrimitive EOF
            {
             newCompositeNode(grammarAccess.getXTypePrimitiveRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXTypePrimitive=ruleXTypePrimitive();

            state._fsp--;

             current =iv_ruleXTypePrimitive.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXTypePrimitive"


    // $ANTLR start "ruleXTypePrimitive"
    // InternalXContext.g:1286:1: ruleXTypePrimitive returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= 'BOOL' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u2124' | (kw= '(' this_XType_6= ruleXType kw= ')' ) | (kw= '\\u2119' kw= '(' this_XType_10= ruleXType kw= ')' ) | (kw= '\\u21191' kw= '(' this_XType_14= ruleXType kw= ')' ) ) ;
    public final AntlrDatatypeRuleToken ruleXTypePrimitive() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_XType_6 = null;

        AntlrDatatypeRuleToken this_XType_10 = null;

        AntlrDatatypeRuleToken this_XType_14 = null;



        	enterRule();

        try {
            // InternalXContext.g:1292:2: ( (this_ID_0= RULE_ID | kw= 'BOOL' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u2124' | (kw= '(' this_XType_6= ruleXType kw= ')' ) | (kw= '\\u2119' kw= '(' this_XType_10= ruleXType kw= ')' ) | (kw= '\\u21191' kw= '(' this_XType_14= ruleXType kw= ')' ) ) )
            // InternalXContext.g:1293:2: (this_ID_0= RULE_ID | kw= 'BOOL' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u2124' | (kw= '(' this_XType_6= ruleXType kw= ')' ) | (kw= '\\u2119' kw= '(' this_XType_10= ruleXType kw= ')' ) | (kw= '\\u21191' kw= '(' this_XType_14= ruleXType kw= ')' ) )
            {
            // InternalXContext.g:1293:2: (this_ID_0= RULE_ID | kw= 'BOOL' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u2124' | (kw= '(' this_XType_6= ruleXType kw= ')' ) | (kw= '\\u2119' kw= '(' this_XType_10= ruleXType kw= ')' ) | (kw= '\\u21191' kw= '(' this_XType_14= ruleXType kw= ')' ) )
            int alt27=8;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt27=1;
                }
                break;
            case 44:
                {
                alt27=2;
                }
                break;
            case 45:
                {
                alt27=3;
                }
                break;
            case 46:
                {
                alt27=4;
                }
                break;
            case 47:
                {
                alt27=5;
                }
                break;
            case 48:
                {
                alt27=6;
                }
                break;
            case 50:
                {
                alt27=7;
                }
                break;
            case 51:
                {
                alt27=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalXContext.g:1294:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getXTypePrimitiveAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalXContext.g:1302:3: kw= 'BOOL'
                    {
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getXTypePrimitiveAccess().getBOOLKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalXContext.g:1308:3: kw= '\\u21151'
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalNDigitOneKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalXContext.g:1314:3: kw= '\\u2115'
                    {
                    kw=(Token)match(input,46,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalNKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalXContext.g:1320:3: kw= '\\u2124'
                    {
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalZKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalXContext.g:1326:3: (kw= '(' this_XType_6= ruleXType kw= ')' )
                    {
                    // InternalXContext.g:1326:3: (kw= '(' this_XType_6= ruleXType kw= ')' )
                    // InternalXContext.g:1327:4: kw= '(' this_XType_6= ruleXType kw= ')'
                    {
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_15); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getXTypePrimitiveAccess().getLeftParenthesisKeyword_5_0());
                    			

                    				newCompositeNode(grammarAccess.getXTypePrimitiveAccess().getXTypeParserRuleCall_5_1());
                    			
                    pushFollow(FollowSets000.FOLLOW_23);
                    this_XType_6=ruleXType();

                    state._fsp--;


                    				current.merge(this_XType_6);
                    			

                    				afterParserOrEnumRuleCall();
                    			
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getXTypePrimitiveAccess().getRightParenthesisKeyword_5_2());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalXContext.g:1349:3: (kw= '\\u2119' kw= '(' this_XType_10= ruleXType kw= ')' )
                    {
                    // InternalXContext.g:1349:3: (kw= '\\u2119' kw= '(' this_XType_10= ruleXType kw= ')' )
                    // InternalXContext.g:1350:4: kw= '\\u2119' kw= '(' this_XType_10= ruleXType kw= ')'
                    {
                    kw=(Token)match(input,50,FollowSets000.FOLLOW_24); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalPKeyword_6_0());
                    			
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_15); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getXTypePrimitiveAccess().getLeftParenthesisKeyword_6_1());
                    			

                    				newCompositeNode(grammarAccess.getXTypePrimitiveAccess().getXTypeParserRuleCall_6_2());
                    			
                    pushFollow(FollowSets000.FOLLOW_23);
                    this_XType_10=ruleXType();

                    state._fsp--;


                    				current.merge(this_XType_10);
                    			

                    				afterParserOrEnumRuleCall();
                    			
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getXTypePrimitiveAccess().getRightParenthesisKeyword_6_3());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalXContext.g:1377:3: (kw= '\\u21191' kw= '(' this_XType_14= ruleXType kw= ')' )
                    {
                    // InternalXContext.g:1377:3: (kw= '\\u21191' kw= '(' this_XType_14= ruleXType kw= ')' )
                    // InternalXContext.g:1378:4: kw= '\\u21191' kw= '(' this_XType_14= ruleXType kw= ')'
                    {
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_24); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getXTypePrimitiveAccess().getDoubleStruckCapitalPDigitOneKeyword_7_0());
                    			
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_15); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getXTypePrimitiveAccess().getLeftParenthesisKeyword_7_1());
                    			

                    				newCompositeNode(grammarAccess.getXTypePrimitiveAccess().getXTypeParserRuleCall_7_2());
                    			
                    pushFollow(FollowSets000.FOLLOW_23);
                    this_XType_14=ruleXType();

                    state._fsp--;


                    				current.merge(this_XType_14);
                    			

                    				afterParserOrEnumRuleCall();
                    			
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getXTypePrimitiveAccess().getRightParenthesisKeyword_7_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXTypePrimitive"


    // $ANTLR start "entryRuleEVENTB_IDENTIFIER_KEYWORD"
    // InternalXContext.g:1408:1: entryRuleEVENTB_IDENTIFIER_KEYWORD returns [String current=null] : iv_ruleEVENTB_IDENTIFIER_KEYWORD= ruleEVENTB_IDENTIFIER_KEYWORD EOF ;
    public final String entryRuleEVENTB_IDENTIFIER_KEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEVENTB_IDENTIFIER_KEYWORD = null;


        try {
            // InternalXContext.g:1408:65: (iv_ruleEVENTB_IDENTIFIER_KEYWORD= ruleEVENTB_IDENTIFIER_KEYWORD EOF )
            // InternalXContext.g:1409:2: iv_ruleEVENTB_IDENTIFIER_KEYWORD= ruleEVENTB_IDENTIFIER_KEYWORD EOF
            {
             newCompositeNode(grammarAccess.getEVENTB_IDENTIFIER_KEYWORDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEVENTB_IDENTIFIER_KEYWORD=ruleEVENTB_IDENTIFIER_KEYWORD();

            state._fsp--;

             current =iv_ruleEVENTB_IDENTIFIER_KEYWORD.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEVENTB_IDENTIFIER_KEYWORD"


    // $ANTLR start "ruleEVENTB_IDENTIFIER_KEYWORD"
    // InternalXContext.g:1415:1: ruleEVENTB_IDENTIFIER_KEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'BOOL' | kw= 'FALSE' | kw= 'TRUE' | kw= 'bool' | kw= 'card' | kw= 'dom' | kw= 'finite' | kw= 'id' | kw= 'inter' | kw= 'max' | kw= 'min' | kw= 'mod' | kw= 'pred' | kw= 'prj1' | kw= 'prj2' | kw= 'ran' | kw= 'succ' | kw= 'union' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u21191' | kw= '\\u2119' | kw= '\\u2124' ) ;
    public final AntlrDatatypeRuleToken ruleEVENTB_IDENTIFIER_KEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalXContext.g:1421:2: ( (kw= 'BOOL' | kw= 'FALSE' | kw= 'TRUE' | kw= 'bool' | kw= 'card' | kw= 'dom' | kw= 'finite' | kw= 'id' | kw= 'inter' | kw= 'max' | kw= 'min' | kw= 'mod' | kw= 'pred' | kw= 'prj1' | kw= 'prj2' | kw= 'ran' | kw= 'succ' | kw= 'union' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u21191' | kw= '\\u2119' | kw= '\\u2124' ) )
            // InternalXContext.g:1422:2: (kw= 'BOOL' | kw= 'FALSE' | kw= 'TRUE' | kw= 'bool' | kw= 'card' | kw= 'dom' | kw= 'finite' | kw= 'id' | kw= 'inter' | kw= 'max' | kw= 'min' | kw= 'mod' | kw= 'pred' | kw= 'prj1' | kw= 'prj2' | kw= 'ran' | kw= 'succ' | kw= 'union' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u21191' | kw= '\\u2119' | kw= '\\u2124' )
            {
            // InternalXContext.g:1422:2: (kw= 'BOOL' | kw= 'FALSE' | kw= 'TRUE' | kw= 'bool' | kw= 'card' | kw= 'dom' | kw= 'finite' | kw= 'id' | kw= 'inter' | kw= 'max' | kw= 'min' | kw= 'mod' | kw= 'pred' | kw= 'prj1' | kw= 'prj2' | kw= 'ran' | kw= 'succ' | kw= 'union' | kw= '\\u21151' | kw= '\\u2115' | kw= '\\u21191' | kw= '\\u2119' | kw= '\\u2124' )
            int alt28=23;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt28=1;
                }
                break;
            case 52:
                {
                alt28=2;
                }
                break;
            case 53:
                {
                alt28=3;
                }
                break;
            case 54:
                {
                alt28=4;
                }
                break;
            case 55:
                {
                alt28=5;
                }
                break;
            case 56:
                {
                alt28=6;
                }
                break;
            case 57:
                {
                alt28=7;
                }
                break;
            case 58:
                {
                alt28=8;
                }
                break;
            case 59:
                {
                alt28=9;
                }
                break;
            case 60:
                {
                alt28=10;
                }
                break;
            case 61:
                {
                alt28=11;
                }
                break;
            case 62:
                {
                alt28=12;
                }
                break;
            case 63:
                {
                alt28=13;
                }
                break;
            case 64:
                {
                alt28=14;
                }
                break;
            case 65:
                {
                alt28=15;
                }
                break;
            case 66:
                {
                alt28=16;
                }
                break;
            case 67:
                {
                alt28=17;
                }
                break;
            case 68:
                {
                alt28=18;
                }
                break;
            case 45:
                {
                alt28=19;
                }
                break;
            case 46:
                {
                alt28=20;
                }
                break;
            case 51:
                {
                alt28=21;
                }
                break;
            case 50:
                {
                alt28=22;
                }
                break;
            case 47:
                {
                alt28=23;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalXContext.g:1423:3: kw= 'BOOL'
                    {
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBOOLKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalXContext.g:1429:3: kw= 'FALSE'
                    {
                    kw=(Token)match(input,52,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFALSEKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalXContext.g:1435:3: kw= 'TRUE'
                    {
                    kw=(Token)match(input,53,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getTRUEKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalXContext.g:1441:3: kw= 'bool'
                    {
                    kw=(Token)match(input,54,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getBoolKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalXContext.g:1447:3: kw= 'card'
                    {
                    kw=(Token)match(input,55,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getCardKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalXContext.g:1453:3: kw= 'dom'
                    {
                    kw=(Token)match(input,56,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDomKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalXContext.g:1459:3: kw= 'finite'
                    {
                    kw=(Token)match(input,57,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getFiniteKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalXContext.g:1465:3: kw= 'id'
                    {
                    kw=(Token)match(input,58,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getIdKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalXContext.g:1471:3: kw= 'inter'
                    {
                    kw=(Token)match(input,59,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getInterKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalXContext.g:1477:3: kw= 'max'
                    {
                    kw=(Token)match(input,60,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMaxKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalXContext.g:1483:3: kw= 'min'
                    {
                    kw=(Token)match(input,61,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getMinKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalXContext.g:1489:3: kw= 'mod'
                    {
                    kw=(Token)match(input,62,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getModKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalXContext.g:1495:3: kw= 'pred'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPredKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalXContext.g:1501:3: kw= 'prj1'
                    {
                    kw=(Token)match(input,64,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj1Keyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalXContext.g:1507:3: kw= 'prj2'
                    {
                    kw=(Token)match(input,65,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getPrj2Keyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalXContext.g:1513:3: kw= 'ran'
                    {
                    kw=(Token)match(input,66,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getRanKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalXContext.g:1519:3: kw= 'succ'
                    {
                    kw=(Token)match(input,67,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getSuccKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalXContext.g:1525:3: kw= 'union'
                    {
                    kw=(Token)match(input,68,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getUnionKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalXContext.g:1531:3: kw= '\\u21151'
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNDigitOneKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalXContext.g:1537:3: kw= '\\u2115'
                    {
                    kw=(Token)match(input,46,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalNKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalXContext.g:1543:3: kw= '\\u21191'
                    {
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPDigitOneKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalXContext.g:1549:3: kw= '\\u2119'
                    {
                    kw=(Token)match(input,50,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalPKeyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalXContext.g:1555:3: kw= '\\u2124'
                    {
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_IDENTIFIER_KEYWORDAccess().getDoubleStruckCapitalZKeyword_22());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEVENTB_IDENTIFIER_KEYWORD"


    // $ANTLR start "entryRuleEVENTB_PREDICATE_SYMBOLS"
    // InternalXContext.g:1564:1: entryRuleEVENTB_PREDICATE_SYMBOLS returns [String current=null] : iv_ruleEVENTB_PREDICATE_SYMBOLS= ruleEVENTB_PREDICATE_SYMBOLS EOF ;
    public final String entryRuleEVENTB_PREDICATE_SYMBOLS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEVENTB_PREDICATE_SYMBOLS = null;


        try {
            // InternalXContext.g:1564:64: (iv_ruleEVENTB_PREDICATE_SYMBOLS= ruleEVENTB_PREDICATE_SYMBOLS EOF )
            // InternalXContext.g:1565:2: iv_ruleEVENTB_PREDICATE_SYMBOLS= ruleEVENTB_PREDICATE_SYMBOLS EOF
            {
             newCompositeNode(grammarAccess.getEVENTB_PREDICATE_SYMBOLSRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEVENTB_PREDICATE_SYMBOLS=ruleEVENTB_PREDICATE_SYMBOLS();

            state._fsp--;

             current =iv_ruleEVENTB_PREDICATE_SYMBOLS.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEVENTB_PREDICATE_SYMBOLS"


    // $ANTLR start "ruleEVENTB_PREDICATE_SYMBOLS"
    // InternalXContext.g:1571:1: ruleEVENTB_PREDICATE_SYMBOLS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '(' | kw= ')' | kw= '\\u21D4' | kw= '\\u21D2' | kw= '\\u2227' | kw= '&' | kw= '\\u2228' | kw= '\\u00AC' | kw= '\\u22A4' | kw= '\\u22A5' | kw= '\\u2200' | kw= '!' | kw= '\\u2203' | kw= '#' | kw= ',' | kw= '\\u00B7' | kw= '.' | kw= '=' | kw= '\\u2260' | kw= '\\u2264' | kw= '<' | kw= '\\u2265' | kw= '>' | kw= '\\u2208' | kw= ':' | kw= '\\u2209' | kw= '\\u2282' | kw= '\\u2284' | kw= '\\u2286' | kw= '\\u2288' | kw= 'partition' ) ;
    public final AntlrDatatypeRuleToken ruleEVENTB_PREDICATE_SYMBOLS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalXContext.g:1577:2: ( (kw= '(' | kw= ')' | kw= '\\u21D4' | kw= '\\u21D2' | kw= '\\u2227' | kw= '&' | kw= '\\u2228' | kw= '\\u00AC' | kw= '\\u22A4' | kw= '\\u22A5' | kw= '\\u2200' | kw= '!' | kw= '\\u2203' | kw= '#' | kw= ',' | kw= '\\u00B7' | kw= '.' | kw= '=' | kw= '\\u2260' | kw= '\\u2264' | kw= '<' | kw= '\\u2265' | kw= '>' | kw= '\\u2208' | kw= ':' | kw= '\\u2209' | kw= '\\u2282' | kw= '\\u2284' | kw= '\\u2286' | kw= '\\u2288' | kw= 'partition' ) )
            // InternalXContext.g:1578:2: (kw= '(' | kw= ')' | kw= '\\u21D4' | kw= '\\u21D2' | kw= '\\u2227' | kw= '&' | kw= '\\u2228' | kw= '\\u00AC' | kw= '\\u22A4' | kw= '\\u22A5' | kw= '\\u2200' | kw= '!' | kw= '\\u2203' | kw= '#' | kw= ',' | kw= '\\u00B7' | kw= '.' | kw= '=' | kw= '\\u2260' | kw= '\\u2264' | kw= '<' | kw= '\\u2265' | kw= '>' | kw= '\\u2208' | kw= ':' | kw= '\\u2209' | kw= '\\u2282' | kw= '\\u2284' | kw= '\\u2286' | kw= '\\u2288' | kw= 'partition' )
            {
            // InternalXContext.g:1578:2: (kw= '(' | kw= ')' | kw= '\\u21D4' | kw= '\\u21D2' | kw= '\\u2227' | kw= '&' | kw= '\\u2228' | kw= '\\u00AC' | kw= '\\u22A4' | kw= '\\u22A5' | kw= '\\u2200' | kw= '!' | kw= '\\u2203' | kw= '#' | kw= ',' | kw= '\\u00B7' | kw= '.' | kw= '=' | kw= '\\u2260' | kw= '\\u2264' | kw= '<' | kw= '\\u2265' | kw= '>' | kw= '\\u2208' | kw= ':' | kw= '\\u2209' | kw= '\\u2282' | kw= '\\u2284' | kw= '\\u2286' | kw= '\\u2288' | kw= 'partition' )
            int alt29=31;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt29=1;
                }
                break;
            case 49:
                {
                alt29=2;
                }
                break;
            case 69:
                {
                alt29=3;
                }
                break;
            case 70:
                {
                alt29=4;
                }
                break;
            case 71:
                {
                alt29=5;
                }
                break;
            case 72:
                {
                alt29=6;
                }
                break;
            case 73:
                {
                alt29=7;
                }
                break;
            case 74:
                {
                alt29=8;
                }
                break;
            case 75:
                {
                alt29=9;
                }
                break;
            case 76:
                {
                alt29=10;
                }
                break;
            case 77:
                {
                alt29=11;
                }
                break;
            case 78:
                {
                alt29=12;
                }
                break;
            case 79:
                {
                alt29=13;
                }
                break;
            case 80:
                {
                alt29=14;
                }
                break;
            case 81:
                {
                alt29=15;
                }
                break;
            case 82:
                {
                alt29=16;
                }
                break;
            case 22:
                {
                alt29=17;
                }
                break;
            case 27:
                {
                alt29=18;
                }
                break;
            case 83:
                {
                alt29=19;
                }
                break;
            case 84:
                {
                alt29=20;
                }
                break;
            case 85:
                {
                alt29=21;
                }
                break;
            case 86:
                {
                alt29=22;
                }
                break;
            case 87:
                {
                alt29=23;
                }
                break;
            case 88:
                {
                alt29=24;
                }
                break;
            case 26:
                {
                alt29=25;
                }
                break;
            case 89:
                {
                alt29=26;
                }
                break;
            case 90:
                {
                alt29=27;
                }
                break;
            case 91:
                {
                alt29=28;
                }
                break;
            case 92:
                {
                alt29=29;
                }
                break;
            case 93:
                {
                alt29=30;
                }
                break;
            case 94:
                {
                alt29=31;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalXContext.g:1579:3: kw= '('
                    {
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftParenthesisKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalXContext.g:1585:3: kw= ')'
                    {
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightParenthesisKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalXContext.g:1591:3: kw= '\\u21D4'
                    {
                    kw=(Token)match(input,69,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLeftRightDoubleArrowKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalXContext.g:1597:3: kw= '\\u21D2'
                    {
                    kw=(Token)match(input,70,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getRightwardsDoubleArrowKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalXContext.g:1603:3: kw= '\\u2227'
                    {
                    kw=(Token)match(input,71,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalAndKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalXContext.g:1609:3: kw= '&'
                    {
                    kw=(Token)match(input,72,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getAmpersandKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalXContext.g:1615:3: kw= '\\u2228'
                    {
                    kw=(Token)match(input,73,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLogicalOrKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalXContext.g:1621:3: kw= '\\u00AC'
                    {
                    kw=(Token)match(input,74,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotSignKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalXContext.g:1627:3: kw= '\\u22A4'
                    {
                    kw=(Token)match(input,75,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getDownTackKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalXContext.g:1633:3: kw= '\\u22A5'
                    {
                    kw=(Token)match(input,76,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getUpTackKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalXContext.g:1639:3: kw= '\\u2200'
                    {
                    kw=(Token)match(input,77,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getForAllKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalXContext.g:1645:3: kw= '!'
                    {
                    kw=(Token)match(input,78,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getExclamationMarkKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalXContext.g:1651:3: kw= '\\u2203'
                    {
                    kw=(Token)match(input,79,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getThereExistsKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalXContext.g:1657:3: kw= '#'
                    {
                    kw=(Token)match(input,80,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNumberSignKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalXContext.g:1663:3: kw= ','
                    {
                    kw=(Token)match(input,81,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getCommaKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalXContext.g:1669:3: kw= '\\u00B7'
                    {
                    kw=(Token)match(input,82,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getMiddleDotKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalXContext.g:1675:3: kw= '.'
                    {
                    kw=(Token)match(input,22,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getFullStopKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalXContext.g:1681:3: kw= '='
                    {
                    kw=(Token)match(input,27,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getEqualsSignKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalXContext.g:1687:3: kw= '\\u2260'
                    {
                    kw=(Token)match(input,83,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotEqualToKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalXContext.g:1693:3: kw= '\\u2264'
                    {
                    kw=(Token)match(input,84,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanOrEqualToKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalXContext.g:1699:3: kw= '<'
                    {
                    kw=(Token)match(input,85,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getLessThanSignKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalXContext.g:1705:3: kw= '\\u2265'
                    {
                    kw=(Token)match(input,86,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanOrEqualToKeyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalXContext.g:1711:3: kw= '>'
                    {
                    kw=(Token)match(input,87,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getGreaterThanSignKeyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalXContext.g:1717:3: kw= '\\u2208'
                    {
                    kw=(Token)match(input,88,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getElementOfKeyword_23());
                    		

                    }
                    break;
                case 25 :
                    // InternalXContext.g:1723:3: kw= ':'
                    {
                    kw=(Token)match(input,26,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getColonKeyword_24());
                    		

                    }
                    break;
                case 26 :
                    // InternalXContext.g:1729:3: kw= '\\u2209'
                    {
                    kw=(Token)match(input,89,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotAnElementOfKeyword_25());
                    		

                    }
                    break;
                case 27 :
                    // InternalXContext.g:1735:3: kw= '\\u2282'
                    {
                    kw=(Token)match(input,90,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfKeyword_26());
                    		

                    }
                    break;
                case 28 :
                    // InternalXContext.g:1741:3: kw= '\\u2284'
                    {
                    kw=(Token)match(input,91,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNotASubsetOfKeyword_27());
                    		

                    }
                    break;
                case 29 :
                    // InternalXContext.g:1747:3: kw= '\\u2286'
                    {
                    kw=(Token)match(input,92,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getSubsetOfOrEqualToKeyword_28());
                    		

                    }
                    break;
                case 30 :
                    // InternalXContext.g:1753:3: kw= '\\u2288'
                    {
                    kw=(Token)match(input,93,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getNeitherASubsetOfNorEqualToKeyword_29());
                    		

                    }
                    break;
                case 31 :
                    // InternalXContext.g:1759:3: kw= 'partition'
                    {
                    kw=(Token)match(input,94,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_PREDICATE_SYMBOLSAccess().getPartitionKeyword_30());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEVENTB_PREDICATE_SYMBOLS"


    // $ANTLR start "entryRuleEVENTB_EXPRESSION_SYMBOLS"
    // InternalXContext.g:1768:1: entryRuleEVENTB_EXPRESSION_SYMBOLS returns [String current=null] : iv_ruleEVENTB_EXPRESSION_SYMBOLS= ruleEVENTB_EXPRESSION_SYMBOLS EOF ;
    public final String entryRuleEVENTB_EXPRESSION_SYMBOLS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEVENTB_EXPRESSION_SYMBOLS = null;


        try {
            // InternalXContext.g:1768:65: (iv_ruleEVENTB_EXPRESSION_SYMBOLS= ruleEVENTB_EXPRESSION_SYMBOLS EOF )
            // InternalXContext.g:1769:2: iv_ruleEVENTB_EXPRESSION_SYMBOLS= ruleEVENTB_EXPRESSION_SYMBOLS EOF
            {
             newCompositeNode(grammarAccess.getEVENTB_EXPRESSION_SYMBOLSRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEVENTB_EXPRESSION_SYMBOLS=ruleEVENTB_EXPRESSION_SYMBOLS();

            state._fsp--;

             current =iv_ruleEVENTB_EXPRESSION_SYMBOLS.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEVENTB_EXPRESSION_SYMBOLS"


    // $ANTLR start "ruleEVENTB_EXPRESSION_SYMBOLS"
    // InternalXContext.g:1775:1: ruleEVENTB_EXPRESSION_SYMBOLS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '{' | kw= '}' | kw= '\\u21A6' | kw= '\\u2205' | kw= '\\u2229' | kw= '\\u222A' | kw= '\\u2216' | kw= '\\u00D7' | kw= '[' | kw= ']' | kw= '\\uE103' | kw= '\\u2218' | kw= ';' | kw= '\\u2297' | kw= '\\u2225' | kw= '\\u223C' | kw= '\\u25C1' | kw= '\\u2A64' | kw= '\\u25B7' | kw= '\\u2A65' | kw= '\\u03BB' | (kw= '%' kw= '\\u22C2' ) | kw= '\\u22C3' | kw= '\\u2223' | kw= '\\u2025' | kw= '+' | kw= '\\u2212' | kw= '-' | kw= '\\u2217' | kw= '*' | kw= '\\u00F7' | kw= '/' | kw= '^' | kw= '\\\\' ) ;
    public final AntlrDatatypeRuleToken ruleEVENTB_EXPRESSION_SYMBOLS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalXContext.g:1781:2: ( (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '{' | kw= '}' | kw= '\\u21A6' | kw= '\\u2205' | kw= '\\u2229' | kw= '\\u222A' | kw= '\\u2216' | kw= '\\u00D7' | kw= '[' | kw= ']' | kw= '\\uE103' | kw= '\\u2218' | kw= ';' | kw= '\\u2297' | kw= '\\u2225' | kw= '\\u223C' | kw= '\\u25C1' | kw= '\\u2A64' | kw= '\\u25B7' | kw= '\\u2A65' | kw= '\\u03BB' | (kw= '%' kw= '\\u22C2' ) | kw= '\\u22C3' | kw= '\\u2223' | kw= '\\u2025' | kw= '+' | kw= '\\u2212' | kw= '-' | kw= '\\u2217' | kw= '*' | kw= '\\u00F7' | kw= '/' | kw= '^' | kw= '\\\\' ) )
            // InternalXContext.g:1782:2: (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '{' | kw= '}' | kw= '\\u21A6' | kw= '\\u2205' | kw= '\\u2229' | kw= '\\u222A' | kw= '\\u2216' | kw= '\\u00D7' | kw= '[' | kw= ']' | kw= '\\uE103' | kw= '\\u2218' | kw= ';' | kw= '\\u2297' | kw= '\\u2225' | kw= '\\u223C' | kw= '\\u25C1' | kw= '\\u2A64' | kw= '\\u25B7' | kw= '\\u2A65' | kw= '\\u03BB' | (kw= '%' kw= '\\u22C2' ) | kw= '\\u22C3' | kw= '\\u2223' | kw= '\\u2025' | kw= '+' | kw= '\\u2212' | kw= '-' | kw= '\\u2217' | kw= '*' | kw= '\\u00F7' | kw= '/' | kw= '^' | kw= '\\\\' )
            {
            // InternalXContext.g:1782:2: (kw= '\\u2194' | kw= '\\uE100' | kw= '\\uE101' | kw= '\\uE102' | kw= '\\u21F8' | kw= '\\u2192' | kw= '\\u2914' | kw= '\\u21A3' | kw= '\\u2900' | kw= '\\u21A0' | kw= '\\u2916' | kw= '{' | kw= '}' | kw= '\\u21A6' | kw= '\\u2205' | kw= '\\u2229' | kw= '\\u222A' | kw= '\\u2216' | kw= '\\u00D7' | kw= '[' | kw= ']' | kw= '\\uE103' | kw= '\\u2218' | kw= ';' | kw= '\\u2297' | kw= '\\u2225' | kw= '\\u223C' | kw= '\\u25C1' | kw= '\\u2A64' | kw= '\\u25B7' | kw= '\\u2A65' | kw= '\\u03BB' | (kw= '%' kw= '\\u22C2' ) | kw= '\\u22C3' | kw= '\\u2223' | kw= '\\u2025' | kw= '+' | kw= '\\u2212' | kw= '-' | kw= '\\u2217' | kw= '*' | kw= '\\u00F7' | kw= '/' | kw= '^' | kw= '\\\\' )
            int alt30=45;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt30=1;
                }
                break;
            case 33:
                {
                alt30=2;
                }
                break;
            case 34:
                {
                alt30=3;
                }
                break;
            case 35:
                {
                alt30=4;
                }
                break;
            case 36:
                {
                alt30=5;
                }
                break;
            case 37:
                {
                alt30=6;
                }
                break;
            case 38:
                {
                alt30=7;
                }
                break;
            case 39:
                {
                alt30=8;
                }
                break;
            case 40:
                {
                alt30=9;
                }
                break;
            case 41:
                {
                alt30=10;
                }
                break;
            case 42:
                {
                alt30=11;
                }
                break;
            case 95:
                {
                alt30=12;
                }
                break;
            case 96:
                {
                alt30=13;
                }
                break;
            case 97:
                {
                alt30=14;
                }
                break;
            case 98:
                {
                alt30=15;
                }
                break;
            case 99:
                {
                alt30=16;
                }
                break;
            case 100:
                {
                alt30=17;
                }
                break;
            case 101:
                {
                alt30=18;
                }
                break;
            case 43:
                {
                alt30=19;
                }
                break;
            case 102:
                {
                alt30=20;
                }
                break;
            case 103:
                {
                alt30=21;
                }
                break;
            case 104:
                {
                alt30=22;
                }
                break;
            case 105:
                {
                alt30=23;
                }
                break;
            case 106:
                {
                alt30=24;
                }
                break;
            case 107:
                {
                alt30=25;
                }
                break;
            case 108:
                {
                alt30=26;
                }
                break;
            case 109:
                {
                alt30=27;
                }
                break;
            case 110:
                {
                alt30=28;
                }
                break;
            case 111:
                {
                alt30=29;
                }
                break;
            case 112:
                {
                alt30=30;
                }
                break;
            case 113:
                {
                alt30=31;
                }
                break;
            case 114:
                {
                alt30=32;
                }
                break;
            case 115:
                {
                alt30=33;
                }
                break;
            case 117:
                {
                alt30=34;
                }
                break;
            case 118:
                {
                alt30=35;
                }
                break;
            case 119:
                {
                alt30=36;
                }
                break;
            case 120:
                {
                alt30=37;
                }
                break;
            case 121:
                {
                alt30=38;
                }
                break;
            case 122:
                {
                alt30=39;
                }
                break;
            case 123:
                {
                alt30=40;
                }
                break;
            case 124:
                {
                alt30=41;
                }
                break;
            case 125:
                {
                alt30=42;
                }
                break;
            case 126:
                {
                alt30=43;
                }
                break;
            case 127:
                {
                alt30=44;
                }
                break;
            case 128:
                {
                alt30=45;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalXContext.g:1783:3: kw= '\\u2194'
                    {
                    kw=(Token)match(input,32,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftRightArrowKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalXContext.g:1789:3: kw= '\\uE100'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE100Keyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalXContext.g:1795:3: kw= '\\uE101'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE101Keyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalXContext.g:1801:3: kw= '\\uE102'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE102Keyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalXContext.g:1807:3: kw= '\\u21F8'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithVerticalStrokeKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalXContext.g:1813:3: kw= '\\u2192'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalXContext.g:1819:3: kw= '\\u2914'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailWithVerticalStrokeKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalXContext.g:1825:3: kw= '\\u21A3'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowWithTailKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalXContext.g:1831:3: kw= '\\u2900'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithVerticalStrokeKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalXContext.g:1837:3: kw= '\\u21A0'
                    {
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalXContext.g:1843:3: kw= '\\u2916'
                    {
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsTwoHeadedArrowWithTailKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalXContext.g:1849:3: kw= '{'
                    {
                    kw=(Token)match(input,95,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftCurlyBracketKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalXContext.g:1855:3: kw= '}'
                    {
                    kw=(Token)match(input,96,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightCurlyBracketKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalXContext.g:1861:3: kw= '\\u21A6'
                    {
                    kw=(Token)match(input,97,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightwardsArrowFromBarKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalXContext.g:1867:3: kw= '\\u2205'
                    {
                    kw=(Token)match(input,98,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getEmptySetKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalXContext.g:1873:3: kw= '\\u2229'
                    {
                    kw=(Token)match(input,99,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getIntersectionKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalXContext.g:1879:3: kw= '\\u222A'
                    {
                    kw=(Token)match(input,100,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getUnionKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalXContext.g:1885:3: kw= '\\u2216'
                    {
                    kw=(Token)match(input,101,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSetMinusKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalXContext.g:1891:3: kw= '\\u00D7'
                    {
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMultiplicationSignKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalXContext.g:1897:3: kw= '['
                    {
                    kw=(Token)match(input,102,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getLeftSquareBracketKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalXContext.g:1903:3: kw= ']'
                    {
                    kw=(Token)match(input,103,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRightSquareBracketKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalXContext.g:1909:3: kw= '\\uE103'
                    {
                    kw=(Token)match(input,104,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPrivateUseAreaE103Keyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalXContext.g:1915:3: kw= '\\u2218'
                    {
                    kw=(Token)match(input,105,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getRingOperatorKeyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalXContext.g:1921:3: kw= ';'
                    {
                    kw=(Token)match(input,106,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSemicolonKeyword_23());
                    		

                    }
                    break;
                case 25 :
                    // InternalXContext.g:1927:3: kw= '\\u2297'
                    {
                    kw=(Token)match(input,107,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircledTimesKeyword_24());
                    		

                    }
                    break;
                case 26 :
                    // InternalXContext.g:1933:3: kw= '\\u2225'
                    {
                    kw=(Token)match(input,108,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getParallelToKeyword_25());
                    		

                    }
                    break;
                case 27 :
                    // InternalXContext.g:1939:3: kw= '\\u223C'
                    {
                    kw=(Token)match(input,109,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTildeOperatorKeyword_26());
                    		

                    }
                    break;
                case 28 :
                    // InternalXContext.g:1945:3: kw= '\\u25C1'
                    {
                    kw=(Token)match(input,110,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteLeftPointingTriangleKeyword_27());
                    		

                    }
                    break;
                case 29 :
                    // InternalXContext.g:1951:3: kw= '\\u2A64'
                    {
                    kw=(Token)match(input,111,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationDomainAntirestrictionKeyword_28());
                    		

                    }
                    break;
                case 30 :
                    // InternalXContext.g:1957:3: kw= '\\u25B7'
                    {
                    kw=(Token)match(input,112,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getWhiteRightPointingTriangleKeyword_29());
                    		

                    }
                    break;
                case 31 :
                    // InternalXContext.g:1963:3: kw= '\\u2A65'
                    {
                    kw=(Token)match(input,113,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getZNotationRangeAntirestrictionKeyword_30());
                    		

                    }
                    break;
                case 32 :
                    // InternalXContext.g:1969:3: kw= '\\u03BB'
                    {
                    kw=(Token)match(input,114,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getGreekSmallLetterLamdaKeyword_31());
                    		

                    }
                    break;
                case 33 :
                    // InternalXContext.g:1975:3: (kw= '%' kw= '\\u22C2' )
                    {
                    // InternalXContext.g:1975:3: (kw= '%' kw= '\\u22C2' )
                    // InternalXContext.g:1976:4: kw= '%' kw= '\\u22C2'
                    {
                    kw=(Token)match(input,115,FollowSets000.FOLLOW_25); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPercentSignKeyword_32_0());
                    			
                    kw=(Token)match(input,116,FollowSets000.FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryIntersectionKeyword_32_1());
                    			

                    }


                    }
                    break;
                case 34 :
                    // InternalXContext.g:1988:3: kw= '\\u22C3'
                    {
                    kw=(Token)match(input,117,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getNAryUnionKeyword_33());
                    		

                    }
                    break;
                case 35 :
                    // InternalXContext.g:1994:3: kw= '\\u2223'
                    {
                    kw=(Token)match(input,118,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDividesKeyword_34());
                    		

                    }
                    break;
                case 36 :
                    // InternalXContext.g:2000:3: kw= '\\u2025'
                    {
                    kw=(Token)match(input,119,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getTwoDotLeaderKeyword_35());
                    		

                    }
                    break;
                case 37 :
                    // InternalXContext.g:2006:3: kw= '+'
                    {
                    kw=(Token)match(input,120,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getPlusSignKeyword_36());
                    		

                    }
                    break;
                case 38 :
                    // InternalXContext.g:2012:3: kw= '\\u2212'
                    {
                    kw=(Token)match(input,121,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getMinusSignKeyword_37());
                    		

                    }
                    break;
                case 39 :
                    // InternalXContext.g:2018:3: kw= '-'
                    {
                    kw=(Token)match(input,122,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getHyphenMinusKeyword_38());
                    		

                    }
                    break;
                case 40 :
                    // InternalXContext.g:2024:3: kw= '\\u2217'
                    {
                    kw=(Token)match(input,123,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskOperatorKeyword_39());
                    		

                    }
                    break;
                case 41 :
                    // InternalXContext.g:2030:3: kw= '*'
                    {
                    kw=(Token)match(input,124,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getAsteriskKeyword_40());
                    		

                    }
                    break;
                case 42 :
                    // InternalXContext.g:2036:3: kw= '\\u00F7'
                    {
                    kw=(Token)match(input,125,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getDivisionSignKeyword_41());
                    		

                    }
                    break;
                case 43 :
                    // InternalXContext.g:2042:3: kw= '/'
                    {
                    kw=(Token)match(input,126,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getSolidusKeyword_42());
                    		

                    }
                    break;
                case 44 :
                    // InternalXContext.g:2048:3: kw= '^'
                    {
                    kw=(Token)match(input,127,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getCircumflexAccentKeyword_43());
                    		

                    }
                    break;
                case 45 :
                    // InternalXContext.g:2054:3: kw= '\\\\'
                    {
                    kw=(Token)match(input,128,FollowSets000.FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEVENTB_EXPRESSION_SYMBOLSAccess().getBackslashKeyword_44());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEVENTB_EXPRESSION_SYMBOLS"


    // $ANTLR start "entryRuleXRecord"
    // InternalXContext.g:2063:1: entryRuleXRecord returns [EObject current=null] : iv_ruleXRecord= ruleXRecord EOF ;
    public final EObject entryRuleXRecord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRecord = null;


        try {
            // InternalXContext.g:2063:48: (iv_ruleXRecord= ruleXRecord EOF )
            // InternalXContext.g:2064:2: iv_ruleXRecord= ruleXRecord EOF
            {
             newCompositeNode(grammarAccess.getXRecordRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXRecord=ruleXRecord();

            state._fsp--;

             current =iv_ruleXRecord; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXRecord"


    // $ANTLR start "ruleXRecord"
    // InternalXContext.g:2070:1: ruleXRecord returns [EObject current=null] : ( () ( (lv_extended_1_0= 'extended' ) )? otherlv_2= 'record' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'inherits' ( (lv_inheritsNames_5_0= RULE_ID ) ) )? ( (otherlv_6= 'field' ( (lv_fields_7_0= ruleField ) ) ) | (otherlv_8= 'constraint' ( (lv_constraints_9_0= ruleXConstraint ) ) ) )* otherlv_10= 'end' ) ;
    public final EObject ruleXRecord() throws RecognitionException {
        EObject current = null;

        Token lv_extended_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token lv_inheritsNames_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_fields_7_0 = null;

        EObject lv_constraints_9_0 = null;



        	enterRule();

        try {
            // InternalXContext.g:2076:2: ( ( () ( (lv_extended_1_0= 'extended' ) )? otherlv_2= 'record' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'inherits' ( (lv_inheritsNames_5_0= RULE_ID ) ) )? ( (otherlv_6= 'field' ( (lv_fields_7_0= ruleField ) ) ) | (otherlv_8= 'constraint' ( (lv_constraints_9_0= ruleXConstraint ) ) ) )* otherlv_10= 'end' ) )
            // InternalXContext.g:2077:2: ( () ( (lv_extended_1_0= 'extended' ) )? otherlv_2= 'record' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'inherits' ( (lv_inheritsNames_5_0= RULE_ID ) ) )? ( (otherlv_6= 'field' ( (lv_fields_7_0= ruleField ) ) ) | (otherlv_8= 'constraint' ( (lv_constraints_9_0= ruleXConstraint ) ) ) )* otherlv_10= 'end' )
            {
            // InternalXContext.g:2077:2: ( () ( (lv_extended_1_0= 'extended' ) )? otherlv_2= 'record' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'inherits' ( (lv_inheritsNames_5_0= RULE_ID ) ) )? ( (otherlv_6= 'field' ( (lv_fields_7_0= ruleField ) ) ) | (otherlv_8= 'constraint' ( (lv_constraints_9_0= ruleXConstraint ) ) ) )* otherlv_10= 'end' )
            // InternalXContext.g:2078:3: () ( (lv_extended_1_0= 'extended' ) )? otherlv_2= 'record' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'inherits' ( (lv_inheritsNames_5_0= RULE_ID ) ) )? ( (otherlv_6= 'field' ( (lv_fields_7_0= ruleField ) ) ) | (otherlv_8= 'constraint' ( (lv_constraints_9_0= ruleXConstraint ) ) ) )* otherlv_10= 'end'
            {
            // InternalXContext.g:2078:3: ()
            // InternalXContext.g:2079:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXRecordAccess().getRecordAction_0(),
            					current);
            			

            }

            // InternalXContext.g:2085:3: ( (lv_extended_1_0= 'extended' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==129) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalXContext.g:2086:4: (lv_extended_1_0= 'extended' )
                    {
                    // InternalXContext.g:2086:4: (lv_extended_1_0= 'extended' )
                    // InternalXContext.g:2087:5: lv_extended_1_0= 'extended'
                    {
                    lv_extended_1_0=(Token)match(input,129,FollowSets000.FOLLOW_26); 

                    					newLeafNode(lv_extended_1_0, grammarAccess.getXRecordAccess().getExtendedExtendedKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getXRecordRule());
                    					}
                    					setWithLastConsumed(current, "extended", lv_extended_1_0 != null, "extended");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,130,FollowSets000.FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getXRecordAccess().getRecordKeyword_2());
            		
            // InternalXContext.g:2103:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalXContext.g:2104:4: (lv_name_3_0= RULE_ID )
            {
            // InternalXContext.g:2104:4: (lv_name_3_0= RULE_ID )
            // InternalXContext.g:2105:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_27); 

            					newLeafNode(lv_name_3_0, grammarAccess.getXRecordAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXRecordRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"ac.soton.xeventb.xcontext.XContext.ID");
            				

            }


            }

            // InternalXContext.g:2121:3: (otherlv_4= 'inherits' ( (lv_inheritsNames_5_0= RULE_ID ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==131) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalXContext.g:2122:4: otherlv_4= 'inherits' ( (lv_inheritsNames_5_0= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,131,FollowSets000.FOLLOW_4); 

                    				newLeafNode(otherlv_4, grammarAccess.getXRecordAccess().getInheritsKeyword_4_0());
                    			
                    // InternalXContext.g:2126:4: ( (lv_inheritsNames_5_0= RULE_ID ) )
                    // InternalXContext.g:2127:5: (lv_inheritsNames_5_0= RULE_ID )
                    {
                    // InternalXContext.g:2127:5: (lv_inheritsNames_5_0= RULE_ID )
                    // InternalXContext.g:2128:6: lv_inheritsNames_5_0= RULE_ID
                    {
                    lv_inheritsNames_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_28); 

                    						newLeafNode(lv_inheritsNames_5_0, grammarAccess.getXRecordAccess().getInheritsNamesIDTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getXRecordRule());
                    						}
                    						addWithLastConsumed(
                    							current,
                    							"inheritsNames",
                    							lv_inheritsNames_5_0,
                    							"ac.soton.xeventb.xcontext.XContext.ID");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalXContext.g:2145:3: ( (otherlv_6= 'field' ( (lv_fields_7_0= ruleField ) ) ) | (otherlv_8= 'constraint' ( (lv_constraints_9_0= ruleXConstraint ) ) ) )*
            loop33:
            do {
                int alt33=3;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==132) ) {
                    alt33=1;
                }
                else if ( (LA33_0==133) ) {
                    alt33=2;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalXContext.g:2146:4: (otherlv_6= 'field' ( (lv_fields_7_0= ruleField ) ) )
            	    {
            	    // InternalXContext.g:2146:4: (otherlv_6= 'field' ( (lv_fields_7_0= ruleField ) ) )
            	    // InternalXContext.g:2147:5: otherlv_6= 'field' ( (lv_fields_7_0= ruleField ) )
            	    {
            	    otherlv_6=(Token)match(input,132,FollowSets000.FOLLOW_8); 

            	    					newLeafNode(otherlv_6, grammarAccess.getXRecordAccess().getFieldKeyword_5_0_0());
            	    				
            	    // InternalXContext.g:2151:5: ( (lv_fields_7_0= ruleField ) )
            	    // InternalXContext.g:2152:6: (lv_fields_7_0= ruleField )
            	    {
            	    // InternalXContext.g:2152:6: (lv_fields_7_0= ruleField )
            	    // InternalXContext.g:2153:7: lv_fields_7_0= ruleField
            	    {

            	    							newCompositeNode(grammarAccess.getXRecordAccess().getFieldsFieldParserRuleCall_5_0_1_0());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_28);
            	    lv_fields_7_0=ruleField();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getXRecordRule());
            	    							}
            	    							add(
            	    								current,
            	    								"fields",
            	    								lv_fields_7_0,
            	    								"ac.soton.xeventb.xcontext.XContext.Field");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalXContext.g:2172:4: (otherlv_8= 'constraint' ( (lv_constraints_9_0= ruleXConstraint ) ) )
            	    {
            	    // InternalXContext.g:2172:4: (otherlv_8= 'constraint' ( (lv_constraints_9_0= ruleXConstraint ) ) )
            	    // InternalXContext.g:2173:5: otherlv_8= 'constraint' ( (lv_constraints_9_0= ruleXConstraint ) )
            	    {
            	    otherlv_8=(Token)match(input,133,FollowSets000.FOLLOW_9); 

            	    					newLeafNode(otherlv_8, grammarAccess.getXRecordAccess().getConstraintKeyword_5_1_0());
            	    				
            	    // InternalXContext.g:2177:5: ( (lv_constraints_9_0= ruleXConstraint ) )
            	    // InternalXContext.g:2178:6: (lv_constraints_9_0= ruleXConstraint )
            	    {
            	    // InternalXContext.g:2178:6: (lv_constraints_9_0= ruleXConstraint )
            	    // InternalXContext.g:2179:7: lv_constraints_9_0= ruleXConstraint
            	    {

            	    							newCompositeNode(grammarAccess.getXRecordAccess().getConstraintsXConstraintParserRuleCall_5_1_1_0());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_28);
            	    lv_constraints_9_0=ruleXConstraint();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getXRecordRule());
            	    							}
            	    							add(
            	    								current,
            	    								"constraints",
            	    								lv_constraints_9_0,
            	    								"ac.soton.xeventb.xcontext.XContext.XConstraint");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getXRecordAccess().getEndKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXRecord"


    // $ANTLR start "entryRuleFieldType"
    // InternalXContext.g:2206:1: entryRuleFieldType returns [String current=null] : iv_ruleFieldType= ruleFieldType EOF ;
    public final String entryRuleFieldType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFieldType = null;


        try {
            // InternalXContext.g:2206:49: (iv_ruleFieldType= ruleFieldType EOF )
            // InternalXContext.g:2207:2: iv_ruleFieldType= ruleFieldType EOF
            {
             newCompositeNode(grammarAccess.getFieldTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFieldType=ruleFieldType();

            state._fsp--;

             current =iv_ruleFieldType.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldType"


    // $ANTLR start "ruleFieldType"
    // InternalXContext.g:2213:1: ruleFieldType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_EVENTB_IDENTIFIER_KEYWORD_1= ruleEVENTB_IDENTIFIER_KEYWORD ) ;
    public final AntlrDatatypeRuleToken ruleFieldType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_EVENTB_IDENTIFIER_KEYWORD_1 = null;



        	enterRule();

        try {
            // InternalXContext.g:2219:2: ( (this_ID_0= RULE_ID | this_EVENTB_IDENTIFIER_KEYWORD_1= ruleEVENTB_IDENTIFIER_KEYWORD ) )
            // InternalXContext.g:2220:2: (this_ID_0= RULE_ID | this_EVENTB_IDENTIFIER_KEYWORD_1= ruleEVENTB_IDENTIFIER_KEYWORD )
            {
            // InternalXContext.g:2220:2: (this_ID_0= RULE_ID | this_EVENTB_IDENTIFIER_KEYWORD_1= ruleEVENTB_IDENTIFIER_KEYWORD )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ID) ) {
                alt34=1;
            }
            else if ( ((LA34_0>=44 && LA34_0<=47)||(LA34_0>=50 && LA34_0<=68)) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalXContext.g:2221:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getFieldTypeAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalXContext.g:2229:3: this_EVENTB_IDENTIFIER_KEYWORD_1= ruleEVENTB_IDENTIFIER_KEYWORD
                    {

                    			newCompositeNode(grammarAccess.getFieldTypeAccess().getEVENTB_IDENTIFIER_KEYWORDParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EVENTB_IDENTIFIER_KEYWORD_1=ruleEVENTB_IDENTIFIER_KEYWORD();

                    state._fsp--;


                    			current.merge(this_EVENTB_IDENTIFIER_KEYWORD_1);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldType"


    // $ANTLR start "entryRuleField"
    // InternalXContext.g:2243:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // InternalXContext.g:2243:46: (iv_ruleField= ruleField EOF )
            // InternalXContext.g:2244:2: iv_ruleField= ruleField EOF
            {
             newCompositeNode(grammarAccess.getFieldRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleField=ruleField();

            state._fsp--;

             current =iv_ruleField; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // InternalXContext.g:2250:1: ruleField returns [EObject current=null] : ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_multiplicity_4_0= ruleMultiplicity ) )? ( (lv_type_5_0= ruleFieldType ) ) ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token lv_comment_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Enumerator lv_multiplicity_4_0 = null;

        AntlrDatatypeRuleToken lv_type_5_0 = null;



        	enterRule();

        try {
            // InternalXContext.g:2256:2: ( ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_multiplicity_4_0= ruleMultiplicity ) )? ( (lv_type_5_0= ruleFieldType ) ) ) )
            // InternalXContext.g:2257:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_multiplicity_4_0= ruleMultiplicity ) )? ( (lv_type_5_0= ruleFieldType ) ) )
            {
            // InternalXContext.g:2257:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_multiplicity_4_0= ruleMultiplicity ) )? ( (lv_type_5_0= ruleFieldType ) ) )
            // InternalXContext.g:2258:3: () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_multiplicity_4_0= ruleMultiplicity ) )? ( (lv_type_5_0= ruleFieldType ) )
            {
            // InternalXContext.g:2258:3: ()
            // InternalXContext.g:2259:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFieldAccess().getFieldAction_0(),
            					current);
            			

            }

            // InternalXContext.g:2265:3: ( (lv_comment_1_0= RULE_STRING ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_STRING) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalXContext.g:2266:4: (lv_comment_1_0= RULE_STRING )
                    {
                    // InternalXContext.g:2266:4: (lv_comment_1_0= RULE_STRING )
                    // InternalXContext.g:2267:5: lv_comment_1_0= RULE_STRING
                    {
                    lv_comment_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_4); 

                    					newLeafNode(lv_comment_1_0, grammarAccess.getFieldAccess().getCommentSTRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getFieldRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"comment",
                    						lv_comment_1_0,
                    						"ac.soton.xeventb.xcontext.XContext.STRING");
                    				

                    }


                    }
                    break;

            }

            // InternalXContext.g:2283:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalXContext.g:2284:4: (lv_name_2_0= RULE_ID )
            {
            // InternalXContext.g:2284:4: (lv_name_2_0= RULE_ID )
            // InternalXContext.g:2285:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); 

            					newLeafNode(lv_name_2_0, grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFieldRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"ac.soton.xeventb.xcontext.XContext.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,26,FollowSets000.FOLLOW_30); 

            			newLeafNode(otherlv_3, grammarAccess.getFieldAccess().getColonKeyword_3());
            		
            // InternalXContext.g:2305:3: ( (lv_multiplicity_4_0= ruleMultiplicity ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=134 && LA36_0<=136)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalXContext.g:2306:4: (lv_multiplicity_4_0= ruleMultiplicity )
                    {
                    // InternalXContext.g:2306:4: (lv_multiplicity_4_0= ruleMultiplicity )
                    // InternalXContext.g:2307:5: lv_multiplicity_4_0= ruleMultiplicity
                    {

                    					newCompositeNode(grammarAccess.getFieldAccess().getMultiplicityMultiplicityEnumRuleCall_4_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_30);
                    lv_multiplicity_4_0=ruleMultiplicity();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getFieldRule());
                    					}
                    					set(
                    						current,
                    						"multiplicity",
                    						lv_multiplicity_4_0,
                    						"ac.soton.xeventb.xcontext.XContext.Multiplicity");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalXContext.g:2324:3: ( (lv_type_5_0= ruleFieldType ) )
            // InternalXContext.g:2325:4: (lv_type_5_0= ruleFieldType )
            {
            // InternalXContext.g:2325:4: (lv_type_5_0= ruleFieldType )
            // InternalXContext.g:2326:5: lv_type_5_0= ruleFieldType
            {

            					newCompositeNode(grammarAccess.getFieldAccess().getTypeFieldTypeParserRuleCall_5_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_type_5_0=ruleFieldType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFieldRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_5_0,
            						"ac.soton.xeventb.xcontext.XContext.FieldType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleXConstraint"
    // InternalXContext.g:2347:1: entryRuleXConstraint returns [EObject current=null] : iv_ruleXConstraint= ruleXConstraint EOF ;
    public final EObject entryRuleXConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstraint = null;


        try {
            // InternalXContext.g:2347:52: (iv_ruleXConstraint= ruleXConstraint EOF )
            // InternalXContext.g:2348:2: iv_ruleXConstraint= ruleXConstraint EOF
            {
             newCompositeNode(grammarAccess.getXConstraintRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleXConstraint=ruleXConstraint();

            state._fsp--;

             current =iv_ruleXConstraint; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXConstraint"


    // $ANTLR start "ruleXConstraint"
    // InternalXContext.g:2354:1: ruleXConstraint returns [EObject current=null] : ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_XLABEL ) ) ( (lv_predicate_3_0= ruleXFormula ) ) ) ;
    public final EObject ruleXConstraint() throws RecognitionException {
        EObject current = null;

        Token lv_comment_1_0=null;
        Token lv_name_2_0=null;
        AntlrDatatypeRuleToken lv_predicate_3_0 = null;



        	enterRule();

        try {
            // InternalXContext.g:2360:2: ( ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_XLABEL ) ) ( (lv_predicate_3_0= ruleXFormula ) ) ) )
            // InternalXContext.g:2361:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_XLABEL ) ) ( (lv_predicate_3_0= ruleXFormula ) ) )
            {
            // InternalXContext.g:2361:2: ( () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_XLABEL ) ) ( (lv_predicate_3_0= ruleXFormula ) ) )
            // InternalXContext.g:2362:3: () ( (lv_comment_1_0= RULE_STRING ) )? ( (lv_name_2_0= RULE_XLABEL ) ) ( (lv_predicate_3_0= ruleXFormula ) )
            {
            // InternalXContext.g:2362:3: ()
            // InternalXContext.g:2363:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXConstraintAccess().getConstraintAction_0(),
            					current);
            			

            }

            // InternalXContext.g:2369:3: ( (lv_comment_1_0= RULE_STRING ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_STRING) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalXContext.g:2370:4: (lv_comment_1_0= RULE_STRING )
                    {
                    // InternalXContext.g:2370:4: (lv_comment_1_0= RULE_STRING )
                    // InternalXContext.g:2371:5: lv_comment_1_0= RULE_STRING
                    {
                    lv_comment_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_18); 

                    					newLeafNode(lv_comment_1_0, grammarAccess.getXConstraintAccess().getCommentSTRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getXConstraintRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"comment",
                    						lv_comment_1_0,
                    						"ac.soton.xeventb.xcontext.XContext.STRING");
                    				

                    }


                    }
                    break;

            }

            // InternalXContext.g:2387:3: ( (lv_name_2_0= RULE_XLABEL ) )
            // InternalXContext.g:2388:4: (lv_name_2_0= RULE_XLABEL )
            {
            // InternalXContext.g:2388:4: (lv_name_2_0= RULE_XLABEL )
            // InternalXContext.g:2389:5: lv_name_2_0= RULE_XLABEL
            {
            lv_name_2_0=(Token)match(input,RULE_XLABEL,FollowSets000.FOLLOW_17); 

            					newLeafNode(lv_name_2_0, grammarAccess.getXConstraintAccess().getNameXLABELTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXConstraintRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"ac.soton.xeventb.xcontext.XContext.XLABEL");
            				

            }


            }

            // InternalXContext.g:2405:3: ( (lv_predicate_3_0= ruleXFormula ) )
            // InternalXContext.g:2406:4: (lv_predicate_3_0= ruleXFormula )
            {
            // InternalXContext.g:2406:4: (lv_predicate_3_0= ruleXFormula )
            // InternalXContext.g:2407:5: lv_predicate_3_0= ruleXFormula
            {

            					newCompositeNode(grammarAccess.getXConstraintAccess().getPredicateXFormulaParserRuleCall_3_0());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_predicate_3_0=ruleXFormula();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getXConstraintRule());
            					}
            					set(
            						current,
            						"predicate",
            						lv_predicate_3_0,
            						"ac.soton.xeventb.xcontext.XContext.XFormula");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXConstraint"


    // $ANTLR start "ruleMultiplicity"
    // InternalXContext.g:2428:1: ruleMultiplicity returns [Enumerator current=null] : ( (enumLiteral_0= 'one' ) | (enumLiteral_1= 'many' ) | (enumLiteral_2= 'opt' ) ) ;
    public final Enumerator ruleMultiplicity() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalXContext.g:2434:2: ( ( (enumLiteral_0= 'one' ) | (enumLiteral_1= 'many' ) | (enumLiteral_2= 'opt' ) ) )
            // InternalXContext.g:2435:2: ( (enumLiteral_0= 'one' ) | (enumLiteral_1= 'many' ) | (enumLiteral_2= 'opt' ) )
            {
            // InternalXContext.g:2435:2: ( (enumLiteral_0= 'one' ) | (enumLiteral_1= 'many' ) | (enumLiteral_2= 'opt' ) )
            int alt38=3;
            switch ( input.LA(1) ) {
            case 134:
                {
                alt38=1;
                }
                break;
            case 135:
                {
                alt38=2;
                }
                break;
            case 136:
                {
                alt38=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalXContext.g:2436:3: (enumLiteral_0= 'one' )
                    {
                    // InternalXContext.g:2436:3: (enumLiteral_0= 'one' )
                    // InternalXContext.g:2437:4: enumLiteral_0= 'one'
                    {
                    enumLiteral_0=(Token)match(input,134,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getMultiplicityAccess().getONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMultiplicityAccess().getONEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalXContext.g:2444:3: (enumLiteral_1= 'many' )
                    {
                    // InternalXContext.g:2444:3: (enumLiteral_1= 'many' )
                    // InternalXContext.g:2445:4: enumLiteral_1= 'many'
                    {
                    enumLiteral_1=(Token)match(input,135,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getMultiplicityAccess().getMANYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMultiplicityAccess().getMANYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalXContext.g:2452:3: (enumLiteral_2= 'opt' )
                    {
                    // InternalXContext.g:2452:3: (enumLiteral_2= 'opt' )
                    // InternalXContext.g:2453:4: enumLiteral_2= 'opt'
                    {
                    enumLiteral_2=(Token)match(input,136,FollowSets000.FOLLOW_2); 

                    				current = grammarAccess.getMultiplicityAccess().getOPTIONALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getMultiplicityAccess().getOPTIONALEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicity"

    // Delegated rules


    protected DFA9 dfa9 = new DFA9(this);
    static final String dfa_1s = "\15\uffff";
    static final String dfa_2s = "\1\1\14\uffff";
    static final String dfa_3s = "\1\4\4\uffff\1\27\7\uffff";
    static final String dfa_4s = "\1\u0082\4\uffff\1\37\7\uffff";
    static final String dfa_5s = "\1\uffff\1\13\1\1\1\2\1\3\1\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12";
    static final String dfa_6s = "\15\uffff}>";
    static final String[] dfa_7s = {
            "\1\5\12\uffff\1\2\2\3\1\4\1\7\1\12\1\1\1\uffff\1\6\2\10\2\uffff\2\13\2\14\141\uffff\2\11",
            "",
            "",
            "",
            "",
            "\1\6\2\10\2\uffff\2\13\2\14",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 152:3: ( (otherlv_6= 'extends' ( ( ruleQualifiedName ) )+ ) | ( (otherlv_8= 'extend' | otherlv_9= 'ext' ) ( ( ruleQualifiedName ) ) ) | (otherlv_11= 'sets' ( (lv_orderedChildren_12_0= ruleXCarrierSet ) )+ ) | ( (lv_orderedChildren_13_0= ruleXIndividualCarrierSet ) ) | (otherlv_14= 'constants' ( (lv_orderedChildren_15_0= ruleXConstant ) )+ ) | ( (lv_orderedChildren_16_0= ruleXIndividualConstant ) ) | ( (lv_orderedChildren_17_0= ruleXRecord ) ) | (otherlv_18= 'axioms' ( (lv_orderedChildren_19_0= ruleXAxiom ) )+ ) | ( (lv_orderedChildren_20_0= ruleXIndividualAxiom ) ) | ( (lv_orderedChildren_21_0= ruleXIndividualTheorem ) ) )*";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000F3BFC012L,0x0000000000000000L,0x0000000000000006L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000F3BF8032L,0x0000000000000000L,0x0000000000000006L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000F3BF8012L,0x0000000000000000L,0x0000000000000006L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000050L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000F3BF8052L,0x0000000000000000L,0x0000000000000006L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000000C000002L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000DF00000000020L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0xFFFFFFFF0C4001A0L,0xFFEFFFFFFFFFFFFFL,0x0000000000000001L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xFFFFFFFF0C4001A2L,0xFFEFFFFFFFFFFFFFL,0x0000000000000001L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000FFF00000002L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000000L,0x0000000000000038L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000000L,0x0000000000000030L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0xFFFCF00000000020L,0x000000000000001FL,0x00000000000001C0L});
    }


}