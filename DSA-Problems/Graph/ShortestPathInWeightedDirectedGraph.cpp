#include<iostream>
#include<list>
#include<limits.h>
#include<stack>
#include<unordered_map>
#include<vector>
using namespace std;

class Graph{
    public:
        unordered_map<int,list<pair<int,int> > > adj; // Adjacency list storing (node, weight) pairs
        stack<int> topo; // Stack to store the topological order

        // Function to insert a directed edge with a weight
        void insert(int parent, int adjacent, int weight){
            adj[parent].push_back(make_pair(adjacent, weight));
        }

        // Function to print the adjacency list representation of the graph
        void printGraph(){
            for (auto i : adj)
            {
                cout<<i.first<<" -> ";
                for (auto neighbour: i.second)
                {
                    cout<<"("<<neighbour.first<<", "<<neighbour.second<<"), ";
                }
                cout<<endl;
            }
        }
    
        // Function to perform Topological Sort using DFS
        void topoSortUsingDFS(int node, unordered_map<int, bool> &visited){
            visited[node] = true; // Mark the node as visited

            // Visit all unvisited adjacent nodes
            for (auto neighbour: adj[node])
            {
                if (!visited[neighbour.first])
                {
                    topoSortUsingDFS(neighbour.first, visited);
                }
            }
            // Push the node to the stack after all its neighbors are visited
            topo.push(node);
        }

        // Function to calculate shortest path from a given start node in a DAG
        void getDistance(int startPoint){
            vector<int> distance(6, INT_MAX); // Initialize all distances to infinity
            distance[startPoint] = 0; // Distance to start point is 0

            // Process nodes in topological order
            while(!topo.empty()){
                int node = topo.top();
                topo.pop();

                // Update distances of adjacent nodes if current node is reachable
                if(distance[node] != INT_MAX){
                    for(auto i : adj[node]){
                        int currDistance = distance[node] + i.second;
                        if (currDistance < distance[i.first])
                        {
                            distance[i.first] = currDistance;
                        }
                    }
                }
            }

            // Print the shortest distances from startPoint
            for (auto i : distance)
            {
                cout<<i<<" ";
            }
        }
};

int main(){
    Graph g;
    
    // Adding edges to the graph (DAG)
    g.insert(0,1,5);
    g.insert(0,2,3);
    g.insert(1,2,2);
    g.insert(1,3,6);
    g.insert(2,3,7);
    g.insert(2,4,4);
    g.insert(2,5,2);
    g.insert(3,4,-1);
    g.insert(4,5,-2);

    // Print the adjacency list representation of the graph
    g.printGraph();
    
    unordered_map<int, bool> visited;

    // Perform Topological Sort for all unvisited nodes
    for(int i = 0; i < 6; i++){
        if(!visited[i]){
            g.topoSortUsingDFS(i, visited);
        }
    }

    // Compute shortest paths from node 1
    g.getDistance(0);

    return 0;
}