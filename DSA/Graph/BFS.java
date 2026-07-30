

// Since it is a BFS we wanted

we need to go with iterative flow with queue

lets say we have a adecency list as graph

we take the first node
we push it to the queue with queue.pushand mark it as visted

till queue becomes empty we do
currentnode = queue.shift
for neighbour of grpah[currentnode]:
  if neighbor is not visited then 
	queue.push(neighbors);
  	mark neighbor as visited 


once all done we can exit