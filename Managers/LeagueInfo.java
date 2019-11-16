package me.Shogatsu.TheDrakeProject.Managers;

import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMasteries;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMastery;
import com.merakianalytics.orianna.types.core.league.LeagueEntry;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

import java.util.List;
import java.util.stream.Collectors;

public class LeagueInfo {
    private Summoner summoner;
    public LeagueInfo(Summoner s1) {
        summoner = s1;
    }
    //Should return a list of champs that user plays that is greater than 6
    public List<String> getM7() {
        ChampionMasteries masteries = summoner.getChampionMasteries();
        List<ChampionMastery> good = masteries.filter((ChampionMastery mastery) -> {
            assert mastery != null;
            return mastery.getLevel() == 7;
        });
        return good.stream().map((ChampionMastery mastery) -> mastery.getChampion().getName()).collect(Collectors.toList());
    }
    public List<String> getM6() {
        ChampionMasteries masteries = summoner.getChampionMasteries();
        List<ChampionMastery> good = masteries.filter((ChampionMastery mastery) -> {
            assert mastery != null;
            return mastery.getLevel() == 6;
        });
        return good.stream().map((ChampionMastery mastery) -> mastery.getChampion().getName()).collect(Collectors.toList());
    }
    public LeagueEntry promos() {
        final LeagueEntry promos = summoner.getLeaguePosition(Queue.RANKED_SOLO);
        if (promos.getPromos() != null) {
            return promos;
        } else {
            return null;
        }
    }
    public String getSoloRankedIcon() {
        final LeagueEntry ranked = summoner.getLeaguePosition(Queue.RANKED_SOLO);
        String rankedIcon = "";
        switch (ranked.getTier().name()) {
            case "UNRANKED":
                break;
            case "PROVISIONAL":
                break;
            case "IRON":
                switch (ranked.getDivision()) {
                    case I:
                        rankedIcon = "https://i.imgur.com/g1HxVTP.png";
                    case II:
                        rankedIcon = "https://i.imgur.com/LUsTq2w.png";
                    case III:
                        rankedIcon = "https://i.imgur.com/VE6t9BA.png";
                    case IV:
                        rankedIcon = "https://i.imgur.com/DbNof4m.png";
                }
                break;
            case "BRONZE":
                switch (ranked.getDivision()) {
                    case I:
                        rankedIcon = "https://i.imgur.com/YXmjArE.png";
                    case II:
                        rankedIcon = "https://i.imgur.com/8mwwy9s.png";
                    case III:
                        rankedIcon = "https://i.imgur.com/1IpFxX1.png";
                    case IV:
                        rankedIcon = "https://i.imgur.com/Md4GjTi.png";
                    default:
                        throw new IllegalStateException("Unexpected Bronze: " + ranked.getDivision());
                }
            case "SILVER":
                switch (ranked.getDivision()) {
                    case I:
                        rankedIcon = "https://i.imgur.com/rzKRw8o.png";
                    case II:
                        rankedIcon = "https://i.imgur.com/oRQTd4C.png";
                    case III:
                        rankedIcon = "https://i.imgur.com/TF6x9BR.png";
                    case IV:
                        rankedIcon = "https://i.imgur.com/DhGqpW5.png";
                    default:
                        throw new IllegalStateException("Unexpected Silver: " + ranked.getDivision());
                }
            case "GOLD":
                switch (ranked.getDivision()) {
                    case I:
                        rankedIcon = "https://i.imgur.com/p4UnVyD.png";
                    case II:
                        rankedIcon = "https://i.imgur.com/4bMx489.png";
                    case III:
                        rankedIcon =  "https://i.imgur.com/rZsYWn5.png";
                    case IV:
                        rankedIcon = "https://i.imgur.com/Sa2mYbF.png";
                    default:
                        throw new IllegalStateException("Unexpected Gold: " + ranked.getDivision());
                }
            case "PLATINUM":
                switch (ranked.getDivision()) {
                    case I:
                        break;
                    case II:
                        break;
                    case III:
                        break;
                    case IV:
                        break;
                    case V:
                        break;
                    default:
                        throw new IllegalStateException("Unexpected Platinum: " + ranked.getDivision());
                }
                break;
            case "DIAMOND":
                switch (ranked.getDivision()) {
                    case I:
                        break;
                    case II:
                        break;
                    case III:
                        break;
                    case IV:
                        break;
                    case V:
                        break;
                    default:
                        throw new IllegalStateException("Unexpected Diamond: " + ranked.getDivision());
                }
                break;
            case "MASTER":
                break;
            case "GRANDMASTER":
                break;
            case "CHALLENGER":
                break;
            default:
                break;
        }
        return rankedIcon;
    }
    public String getFlexRank() {
        final LeagueEntry ranked = summoner.getLeaguePosition(Queue.RANKED_FLEX);
        return ranked.getDivision().name() + "LP: " + ranked.getLeaguePoints();
    }
    public String getTFTRank() {
        final LeagueEntry ranked = summoner.getLeaguePosition(Queue.RANKED_TFT);
        return ranked.getDivision().name() + "LP: " + ranked.getLeaguePoints();
    }
    public String getLeagueName() {
        final LeagueEntry ranked = summoner.getLeaguePosition(Queue.RANKED_SOLO);
        return ranked.getTier().name();
    }
}
