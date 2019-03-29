//
//  TreeHandle.m
//  LeetCodeOC
//
//  Created by fgy on 2019/3/26.
//  Copyright © 2019 test. All rights reserved.
//

#import "TreeHandle.h"
@interface TreeHandle()

@property (nonatomic,strong) NSMutableArray* trees;
@end

@implementation TreeHandle
-(NSMutableArray *)valsArray{
    if (_valsArray == nil) {
        _valsArray=[NSMutableArray arrayWithCapacity:1];
    }
    return _valsArray;
}
-(NSMutableArray *)trees{
    if (_trees == nil) {
        _trees=[NSMutableArray arrayWithCapacity:1];
    }
    return _trees;
}
- (void)travIn_C:(Tree *)tree{
    if (tree == nil) {
        return;
    }
    [self.valsArray addObject:@(tree.val)];
    [self travIn_C:tree.left];
    [self travIn_C:tree.right];
}
- (void)travIn_L:(Tree *)tree{
    if (tree == nil) {
        return;
    }
    [self travIn_L:tree.left];
    [self.valsArray addObject:@(tree.val)];
    [self travIn_L:tree.right];
}
- (void)travIn_R:(Tree *)tree{
    if (tree == nil) {
        return;
    }
    [self travIn_R:tree.left];
    [self travIn_R:tree.right];
    [self.valsArray addObject:@(tree.val)];
}
//递归版本先序遍历
- (void)travIn_I_C:(Tree *)tree{
    Tree *top = tree;
    while (1) {
        while (top) {
            if (top.right != nil) {
                [self.trees addObject:top.right];
            }
            [self.valsArray addObject:@(top.val)];
            top = top.left;
        }
        if (self.trees.count == 0) {
            break;
        }
        top = self.trees.lastObject;
        [self.trees removeLastObject];
    }
}
//递归版本中序遍历
- (void)travIn_I_L:(Tree *)tree{
    Tree *top = tree;
    while (1) {
        while (top) {
            [self.trees addObject:top];
            top = top.left;
        }
        if (self.trees.count == 0) {
            break;
        }
        top = self.trees.lastObject;
        [self.valsArray addObject:@(top.val)];
        if (top.right) {
            top = top.right;
            if (top.left == nil) {
                top = nil;
            }
        }else{
            [self.trees removeLastObject];
            top = nil;
        }
        
    }
}

- (NSString *)description{
    NSMutableString *str =[NSMutableString string];
    NSInteger length = self.valsArray.count;
    for (NSInteger i = 0; i < length; i ++) {
        NSString *subString=[NSString stringWithFormat:@"%ld",(long)[self.valsArray[i] integerValue]];
        [str appendString:subString];
    }
    return [str copy];
}
@end
