
// https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

class Solution
{
    public:
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    static bool cmp(pair<int,int> a, pair<int,int> b){
        return a.second<b.second;
    }
    
    int maxMeetings(int start[], int end[], int n)
    {
        // Your code here
        vector<pair<int,int>> meeting;
        for(int i=0; i<n; i++){
            meeting.push_back(make_pair(start[i], end[i]));
        }
        
        sort(meeting.begin(), meeting.end(), cmp);
        
        int count= 1;
        pair<int,int> prevMeeting= meeting[0];
        for(int i=1; i<n; i++){
            if(meeting[i].first>prevMeeting.second){
                count++;
                prevMeeting= meeting[i];
            }
        }
        return count;
        
    }
};