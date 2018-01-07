package leetcode.sheldon.contest.jan06;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sheldon Shao xshao@ebay.com on 1/6/18.
 * @version 1.0
 */
public class Contest2Test {
    @Test
    public void boldWords() throws Exception {
        Contest2 contest2 = new Contest2();
        assertEquals("a<b>abc</b>d", contest2.boldWords(new String[] { "ab", "bc"}, "aabcd"));
        assertEquals("a<b>ab</b>d<b>bc</b>d", contest2.boldWords(new String[] { "ab", "bc"}, "aabdbcd"));

        assertEquals("eeaa<b>d</b>a<b>d</b>a<b>dc</b>", contest2.boldWords(new String[] { "ccb","b","d","cba","dc"},
                "eeaadadadc"));

        assertEquals("<b>ww</b>cy<b>u</b>aq<b>zgtud</b>mp<b>j</b>kl<b>u</b>qoseslygy<b>wzk</b>i<b>xj</b>qg<b>h</b>soc<b>vjqigvxw</b>q<b>loyugfh</b>c<b>j</b>sc<b>j</b>g<b>h</b>qmigl<b>gyazwel</b>s<b>h</b>z<b>apa</b>ezqgmcm<b>r</b>mf<b>r</b>fz<b>ttd</b>gq<b>u</b>izyd<b>u</b>c<b>b</b>v<b>xzzuid</b>dcn<b>wu</b>aapd<b>u</b>nzl<b>b</b>agnifnd<b>bj</b>yalqqg<b>br</b>a<b>mhbivver</b>v<b>xr</b>tc<b>szszwigrlwzmu</b>teys<b>w</b>zag<b>u</b>dtp<b>vlrjmobuhozb</b>g<b>h</b>k<b>h</b>vo<b>xawcxmjn</b>azlqlkqqqnocl<b>u</b>fgkov<b>b</b>okvko<b>eze</b>kn<b>whcfg</b>cenvaa<b>b</b>lp<b>vtcejvzndtzn</b>c<b>r</b>el<b>h</b>ed<b>wlw</b>iqgd<b>b</b>d<b>gctgubzczgt</b>ov<b>u</b>fncic<b>jlwsmfd</b>c<b>r</b>qeag<b>huevyex</b>qd<b>hffikvecua</b>z<b>r</b>e<b>lofjmyjjznnj</b>dkim<b>bklrhsjusb</b>stq<b>h</b>vle<b>j</b>t<b>j</b>cczq<b>nzbvyfzxgaudyo</b>sckysmminoan<b>j</b>m<b>b</b>af<b>h</b>tn<b>brr</b>z<b>qagllwx</b>l<b>x</b>m<b>janyfelmwru</b>ftlz<b>uuhb</b>s<b>j</b>e<b>x</b>oo<b>bj</b>kmymliti<b>wj</b>td<b>x</b>scotzv<b>znvixpdhnsxsodi</b>eatipiaod<b>gcmdgyv</b>",
                contest2.boldWords(new String[]{"di","r","buhozb","lofjmyjj","qagllw","zzuid","loyugfh","w","hcfg","ttd","vjqigvx","u","mhbivve","x","nzbvyfzx","zs","j","zgtud","zm","huevyex","szwigrlwzm","vlrjmobu","b","h","gcmdgyv","anyfelm","vtcejv","myjjzn","jznnj","awcxmjn","lw","sju","szszwigrl","eze","ffikvecua","bklrhsju","gyazwel","pdhnsxsod","zn","rhsjus","zk","gctgu","vzndt","mfd","jlws","j","zxgaudyo","apa","znvixpdh","tgubzczgt"},
        "wwcyuaqzgtudmpjkluqoseslygywzkixjqghsocvjqigvxwqloyugfhcjscjghqmiglgyazwelshzapaezqgmcmrmfrfzttdgquizyducbvxzzuiddcnwuaapdunzlbagnifndbjyalqqgbramhbivvervxrtcszszwigrlwzmuteyswzagudtpvlrjmobuhozbghkhvoxawcxmjnazlqlkqqqnoclufgkovbokvkoezeknwhcfgcenvaablpvtcejvzndtzncrelhedwlwiqgdbdgctgubzczgtovufncicjlwsmfdcrqeaghuevyexqdhffikvecuazrelofjmyjjznnjdkimbklrhsjusbstqhvlejtjcczqnzbvyfzxgaudyosckysmminoanjmbafhtnbrrzqagllwxlxmjanyfelmwruftlzuuhbsjexoobjkmymlitiwjtdxscotzvznvixpdhnsxsodieatipiaodgcmdgyv"));
    }

}