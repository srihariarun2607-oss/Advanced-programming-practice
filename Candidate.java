import java.util.Scanner;

class Candidate {
    int candidateId;
    String name;
    int aptitude;
    int technical;
    int communication;
    
    public Candidate(int candidateId, String name, int aptitude, int technical, int communication) {
        this.candidateId = candidateId;
        this.name = name;
        this.aptitude = aptitude;
        this.technical = technical;
        this.communication = communication;
    }
    
    int getTotalScore() {
        return aptitude + technical + communication;
    }
}

class CandidateComparator {
    static void sortCandidates(Candidate[] candidates, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int score1 = candidates[j].getTotalScore();
                int score2 = candidates[j + 1].getTotalScore();
                
                if (score1 < score2) {
                    Candidate temp = candidates[j];
                    candidates[j] = candidates[j + 1];
                    candidates[j + 1] = temp;
                } else if (score1 == score2) {
                    if (candidates[j].candidateId > candidates[j + 1].candidateId) {
                        Candidate temp = candidates[j];
                        candidates[j] = candidates[j + 1];
                        candidates[j + 1] = temp;
                    }
                }
            }
        }
    }
}

class PlacementDrive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        Candidate[] candidates = new Candidate[n];
        
        for (int i = 0; i < n; i++) {
            int candidateId = sc.nextInt();
            String name = sc.next();
            int aptitude = sc.nextInt();
            int technical = sc.nextInt();
            int communication = sc.nextInt();
            
            candidates[i] = new Candidate(candidateId, name, aptitude, technical, communication);
        }
        
        CandidateComparator.sortCandidates(candidates, n);
        
        System.out.println("Top " + k + " Candidates:");
        for (int i = 0; i < k; i++) {
            System.out.println(candidates[i].candidateId + " " + candidates[i].name + " " + candidates[i].getTotalScore());
        }
        
        sc.close();
    }
}