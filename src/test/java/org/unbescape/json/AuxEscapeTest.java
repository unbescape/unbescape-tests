/*
 * =============================================================================
 * 
 *   Copyright (c) 2014, The UNBESCAPE team (http://www.unbescape.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.unbescape.json;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public class AuxEscapeTest {







    @Test
    public void testToUHexa() throws Exception {

        {
            final String uhexa2FF =
                    "0000000100020003000400050006000700080009000A000B000C000D000E000F0010001100120013001400150016001700180019001A001B001C001D001E001F0020002100220023002400250026002700280029002A002B002C002D002E002F0030003100320033003400350036003700380039003A003B003C003D003E003F0040004100420043004400450046004700480049004A004B004C004D004E004F0050005100520053005400550056005700580059005A005B005C005D005E005F0060006100620063006400650066006700680069006A006B006C006D006E006F0070007100720073007400750076007700780079007A007B007C007D007E007F0080008100820083008400850086008700880089008A008B008C008D008E008F0090009100920093009400950096009700980099009A009B009C009D009E009F00A000A100A200A300A400A500A600A700A800A900AA00AB00AC00AD00AE00AF00B000B100B200B300B400B500B600B700B800B900BA00BB00BC00BD00BE00BF00C000C100C200C300C400C500C600C700C800C900CA00CB00CC00CD00CE00CF00D000D100D200D300D400D500D600D700D800D900DA00DB00DC00DD00DE00DF00E000E100E200E300E400E500E600E700E800E900EA00EB00EC00ED00EE00EF00F000F100F200F300F400F500F600F700F800F900FA00FB00FC00FD00FE00FF0100010101020103010401050106010701080109010A010B010C010D010E010F0110011101120113011401150116011701180119011A011B011C011D011E011F0120012101220123012401250126012701280129012A012B012C012D012E012F0130013101320133013401350136013701380139013A013B013C013D013E013F0140014101420143014401450146014701480149014A014B014C014D014E014F0150015101520153015401550156015701580159015A015B015C015D015E015F0160016101620163016401650166016701680169016A016B016C016D016E016F0170017101720173017401750176017701780179017A017B017C017D017E017F0180018101820183018401850186018701880189018A018B018C018D018E018F0190019101920193019401950196019701980199019A019B019C019D019E019F01A001A101A201A301A401A501A601A701A801A901AA01AB01AC01AD01AE01AF01B001B101B201B301B401B501B601B701B801B901BA01BB01BC01BD01BE01BF01C001C101C201C301C401C501C601C701C801C901CA01CB01CC01CD01CE01CF01D001D101D201D301D401D501D601D701D801D901DA01DB01DC01DD01DE01DF01E001E101E201E301E401E501E601E701E801E901EA01EB01EC01ED01EE01EF01F001F101F201F301F401F501F601F701F801F901FA01FB01FC01FD01FE01FF0200020102020203020402050206020702080209020A020B020C020D020E020F0210021102120213021402150216021702180219021A021B021C021D021E021F0220022102220223022402250226022702280229022A022B022C022D022E022F0230023102320233023402350236023702380239023A023B023C023D023E023F0240024102420243024402450246024702480249024A024B024C024D024E024F0250025102520253025402550256025702580259025A025B025C025D025E025F0260026102620263026402650266026702680269026A026B026C026D026E026F0270027102720273027402750276027702780279027A027B027C027D027E027F0280028102820283028402850286028702880289028A028B028C028D028E028F0290029102920293029402950296029702980299029A029B029C029D029E029F02A002A102A202A302A402A502A602A702A802A902AA02AB02AC02AD02AE02AF02B002B102B202B302B402B502B602B702B802B902BA02BB02BC02BD02BE02BF02C002C102C202C302C402C502C602C702C802C902CA02CB02CC02CD02CE02CF02D002D102D202D302D402D502D602D702D802D902DA02DB02DC02DD02DE02DF02E002E102E202E302E402E502E602E702E802E902EA02EB02EC02ED02EE02EF02F002F102F202F302F402F502F602F702F802F902FA02FB02FC02FD02FE02FF";

            final StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i <= 0x02FF; i++) {
                strBuilder.append(JSONEscapeUtil.toUHexa(i));
            }

            final String result = strBuilder.toString();
            Assert.assertEquals(uhexa2FF, result);
        }

        {
            final String uhexaFFFF =
                    "FE00FE01FE02FE03FE04FE05FE06FE07FE08FE09FE0AFE0BFE0CFE0DFE0EFE0FFE10FE11FE12FE13FE14FE15FE16FE17FE18FE19FE1AFE1BFE1CFE1DFE1EFE1FFE20FE21FE22FE23FE24FE25FE26FE27FE28FE29FE2AFE2BFE2CFE2DFE2EFE2FFE30FE31FE32FE33FE34FE35FE36FE37FE38FE39FE3AFE3BFE3CFE3DFE3EFE3FFE40FE41FE42FE43FE44FE45FE46FE47FE48FE49FE4AFE4BFE4CFE4DFE4EFE4FFE50FE51FE52FE53FE54FE55FE56FE57FE58FE59FE5AFE5BFE5CFE5DFE5EFE5FFE60FE61FE62FE63FE64FE65FE66FE67FE68FE69FE6AFE6BFE6CFE6DFE6EFE6FFE70FE71FE72FE73FE74FE75FE76FE77FE78FE79FE7AFE7BFE7CFE7DFE7EFE7FFE80FE81FE82FE83FE84FE85FE86FE87FE88FE89FE8AFE8BFE8CFE8DFE8EFE8FFE90FE91FE92FE93FE94FE95FE96FE97FE98FE99FE9AFE9BFE9CFE9DFE9EFE9FFEA0FEA1FEA2FEA3FEA4FEA5FEA6FEA7FEA8FEA9FEAAFEABFEACFEADFEAEFEAFFEB0FEB1FEB2FEB3FEB4FEB5FEB6FEB7FEB8FEB9FEBAFEBBFEBCFEBDFEBEFEBFFEC0FEC1FEC2FEC3FEC4FEC5FEC6FEC7FEC8FEC9FECAFECBFECCFECDFECEFECFFED0FED1FED2FED3FED4FED5FED6FED7FED8FED9FEDAFEDBFEDCFEDDFEDEFEDFFEE0FEE1FEE2FEE3FEE4FEE5FEE6FEE7FEE8FEE9FEEAFEEBFEECFEEDFEEEFEEFFEF0FEF1FEF2FEF3FEF4FEF5FEF6FEF7FEF8FEF9FEFAFEFBFEFCFEFDFEFEFEFFFF00FF01FF02FF03FF04FF05FF06FF07FF08FF09FF0AFF0BFF0CFF0DFF0EFF0FFF10FF11FF12FF13FF14FF15FF16FF17FF18FF19FF1AFF1BFF1CFF1DFF1EFF1FFF20FF21FF22FF23FF24FF25FF26FF27FF28FF29FF2AFF2BFF2CFF2DFF2EFF2FFF30FF31FF32FF33FF34FF35FF36FF37FF38FF39FF3AFF3BFF3CFF3DFF3EFF3FFF40FF41FF42FF43FF44FF45FF46FF47FF48FF49FF4AFF4BFF4CFF4DFF4EFF4FFF50FF51FF52FF53FF54FF55FF56FF57FF58FF59FF5AFF5BFF5CFF5DFF5EFF5FFF60FF61FF62FF63FF64FF65FF66FF67FF68FF69FF6AFF6BFF6CFF6DFF6EFF6FFF70FF71FF72FF73FF74FF75FF76FF77FF78FF79FF7AFF7BFF7CFF7DFF7EFF7FFF80FF81FF82FF83FF84FF85FF86FF87FF88FF89FF8AFF8BFF8CFF8DFF8EFF8FFF90FF91FF92FF93FF94FF95FF96FF97FF98FF99FF9AFF9BFF9CFF9DFF9EFF9FFFA0FFA1FFA2FFA3FFA4FFA5FFA6FFA7FFA8FFA9FFAAFFABFFACFFADFFAEFFAFFFB0FFB1FFB2FFB3FFB4FFB5FFB6FFB7FFB8FFB9FFBAFFBBFFBCFFBDFFBEFFBFFFC0FFC1FFC2FFC3FFC4FFC5FFC6FFC7FFC8FFC9FFCAFFCBFFCCFFCDFFCEFFCFFFD0FFD1FFD2FFD3FFD4FFD5FFD6FFD7FFD8FFD9FFDAFFDBFFDCFFDDFFDEFFDFFFE0FFE1FFE2FFE3FFE4FFE5FFE6FFE7FFE8FFE9FFEAFFEBFFECFFEDFFEEFFEFFFF0FFF1FFF2FFF3FFF4FFF5FFF6FFF7FFF8FFF9FFFAFFFBFFFCFFFDFFFEFFFF";

            final StringBuilder strBuilder = new StringBuilder();
            for (int i = 0xFE00; i <= 0xFFFF; i++) {
                strBuilder.append(JSONEscapeUtil.toUHexa(i));
            }

            final String result = strBuilder.toString();
            Assert.assertEquals(uhexaFFFF, result);
        }

    }




    public AuxEscapeTest() {
        super();
    }


}
