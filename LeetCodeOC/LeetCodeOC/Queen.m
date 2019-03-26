//
//  Queen.m
//  LeetCodeOC
//
//  Created by fgy on 2019/3/25.
//  Copyright © 2019 test. All rights reserved.
//

#import "Queen.h"

@implementation Queen
-(instancetype)initWithX:(NSInteger)x X:(NSInteger)y{
    self = [super init];
    self.x = x;
    self.y = y;
    return self;
}
-(NSString *)description{
    return [NSString stringWithFormat:@"x:%ld y:%ld",(long)self.x,(long)self.y];
}
@end
