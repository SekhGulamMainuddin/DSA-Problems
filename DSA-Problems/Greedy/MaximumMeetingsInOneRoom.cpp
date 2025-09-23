
// https://practice.geeksforgeeks.org/problems/maximum-meetings-in-one-room/1

class Solution{
public:
    static bool cmp(pair<pair<int,int>,int> a, pair<pair<int,int>,int> b){
        return a.first.second<b.first.second;
    }
    vector<int> maxMeetings(int n,vector<int> &start,vector<int> &end){
        vector<pair<pair<int,int>,int>> meeting;
        for(int i=0; i<n; i++){
            meeting.push_back(make_pair(make_pair(start[i], end[i]), i+1));
        }
        
        sort(meeting.begin(), meeting.end(), cmp);
        
        vector<int> ans;
        pair<pair<int,int>,int> prevMeeting= meeting[0];
        ans.push_back(meeting[0].second);
        for(int i=1; i<n; i++){
            if(meeting[i].first.first>prevMeeting.first.second){
                ans.push_back(meeting[i].second);
                prevMeeting= meeting[i];
            }
        }
        sort(ans.begin(), ans.end());
        return ans;
    }
};